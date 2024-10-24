package com.piti.java.hotelbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hotelbooking.projection.BookingByDate;
import com.piti.java.hotelbooking.service.ReportingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/reports")
@AllArgsConstructor
public class ReportingController {
	private final ReportingService reportingService;
	 
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_SUPER_ADMIN')")
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingByDate>> getBookingsByDate(
            @RequestParam("bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
            Authentication authentication) {
        
       
        List<BookingByDate> bookingByDateList = reportingService.getBookingByDate(bookingDate, authentication);
        return ResponseEntity.ok(bookingByDateList);
    }
}
