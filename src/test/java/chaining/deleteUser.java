package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {
	@Test
	public void deleteuser(ITestContext context) { 
	baseURI = "https://gorest.co.in/";
	//int id = (int) context.getAttribute("user_id");
	int id = (int) context.getSuite().getAttribute("user_id");
	String token = "f4b465f0ec36b00c21224216f293d57db384c0300f0a967bda04caa03e5d1d9d";
    given().headers("Authorization","Bearer " + (token))
    .pathParam("id", id).when()
    .delete
    ("/public/v2/users/{id}")
    .then().statusCode(204).log().all();
	}
}
