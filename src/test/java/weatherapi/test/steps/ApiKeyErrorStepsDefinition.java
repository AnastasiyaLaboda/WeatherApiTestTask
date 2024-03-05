package weatherapi.test.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import weatherapi.models.ErrorResp;
import weatherapi.service.WeatherApiService;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static weatherapi.constants.UrlParametersForApi.CURRENT_WEATHER;

@Slf4j
public class ApiKeyErrorStepsDefinition {
    private static final String CITY_PARAMETER = "Minsk";
    private WeatherApiService weatherApiService = new WeatherApiService();
    private ErrorResp errorResp = new ErrorResp();

    @When("the user sends a request providing invalid API {string}")
    public void sendRequestWithInvalidAPI(String apiKey) {
        errorResp = weatherApiService.getWithApiKey(
                CURRENT_WEATHER,
                apiKey,
                "q", CITY_PARAMETER,
                ErrorResp.class,
                SC_UNAUTHORIZED);
        log.debug("Send request with invalid api key apiKey{}", apiKey);
    }

    @Then("the error message returned by the API should contain the error code {string}")
    public void verifyErrorCode(String expectedErrorCode) {
        assertEquals(parseInt(expectedErrorCode), errorResp.getError().getCode(), "Error code mismatch");
    }

    @Then("the error message returned by the API should contain the error {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, errorResp.getError().getMessage(),
                format("Expected error message '%s' not found", expectedErrorMessage));
    }
}
