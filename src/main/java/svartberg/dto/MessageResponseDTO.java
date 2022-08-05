package svartberg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MessageResponseDTO {

  @ApiModelProperty(position = 0)
  private Integer id;
  @ApiModelProperty(position = 1)
  @JsonProperty(value = "name")
  private String username;
  @ApiModelProperty(position = 2)
  @JsonProperty(value = "message")
  private String message;
}
