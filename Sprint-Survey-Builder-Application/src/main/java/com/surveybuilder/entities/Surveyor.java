package com.surveybuilder.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Surveyor {
	@Id
	@Column(name="surveyor_id")
	private int surveyorId;
	
	@Column(name="surveyor_username",length=20,unique=true)
	@NotBlank(message="Username is required")
	private String surveyorUsername;
	
	@Column(name="surveyor_password",length=15)
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	@NotBlank(message="Password is required")
	private String surveyorPassword;
	
	@Column(name="userType",length=15)
	@NotBlank(message="User Type is required")
	private String userType;
	
	@OneToMany(mappedBy="surveyor",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Survey> survey=new ArrayList<Survey>();
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public List<Survey> getSurvey() {
		return survey;
	}
	public void setSurvey(List<Survey> survey) {
		this.survey = survey;
	}
	public int getSurveyorId() {
		return surveyorId;
	}
	public void setSurveyorId(int surveyorId) {
		this.surveyorId = surveyorId;
	}
	public String getSurveyorUsername() {
		return surveyorUsername;
	}
	public void setSurveyorUsername(String surveyorUsername) {
		this.surveyorUsername = surveyorUsername;
	}
	public String getSurveyorPassword() {
		return surveyorPassword;
	}
	public void setSurveyorPassword(String surveyorPassword) {
		this.surveyorPassword = surveyorPassword;
	}
	
	

}
