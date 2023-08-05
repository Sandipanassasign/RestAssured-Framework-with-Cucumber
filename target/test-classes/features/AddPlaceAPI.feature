
Feature: Checking the AddPlace API 
  I want to use this template for my feature file

	@AddPlaceAPI
  Scenario Outline:
		: Verfiy the Add Place API is working properly or not
    Given Add the Add API with payload "<lat>" "<lng>" <accuracy> "<name>" "<phone_number>" "<address>" "<website>" "<language>"
    When User call the "Post" the "Addmapapi" with the json payload
    Then Validates the HTTP StatusCode of the response is 200
    And  validates the "status" in the response is "OK"
		And  Validates "scope" in the response is "APP"
		And  Validate the "<name>" value in the "Getmapdetailsapi" matches with the Addmapi response

		Examples:

|lat			 |lng			 |accuracy |name													|phone_number|address																						|website														 				|language|
|50.877045 |7.3157654|50			 |Naafbachtal Nature Reserve		|+7458748547 |Auenweg Neunkirchen-Seelscheid, Germany	          |https://nsg.naturschutzinformationen.nrw.de/|DE		 |
|52.1594683|6.0659377|50			 |Marhe / Sfeervolle Bestrating |+31557908831|Woudweg BC Klarenbeek, Netherlands			|https://www.sfeervollebestrating.nl/				 |NL     |

	@DelPlaceAPI
  Scenario: Verify the Delete MAP API is working properly or not
		Given User add the Payload in the DeleteAPI
		When 	User call the "DELETE" the "Deletemapapi" with the json payload
		Then 	Validates the HTTP StatusCode of the response is 200
		And  	validates the "status" in the response is "OK"
		
		
		
		
		