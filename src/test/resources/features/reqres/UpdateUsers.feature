Feature: Update Users - Automation Testing QE-10
  @Tugas @PositiveCase
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body for update name was "morpheus" and job was "zion resident"
    And Validate put user json schema
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas @NegativeCase
  Scenario Outline: Put update user with valid json and invalid id
    Given Put update user with valid json and invalid id "<id>"
    Then Send put update user
    Then Status code should be 400 Bad Request
  Examples:
    | id |
    | a  |
    | @  |

  @Tugas @NegativeCase
  Scenario: Put update user with valid json and empty id
    Given Put update user with valid json and empty id
    Then Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Put update user with empty request body and valid id
    Given Put update user with empty request body and valid id 1
    Then Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Put update user with valid id and request body without name
    Given Put update user with valid id 1 and request body without name
    Then Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Put update user with valid id and request body without job
    Given Put update user with valid id 1 and request body without job
    Then Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Put update user with valid id and request body with invalid name
    Given Put update user with valid id 1 and request body with invalid name
    Then Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Put update user with valid id and request body with invalid job
    Given Put update user with valid id 1 and request body with invalid job
    Then Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Put update user with valid id and request body with empty name
    Given Put update user with valid id 1 and request body with empty name
    Then Send put update user
    Then Status code should be 400 Bad Request

  @Tugas @NegativeCase
  Scenario: Put update user with valid id and request body with empty job
    Given Put update user with valid id 1 and request body with empty job
    Then Send put update user
    Then Status code should be 400 Bad Request