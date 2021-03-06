package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class T01_Get_Request extends BaseTest {

	@Test
	public void getJockers() {
		
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "/new/?jokers_enabled=true");

		String responBody = response.getBody().asString();
		System.out.println("Response Body is : " + responBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// status line
		String statusLine = response.getStatusLine();
		System.out.println("Status line :" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

	@Test
	void getDraw() {

		RequestSpecification httpRequest = RestAssured.given();

		// here i use the 
		Response response = httpRequest.request(Method.GET, "/93sze1gp5g9b/draw");

		String responBody = response.getBody().asString();
		System.out.println("Response Body is : " + responBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// status line
		String statusLine = response.getStatusLine();
		System.out.println("Status line :" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
