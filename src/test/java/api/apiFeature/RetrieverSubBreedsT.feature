Feature: produce a list of sub-breeds for retrieve

  @run
  Scenario: produce a list of sub-breeds for retrieve
    Given the API endpoint is available
    When I send a GET request to "breeds/list/all"
    Then I should receive a "success" status
    And the response should contain a list subbreeds for retrieve
