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
    When I enter "aa@fast.com"/"" credentials
    And I click login button
    Then I expect "Please enter your password!" message

  Scenario: Login with no email
    Given I acces the login page
    When I enter ""/"eu.pass" credentials
    And I click login button
    Then I expect "Please enter your email!" message

  Scenario Outline: Failed login
    Given I acces the login page
    When I enter "<email>"/"<pass>" credentials
    And I click login button
    Then I expect "<message>" message
    Examples:
      | email       | pass     | message                     |
      |             | pass     | Please enter your email!    |
      | eu@fast.com |          | Please enter your password! |
      | aa@fast.com | somepass | Invalid user or password!   |
      | email       | pass     | Invalid user or password!   |