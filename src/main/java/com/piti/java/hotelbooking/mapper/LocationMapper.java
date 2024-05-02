package com.piti.java.hotelbooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piti.java.hotelbooking.dto.LocationDTO;
import com.piti.java.hotelbooking.model.Location;

@Mapper
public interface LocationMapper {
	LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);
	
	Location toEntity(LocationDTO locationDTO);
	LocationDTO toDTO(Location location);
	
}
