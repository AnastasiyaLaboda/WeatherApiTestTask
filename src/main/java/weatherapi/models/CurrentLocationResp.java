package weatherapi.models.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrentLocationResp {
}


//{
//   "location":{
//      "name":"Minsk",
//      "region":"Minsk",
//      "country":"Belarus",
//      "lat":53.9,
//      "lon":27.57,
//      "tz_id":"Europe/Minsk",
//      "localtime_epoch":1709460605,
//      "localtime":"2024-03-03 13:10"
//   },
//   "current":{
//      "last_updated_epoch":1709460000,
//      "last_updated":"2024-03-03 13:00",
//      "temp_c":2.0,
//      "temp_f":35.6,
//      "is_day":1,
//      "condition":{
//         "text":"Sunny",
//         "icon":"//cdn.weatherapi.com/weather/64x64/day/113.png",
//         "code":1000
//      },
//      "wind_mph":6.9,
//      "wind_kph":11.2,
//      "wind_degree":90,
//      "wind_dir":"E",
//      "pressure_mb":1021.0,
//      "pressure_in":30.15,
//      "precip_mm":0.0,
//      "precip_in":0.0,
//      "humidity":80,
//      "cloud":0,
//      "feelslike_c":-3.0,
//      "feelslike_f":26.6,
//      "vis_km":10.0,
//      "vis_miles":6.0,
//      "uv":1.0,
//      "gust_mph":16.2,
//      "gust_kph":26.0
//   }
//}