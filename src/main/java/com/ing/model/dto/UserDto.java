package com.ing.model.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto extends Dto<Long> {
	
	@NotEmpty(message="Username cannot be empty")
	private String userName;
	
	private String oauthUserId;
	
	private String password;
	
	private Date lastSignedIn;
	@Valid
	@NotNull(message="Person cannot be null")
	private PersonDto person;

	private String message;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOauthUserId() {
		return oauthUserId;
	}

	public void setOauthUserId(String oauthUserId) {
		this.oauthUserId = oauthUserId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastSignedIn() {
		return lastSignedIn;
	}

	public void setLastSignedIn(Date lastSignedIn) {
		this.lastSignedIn = lastSignedIn;
	}

	public PersonDto getPerson() {
		return person;
	}

	public void setPerson(PersonDto person) {
		this.person = person;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}