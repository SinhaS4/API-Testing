package RestAssured;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ExtractMethod {

	@Test
	public void TestCase1()
	{
		Response Response=RestAssured.given().contentType(ContentType.JSON).get("https://reqres.in/api/users");
		
		//Technique 1
		int Id=Response.then().extract().path("data[0].id");
		System.out.println(Id);
		
		//Technique 2
		int userid=Response.jsonPath().get("data[0].id");
		System.out.println(userid);
		
		//Extract the email of person whose first name is michael
		String email=Response.jsonPath().get("data.find{it.last_name=='Wong'}.email");
		System.out.println(email);
		
		//Extract the email whose id is max
		String useremail=Response.jsonPath().get("data.max{it.id}.email");
		System.out.println(useremail);
		
		////Extract the email whose id is min
		String useremail1=Response.jsonPath().get("data.min{it.id}.email");
		System.out.println(useremail1);
	}
	
	@Test
	public void TestCase2()
	{
		Response Response=RestAssured.given().contentType(ContentType.JSON).get("https://reqres.in/api/users");
		
		Headers responseheaders= Response.getHeaders();   //to get the headers we are using headers class
		System.out.println(responseheaders);
		
		Header obj=responseheaders.get("Content-Type");    //to get the particular key:value pair from headers we are using this 
		System.out.println(obj);
		
		String obj1=responseheaders.get("Content-Type").getValue();   //to get only the value of the particular thing we are using this method
		System.out.println(obj1);
	}
	
	@Test
	public void TestCase()
	{
		//jwayjson is an another method of extracting.
		//Syntax->JsonPath.read("name of the object of response".asString,"path").
		//"$"-indicates that the extraction will happen from the root(from the top).
		Response response=RestAssured.given().contentType(ContentType.JSON).get("https://reqres.in/api/users");
		
		Map<String,Object> value=JsonPath.read(response.asString(),"$");//print all the value
		System.out.println(value);
		
		int value1=JsonPath.read(response.asString(),"$.total");//print the total value from the response
		System.out.println(value1);
		
		List<String> value2=JsonPath.read(response.asString(), "$.data[*].id");//print the total id as we have given *.
		System.out.println(value2);
		
		List<String> value3=JsonPath.read(response.asString(),"$.data[*].email");//print the all emails
		System.out.println(value3);
	}
}
