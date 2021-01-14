@PetStore
Feature: Pet store feature

  Scenario: Pet store scenario
    Given User get the available pets and verify "available" in response
    When User added new pet to store and verify id "76" in response
    And User update status to sold and status is "sold" in response
    And User deletes the pet
    Then User validate that pet is deleted
