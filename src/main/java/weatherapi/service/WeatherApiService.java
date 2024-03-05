package weatherapi.service;

import java.util.Map;

import static weatherapi.utils.GetRequestUtils.makeRequestAndGetResponseBody;

public class WeatherApiService {
    public <T> T getWithApiKey(String url, String apiKey, String queryParameter, String queryValue,
                               Class<T> responseType, int statusCode) {
        return makeRequestAndGetResponseBody(
                url,
                configureHeaders(apiKey),
                configureParams(queryParameter, queryValue),
                responseType,
                statusCode);
    }

    public Map<String, Object> configureHeaders(String apiKey) {
        return Map.of("key", apiKey);
    }

    public Map<String, Object> configureParams(String filterKey, String selectedFilter) {
        return Map.of(filterKey, selectedFilter);
    }
}
