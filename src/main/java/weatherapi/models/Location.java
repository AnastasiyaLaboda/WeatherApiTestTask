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
public class Location {
    @JsonProperty("name")
    String name;
    @JsonProperty("region")
    String region;
    @JsonProperty("country")
    String country;
    @JsonProperty("lat")
    Double lat;
    @JsonProperty("lon")
    Double lon;
    @JsonProperty("tz_id")
    String tz_id;
    @JsonProperty("localtime_epoch")
    Integer localtime_epoch;
    @JsonProperty("localtime")
    String localtime;
}
