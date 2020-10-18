package com.ing.model.mapper;

import org.springframework.beans.BeanUtils;

import com.ing.model.domain.Person;
import com.ing.model.dto.PersonDto;

public class PersonMapper implements DtoEntityMapper<PersonDto, Person> {

	@Override
	public PersonDto mapToDto(Person entity) {
		PersonDto dto = new PersonDto();
		BeanUtils.copyProperties(entity, dto);
		
		AddressMapper addressMapper = new AddressMapper();
		dto.setAddress(addressMapper.mapToDto(entity.getAddress()));
		
		return dto;
	}

	@Override
	public Person mapToEntity(PersonDto dto) {
		Person entity = new Person();
		BeanUtils.copyProperties(dto, entity);
		
		AddressMapper addressMapper = new AddressMapper();
		entity.setAddress(addressMapper.mapToEntity(dto.getAddress()));
		
		return entity;
	}

}
