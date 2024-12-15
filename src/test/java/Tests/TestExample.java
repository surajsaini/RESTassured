package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;

import java.util.*;

@Test(enabled = false)
public class TestExample {

	public void test_1() {

		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
	}

	@Test
	public void test1() {
		
		JSONObject json = new JSONObject();
		
		json.put("name", "suraj");
		json.put("secondname", "saini");
		
		String resbody = json.toString();

		RequestSpecification rs = RestAssured.given().header("content-type", "application/json")
				.baseUri("http://localhost:3000");

	Response response = RestAssured.given().spec(rs).when().body(resbody).post("/users");
	response.then().assertThat().body("name",Matchers.equalTo("saini"));
	
	System.out.println(response.getBody().asString());
		
		

	}

}
