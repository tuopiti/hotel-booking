package com.piti.java.hotelbooking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hotelbooking.dto.UserDTO;
import com.piti.java.hotelbooking.model.User;
import com.piti.java.hotelbooking.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody UserDTO userDTO){
		String response = userService.createUser(userDTO);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id){
		User user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUser(){
		List<UserDTO> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
	
}
