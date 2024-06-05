package com.piti.java.hotelbooking.service.impl;

import org.springframework.stereotype.Service;

import com.piti.java.hotelbooking.dto.RoomDTO;
import com.piti.java.hotelbooking.exception.ResourceNotFoundException;
import com.piti.java.hotelbooking.mapper.RoomMapper;
import com.piti.java.hotelbooking.model.Room;
import com.piti.java.hotelbooking.repository.RoomRepository;
import com.piti.java.hotelbooking.service.RoomService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{
	private RoomRepository roomRepository;
	private RoomMapper roomMapper;

	@Override
	public RoomDTO save(RoomDTO roomDTO) {
		Room room = roomMapper.toEntity(roomDTO);
		room = roomRepository.save(room);
		return roomMapper.toDTO(room);
	}

	@Override
	public Room getById(Long id) {
		return roomRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room", "id", id));
	}

}
