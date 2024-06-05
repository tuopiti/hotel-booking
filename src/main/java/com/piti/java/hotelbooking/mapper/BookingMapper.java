package com.piti.java.hotelbooking.mapper;

import java.math.BigDecimal;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.piti.java.hotelbooking.dto.BookingDTO;
import com.piti.java.hotelbooking.dto.RoomBookingDTO;
import com.piti.java.hotelbooking.model.Booking;
import com.piti.java.hotelbooking.model.BookingDetail;
import com.piti.java.hotelbooking.service.RoomService;

@Mapper(componentModel = "spring", uses = {RoomService.class})
public interface BookingMapper {
	Booking toBooking(BookingDTO dto);
	
	@Mapping(target = "booking", source = "booking")
	@Mapping(target = "room", source = "dto.roomId")
	@Mapping(target = "id", ignore = true)
	BookingDetail toBookingDetail(RoomBookingDTO dto, Booking booking, BigDecimal totalPrice);
}
