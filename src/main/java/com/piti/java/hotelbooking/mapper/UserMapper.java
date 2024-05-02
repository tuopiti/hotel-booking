package com.piti.java.hotelbooking.mapper;

import org.mapstruct.Mapper;

import com.piti.java.hotelbooking.dto.UserDTO;
import com.piti.java.hotelbooking.model.User;

@Mapper(uses = RoleMapper.class)
public interface UserMapper {
	User toEntity(UserDTO userDTO);
	UserDTO toDto(User user);
}
