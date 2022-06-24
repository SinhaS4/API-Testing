package RestAssured;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutMethod {

	@Test
	public void TestCase1()
	{
		JSONObject Request=new JSONObject();
		Request.put("Name","Saumya");
		Request.put("Job", "Analyst");
		
		RestAssured.given().
		  contentType(ContentType.JSON).body(Request.toString())
		.when()
		   .put("https://reqres.in/api/users/2")
		.then()
		   .statusCode(200).log().body();
		
	}
	
	 @Test
     public void Testcase2()
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
 		    .put("https://reqres.in/api/users/2")
 		.then()
 		   .statusCode(200).log().body();
     }
}
