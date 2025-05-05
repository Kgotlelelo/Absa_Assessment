Feature: Retrieve list of dogs

  Scenario Outline: produce a list of sub-breeds for “retrieve"
    Given the API endpoint is available
    When I send a GET request to "<endpoint>"
    Then I should receive a 200 status code
    And the response should contain a list sub-breeds for "retrieve"
    Examples:
      | endpoint |
      |https://dog.ceo/api/breeds/list/all|