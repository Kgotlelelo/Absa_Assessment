Feature:verify “retriever” breed is within the list

  Scenario Outline: verify “retriever” breed is within the list.
    Given the API endpoint is available
    When I send a GET request to "<endpoint>"
    Then I should receive a 200 status code
    And   verify “retriever” breed is within the list
    Examples:
      | endpoint                                    |
      |   https://dog.ceo/api/breeds/list/all       |