package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.pojoAddMap;

public class Databuilder {
	
	
	public pojoAddMap getAddPayload(String lat,String lng, int accuracy,String name,String phone_number,String address,String website,String language) {
		
		
		pojoAddMap pj = new pojoAddMap();
		pj.setAccuracy(accuracy);
		pj.setName(name);
		pj.setPhone_number(phone_number);
		pj.setAddress(address);
		pj.setWebsite(website);
		pj.setLanguage(language);

		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);

		pj.setLocation(loc);

		List<String> lt = new ArrayList<String>();
		lt.add("shoe park");
		lt.add("shop");
		pj.setTypes(lt);
		return pj;
	}
	
	public String Deletepayload(String Placeid) {
		
		
		//String payload="{\"place_id\":\""+Placeid+"\"}";
		//return payload;
		
		
		return "{\r\n    \"place_id\":\""+Placeid+"\"\r\n}";
	}

}
