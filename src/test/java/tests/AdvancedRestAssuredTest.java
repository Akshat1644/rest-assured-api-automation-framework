package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.Test;

import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import models.Booking;
import specifications.RequestSpec;

public class AdvancedRestAssuredTest extends BaseTest {
	
	@Test
	public void deserializeBookingResponse() {

	    int bookingId = 1;

	    Booking booking =

	            given()

	                    .spec(RequestSpec.requestSpecification())

	            .when()

	                    .get(Routes.BOOKING + "/" + bookingId)

	            .as(Booking.class);

	    System.out.println("First Name : " + booking.getFirstname());
	    System.out.println("Last Name  : " + booking.getLastname());
	    System.out.println("Price      : " + booking.getTotalprice());
	    System.out.println("Deposit Paid : " + booking.isDepositpaid());
	    System.out.println("Additional Needs : " + booking.getAdditionalneeds());
	    
	    Response response =

	            given()

	                    .spec(RequestSpec.requestSpecification())

	            .when()

	                    .get(Routes.BOOKING + "/" + bookingId);

	    response.then()
	            .statusCode(200);

	}
	
	
	@Test
	public void getBookingUsingPathParam() {

	    int bookingId = 1;

	    given()

	            .spec(RequestSpec.requestSpecification())

	            .pathParam("id", bookingId)

	    .when()

	            .get(Routes.BOOKING + "/{id}")

	    .then()

	            .statusCode(200)
	            .log().all();

	}
	
	
	@Test
	public void getBookingUsingQueryParam() {

	    given()

	            .spec(RequestSpec.requestSpecification())

	            .queryParam("firstname", "Susan")

	    .when()

	            .get(Routes.BOOKING)

	    .then()

	            .statusCode(200)
	            .log().all();

	}
	
	
	@Test
	public void extractResponseData() {

	    Response response =

	            given()

	                    .spec(RequestSpec.requestSpecification())

	            .when()

	                    .get(Routes.BOOKING + "/1");

	    System.out.println("Status Code : " + response.statusCode());

	    System.out.println("Response Time : " + response.time());

	    System.out.println("Content Type : "
	            + response.getContentType());

	    System.out.println("Server : "
	            + response.getHeader("Server"));

	}
	
	
	@Test
	public void extractUsingJsonPath() {

	    Response response =

	            given()

	                    .spec(RequestSpec.requestSpecification())

	            .when()

	                    .get(Routes.BOOKING + "/1");

	    System.out.println(response.jsonPath()
	            .getString("firstname"));

	    System.out.println(response.jsonPath()
	            .getString("lastname"));

	    System.out.println(response.jsonPath()
	            .getInt("totalprice"));

	    System.out.println(response.jsonPath()
	            .getBoolean("depositpaid"));

	    System.out.println(response.jsonPath()
	            .getString("bookingdates.checkin"));

	}
	
	
	@Test
	public void validateHeaders() {

	    given()

	            .spec(RequestSpec.requestSpecification())

	    .when()

	            .get(Routes.BOOKING + "/1")

	    .then()

	            .statusCode(200)

	            .header("Content-Type",
	                    "application/json; charset=utf-8")

	            .header("Server",
	                    "Heroku");

	}
	
	
	
	@Test
	public void validateResponseTime() {

	    given()

	            .spec(RequestSpec.requestSpecification())

	    .when()

	            .get(Routes.BOOKING + "/1")

	    .then()

	            .time(lessThan(10000L));

	}
	
	

}