package com.piti.java.hotelbooking.projection;

import java.time.LocalDate;

public interface BookingByDate {
	String getHotelName();
	
	LocalDate getBookingDate();
	
	Long getTotalBooking();
	
	Double getAmount();
}
