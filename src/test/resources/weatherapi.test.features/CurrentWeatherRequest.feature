Feature: As an user
  I want to specify the city
  So that I get the current weather information for a given city

  Scenario Outline: Checking current weather for "<city>"
    Given the user has valid Api key credentials
    When the user sends a request to get the current weather for "<city>"
    Then the received weather matches the expected values: "<country>", "<lat>", "<lon>", "<condition>"

    Examples:
      | city   | country        | lat   | lon   | condition     |
      | Minsk  | Belarus        | 53.9  | 27.57 | Partly cloudy |
      | London | United Kingdom | 51.52 | -0.11 | Clear         |
      | Moscow | Russia         | 55.75 | 37.62 | Clear         |
      | Madrid | Spain          | 40.4  | -3.68 | Partly cloudy |

  Scenario: Error occurs if send a request without a city parameter
    Given the user has valid Api key credentials
    When the user sends a request without providing city parameter
    Then the response status code should be 400
    And the error message should contain the error code 1003