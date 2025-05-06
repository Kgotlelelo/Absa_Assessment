Feature: produce a random image / link for the sub-breed “golden”

  @run
  Scenario: Produce a random imagelink for the subbreed golden
    Given the API endpoint is available
    When I send a GET request to "breed/retriever/golden/images/random"
    Then I should receive a "success" status
    And the response should contain a random image for the subbreed golden

