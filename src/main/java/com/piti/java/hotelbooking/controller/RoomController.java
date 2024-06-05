package com.piti.java.hotelbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hotelbooking.dto.RoomDTO;
import com.piti.java.hotelbooking.mapper.RoomMapper;
import com.piti.java.hotelbooking.model.Room;
import com.piti.java.hotelbooking.service.RoomService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/room")
@AllArgsConstructor
public class RoomController {
	private RoomService roomService;
	private RoomMapper roomMapper;
	
	@PreAuthorize("hasAnyRole('ROLE_SUPER_ADMIN','ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<RoomDTO> create(@RequestBody RoomDTO roomDTO){
		RoomDTO dto = roomService.save(roomDTO);
		return new ResponseEntity<RoomDTO>(dto,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoomDTO> getRoomById(@PathVariable("id") long id){
		Room room = roomService.getById(id);
		return ResponseEntity.ok(roomMapper.toDTO(room));
	}
}
