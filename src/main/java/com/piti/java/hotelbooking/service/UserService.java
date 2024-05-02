package com.piti.java.hotelbooking.service;

import java.util.List;

import com.piti.java.hotelbooking.dto.UserDTO;

public interface UserService {
	
	String createUser(UserDTO userDTO);
	List<UserDTO> getAllUser();
	
}
