Feature: Login Users - Automation Testing QE-10
  @Tugas @PositiveCase
  Scenario: Login user with valid json
    Given Login user with valid json
    When Send POST login user
    Then Status code should be 200 OK
    And Response body token exist for login
    And Validate post login user json schema

  @Tugas @NegativeCase
  Scenario:  Login user without request body password
    Given Login user without request body password
    When Send POST login user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing password" for login
    And Validate post unsuccessful login user

  @Tugas @NegativeCase
  Scenario:  Login user without request body email
    Given Login user without request body email
    When Send POST login user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username" for login
    And Validate post unsuccessful login user

  @Tugas @NegativeCase
  Scenario:  Login user without request body email and password
    Given Login user without request body email and password
    When Send POST login user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username" for login
    And Validate post unsuccessful login user

  @Tugas @NegativeCase
  Scenario:  Login for unregistered user
    Given Login for unregistered user
    When Send POST login user
    Then Status code should be 404 Not Found

  @Tugas @NegativeCase
  Scenario: Login user with invalid format email
    Given Login user with invalid format email
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Login user where the email's type data is number
    Given Login user with email number type data
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Login user with invalid password
    Given Login user with invalid password
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Login user with invalid email and password
    Given Login user with invalid email and password
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Login user with empty password
    Given Login user with empty password
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Login user with empty email
    Given Login user with empty email
    When Send POST register user
    Then Status code should be 400 Bad Request