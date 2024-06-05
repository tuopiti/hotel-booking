package com.piti.java.hotelbooking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hotelbooking.dto.BookingDTO;
import com.piti.java.hotelbooking.service.BookingService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/booking")
@AllArgsConstructor
public class BookingController {
	private BookingService bookingService;
	
	@PostMapping
    public ResponseEntity<?> create(@RequestBody BookingDTO bookingDTO) {        
        bookingService.booking(bookingDTO);
        return ResponseEntity.ok().build();
    }
}
