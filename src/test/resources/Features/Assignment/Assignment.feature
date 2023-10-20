Feature: Perform testing on Dynamic table page
  
  @login
  Scenario: upload data and verify the table
    Given User is on dynamic web page
    When User able to upload data and refresh the table
    Then User able to verify table data