package chaining;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.ITestContext;

import com.github.javafaker.Faker;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class updateUser {
	
public void update(ITestContext context) {
	//int id = (int) context.getAttribute("user_id");
	int id = (int) context.getSuite().getAttribute("user_id");
	baseURI = "https://gorest.co.in/";
	Faker faker = new Faker();
	
	JSONObject data = new JSONObject();
	
	data.put("name", faker.name().fullName());
	data.put("gender", "male");
	data.put("email", faker.internet().emailAddress());
	data.put("status", "active");
	
	System.out.println(data);
	String token = "f4b465f0ec36b00c21224216f293d57db384c0300f0a967bda04caa03e5d1d9d";

	given()
		.headers("Authorization", "Bearer " + token)
		.contentType("application/json")
		.pathParam("id", id)
		.body(data.toJSONString())
	.when()
		.put("/public/v2/users/{id}")
	.then()
		 .statusCode(200)
		 .log()
		 .all();

}

}
