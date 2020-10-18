package com.ing.model.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.ing.model.commons.Gender;


public class PersonDto extends Dto<Long> {

	@NotEmpty(message = "firstName cannot be empty")
	private String firstName;
	
	@NotEmpty(message = "lastName cannot be empty")
	private String lastName;
	
	@Range(min = 1, max = 200)
	private Integer age;
	
	@NotNull(message = "gender cannot be empty")
	private Gender gender;
	@Valid
	@NotNull(message = "Must have an Address")
	private AddressDto address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

}
