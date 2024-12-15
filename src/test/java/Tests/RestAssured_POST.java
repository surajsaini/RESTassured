package Tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssured_POST {

	@Test(enabled = true)
	public static void post() {
		
		String requestBody = "{\r\n"
				+ "  \"firstName\": \"Raghav9\",\r\n"
				+ "  \"lastName\": \"Pal9\",\r\n"
				+ "  \"subjectID\": 9,\r\n"
				+ "  \"id\": 1\r\n"
				+ "}";
		
	Response response = RestAssured.given().header("Content-Type", "application/json").body(requestBody)
			.when().post("http://localhost:3000/users");
			
			response.then().statusCode(201);
	

	
	
	System.out.println(response.getBody());
	System.out.println(response.getStatusCode());
	System.out.println(response.getHeader("Content-Type"));
	
	
		
		
		
//		RestAssured.given().baseUri("https://reqres.in").header("Content-Type", "application/json")
	//			.body("{ \"name\": \"Jatin\", \"job\": \"QA\" }").log().all().when().post("/api/users").then()
		//		.statusCode(201).log().all();

	}

	@Test(enabled = false)
	public static void post1() {
		// RestAssured.baseURI = "https://reqres.in";
		RestAssured.baseURI = "http://localhost:3000";

		// http://localhost:3000/users

		// Request Body as JSON
		String requestBody = "{\n" + "  \"name\": \"Jatin\",\n" + "  \"job\": \"QA\"\n" + "}";

		// POST Request
		Response response = RestAssured.given().header("Content-Type", "application/json") // Set Content-Type header
				.body(requestBody) // Attach JSON body
				.log().all() // Log request details
				.when().post("/users") // Specify endpoint
				.then().statusCode(201) // Validate status code
				.log().all() // Log response details
				.extract().response(); // Extract full response

		// Print Response Body
		System.out.println("Response Body: " + response.getBody().asString());
	}

}
