Feature: Update Users - Automation Testing QE-10
  @Tugas @PositiveCase
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body for update name was "Ghalda Putri" and job was "QA Manager"
    And Validate put user json schema
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |