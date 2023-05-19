Feature: Create User - Automation Testing
  @Tugas @PositiveCase
  Scenario: Post create new user with valid json
    Given Post create new user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Ghalda Putri" and job was "QA Manager"
    And Validate post list user json schema