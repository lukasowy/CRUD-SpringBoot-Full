package com.lukasowy.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

//AbstractPersistable class will add primary key
//No need to give column name like userName = user_name that will take care automatically
@Entity
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	private String userIdd;
	private String userName;
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Address> adresses;

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public String getUserIdd() {
		return userIdd;
	}

	public void setUserIdd(String userId) {
		this.userIdd = userId;
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
