package tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import models.Booking;
import models.BookingDates;
import specifications.RequestSpec;
import specifications.ResponseSpec;
import base.BaseTest;
import endpoints.Routes;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBookingSuccessfully() {
        
        BookingDates dates = new BookingDates();
        dates.setCheckin("2026-08-01");
        dates.setCheckout("2026-08-05");

        Booking booking = new Booking();
        booking.setFirstname("Akshat");
        booking.setLastname("Dahalwar");
        booking.setTotalprice(1500);
        booking.setDepositpaid(true);
        booking.setBookingdates(dates);
        booking.setAdditionalneeds("Breakfast");
        
        Response response =

        		given()
        		.spec(RequestSpec.requestSpecification())
        		.body(booking)

        		.when()
        		.post(Routes.BOOKING);
        
        		int bookingId = response.jsonPath().getInt("bookingid");

        		System.out.println("Booking ID = " + bookingId);
        		
        }

}