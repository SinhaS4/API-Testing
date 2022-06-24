package RestAssured;

import io.restassured.RestAssured;

public class sample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.given().queryParam("page","1")
		.get("https://reqres.in/api/users")
	    .then().log().all();
		
		//inside query param we can give one thing as before question mark and second thing as a numbers.
		
		RestAssured.given().pathParam("saumya",3)
		.get("https://reqres.in/api/users/{saumya}")
	    .then().log().body();
		
		/*inside path param we can give one as anything just need to add in URI with
		curly braces as i have done and second as a number*/
		
		
	}

}
