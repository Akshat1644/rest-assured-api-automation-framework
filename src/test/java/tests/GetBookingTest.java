package tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import endpoints.Routes;
import specifications.RequestSpec;
import specifications.ResponseSpec;

import java.util.List;

public class GetBookingTest extends BaseTest {

    @Test
    public void getBookingSuccessfully() {

        List<Integer> bookingIds =
            given()
                .spec(RequestSpec.requestSpecification())
            .when()
                .get(Routes.BOOKING)
            .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("bookingid", Integer.class);

        Assert.assertNotNull(bookingIds, "Booking IDs should not be null");
        Assert.assertFalse(bookingIds.isEmpty(), "At least one booking should exist");

        int bookingId = bookingIds.get(0);

        given()
            .spec(RequestSpec.requestSpecification())
        .when()
            .get(Routes.BOOKING + "/" + bookingId)
        .then()
            .spec(ResponseSpec.responseSpecification());
    }
}
