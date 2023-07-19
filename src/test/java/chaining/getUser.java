package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class getUser {
	
	@Test
	public void getuser(ITestContext context) {

	 
	baseURI = "https://gorest.co.in/";
	String token = "f4b465f0ec36b00c21224216f293d57db384c0300f0a967bda04caa03e5d1d9d";
	//int id = (int) context.getAttribute("user_id");
	int id = (int) context.getSuite().getAttribute("user_id");
    given().headers("Authorization","Bearer " + (token))
    .pathParam("id", id).when()
    .get
    ("/public/v2/users/{id}")
    .then().statusCode(200).log().all();

	}
}
	


