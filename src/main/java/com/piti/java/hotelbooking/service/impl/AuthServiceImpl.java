package com.piti.java.hotelbooking.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.piti.java.hotelbooking.config.security.jwt.JwtTokenProvider;
import com.piti.java.hotelbooking.dto.LoginDTO;
import com.piti.java.hotelbooking.dto.RegisterDTO;
import com.piti.java.hotelbooking.exception.ApiException;
import com.piti.java.hotelbooking.model.Role;
import com.piti.java.hotelbooking.model.User;
import com.piti.java.hotelbooking.repository.RoleRepository;
import com.piti.java.hotelbooking.repository.UserRepository;
import com.piti.java.hotelbooking.service.AuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    
	@Override
	public String register(RegisterDTO registerDTO) {
		// check username is already exists in database
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if(userRepository.existsByEmail(registerDTO.getEmail())){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }
        
        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("CUSTOMER");
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);

        return "User Registered Successfully!.";
	}
	

	@Override
	public String login(LoginDTO loginDto) {
		    Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail()
				                                           ,loginDto.getPassword()
				)
		    );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        String token = jwtTokenProvider.generateToken(authentication);
            return token;
	        //return "User logged-in successfully!.";
	}

}
