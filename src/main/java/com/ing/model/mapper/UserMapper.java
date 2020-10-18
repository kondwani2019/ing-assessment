package com.ing.model.mapper;

import org.springframework.beans.BeanUtils;

import com.ing.model.domain.User;
import com.ing.model.dto.UserDto;

public class UserMapper implements DtoEntityMapper<UserDto, User> {

	@Override
	public UserDto mapToDto(User entity) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(entity, dto);
		
		PersonMapper personMapper = new PersonMapper();
		dto.setPerson(personMapper.mapToDto(entity.getPerson()));
		
		return dto;
	}

	@Override
	public User mapToEntity(UserDto dto) {
		User entity = new User();
		BeanUtils.copyProperties(dto, entity);
		
		PersonMapper personMapper = new PersonMapper();
		entity.setPerson(personMapper.mapToEntity(dto.getPerson()));
		
		return entity;
	}

}
