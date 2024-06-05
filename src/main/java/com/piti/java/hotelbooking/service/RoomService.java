package com.piti.java.hotelbooking.service;

import com.piti.java.hotelbooking.dto.RoomDTO;
import com.piti.java.hotelbooking.model.Room;

public interface RoomService{
	RoomDTO save(RoomDTO roomDTO);
	Room getById(Long id);
}
