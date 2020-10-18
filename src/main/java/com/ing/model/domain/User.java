package com.ing.model.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
/*
 *   Call table "users" as in some databases, e.g. postgres "user" is a keyword
 */
@Table(name="users")
public class User extends BaseEntity<Long> {

	@Column(name="user_name", nullable=false, length=100, unique=true)
	private String userName;

	//  If we need Single-Sign-on, we can use this - optional field
	@Column(name="oauth_user_id", length=100, unique=true)
	private String oauthUserId;

	@Column(name="password", length=60)
	private String password;

	@Column(name="last_signed_in")
	private Date lastSignedIn;

	@OneToOne(targetEntity=Person.class, cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch=FetchType.EAGER, optional=false )
	@JoinColumn(name="person_id")
	private Person person;

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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}