package svartberg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageDataDTO {

  @ApiModelProperty(position = 0)
  @JsonProperty(value = "name")
  private String userName;
  @ApiModelProperty(position = 1)
  @JsonProperty(value = "message")
  private String message;

}
