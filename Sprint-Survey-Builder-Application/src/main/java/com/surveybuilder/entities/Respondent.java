package com.surveybuilder.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Respondent {
	@Id
	@Column(name="respondent_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int respondentId;
	
	@Column(name="respondent_name",length=20)
	@NotBlank(message="Respondent name is required")
	private String respondentName;
	
	@Column(name="respondent_username",length=20,unique=true)
	@NotBlank(message="User name is Reqiured")
	private String respondentUsername;
	
	@Column(name="respondent_password",length=15)
	@Size(min = 4, max = 20, message = "Password must be between 4 and 20 characters")
	@NotBlank(message="Password is required")
	private String respondentPassword;
	
	
	  @Column(name="userType",length=15)
	  @NotBlank(message="Type is required") 
	  private String userType;
	 
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@OneToMany(mappedBy="respondent",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Responses>responses=new ArrayList<Responses>();
	
	@OneToOne(mappedBy="respondent",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private Feedback feedback1;
	
	
	public List<Responses> getResponses() {
		return responses;
	}
	public void setResponses(List<Responses> responses) {
		this.responses = responses;
	}
	public int getRespondentId() {
		return respondentId;
	}
	public void setRespondentId(int respondentId) {
		this.respondentId = respondentId;
	}
	public String getRespondentName() {
		return respondentName;
	}
	public void setRespondentName(String respondentName) {
		this.respondentName = respondentName;
	}
	public String getRespondentUsername() {
		return respondentUsername;
	}
	public void setRespondentUsername(String respondentUsername) {
		this.respondentUsername = respondentUsername;
	}
	public String getRespondentPassword() {
		return respondentPassword;
	}
	public void setRespondentPassword(String respondentPassword) {
		this.respondentPassword = respondentPassword;
	}
	
	
}
