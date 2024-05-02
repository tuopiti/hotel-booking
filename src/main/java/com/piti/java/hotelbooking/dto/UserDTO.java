package com.piti.java.hotelbooking.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;
	private Boolean isAccountNonExpired = true;
	private Boolean isAccountNonLocked = true;
	private Boolean isCredentialsNonExpired = true;
	private Boolean isEnabled = true;
	private Set<String> roles; // Modified to accept role IDs as strings
}
