Feature: Get User - Automation Testing
  @Tugas
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

  @Tugas
  Scenario: Get List Users empty parameter
    Given Got list users empty parameter ""
    When Send get lists users
    Then Status code should be 200 OK
    And Response body page should be 1
    And Validate get list user json schema

  @Tugas
  Scenario Outline: Get List Users with invalid parameter
    Given Got list user with invalid parameter "<invalidParams>"
    When Send get lists users
    Then Status code should be 400 Bad Request
    Examples:
      | invalidParams |
      | z             |
      | @             |