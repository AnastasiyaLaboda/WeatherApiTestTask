Feature: API Key Error Handling

  Scenario Outline: Sending request with invalid "<key>"
    When the user sends a request providing invalid API "<key>"
    Then the error message returned by the API should contain the error code "<code>"
    And the error message returned by the API should contain the error "<message>"

    Examples:
      | key | code | message                     |
      |     | 1002 | API key not provided        |
      | a0! | 2006 | API key provided is invalid |
