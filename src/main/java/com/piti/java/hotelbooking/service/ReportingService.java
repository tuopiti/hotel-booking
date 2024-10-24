package com.piti.java.hotelbooking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.piti.java.hotelbooking.projection.BookingByDate;

public interface ReportingService {
	List<BookingByDate> getBookingByDate(LocalDate bookingDate, Authentication authentication);
}
