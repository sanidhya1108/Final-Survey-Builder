package com.surveybuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Feedback {
	@Id
	@Column(name="feedback_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;
	@Column(name="feedback")
	@NotBlank(message="Please provide feedback ")
	private String feedback;
	
	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Survey getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
	}

	public Respondent getRespondent() {
		return respondent;
	}

	public void setRespondentId(Respondent respondent) {
		this.respondent = respondent;
	}

	@OneToOne
	@JoinColumn(name="survey_id")
	private Survey surveyId;
	
	@OneToOne
	@JoinColumn(name="respondent_id")
	private Respondent respondent;
	

}
