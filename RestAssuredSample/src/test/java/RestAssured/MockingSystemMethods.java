package RestAssured;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class MockingSystemMethods {
 
	//@Test
	public void TestCase1()
	{
	RestAssured.given()
	      .get("http://localhost:3000/users")
	   .then()
	      .statusCode(200)
	      .log().body();
	
	}
	
	//@Test
	public void TestCase2()
	{
		
		JSONObject json=new JSONObject();
		json.put("firstName", "Mathew");
		json.put("lastName", "perry");
		
		
		RestAssured.given().contentType(ContentType.JSON).body(json.toString())
		  .when()
		    .post("http://localhost:3000/users")
		  .then()
		     .statusCode(201)
		     .log()
		     .body();
	}
	
	@Test
	public void TestCase3()
	{
		RestAssured.when()
		              .delete("http://localhost:3000/users/4")
		           .then()
		              .statusCode(204)
	                  .log()
		              .body();
	}
}
