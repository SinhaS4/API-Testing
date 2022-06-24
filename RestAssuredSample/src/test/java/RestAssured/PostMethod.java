package RestAssured;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostMethod {
     @Test
	public void Testcase2()
	{
		File json=new File("File.json");   //here we are creating the json file then calling and checking
		RestAssured.given().
		contentType(ContentType.JSON).body(json)
		.when()
		   .post("https://reqres.in/api/users")
		.then().statusCode(201).log().body();
	}
     
     @Test
     public void Testcase3()
     {
    	 Map<String, Object> map=new HashMap<String, Object>();  //here we are normally giving datas using hash maps and converting it in json file
    	 map.put("name", "saumya");
    	 map.put("job", "analyst");
    	 System.out.println(map);
    	 
    	 JSONObject json=new JSONObject(map);
    	 System.out.println(json.toString());
    	 
    	 RestAssured.given().
 		  contentType(ContentType.JSON).body(json.toString())
 		.when()
 		   .post("https://reqres.in/api/users")
 		.then()
 		   .statusCode(201).log().body();
     }
     
     @Test
     public void Testcase4()
     {
    	 JSONObject request= new JSONObject();  //Dynamically creating object using JSONObject which is the easy and best method
    	 request.put("name","Saumya");
    	 request.put("job","Analyst");
    	 System.out.println(request.toString());
    	 
    	 RestAssured.given().
		  contentType(ContentType.JSON).body(request.toString())
		.when()
		   .post("https://reqres.in/api/users")
		.then()
		   .statusCode(201).log().body();
     }
}
