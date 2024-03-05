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
public class AirQuality {
    @JsonProperty("co")
    Double co;
    @JsonProperty("no2")
    Double no2;
    @JsonProperty("o3")
    Double o3;
    @JsonProperty("so2")
    Integer so2;
    @JsonProperty("pm2_5")
    Double pm2_5;
    @JsonProperty("pm10")
    Integer pm10;
    @JsonProperty("us-epa-index")
    Integer us_epa_index;
    @JsonProperty("gb-defra-index")
    Integer gb_defra_index;
}
