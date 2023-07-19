package auth;

import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class bearerToken {
	
    @Test
    public void bearertoken(){


        baseURI = "https://api.github.com";
        String token = "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";
        given().headers("Authorization","Bearer " + (token))
                .when()
                .get("/user/repos")
                .then().statusCode(200).log().all();

    }
	

}
