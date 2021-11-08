package com.surveybuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	@Column(name="admin_id")
	private int adminId;
	@NotBlank(message="Username is mandatory")
	@Column(name="admin_username",length=20,unique=true)
	private String adminUsername;
	@NotBlank(message="Password is mandatory")
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	@Column(name="admin_password",length=15)
	private String adminPassword;
	@NotBlank(message="Usertype is mandatory")
	@Column(name="userType",length=15)
	private String userType;
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	
	

}