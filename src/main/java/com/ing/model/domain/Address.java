package com.ing.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.ing.model.commons.State;

@Entity
@DynamicUpdate
@Table(name="address")
public class Address extends BaseEntity<Long> {

	@Column(name="address_line_1", nullable=false, length=160)
	private String addressLine1;
	
	@Column(name="address_line_2", length=160)
	private String addressLine2;

	@Column(name="city", length=160)
	private String city;
	
	@Enumerated(EnumType.STRING)
	@Column(name="state", nullable = false, length=5)
	private State state;
	
	@Column(name="postal_code", length=10)
	private String postalCode;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
