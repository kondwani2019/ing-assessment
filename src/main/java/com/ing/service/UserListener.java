package com.ing.service;

import java.net.ConnectException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.ing.model.domain.User;
import com.ing.model.dto.UserDto;
import com.ing.model.mapper.UserMapper;
import com.ing.persistence.UserRepository;

@Service
public class UserListener {
	@Autowired
	private UserRepository userRepository;
	
	@Retryable(value = {SQLException.class, ConnectException.class}, backoff = @Backoff(delay = 60000), maxAttempts = 10)
	@JmsListener(destination = "${ing.user.save.topic}")
    public void saveUser(@Payload UserDto user) {
		User userEntity = new UserMapper().mapToEntity(user);
		userRepository.save(userEntity);
    }
	
	@Retryable(value = {SQLException.class, ConnectException.class}, backoff = @Backoff(delay = 60000), maxAttempts = 10)
	@JmsListener(destination = "${ing.user.update.topic}")
    public void updateUser(@Payload UserDto user) {
		User userEntity = new UserMapper().mapToEntity(user);
		userRepository.save(userEntity);
    }
}
