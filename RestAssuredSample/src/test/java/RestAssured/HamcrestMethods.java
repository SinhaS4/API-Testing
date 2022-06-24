package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
public class HamcrestMethods {
  
	@Test
	public void TestCase1()
	{
		//equalto is an inbuilt method used to compare.
		RestAssured.given().get("https://private-1d42c4-remi2.apiary-mock.com/search").then()
		     .body("medications[0].aceInhibitors[0].name",equalTo("lisinopril"));
		
		//hasitem is inbuilt method to check weather the item is present or not.
		RestAssured.given().get("https://private-1d42c4-remi2.apiary-mock.com/search").then()
	     .body("labs.time",hasItem("Today"));
		
		//hasitems is inbuilt method to check weather the items is present or not.
		RestAssured.given().get("https://private-1d42c4-remi2.apiary-mock.com/search").then()
	     .body("labs.time",hasItems("Today","3 Weeks","1 Year"));
		
		//Hasentry is a keyword which is used to check whether the option is present or not.
		RestAssured.given().get("https://private-1d42c4-remi2.apiary-mock.com/search").then()
	     .body("labs[0].paymentOptions",hasEntry("allowCheque",true));
	}
	
	@Test
	public void TestCase2()
	{
		//HardAssertion it will check the first condition and then if it fails it will stop executing
		RestAssured.given().get("https://reqres.in/api/users/7").then()
	     .body("id", equalTo(7))
	     .body("id", greaterThan(10))
	     .body("id", lessThan(12));
		
		
	}
	
	@Test
	public void TestCase3()
	{
		//softAssertion it will check the first condition if it fails then move to the second.
		RestAssured.given().get("https://reqres.in/api/users/7").then()
	     .body("id", equalTo(7),"id", greaterThan(5),"id", lessThan(10));
	}
}
