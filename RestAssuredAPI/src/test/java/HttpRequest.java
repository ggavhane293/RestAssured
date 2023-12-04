import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;




/*
 * given()
 * content type, set cookies, add auth, set headers info etc....
 * 
 * when()
 * get,post,put,delete
 * 
 * then()
 * validate status code, extract headers cookies & response body..
 */


public class HttpRequest {
		
	//Below example for GET method, get user
		
	@Test
		void getUsers()
		{
			given()
			
			.when()
				.get("https://reqres.in/api/users?page=2")
			
			.then()
				.statusCode(200)
				.body("page", equalTo(2))
				.log().all();
		}
		
		//Below example for POST method, create user
		//@Test
		void createUser()
		{
			HashMap data = new HashMap();
				data.put("name", "Ganesh");
				data.put("job", "tester");
				
			given()
				.contentType("application/json")
				.body(data)
			.when()
				.post("https://reqres.in/api/users")
			
			.then()
				.statusCode(200)
				.log().all();
			;
		}
		//Below example for PUT method, update user
		//@Test
		void updateuser()
		{
			HashMap data = new HashMap();
			data.put("name", "GaneshG");
			data.put("job", "Tester");
			given()
				.contentType("application/json")
				.body(data)
				
			.when()
				.put("https://reqres.in/api/users/696")
			.then()
				.statusCode(200)
				.log().all()
			;
		}
}
