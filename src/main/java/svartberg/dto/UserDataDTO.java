package svartberg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDataDTO {

  @ApiModelProperty(position = 0)
  @JsonProperty(value = "name")
  private String username;

  @ApiModelProperty(position = 1)
  @JsonProperty(value = "password")
  private String password;
}
