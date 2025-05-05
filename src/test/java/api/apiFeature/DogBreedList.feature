Feature: Retrieve list of dog Breed

  Scenario Outline: Get a list of dog breed
    Given the API endpoint is available
    When I send a GET request to "<endpoint>"
    Then I should receive a 200 status code
    And the response should contain a list of dogs
    Examples:
      | endpoint |
      |https://dog.ceo/api/breeds/list/all|