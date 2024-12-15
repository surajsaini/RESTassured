

package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SurajSDET_RESTAssured {
	
	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Suraj");
		request.put("lastName", "Saini");
		request.put("subjectID", 3);
		
		baseURI = "http://localhost:3000";
		
		given().header("Content-Type","application/json")
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201);
		
	}

}
