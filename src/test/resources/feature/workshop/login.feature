Feature: Login



  Scenario: Login succesfully
   Given I acces the login page
   And I insert valid credentials
   When I click login button
   Then I check if user was logged in


  Scenario: login with wrong credentials
    Given I acces the login page
    And I insert invalid credentials
    When I click login button
    Then I expect invalid credentials message

    Scenario: Login with no password
      Given I acces the login page
      When I "aa@fast.com"/"" credentials
      And I click login button
      Then I expect "Please enter your password!" message
