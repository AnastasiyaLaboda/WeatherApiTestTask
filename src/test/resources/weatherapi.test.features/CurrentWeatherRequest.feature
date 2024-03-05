Feature: Retrieving Current Weather Information

  Background: the user has valid Api key credentials

  Scenario Outline: Checking current weather for "<city>"
    When the user requests the current weather in "<city>"
    Then the received weather matches the expected values: "<country>", "<lat>", "<lon>", "<condition>"

    Examples:
      | city   | country        | lat   | lon   | condition     |
      | Minsk  | Belarus        | 53.9  | 27.57 | Partly cloudy |
      | London | United Kingdom | 51.52 | -0.11 | Clear         |
      | Moscow | Russia         | 55.75 | 37.62 | Clear         |
      | Madrid | Spain          | 40.4  | -3.68 | Partly cloudy |


  Scenario Outline: Sending request with city parameter "<q>"
    When the user sends a request providing invalid city parameter "<q>"
    Then the error message should contain error code "<code>"
    And the error message should contain error "<message>"
    Examples:
      | q         | code | message                                  |
      |           | 1003 | Parameter 'q' not provided               |
      | MMJbifh!! | 1006 | No location found matching parameter 'q' |