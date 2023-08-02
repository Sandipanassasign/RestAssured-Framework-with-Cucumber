package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.pojoAddMap;

public class Databuilder {
	
	
	public pojoAddMap getPayload() {
		
		
		pojoAddMap pj = new pojoAddMap();
		pj.setAccuracy(50);
		pj.setName("Frontline house");
		pj.setPhone_number("(+91) 983 893 3937");
		pj.setAddress("29, side layout, cohen 09");
		pj.setWebsite("http://google.com");
		pj.setLanguage("French-IN");

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

}
