Feature: Retrieve list of dog Breed

  @run
  Scenario: Retrieve list of dog Breed
    Given the API endpoint is available
    When I send a GET request to "breeds/list/all"
    Then I should receive a "success" status
    And the response should contain a list of dogs
