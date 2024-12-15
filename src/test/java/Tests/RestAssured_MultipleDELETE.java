package Tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssured_MultipleDELETE {

	@Test
	static void multipleDelete() {

		int[] ids = { 1, 5 };

		for (int id : ids) {
			Response response = RestAssured.given().delete("http://localhost:3000/users/" + id);
			System.out.println(id + "--" + response.getStatusCode());
		}
	}

}
