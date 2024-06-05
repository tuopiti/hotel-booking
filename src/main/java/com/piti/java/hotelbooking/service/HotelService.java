package com.piti.java.hotelbooking.service;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.piti.java.hotelbooking.dto.HotelDTO;
import com.piti.java.hotelbooking.model.Hotel;

public interface HotelService {
	HotelDTO save(HotelDTO hotelDTO);
	//HotelDTO getById(Long id);
	Hotel getById(Long id);
	Page<HotelDTO> getHotels(Map<String, String> params);
}
