Feature: Register Users - Automation Testing QE-10
  @Tugas @PositiveCase
  Scenario: Register new user with valid json
    Given Register new user with valid json
    When Send POST register user
    Then Status code should be 200 OK
    And Response body token exist
    And Validate successful post register user json schema

  @Tugas @NegativeCase
  Scenario:  Register new user without request body password
    Given Register new user without request body password
    When Send POST register user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing password"
    And Validate post unsuccessful register user

  @Tugas @NegativeCase
  Scenario:  Register new user without request body email
    Given Register new user without request body email
    When Send POST register user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username"
    And Validate post unsuccessful register user

  @Tugas @NegativeCase
  Scenario:  Register new user without request body email and password
    Given Register new user without request body email and password
    When Send POST register user
    Then Status code should be 400 Bad Request
    And Response body error message was "Missing email or username"
    And Validate post unsuccessful register user

  @Tugas @NegativeCase
  Scenario: Register new user with invalid format email
    Given Register new user with invalid format email
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Register new user where the email's type data is number
    Given Register new user with email number type data
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Register new user with invalid password
    Given Register new user with invalid password
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Register new user with invalid email and password
    Given Register new user with invalid email and password
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Register new user with empty password
    Given Register new user with empty password
    When Send POST register user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Register new user with empty email
    Given Register new user with empty email
    When Send POST register user
    Then Status code should be 400 Bad Request