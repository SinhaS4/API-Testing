package RestAssured;

import io.restassured.RestAssured;

public class Sample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    RestAssured.given() 
    .get("https://reqres.in/api/users?page=1")
    /*.then().log().all();
     
        --this is used to get all the data of the page 1
    
     .then().statusCode(200).log().body();
     
        -- here we are checking that status code is matching or not if matching then only as a 
            output body will be seen*/
    
    .then().log().headers();
         /*here we are checking that status code is matching or not if matching then only as a 
           output only headers will be seen*/

	}

}
