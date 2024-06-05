package com.piti.java.hotelbooking.service;

import java.util.List;

import com.piti.java.hotelbooking.dto.UserDTO;
import com.piti.java.hotelbooking.model.User;

public interface UserService {
	
	String createUser(UserDTO userDTO);
	User getUserById(Long id);
	List<UserDTO> getAllUser();
	
}
