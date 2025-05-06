Feature:verify retriever breed is within the list

  @run
  Scenario: verify retriever breed is within the list
    Given the API endpoint is available
    When I send a GET request to "breeds/list/all"
    Then I should receive a "success" status
    And  verify "retriever" breed is within the list
