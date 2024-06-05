package com.piti.java.hotelbooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.piti.java.hotelbooking.dto.RoomDTO;
import com.piti.java.hotelbooking.model.Room;
import com.piti.java.hotelbooking.service.HotelService;

@Mapper(componentModel = "spring", uses = {HotelService.class})
public interface RoomMapper {

	@Mapping(target = "hotel", source = "roomDTO.hotelId")
	Room toEntity(RoomDTO roomDTO);
	
	@Mapping(target = "hotelId", source = "hotel.id")
	RoomDTO toDTO(Room room);
}
