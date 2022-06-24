package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class GetMethod {
	@Test
	public void testcase1() {
	 RestAssured.given() 
	    .get("https://reqres.in/api/users?page=1")
	    .then().statusCode(200).log().all();
	}
}
