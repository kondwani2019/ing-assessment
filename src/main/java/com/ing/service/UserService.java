package com.ing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.ing.exceptions.ValidationException;
import com.ing.model.domain.User;
import com.ing.model.dto.UserDto;
import com.ing.model.mapper.UserMapper;
import com.ing.persistence.UserRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    	private JmsTemplate jmsTemplate;
	
	@Value(value="${ing.user.save.topic}")
	private String userSaveTopic;
	
	@Value(value="${ing.user.update.topic}")
	private String userUpdateTopic;
	
	private final static Logger LOGGER = Logger.getLogger(UserService.class.getName());
	
	@Override
	public UserDto getDetails(String userName) {
		LOGGER.log(Level.INFO, "getDetails");
		List<User> users = userRepository.findByUserName(userName);
		
		if (!users.isEmpty()) {
			new UserMapper().mapToDto(users.get(0));
		}
		return null;
	}

	@Override
	@Transactional
	@HystrixCommand(fallbackMethod = "publishSave")
	public void save(UserDto user) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<UserDto>> violations = validator.validate(user);
		
		if (!violations.isEmpty()) {
			throw new ValidationException(new ArrayList<>(violations));
		}
		
		User userEntity = new UserMapper().mapToEntity(user);
		userRepository.save(userEntity);
	}

	@Override
	@HystrixCommand(fallbackMethod = "publishUpdate")
	@Transactional
	public void update(UserDto user) {
		User userEntity = new UserMapper().mapToEntity(user);
		userRepository.save(userEntity);
	}

	@Override
	public void publishSave(UserDto user) {
		jmsTemplate.convertAndSend(userSaveTopic, user);
	}

	@Override
	public void publishUpdate(UserDto user) {
		jmsTemplate.convertAndSend(userUpdateTopic, user);
	}

	@Override
	public List<UserDto> getAll() {
		List<UserDto> allUsers = new ArrayList<>();
		Iterable<User> allUsersIterator = userRepository.findAll();
		
		if (allUsersIterator != null) {
			while(allUsersIterator.iterator().hasNext()) {
				allUsers.add(new UserMapper().mapToDto(allUsersIterator.iterator().next()));
			}
		}
		return allUsers;
	}

	@Override
	@HystrixCommand(fallbackMethod = "getDetailsFallback")
	public UserDto getDetails(Long id) {
		LOGGER.log(Level.INFO, "getDetails");
		Optional<User> findById = userRepository.findById(id);
		
		if (findById.isPresent()) {
			LOGGER.log(Level.INFO, "found: " + findById.get());
			return new UserMapper().mapToDto(findById.get());
		}
		return null;
	}

	@Override
	public UserDto getDetailsFallback(Long id) {
		UserDto userDto = new UserDto();
		userDto.setMessage("System not available - try at a later stage");
		return userDto;
	}

}
