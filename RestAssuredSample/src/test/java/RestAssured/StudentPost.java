package RestAssured;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StudentPost {

	
	@Test
	public void TestCase1()
	{
		JSONObject obj= new JSONObject();  //Dynamically creating object using JSONObject which is the easy and best method
   	    obj.put("firstName","Asmit");
   	    obj.put("lastName","Patel");
   	    obj.put("email","Asmit.patel@gmail.com");
   	    obj.put("programme","Electrical");
   	    
   	    JSONArray arr=new JSONArray();
   	    arr.put("Networks");
   	    arr.put("Control System");
   	    arr.put("Power System");
   	    
   	    obj.put("courses", arr);
   	    System.out.println(obj.toString());
   	 
   	    RestAssured.given().
		  contentType(ContentType.JSON).body(obj.toString())
		.when()
		   .post("http://localhost:8080/student")
		.then()
		   .statusCode(201)
		   .log().body();
	}
	
	@Test
	public void TestCase2()
	{
		JSONObject obj= new JSONObject();  //Dynamically creating object using JSONObject which is the easy and best method
   	    obj.put("firstName","Riya");
   	    obj.put("lastName","Roy");
   	    obj.put("email","Riya.Roy@gmail.com");
   	    obj.put("programme","Electronics");
   	    
   	    JSONArray arr=new JSONArray();
   	    arr.put("Networks");
   	    arr.put("Control System");
   	    arr.put("Power System");
   	    
   	    obj.put("courses", arr);
   	    System.out.println(obj.toString());
   	 
   	    RestAssured.given().
		  contentType(ContentType.JSON).body(obj.toString())
		.when()
		   .post("http://localhost:8080/student")
		.then()
		   .statusCode(201)
		   .log().body();
	}
}
