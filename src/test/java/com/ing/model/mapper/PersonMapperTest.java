package com.ing.model.mapper;

import org.junit.Assert;
import org.junit.Test;

import com.ing.model.commons.State;
import com.ing.model.domain.Address;
import com.ing.model.domain.Person;
import com.ing.model.dto.AddressDto;
import com.ing.model.dto.PersonDto;

public class PersonMapperTest {
	
	@Test
	public void testMapToDto() {
		String firstName = "John";
		String lastName = "Smith";
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		Address address = new Address();
		address.setState(State.NSW);
		person.setAddress(address);
		
		PersonDto mappedDto = new PersonMapper().mapToDto(person);
		
		Assert.assertEquals(firstName, mappedDto.getFirstName());
		Assert.assertEquals(lastName, mappedDto.getLastName());
		Assert.assertEquals(State.NSW, mappedDto.getAddress().getState());
	}

	@Test
	public void testMapToEntity() {
		String firstName = "Ben";
		String lastName = "Wallace";
		
		PersonDto personDto = new PersonDto();
		personDto.setFirstName(firstName);
		personDto.setLastName(lastName);
		
		AddressDto addressDto = new  AddressDto();
		addressDto.setState(State.ACT);
		personDto.setAddress(addressDto);
	
		Person mappedEntity = new PersonMapper().mapToEntity(personDto);
		Assert.assertEquals(firstName, mappedEntity.getFirstName());
		Assert.assertEquals(lastName, mappedEntity.getLastName());
		Assert.assertEquals(State.ACT, mappedEntity.getAddress().getState());
	}
}
