package services;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import endpoints.Routes;
import specifications.RequestSpec;
import utils.ConfigReader;

public class AuthService {

    public String generateToken() {

    	String body =
    			"{\n" +
    			"\"username\":\""+ConfigReader.getProperty("username")+"\",\n"+
    			"\"password\":\""+ConfigReader.getProperty("password")+"\"\n"+
    			"}";

        Response response =

                given()
                        .spec(RequestSpec.requestSpecification())
                        .body(body)

                .when()
                        .post(Routes.AUTH);

        response.then().statusCode(200);

        return response.jsonPath().getString("token");
    }

}