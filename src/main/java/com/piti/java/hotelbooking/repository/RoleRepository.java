package com.piti.java.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hotelbooking.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(String name);
}
