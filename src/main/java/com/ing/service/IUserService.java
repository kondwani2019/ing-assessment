package com.ing.service;

import java.util.List;

import com.ing.model.dto.UserDto;

public interface IUserService {
	
	/**
	 * Get User Details by Id
	 * 
	 * @param id
	 * @return
	 */
	UserDto getDetails(Long id);
	
	/**
	 * This is the fallback method
	 * 
	 * @param id
	 * @return
	 */
	UserDto getDetailsFallback(Long id);
	
	/**
	 * List of All Users
	 * 
	 * @return
	 */
	List<UserDto> getAll();
	/**
	 * Gets UserDto as representation of User Entity from Database
	 * @param id
	 * @return
	 */
	UserDto getDetails(String userName);
	
	/**
	 * Creates a new User Entity in the database based on an equivalent UserDto
	 * 
	 * @param user
	 */
	void save(UserDto user);
	
	/**
	 * Updates a User Entity that matches the User Id on this UserDto
	 * 
	 * @param user
	 */
	void update(UserDto user);
	
	/**
	 * Publishes to JMS Broker - Listner will pick this up and try to persist when the database is 
	 * This is the fallback method for save
	 * 
	 * @param user
	 */
	void publishSave(UserDto user);
	
	/**
	 * Publishes to Jms Broker when DB is down
	 * This is the fallback method for updated
	 * 
	 * @param user
	 */
	void publishUpdate(UserDto user);
}
