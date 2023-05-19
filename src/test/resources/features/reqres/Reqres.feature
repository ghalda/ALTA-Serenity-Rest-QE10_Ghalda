Feature: Reqres API Automation Testing QE-10
  @Latihan
  Scenario Outline: Get List Users with valid parameter page
    Given Got list users with valid parameter page <page>
    When Send get lists users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
  Examples:
    | page |
    | 1    |
    | 2    |

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create new user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Ghalda Putri" and job was "QA Manager"
    And Validate post list user json schema

  @Latihan
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body for update name was "Ghalda Putri" and job was "QA Manager"
    And Validate put user json schema
    Examples:
      | id |
      |1   |
      |2   |
      |3   |
  @Latihan
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      |1   |
      |2   |