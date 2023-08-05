package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@DelPlaceAPI")
	public void beforeDeleteAPI() throws IOException {
		
		AddPlaceAPIStepDefination apistep=new AddPlaceAPIStepDefination();
		
		
		if(AddPlaceAPIStepDefination.placeIDfromResponse==null) {
		apistep.add_the_add_api_with_payload("22.6228205", "88.3674331"
				, 50, "Vedic Village Spa Resort", "09830025900", "Shikharpur P.O, Bagu", "http://www.thevedicvillage.com/", "EN");
		
		apistep.user_call_the_the_with_the_json_payload("POST", "Addmapapi");
		
		apistep.validate_the_value_in_the_matches_with_the_addmapi_response("Vedic Village Spa Resort", "Getmapdetailsapi");
		}
	
	}
	
}
