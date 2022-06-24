package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class StudentDelete {

	@Test
	public void TestCase1()
	{
	 RestAssured.when()
	      .delete("http://localhost:8080/student/103")
	    .then()
	       .statusCode(204)
	       .log().body();
	    
	}
}
