package RestAssured;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class StudentPut {

	
	@Test
	public void TestCase1()
	{
		JSONObject obj=new JSONObject();
		obj.put("firstName","Asmita");
   	    obj.put("lastName","Patil");
   	    obj.put("email","Asmita.patil@gmail.com");
   	    obj.put("programme","Electrical");
   	    
   	    JSONArray arr=new JSONArray();
   	    arr.put("Networks");
   	    arr.put("Control System");
   	    arr.put("Power System");
   	    
   	    obj.put("courses", arr);
   	    System.out.println(obj.toString());
   	    
   	    RestAssured.given().contentType(ContentType.JSON)
   	        .body(obj.toString())
   	        .when()
   	            .put("http://localhost:8080/student/101")
   	        .then()
   	            .statusCode(200)
   	            .log().body();
   	    
		
	}
}
