package com.piti.java.hotelbooking.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piti.java.hotelbooking.model.Role;

@Mapper
public abstract class RoleMapper {
	public static final RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	 public Long roleToRoleId(Role role) {
	     return role.getId();
	 }
	 
	 public abstract Role roleIdToRole(Long roleId);
}
