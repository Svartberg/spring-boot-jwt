package svartberg.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

  @JsonProperty(value = "token")
  private String token;

  public TokenDTO(String token) {
    this.token = token;
  }
}
