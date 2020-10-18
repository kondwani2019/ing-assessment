package com.ing.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.IngUserManagementApplication;
import com.ing.exceptions.ValidationException;
import com.ing.model.commons.Gender;
import com.ing.model.commons.State;
import com.ing.model.domain.User;
import com.ing.model.dto.AddressDto;
import com.ing.model.dto.PersonDto;
import com.ing.model.dto.UserDto;
import com.ing.persistence.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {IngUserManagementApplication.class})
public class UserServiceTest {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test(expected = ValidationException.class)
	public void testSaveWithInvalidPayload() {
		UserDto user = new UserDto();
		user.setUserName("test-user");
		PersonDto person = new PersonDto();
		user.setPerson(person);
		userService.save(user);

	}
	
	@Test
	public void testSaveWithPayload() {
		UserDto user = new UserDto();
		user.setUserName("test-user");
		PersonDto person = new PersonDto();
		person.setFirstName("Jack");
		person.setLastName("Smith");
		person.setGender(Gender.MALE);
		
		AddressDto address = new AddressDto();
		address.setAddressLine1("13 Brown Street");
		address.setCity("Chatswood");
		address.setState(State.NSW);
		address.setPostalCode("2067");
		person.setAddress(address);
		user.setPerson(person);
		userService.save(user);
		
		List<User> foundUsers = userRepository.findByUserName("test-user");
		Assert.assertEquals(1, foundUsers.size());
	}
	
	@Test
	public void testGetDetails() {
		UserDto details = userService.getDetails(1L);
		
		Assert.assertEquals("Frank", details.getPerson().getFirstName());
	}
}
