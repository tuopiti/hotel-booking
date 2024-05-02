package com.piti.java.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hotelbooking.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{
	
}
