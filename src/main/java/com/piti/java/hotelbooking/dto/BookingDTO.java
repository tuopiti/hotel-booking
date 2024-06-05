package com.piti.java.hotelbooking.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	private List<RoomBookingDTO> rooms;
    private Boolean status;
}
