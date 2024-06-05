package com.piti.java.hotelbooking.spec;

import lombok.Data;

@Data
public class HotelFilter {
	private Integer hotelId;
	private String hotelName;
	private Integer locationId;
	private String locationName;
}
