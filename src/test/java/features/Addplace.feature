
Feature: Checking the AddPlace API 
  I want to use this template for my feature file


  Scenario: Verfiy the Add Place API is working properly or not
    Given Added the Add API "Payload"
    When Post the Add API with the json payload
    Then Validates the HTTP StatusCode of the response is 200
    And  validates the "status" in the response is "OK"
		And  Validates "scope" in the response is "APP"
