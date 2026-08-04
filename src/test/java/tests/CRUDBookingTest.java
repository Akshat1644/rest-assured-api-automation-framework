package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import endpoints.Routes;
import io.restassured.response.Response;
import models.Booking;
import models.BookingDates;
import services.AuthService;
import services.BookingService;
import specifications.RequestSpec;
import utils.TestDataBuilder;

public class CRUDBookingTest extends BaseTest {

    private int bookingId;
    private String token;
    
    private AuthService authService = new AuthService();

    private BookingService bookingService = new BookingService();

    @Test(priority = 1)
    public void generateToken() {

        String authBody = "{\n"
                + "\"username\":\"admin\",\n"
                + "\"password\":\"password123\"\n"
                + "}";

        Response response =

                given()
                        .spec(RequestSpec.requestSpecification())
                        .body(authBody)

                .when()
                        .post(Routes.AUTH);

        response.then()
                .statusCode(200)
                .log().all();

        token = authService.generateToken();
        
    }

    @Test(priority = 2)
    public void createBookingSuccessfully() {

        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-08-01");
        dates.setCheckout("2026-08-05");

        Booking booking = TestDataBuilder.createBookingData();

        Response response =

                given()
                        .spec(RequestSpec.requestSpecification())
                        .body(booking)

                .when()
                        .post(Routes.BOOKING);

        response.then()
                .statusCode(200)
                .body("booking.firstname", equalTo("Akshat"))
                .body("booking.lastname", equalTo("Dahalwar"))
                .log().all();

        bookingId = bookingService.createBooking(booking);

        System.out.println("Booking ID : " + bookingId);
     
    }

    @Test(priority = 3)
    
    public void getBookingSuccessfully() {

        given()

                .spec(RequestSpec.requestSpecification())

        .when()

                .get(Routes.BOOKING + "/" + bookingId);

       bookingService.getBooking(bookingId)
           .then()
                .statusCode(200)
                .body("firstname", equalTo("Akshat"));
    }

    @Test(priority = 4)
    public void updateBookingSuccessfully() {

        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-09-01");
        dates.setCheckout("2026-09-10");

        Booking booking = new Booking();
        booking.setFirstname("Rahul");
        booking.setLastname("Sharma");
        booking.setTotalprice(2500);
        booking.setDepositpaid(false);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Lunch");

        bookingService.updateBooking(bookingId, token, booking)

        .then()
        .statusCode(200)
        .body("firstname", equalTo("Rahul"))
        .body("lastname", equalTo("Sharma"))
        .log().all();

    }

    @Test(priority = 5)
    public void partialUpdateBooking() {

        String patchBody = "{\n"
                + "\"firstname\":\"Virat\"\n"
                + "}";

        given()

                .spec(RequestSpec.requestSpecification())
                .cookie("token", token)
                .body(patchBody)

        .when()

                .patch(Routes.BOOKING + "/" + bookingId)

        .then()

                .statusCode(200)
                .body("firstname", equalTo("Virat"))
                .log().all();

    }

    @Test(priority = 6)
    public void deleteBookingSuccessfully() {

        bookingService.deleteBooking(bookingId, token)
            .then()
                .statusCode(201)
        		.log().all();
    }

    @Test(priority = 7)
	    public void verifyBookingDeleted() {
	
	        bookingService.getBooking(bookingId)
	            .then()
	            .statusCode(404)
	            .log().all();
	    }

}