package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResource;
import resources.Databuilder;
import resources.Utils;

public class AddPlaceAPIStepDefination extends Utils {

	public RequestSpecification request;
	public ResponseSpecification res;
	public Response rcvdResponse;
	public APIResource API;
	public JsonPath js;
	static String placeIDfromResponse;
	public Databuilder payload = new Databuilder();

	@Given("Add the Add API with payload {string} {string} {int} {string} {string} {string} {string} {string}")
	public void add_the_add_api_with_payload(String lat, String lng, int accuracy, String name, String phone_number,
			String address, String website, String language) throws IOException {

		request = given().spec(baserequest())
				.body(payload.getAddPayload(lat, lng, accuracy, name, phone_number, address, website, language));

		

	}

	@When("User call the {string} the {string} with the json payload")
	public void user_call_the_the_with_the_json_payload(String method, String resourceapi) {

		API = APIResource.valueOf(resourceapi);
		System.out.println("is enium working " + API.getresource());
		
		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if (method.equalsIgnoreCase("POST"))
			rcvdResponse = request.log().all().when().post(API.getresource()).then().spec(res).log().all().extract()
					.response();
		else if (method.equalsIgnoreCase("GET"))
			rcvdResponse = request.log().all().when().get(API.getresource()).then().spec(res).log().all().extract()
					.response();
		else if (method.equalsIgnoreCase("DELETE"))
			rcvdResponse = request.log().all().when().delete(API.getresource()).then().spec(res).log().all().extract()
					.response();

	}

	@Then("Validates the HTTP StatusCode of the response is {int}")
	public void validates_the_http_of_the_response_is(int value) {

		System.out.println(rcvdResponse.getStatusCode());
		Assert.assertEquals(rcvdResponse.getStatusCode(), value);

	}

	@Then("validates the {string} in the response is {string}")
	public void validates_the_in_the_response_is(String key, String value) {

		Assert.assertTrue(getJsonpath(rcvdResponse, key).equals(value));

	}

	@Then("Validates {string} in the response is {string}")
	public void validates_in_the_response_is(String scope, String value) {

		Assert.assertTrue(getJsonpath(rcvdResponse, scope).equals(value));

	}

	@Then("Validate the {string} value in the {string} matches with the Addmapi response")
	public void validate_the_value_in_the_matches_with_the_addmapi_response(String Actualname, String resourceapi)
			throws IOException {

		// Get the Map details
		placeIDfromResponse = getJsonpath(rcvdResponse, "place_id");

		request = given().spec(baserequest()).queryParam("place_id", placeIDfromResponse);

		user_call_the_the_with_the_json_payload("GET", resourceapi);

		String ExpectedResponseName = getJsonpath(rcvdResponse, "name");
		Assert.assertEquals(Actualname, ExpectedResponseName);

	}

	@Given("User add the Payload in the DeleteAPI")
	public void user_add_the_payload_in_the_delete_api() throws IOException {

		
		request = given().spec(baserequest()).body(payload.Deletepayload(placeIDfromResponse));
		
	
		
		
	}

}
