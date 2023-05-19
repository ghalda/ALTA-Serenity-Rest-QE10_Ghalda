Feature: Get Single User - Automation Testing
  @Tugas @PositiveCase
  Scenario Outline: Get Single User with user id
    Given Got single user with id <id>
    When Send get single user
    Then Status code should be 200 OK
    And Response body id was <id> and email was "<email>"
    And Validate get single user json schema
    Examples:
      | id | email                  |
      | 1  | george.bluth@reqres.in |
      | 2  | janet.weaver@reqres.in |
      | 3  | emma.wong@reqres.in    |

  @Tugas @NegativeCase
  Scenario Outline: Get Single User with unregistered id
    Given got single user with unregistered id <id>
    When Send get single user
    Then Status code should be 404 Not Found
    Examples:
      | id |
      | 50 |
      | 51 |

  Scenario Outline: Get Single User with invalid id
    Given got single user with invalid "<id>"
    When Send get single user
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    |    |
    | a  |