package services;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import models.Booking;
import endpoints.Routes;
import specifications.RequestSpec;

public class BookingService {

    public int createBooking(Booking booking) {

        Response response =

                given()
                        .spec(RequestSpec.requestSpecification())
                        .body(booking)

                .when()
                        .post(Routes.BOOKING);

        response.then().statusCode(200);

        return response.jsonPath().getInt("bookingid");

    }
    
    public Response getBooking(int bookingId) {

        return

                given()

                        .spec(RequestSpec.requestSpecification())

                .when()

                        .get(Routes.BOOKING + "/" + bookingId);

    }
    
    public Response updateBooking(int bookingId, String token, Booking booking) {

		return
		
			given()
			
			  .spec(RequestSpec.requestSpecification())
			  .cookie("token", token)
			  .body(booking)
			
			.when()
			
			  .put(Routes.BOOKING + "/" + bookingId);
		
		}
    
    public Response patchBooking(int bookingId, String token, String patchBody) {

		return
		
			given()
			
			   .spec(RequestSpec.requestSpecification())
			   .cookie("token", token)
			   .body(patchBody)
			
			.when()
			
			   .patch(Routes.BOOKING + "/" + bookingId);
		
		}
    
    public Response deleteBooking(int bookingId, String token) {

	return
	
		given()
		
		  .spec(RequestSpec.requestSpecification())
		  .cookie("token", token)
		
		.when()
		
		  .delete(Routes.BOOKING + "/" + bookingId);
		
	}

}