package weatherapi.test.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import weatherapi.models.CurrentLocationResp;
import weatherapi.service.WeatherApiService;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static weatherapi.constants.UrlParametersForApi.API_KEY;

@Slf4j
public class StepsDefinition {
    private WeatherApiService weatherApiService = new WeatherApiService();
    private String apiKey;
    private CurrentLocationResp currentLocationResp;

    @Given("the user has valid Api key credentials")
    public void givenValidApiKey() {
        apiKey = API_KEY;
        log.debug("User has valid Api key credentials");
    }

    @When("the user sends a request to get the current weather for {string}")
    public void userSendsRequestToGetCurrentWeather(String city) {
        currentLocationResp = weatherApiService.getWithApiKey(
                apiKey,
                "q",
                city,
                CurrentLocationResp.class,
                SC_OK);
        log.debug("User sends a request to get the current weather for {}", city);
    }

    @Then("the received weather matches the expected values: {string}, {string}, {string}, {string}")
    public void theReceivedWeatherMatchesTheExpectedValues(String country, String lat, String lon, String condition) {
        assertEquals(country, currentLocationResp.getLocation().getCountry(), "Country does not match");
        assertEquals(Double.parseDouble(lat), currentLocationResp.getLocation().getLat(), 0.01,
                "Latitude does not match");
        assertEquals(Double.parseDouble(lon), currentLocationResp.getLocation().getLon(), 0.01,
                "Longitude does not match");
        assertEquals(condition, currentLocationResp.getCurrent().getCondition().getText(),
                "Condition does not match");
    }

    @When("the user sends a request without providing city parameter")
    public void sendRequestWithoutCityParameter() {
        currentLocationResp = weatherApiService.getWithApiKey(
                apiKey,
                "q",
                null,
                CurrentLocationResp.class,
                SC_BAD_REQUEST);
        log.debug("");
    }
}

