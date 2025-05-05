Feature: produce a random image / link for the sub-breed “golden”

  Scenario Outline: produce a random image / link for the sub-breed “golden”
    Given the API endpoint is available
    When I send a GET request to "<endpoint>"
    Then I should receive a 200 status code
    And the response should contain a random image for the sub-breed "golden"
    Examples:
      | endpoint |
      |https://dog.ceo/api/breed/retriever/golden/images/random|