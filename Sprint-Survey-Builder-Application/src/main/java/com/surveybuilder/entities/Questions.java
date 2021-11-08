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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Questions {
	@Id
	@Column(name="question_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionId;
	
	@Column(name="question_content")
	@NotBlank(message="Question content is mandatory")
	private String questionContent;
	
	@Column(name="question_option1",length=50)
	@NotBlank(message="Provide option")
	private String option1;
	
	@Column(name="question_option2",length=50)
	@NotBlank(message="Provide option")
	private String option2;
	
	@Column(name="question_option3",length=50)
	@NotBlank(message="Provide option")
	private String option3;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="survey_id")
	private Survey survey;
	
	@OneToMany(mappedBy = "que", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)	
	@JsonIgnore
	private List<Responses> answers = new ArrayList<Responses>();
	
	
	public List<Responses> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Responses> answers) {
		this.answers = answers;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	

}
