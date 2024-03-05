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
public class Current {
    @JsonProperty("last_updated_epoch")
    Integer last_updated_epoch;
    @JsonProperty("last_updated")
    String last_updated;
    @JsonProperty("temp_c")
    Double temp_c;
    @JsonProperty("temp_f")
    Double temp_f;
    @JsonProperty("is_day")
    Integer is_day;
    @JsonProperty("condition")
    Condition condition;
    @JsonProperty("wind_mph")
    Double wind_mph;
    @JsonProperty("wind_kph")
    Double wind_kph;
    @JsonProperty("wind_degree")
    Double wind_degree;
    @JsonProperty("wind_dir")
    String wind_dir;
    @JsonProperty("pressure_mb")
    Double pressure_mb;
    @JsonProperty("pressure_in")
    Double pressure_in;
    @JsonProperty("precip_mm")
    Double precip_mm;
    @JsonProperty("precip_in")
    Double precip_in;
    @JsonProperty("humidity")
    Double humidity;
    @JsonProperty("cloud")
    Double cloud;
    @JsonProperty("feelslike_c")
    Double feelslike_c;
    @JsonProperty("feelslike_f")
    Double feelslike_f;
    @JsonProperty("vis_km")
    Double vis_km;
    @JsonProperty("vis_miles")
    Double vis_miles;
    @JsonProperty("uv")
    Double uv;
    @JsonProperty("gust_mph")
    Double gust_mph;
    @JsonProperty("gust_kph")
    Double gust_kph;
    @JsonProperty("air_quality")
    AirQuality air_quality;
}
