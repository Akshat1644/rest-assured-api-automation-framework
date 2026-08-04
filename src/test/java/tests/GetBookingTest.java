package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import base.BaseTest;
import endpoints.Routes;
import specifications.RequestSpec;
import specifications.ResponseSpec;

public class GetBookingTest extends BaseTest {

    @Test
    public void getBookingSuccessfully() {
    	
    	int bookingId = 1;

    	given()

    	.spec(RequestSpec.requestSpecification())

    	.when()

    	.get(Routes.BOOKING + "/" + bookingId)

    	.then()

    	.spec(ResponseSpec.responseSpecification())

    	.body("firstname", equalTo("Akshat"))

    	.body("lastname", equalTo("Dahalwar"));
    	

    }

}