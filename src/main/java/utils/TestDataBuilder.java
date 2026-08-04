package utils;

import models.Booking;
import models.BookingDates;

public class TestDataBuilder {

    public static Booking createBookingData() {

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

        return booking;

    }
    
    
    public static Booking updateBookingData() {

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

        return booking;

    }

}