package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredMethods {

	public static void post() {

		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");
		request.body("{ \"name\": \"Jatin\", \"age\": 30 }");

		Response response = request.header("", "").body("").post("/api/users");

	}

	public static void simpleAuth() {

		RestAssured.baseURI = "http://example.com/api";
		RestAssured.authentication = RestAssured.basic("username", "password");
		Response response = RestAssured.given().when().get("/users");
		System.out.println(response.getBody().asString());
	}

	public static void JsonPath() {
		
		Response response = RestAssured.get("/api/users");
		String firstName = response.jsonPath().getString("data[0].first_name");
		int userId = response.jsonPath().getInt("data[0].id");
		System.out.println("First name: " + firstName);
		System.out.println("User ID: " + userId);
	}
	
}
