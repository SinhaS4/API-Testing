package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteMethod {

	@Test
	public void TestCase1()
	{
		RestAssured.when().
		  delete("https://reqres.in/api/users/2").
		  then().statusCode(204).
		  log().body();
	}
}
