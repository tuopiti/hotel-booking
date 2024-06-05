package com.piti.java.hotelbooking.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "booking_details")
public class BookingDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    
    @Column(name = "guest")
    private Integer numberOfGuest;
}
