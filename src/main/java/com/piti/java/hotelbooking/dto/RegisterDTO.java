package com.piti.java.hotelbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
	private String name;
    private String username;
    private String email;
    private String password;
    private Boolean isAccountNonExpired = true;
	private Boolean isAccountNonLocked = true;
	private Boolean isCredentialsNonExpired = true;
	private Boolean isEnabled = true;
}
