package com.piti.java.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hotelbooking.model.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long>{

}
