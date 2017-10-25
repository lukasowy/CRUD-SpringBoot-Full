package com.lukasowy.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Address extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	private transient Long id;
	@NotNull
	@Size(min=10, max=100, message="Please enter between {min}-{max} characters")
	private String addressLine;
	@NotNull
	@Size(min=3, max=15, message="Please enter between {min}-{max} characters")
	private String city;
	@NotNull
	@Size(min=3, max=15, message="Please enter between {min}-{max} characters")
	private String state;
	@NotNull
	@Size(min=3, max=15, message="Please enter between {min}-{max} characters")
	private String country;
	private transient Long userId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
