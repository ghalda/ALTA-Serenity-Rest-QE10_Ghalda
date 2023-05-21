Feature: Get User - Automation Testing
  @Tugas @PositiveCase
  Scenario Outline: Get List Users with valid parameter page
    Given <page> as valid parameter page
    When Send GET lists users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas @NegativeCase
    Scenario Outline: Get List Users with exceeded parameter
      Given <page> as exceeded parameter page
      When Send GET lists users
      Then Status code should be 404 Not Found
    Examples:
      | page |
      | 3    |

  @Tugas @NegativeCase
  Scenario Outline: Get List Users with invalid parameter
    Given "<invalidParams>" as invalid parameter
    When Send GET lists users
    Then Status code should be 400 Bad Request
    Examples:
      | invalidParams |
      | z             |
      | @             |

  @Tugas @NegativeCase
  Scenario: Get List Users with empty parameter
    Given empty parameter to get list users
    When Send GET lists users
    Then Status code should be 400 Bad Request