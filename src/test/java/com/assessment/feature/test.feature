@ControlAssessment
Feature: Add New Request page

  @AddNewRequest
  Scenario: Verify all fields are present and update Travel Agency ID
    Given user is logged into the control assessment portal
    And user navigates to "Add New Request" page
    When user selects request type as ""
    And enter request title as ""
    And select request channel as ""
    And enter initial request date as ""
    And select request state as ""
    And select request lead as ""
    Then  user saves new request
    And verify below error message displayed
      | error msg. |