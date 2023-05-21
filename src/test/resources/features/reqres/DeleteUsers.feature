Feature: Delete User - Automation Testing QE-10
  @Tugas @PositiveCase
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas @NegativeCase
  Scenario Outline: Delete user with exceeded parameter id
    Given Delete user with exceeded parameter id <id>
    When Send delete user
    Then Status code should be 404 Not Found
    Examples:
      | id  |
      | 100 |
      | 200 |

  @Tugas @NegativeCase
  Scenario Outline: Delete user with invalid parameter id
    Given Delete user with invalid parameter id "<id>"
    When Send delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | @  |
      | a  |

  @Tugas @NegativeCase
  Scenario: Delete user with empty parameter id
    Given Delete user with empty parameter id
    When Send delete user
    Then Status code should be 400 Bad Request