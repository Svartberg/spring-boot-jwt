package svartberg.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import svartberg.dto.TokenDTO;
import svartberg.dto.UserDataDTO;
import svartberg.model.AppUser;
import svartberg.service.UserService;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final ModelMapper modelMapper;

  @PostMapping("/signin")
  @ApiOperation(value = "${UserController.signin}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 422, message = "Invalid username/password supplied")})
  public ResponseEntity<TokenDTO> login(@ApiParam("Signin User") @RequestBody UserDataDTO user) {
    String token = userService.signin(user.getUsername(), user.getPassword());
    return ResponseEntity.ok(new TokenDTO(token));
  }

  @PostMapping("/signup")
  @ApiOperation(value = "${UserController.signup}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use")})
  public ResponseEntity<TokenDTO> signup(@ApiParam("Signup User") @RequestBody UserDataDTO user) {
    String token = userService.signup(modelMapper.map(user, AppUser.class));
    return ResponseEntity.ok(new TokenDTO(token));
  }
}
