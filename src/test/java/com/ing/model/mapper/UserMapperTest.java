package com.ing.model.mapper;

import org.junit.Assert;
import org.junit.Test;

import com.ing.model.commons.Gender;
import com.ing.model.commons.State;
import com.ing.model.domain.Address;
import com.ing.model.domain.Person;
import com.ing.model.domain.User;
import com.ing.model.dto.AddressDto;
import com.ing.model.dto.PersonDto;
import com.ing.model.dto.UserDto;

public class UserMapperTest {
	
	@Test
	public void testMapToDto() {
		String userName = "test-user";
		String streetName = "George Street";
		String firstName = "Harry";
		
		User user = new User();
		user.setUserName(userName);
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setGender(Gender.MALE);
		
		Address address = new Address();
		address.setAddressLine1(streetName);
		address.setState(State.WA);
		person.setAddress(address);
		
		user.setPerson(person);
		
		UserDto mappedUserDto = new UserMapper().mapToDto(user);
		Assert.assertEquals(userName, mappedUserDto.getUserName());
		
		PersonDto mappedPerson = mappedUserDto.getPerson();
		Assert.assertEquals(firstName, mappedPerson.getFirstName());
		Assert.assertEquals(Gender.MALE, mappedPerson.getGender());
		
		AddressDto mappedAddress = mappedPerson.getAddress();
		Assert.assertEquals(streetName, mappedAddress.getAddressLine1());
		Assert.assertEquals(State.WA, mappedAddress.getState());
		
	}

	@Test
	public void testMapToEntity() {
		String userName = "test-user-to-entity";
		String streetName = "Victoria Avenue";
		String firstName = "Jerry";
		
		UserDto userDto = new UserDto();
		userDto.setUserName(userName);
		
		PersonDto personDto = new PersonDto();
		personDto.setGender(Gender.FEMALE);
		personDto.setFirstName(firstName);
		
		AddressDto addressDto = new AddressDto();
		addressDto.setAddressLine1(streetName);
		addressDto.setState(State.QLD);
		personDto.setAddress(addressDto);
		
		userDto.setPerson(personDto);
		
		User mappedUserEntity = new UserMapper().mapToEntity(userDto);
		Assert.assertEquals(userName, mappedUserEntity.getUserName());
		
		Person mappedPerson = mappedUserEntity.getPerson();
		Assert.assertEquals(firstName, mappedPerson.getFirstName());
		Assert.assertEquals(Gender.FEMALE, mappedPerson.getGender());
		
		Address mappedAddress = mappedPerson.getAddress();
		Assert.assertEquals(streetName, mappedAddress.getAddressLine1());
		Assert.assertEquals(State.QLD, mappedAddress.getState());
	}
}
