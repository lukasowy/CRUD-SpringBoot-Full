package com.lukasowy.models;

import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

//AbstractPersistable class will add primary key
//No need to give column name like userName = user_name that will take care automatically
@Entity
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
