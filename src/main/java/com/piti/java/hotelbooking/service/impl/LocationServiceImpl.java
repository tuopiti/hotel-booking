package com.piti.java.hotelbooking.service.impl;

import org.springframework.stereotype.Service;

import com.piti.java.hotelbooking.dto.LocationDTO;
import com.piti.java.hotelbooking.exception.ResourceNotFoundException;
import com.piti.java.hotelbooking.mapper.LocationMapper;
import com.piti.java.hotelbooking.model.Location;
import com.piti.java.hotelbooking.repository.LocationRepository;
import com.piti.java.hotelbooking.service.LocationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService{
	
	private LocationRepository locationRepository;

	@Override
	public LocationDTO save(LocationDTO locationDTO) {
		Location location = LocationMapper.INSTANCE.toEntity(locationDTO);
		location = locationRepository.save(location);
		return LocationMapper.INSTANCE.toDTO(location);
	}

	@Override
	public Location getById(Long id) {
		return locationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
	}

	/*
	@Override
	public LocationDTO getById(Long id) {
		Location location = locationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
		
		return LocationMapper.INSTANCE.toDTO(location);
	}
	
	*/

}