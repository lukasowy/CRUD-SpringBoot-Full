package com.lukasowy.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lukasowy.utils.ConstantUtils;

//AbstractPersistable class will add primary key
//No need to give column name like userName = user_name that will take care automatically
@Entity
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	private transient Long id;
	@NotNull
	@Size(min = 3, max = 15, message = "Please enter between {min}-{max} characters and digits")
	@Pattern(regexp=ConstantUtils.ID_PATTERN, message="Please enter characters or digits")
	private String userId;
	@NotNull
	private String userName;
	@NotNull
	private String password;
	@NotNull
	@Size(min = 10, max = 100, message = "Please enter between {min}-{max} characters")
	@Pattern(regexp=ConstantUtils.EMAIL_PATTERN, message="Please enter valid input")
	private String email;
	@NotNull
	@Size(min = 9, max = 9, message = "Please enter between {min}-{max} digits")
	@Pattern(regexp=ConstantUtils.MOBILE_PATTERN, message="Please enter only digits")
	private String mobile;
	private transient Long roleId;
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Address> adresses;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

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
