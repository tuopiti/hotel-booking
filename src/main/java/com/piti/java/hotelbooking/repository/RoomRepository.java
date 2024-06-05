package com.piti.java.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hotelbooking.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
	
}
