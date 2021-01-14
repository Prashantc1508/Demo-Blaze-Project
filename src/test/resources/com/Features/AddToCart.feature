@AddToCart
Feature: Add to cart feature

  Scenario: Add to cart scenario
    Given User navigates to home page
    When User select laptops from categories
    And User select laptop Sony vaio i5
    And User add the device to cart
    And User clicks on home button
    When User select laptops from categories
    And User select laptop Dell i7 8gb
    And User add the device to cart
    And User click on cart
    And User delete device "Dell i7 8gb" from cart
    And User clicks on home button
    And User click on cart
    Then User validate that device "Dell i7 8gb" is deleted from cart
