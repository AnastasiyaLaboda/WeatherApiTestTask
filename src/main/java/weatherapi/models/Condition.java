package weatherapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Condition {
    @JsonProperty("text")
    String text;
    @JsonProperty("icon")
    String icon;
    @JsonProperty("code")
    Integer code;
}
