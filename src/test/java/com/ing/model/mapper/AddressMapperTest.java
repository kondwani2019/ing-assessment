package com.ing.model.mapper;

import org.junit.Assert;
import org.junit.Test;

import com.ing.model.commons.State;
import com.ing.model.domain.Address;
import com.ing.model.dto.AddressDto;

public class AddressMapperTest {
	
	@Test
	public void testMapToDto() {
		String addressLine1 = "20 TEST STREET";
		
		Address address = new Address();
		address.setAddressLine1(addressLine1);
		address.setState(State.NSW);
		
		AddressDto transformedDto = new AddressMapper().mapToDto(address);
		
		Assert.assertEquals(addressLine1, transformedDto.getAddressLine1());
		Assert.assertEquals(State.NSW, transformedDto.getState());
	}

	@Test
	public void testMapToEntity() {
		final String addressLine1 = "12 TEST STREET - ENTITY";
		
		AddressDto addressDto = new AddressDto();
		addressDto.setAddressLine1(addressLine1);
		addressDto.setState(State.ACT);
		
		Address mappedEntity = new AddressMapper().mapToEntity(addressDto);
		
		Assert.assertEquals(addressLine1, mappedEntity.getAddressLine1());
		Assert.assertEquals(State.ACT, mappedEntity.getState());
	}
}
