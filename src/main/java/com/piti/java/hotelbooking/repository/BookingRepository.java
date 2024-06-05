package com.piti.java.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hotelbooking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
}

