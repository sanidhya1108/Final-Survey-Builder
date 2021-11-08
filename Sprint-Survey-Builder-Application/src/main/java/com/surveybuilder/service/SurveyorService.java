package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Questions;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.entities.Survey;
import com.surveybuilder.entities.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;

public interface SurveyorService {

  public Survey addSurvey(Survey survey);
	public Questions addQuestion(Questions questions);
	public List<Questions> findAllSurvey();
	public Survey findSurveyById(int surveyId)throws ResourceNotFoundException;
	public void updateQuestion(int questionId, Questions questions);
	public boolean removeQuestion(int questionId) throws ResourceNotFoundException;
	public boolean removeSurvey(int surveyId)throws ResourceNotFoundException;
	public List<Responses> findResponsesById(int respondentId)throws ResourceNotFoundException;
	public List<Feedback> findAllFeedback();
	public Surveyor authSurveyor(String surveyorUsername,String surveyorPassword);
}