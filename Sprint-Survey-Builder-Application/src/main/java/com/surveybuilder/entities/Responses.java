package com.surveybuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class Responses {
	@Id
	@Column(name="answer_id")
	private int answerId;
	
	
	@Column(name="answer")
	@NotBlank(message="Answer should not be blank ")
	private String answer;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	
	private Questions que = new Questions();
	
	@ManyToOne
	@JoinColumn(name="respondent_id")
	
	private Respondent respondent;
	
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public Questions getQue() {
		return que;
	}
	public void setQue(Questions que) {
		this.que = que;
	}
	
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Respondent getRespondent() {
		return respondent;
	}
	public void setRespondent(Respondent respondent) {
		this.respondent = respondent;
	}
	
	
	
	
	

}
