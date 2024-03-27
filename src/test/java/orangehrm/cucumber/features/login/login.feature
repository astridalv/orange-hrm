Feature: Login

  @Positive @TDD
Scenario: Success Login
  Given User in login form
  When User input UserID textfield
  And User input Password textfield
  And User click button Login
  Then User on dashboard page

  @Negative @TDD
Scenario: Invalid UserID
  Given User in login form
  When User input invalid UserID textfield
  And User input Password textfield
  And User click button Login
  Then User get error message

  @Negative @TDD
Scenario: Invalid Password
  Given User in login form
  When User input UserID textfield
  And User input invalid Password textfield
  And User click button Login
  Then User get error message

  @Negative
Scenario: Empty Fields
  Given User in login form
  And User click button Login
  Then User get required message