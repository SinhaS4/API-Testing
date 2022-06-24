package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class StudentGet {
  
	@Test
	public void TestCase1()
	{
		RestAssured.given()
		   .get("http://localhost:8080/student/103")
		.then()
		   .statusCode(200)
		   .log().body();
	}
}
