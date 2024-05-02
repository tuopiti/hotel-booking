package com.piti.java.hotelbooking.service;

import com.piti.java.hotelbooking.dto.LoginDTO;
import com.piti.java.hotelbooking.dto.RegisterDTO;

public interface AuthService {
	
	String register(RegisterDTO registerDTO);
	
	String login(LoginDTO loginDto);
}
