package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import specifications.RequestSpec;
import specifications.ResponseSpec;

import endpoints.Routes;
import base.BaseTest;

public class GenerateTokenTest extends BaseTest {

    @Test
    public void generateToken() {

        String body = "{\n" +
                "\"username\":\"admin\",\n" +
                "\"password\":\"password123\"\n" +
                "}";
        Response response =
        		
		        given()
		            .spec(specifications.RequestSpec.requestSpecification())
		            .body(body)
		
		        .when()
		            .post(Routes.AUTH);
        
        		String token =
        		response.jsonPath().getString("token");

        		System.out.println(token);
		
		        response.then()
		            .statusCode(200);
    }
}