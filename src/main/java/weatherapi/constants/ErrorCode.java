package weatherapi.constants;

import lombok.Getter;

@Getter
public enum ErrorCode {
    API_KEY_NOT_PROVIDED(1002, "API key not provided"),
    PARAMETER_Q_NOT_PROVIDED(1003, "Parameter 'q' not provided"),
    API_REQUEST_URL_INVALID(1005, "API request url is invalid"),
    NO_LOCATION_FOUND(1006, "No location found matching parameter 'q'"),
    API_KEY_INVALID(2006, "API key provided is invalid"),
    API_KEY_EXCEEDED_QUOTA(2007, "API key has exceeded calls per month quota"),
    API_KEY_DISABLED(2008, "API key has been disabled"),
    API_KEY_NO_ACCESS(2009, "API key does not have access to the resource"),
    JSON_BODY_INVALID(9000, "Json body passed in bulk request is invalid"),
    JSON_BODY_TOO_MANY_LOCATIONS(9001, "Json body contains too many locations for bulk request"),
    INTERNAL_ERROR(9999, "Internal application error");
    private final int code;
    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
