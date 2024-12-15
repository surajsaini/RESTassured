package Tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssured_DELETE {
	
	
	@Test
	static void delete() {
		
		Response response = RestAssured.given()
				.delete("http://localhost:3000/users/1");
		
		System.out.println("status" + response.statusCode() );
		
	}
	

}
