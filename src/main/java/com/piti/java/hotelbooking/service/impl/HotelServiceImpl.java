package com.piti.java.hotelbooking.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.piti.java.hotelbooking.dto.HotelDTO;
import com.piti.java.hotelbooking.exception.ResourceNotFoundException;
import com.piti.java.hotelbooking.mapper.HotelMapper;
import com.piti.java.hotelbooking.model.Hotel;
import com.piti.java.hotelbooking.repository.HotelRepository;
import com.piti.java.hotelbooking.service.HotelService;
import com.piti.java.hotelbooking.spec.HotelFilter;
import com.piti.java.hotelbooking.spec.HotelSpec;
import com.piti.java.hotelbooking.utils.PageUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService{
	private HotelRepository hotelRepository;
	private HotelMapper hotelMapper;
	
	@Override
	public HotelDTO save(HotelDTO hotelDTO) {
		Hotel hotel = hotelMapper.toEntity(hotelDTO);
		hotel = hotelRepository.save(hotel);
		return hotelMapper.toDTO(hotel);
	}

	/*
	@Override
	public HotelDTO getById(Long id) {
		Hotel hotel = hotelRepository.findById(id).orElseThrow(()  -> new ResourceNotFoundException("Hotel", "id", id));
		return hotelMapper.toDTO(hotel);
	}
	*/
	
	@Override
	public Hotel getById(Long id) {
		return hotelRepository.findById(id).orElseThrow(()  -> new ResourceNotFoundException("Hotel", "id", id));
	}

	@Override
	public Page<HotelDTO> getHotels(Map<String, String> params) {
		Pageable pageable = PageUtils.getPageable(params);
		
		HotelFilter hotelFilter = new HotelFilter();
		if(params.containsKey("hotelId")) {
			hotelFilter.setHotelId(MapUtils.getInteger(params, "hotelId"));
		}
		
		if(params.containsKey("hotelName")) {
			hotelFilter.setHotelName(MapUtils.getString(params, "hotelName"));
		}
		
		if(params.containsKey("locationId")) {
			hotelFilter.setLocationId(MapUtils.getInteger(params, "locationId"));
		}
		
		if(params.containsKey("locationName")) {
			hotelFilter.setLocationName(MapUtils.getString(params, "locationName"));
		}
		
		HotelSpec hotelSpec = new HotelSpec(hotelFilter);
		Page<Hotel> hotel = hotelRepository.findAll(hotelSpec, pageable);
		
		List<HotelDTO> hotelDTO = hotel.getContent().stream()
				.map(hotelMapper::toDTO)
				.collect(Collectors.toList());
		
		Page<HotelDTO> page = new PageImpl<>(hotelDTO, pageable, hotel.getTotalElements());
		return page;
		
	}

	

}
