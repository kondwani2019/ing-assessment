package com.ing.model.mapper;

import org.springframework.beans.BeanUtils;

import com.ing.model.domain.Address;
import com.ing.model.dto.AddressDto;

public class AddressMapper implements DtoEntityMapper<AddressDto, Address> {

	@Override
	public AddressDto mapToDto(Address entity) {
		AddressDto dto = new AddressDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public Address mapToEntity(AddressDto dto) {
		Address entity = new Address();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
