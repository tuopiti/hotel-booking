package com.piti.java.hotelbooking.dto;

import lombok.Data;

@Data
public class HotelDTO {
	private Long id;
	private String name;
	private String address;
	private String description;
	private Integer rating;
	private String imageUrl;
	private Long locationId;
	private Long ownerId;
}
