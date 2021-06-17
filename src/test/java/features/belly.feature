Feature: Testing the petstore application
  Verify if the features of the application work

  Scenario: Login as a authenticated user
    Given user is on homepage
    When user navigates to loginpage
    And user enters username and password
    Then success message is displayed


  Scenario: Create an account as a unauthenticated user
    Given user is on loginpage
    When user enters new username and new password
    And user confirms the new password
    And clicks on the new account button
    And completes personal information
    Then user should be logged in


  Scenario: Buy an item as a authenticated customer
    Given user is logged in
    When user clicks on dogs
    And selects labrador retriever
    And selects tailed
    And adds to cart
    And the user checks out
    And enters credit card number and expiry date
    And submits the order
    Then the transaction wont be committed


  Scenario: Create a new category as a authenticated user
    Given user is already logged in
    When user clicks on category
    And enters required information and clicks on create
    And user saves the category
    Then there should be a new category

  Scenario: Create a new Country
    Given user is authenticated
    When user clicks on account
    And user clicks on country
    And enters country entities and clicks on create
    And user saves the country
    Then there should be a new country

