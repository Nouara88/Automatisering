Feature: User Registration on Basketball England Website
  As a new user I want to register on the Basketball England website
  I want to try with different scenario examples

  Scenario Outline: sign up with different scenarios
    Given I'm on the registration page of Basketball England on browser "<browser>"
    And I fill all the required registration fields
    And I fill in "<first name>" and "<last name>"
    And I enter a password "<password>"
    And I confirm the password "<confirm>"
    When I accept the terms and conditions "<accept>"
    And I click the "CONFIRM AND JOIN"
    Then I should receive a message indicating "<outcome>"

    Examples:
      | browser | first name | last name | password     | confirm      |  accept   | outcome                                                                    |
      | Chrome  | Elisia     | Masoud    | moonlight123 | moonlight123 |   true    |  THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND                 |
      | Chrome  | Fadi       |           | password     | password     |   true    |  Last Name is required                                                     |
      | Chrome  | Nour       | Afram     | password123  | password123  |   false   |  You must confirm that you have read and accepted our Terms and Conditions |
      | Chrome  | Fadi       | Masoud    | password123  | password1234 |   true    |  Password did not match                                                    |
      | Edge    | Elisia     | Masoud    | moonlight123 | moonlight123 |   true    |  THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND                 |
      | Edge    | Fadi       |           | password     | password     |   true    |  Last Name is required                                                     |
      | Edge    | Fadi       | Masoud    | password123  | password1234 |   true    |  Password did not match                                                    |
      | Edge    | Nour       | Afram     | password123  | password123  |   false   |  You must confirm that you have read and accepted our Terms and Conditions |




