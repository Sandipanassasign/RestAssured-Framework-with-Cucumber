package stepDefinations;

import static io.restassured.RestAssured.given;

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
import resources.Databuilder;
import resources.Utils;

public class AddPlaceAPIStepDefination extends Utils {

	public RequestSpecification request;
	public ResponseSpecification res;
	public Response rcvdResponse;
	
	public JsonPath js;
	Databuilder payload=new Databuilder();
	
	
	@Given("Added the Add API {string}")
	public void added_the_add_api(String string)  {

		

		

		request = given().spec(baserequest()).body(payload.getPayload());

		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

	}

	@When("Post the Add API with the json payload")
	public void post_the_add_api_with_the_json_payload() {

		rcvdResponse = request.log().all().when().post("/maps/api/place/add/json").then().spec(res).log().all()
				.extract().response();

	}

	@Then("Validates the HTTP StatusCode of the response is {int}")
	public void validates_the_http_of_the_response_is(int value) {

		System.out.println(rcvdResponse.getStatusCode());
		Assert.assertEquals(rcvdResponse.getStatusCode(), value);

	}

	@Then("validates the {string} in the response is {string}")
	public void validates_the_in_the_response_is(String key, String value) {

		String responseString = rcvdResponse.asString();

		js = new JsonPath(responseString);

		Assert.assertTrue(js.get(key).equals(value));

	}
	
	
	@Then("Validates {string} in the response is {string}")
	public void validates_in_the_response_is(String scope, String value) {
	   
		Assert.assertTrue(js.get(scope).equals(value));
		
	}
}
