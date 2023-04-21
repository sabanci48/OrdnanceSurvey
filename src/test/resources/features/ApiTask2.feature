Feature: Verify OS UK Downloads API

  @wip
  Scenario: Verify the API response
    Given the "/downloads/v1" endpoint is available
    When I send GET request to the API endpoint
    Then the API response status should be 200
    And the response payload should contain the following attributes and corresponding values:
      | title       | OS Downloads API                                                                                                    |
      | description | The available Download APIs offered by Ordnance Survey. These provide access to bulk data through RESTful services. |