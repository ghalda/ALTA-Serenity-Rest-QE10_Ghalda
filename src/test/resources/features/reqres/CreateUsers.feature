Feature: Create User - Automation Testing
  @Tugas @PositiveCase
  Scenario: Post create new user with valid json
    Given Post create new user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Ghalda Putri Balqis" and job was "QA Engineer"
    And Validate post list user json schema

  @Tugas @NegativeCase
  Scenario: Post create new user without name and job
    Given Post create new user without request body
    When Send post create user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Post create new user without job
    Given Post create new user without job
    When Send post create user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Post create new user without name
    Given Post create new user without name
    When Send post create user
    Then Status code should be 400 Bad Request