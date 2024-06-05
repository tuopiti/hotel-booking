package com.piti.java.hotelbooking.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RoomDTO {
	private Long id;
	private Integer roomNumber;
	private String roomType;
	private BigDecimal roomPrice;
	private boolean availability;
	private Integer hotelId;
}
