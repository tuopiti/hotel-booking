package com.piti.java.hotelbooking.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingDTO {
	private Long roomId;
    private Integer numberOfGuest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
