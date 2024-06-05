package com.piti.java.hotelbooking.controller;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hotelbooking.dto.HotelDTO;
import com.piti.java.hotelbooking.dto.PageDTO;
import com.piti.java.hotelbooking.mapper.HotelMapper;
import com.piti.java.hotelbooking.model.Hotel;
import com.piti.java.hotelbooking.service.HotelService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/hotel")
@AllArgsConstructor
public class HotelController {
	private HotelService hotelService;
	private HotelMapper hotelMapper;
	
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@PostMapping
	public ResponseEntity<HotelDTO> create(@RequestBody HotelDTO hotelDTO){
		HotelDTO dto = hotelService.save(hotelDTO);
		return new ResponseEntity<HotelDTO>(dto, HttpStatus.CREATED);
	}
	
	/*
	@GetMapping("/{id}")
	public ResponseEntity<HotelDTO> findHotelById(@PathVariable("id") Long id){
		return ResponseEntity.ok(hotelService.getById(id));
	}
	*/
	@GetMapping("/{id}")
	public ResponseEntity<HotelDTO> getHotelById(@PathVariable("id") Long id){
		Hotel hotel = hotelService.getById(id);
		return ResponseEntity.ok(hotelMapper.toDTO(hotel));
	}
	
	@GetMapping
	public ResponseEntity<?> getHotelsList(@RequestParam Map<String, String> params){
		Page<HotelDTO> hotels = hotelService.getHotels(params);
		PageDTO pageDTO = new PageDTO(hotels);
		return ResponseEntity.ok(pageDTO);	
	}
}
