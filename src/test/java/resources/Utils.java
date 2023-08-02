package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public RequestSpecification queryBaseReq;
	public RequestSpecification baseReq;
	public RequestSpecification baseURIRequest;
	
	public RequestSpecification baserequest() {
		
		
		queryBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		
		baseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		baseURIRequest= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").build();
		return queryBaseReq;
	}
	

}
