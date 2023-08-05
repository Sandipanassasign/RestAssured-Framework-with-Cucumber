package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification queryBaseReq;
	public RequestSpecification baseReq;
	public RequestSpecification baseURIRequest;
	public JsonPath js;

	public static RequestSpecification baserequest() throws IOException {

		if (queryBaseReq == null) {

			PrintStream log = new PrintStream(new File("logfile.txt"));

			queryBaseReq = new RequestSpecBuilder().setBaseUri(getGlobalDatas()).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			return queryBaseReq;
		}

		return queryBaseReq;
	}

	public static String getGlobalDatas() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resources\\GlobalProperties.properties");
		prop.load(fis);

		return prop.getProperty("baseurl");

	}

	public String getJsonpath(Response responseString, String Key) {

		String StrResponse = responseString.asPrettyString();

		js = new JsonPath(StrResponse);

		String intendedresponseValue = js.get(Key).toString();

		return intendedresponseValue;

	}

}
