package svartberg.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import svartberg.dto.MessageDataDTO;
import svartberg.dto.MessageResponseDTO;
import svartberg.service.MessageService;

@RestController
@RequestMapping("/messages")
@Api(tags = "messages")
@RequiredArgsConstructor
public class MessageController {

  private final MessageService messageService;

  @PostMapping("/")
  @ApiOperation(value = "${MessageController.postMessage}", authorizations = {
      @Authorization(value = "apiKey")})
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public ResponseEntity<?> postMessage(
      @ApiParam("Post Message") @RequestBody MessageDataDTO message) {

    if ("history 10".equals(message.getMessage())) {
      List<MessageResponseDTO> messageResponseDTOS = messageService.get(message);
      return ResponseEntity.ok(messageResponseDTOS);
    }
    messageService.save(message);
    return ResponseEntity.accepted().build();
  }
}
