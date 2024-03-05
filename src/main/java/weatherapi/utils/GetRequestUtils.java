package weatherapi.utils;

import org.apache.commons.collections4.MapUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class GetRequestUtils {
    private GetRequestUtils() {
    }

    public static <T> T makeRequestAndGetResponseBody(String endpoint, Map<String, Object> headers,
                                                      Map<String, Object> params, Class<T> responseAsClass, int statusCode) {
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(params))
                .when()
                .get(endpoint)
                .then()
                .log().status()
                .log().body()
                .statusCode(statusCode)
                .extract()
                .response()
                .getBody().as(responseAsClass);
    }
}
