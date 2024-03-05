package weatherapi.test.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import weatherapi.models.CurrentLocationResp;
import weatherapi.models.ErrorResp;
import weatherapi.service.WeatherApiService;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static weatherapi.constants.UrlParametersForApi.API_KEY;
import static weatherapi.constants.UrlParametersForApi.CURRENT_WEATHER;

@Slf4j
public class CurrentWeatherReqStepsDefinition {
    private final String apiKey = API_KEY;
    private WeatherApiService weatherApiService = new WeatherApiService();
    private CurrentLocationResp currentLocationResp;
    private ErrorResp errorResp;

    @When("the user requests the current weather in {string}")
    public void sendRequestCurrentWeatherInCity(String city) {
        currentLocationResp = weatherApiService.getWithApiKey(
                CURRENT_WEATHER,
                apiKey,
                "q",
                city,
                CurrentLocationResp.class,
                SC_OK);
        log.debug("Request to get the current weather for {}", city);
    }

    @Then("the received weather matches the expected values: {string}, {string}, {string}, {string}")
    public void compareReceivedWeatherWithExpectedValues(String country, String lat, String lon, String condition) {
        assertEquals(country, currentLocationResp.getLocation().getCountry(), "Country does not match");
        assertEquals(Double.parseDouble(lat), currentLocationResp.getLocation().getLat(), 0.01,
                "Latitude does not match");
        assertEquals(Double.parseDouble(lon), currentLocationResp.getLocation().getLon(), 0.01,
                "Longitude does not match");
        assertEquals(condition, currentLocationResp.getCurrent().getCondition().getText(),
                "Condition does not match");
    }

    @When("the user sends a request providing invalid city parameter {string}")
    public void sendRequestWithInvalidCityParameter(String q) {
        errorResp = weatherApiService.getWithApiKey(
                CURRENT_WEATHER,
                apiKey,
                "q", q,
                ErrorResp.class,
                SC_BAD_REQUEST);
        log.debug("Send request with invalid city parameter q {}", q);
    }

    @Then("the error message should contain error code {string}")
    public void compareErrorMessageCode(String code) {
        assertEquals(parseInt(code), errorResp.getError().getCode(), "Error code mismatch");
    }

    @Then("the error message should contain error {string}")
    public void compareErrorMessageDescription(String description) {
        assertEquals(description, errorResp.getError().getMessage(),
                format("Expected error message '%s' not found", description));
    }
}

