package chaining;
import io.restassured.RestAssured;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONObject;


public class CreateUser {
	
	
	
	@Test
	public void createUser(ITestContext context) {


		Faker faker = new Faker();		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		baseURI = "https://gorest.co.in/";
		String token = "f4b465f0ec36b00c21224216f293d57db384c0300f0a967bda04caa03e5d1d9d";
		
        int  id =  given().headers("Authorization","Bearer " + (token))
        .contentType("application/json")
        .body(data.toJSONString())
        .when()
        .post
        ("/public/v2/users")
        .then().statusCode(201).log().all().extract().jsonPath().getInt("id");
        System.out.println("id is " + id);


       // context.setAttribute("user_id", id);
        context.getSuite().setAttribute("user_id", id);
		
		
		
		
	}
	

}
