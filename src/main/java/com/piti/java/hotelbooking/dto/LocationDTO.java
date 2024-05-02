package com.piti.java.hotelbooking.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
	private Long id;
	@NotEmpty(message = "location name should not be null or empty")
	private String name;
}
