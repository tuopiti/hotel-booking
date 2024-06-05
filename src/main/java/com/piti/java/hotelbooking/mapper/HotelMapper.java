package com.piti.java.hotelbooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.piti.java.hotelbooking.dto.HotelDTO;
import com.piti.java.hotelbooking.model.Hotel;
import com.piti.java.hotelbooking.service.LocationService;
import com.piti.java.hotelbooking.service.UserService;

@Mapper(componentModel = "spring",uses = {LocationService.class, UserService.class})
public interface HotelMapper {
	HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);
	
	@Mapping(target = "location", source = "hotelDTO.locationId")
	@Mapping(target = "owner", source = "hotelDTO.ownerId")
    @Mapping(target = "imageUrl", ignore = true)
	Hotel toEntity(HotelDTO hotelDTO);
	
	@Mapping(target = "locationId", source = "location.id")
	@Mapping(target = "ownerId", source = "owner.id")
	HotelDTO toDTO(Hotel hotel);
}
