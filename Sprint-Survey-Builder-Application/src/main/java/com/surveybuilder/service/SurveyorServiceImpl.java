package com.surveybuilder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.FeedbackDao;
import com.surveybuilder.dao.QuestionsDao;
import com.surveybuilder.dao.ResponsesDao;
import com.surveybuilder.dao.SurveyDao;
import com.surveybuilder.dao.SurveyorDao;
import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Questions;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.entities.Survey;
import com.surveybuilder.entities.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;

@Service
@Scope(scopeName="singleton")

public class SurveyorServiceImpl implements SurveyorService {
	@Autowired
	private SurveyDao surveydao=null;
	@Autowired
	private QuestionsDao questiondao=null;
	@Autowired
	private ResponsesDao responsesdao=null;
	@Autowired
	private FeedbackDao feedbackdao=null;
	@Autowired
	private SurveyorDao surveyordao=null;
	
	@Override
	
	public Survey addSurvey(Survey survey) {
		return surveydao.save(survey);
		
	}

	@Override
	
	public Questions addQuestion(Questions questions) {
		return questiondao.save(questions);
		
	}

	@Override
	public List<Questions> findAllSurvey() {
		
		return questiondao.findAll();
	}

	@Override
	public Survey findSurveyById(int surveyId) throws ResourceNotFoundException{
		Survey x=null;

		if(surveydao.existsById(surveyId)) {
			x= surveydao.findById(surveyId).get();
		}
		else {
			new ResourceNotFoundException("Survey not found for ID "+surveyId);
		}
		return x;
		
	}

	@Override
	public void updateQuestion(int questionId, Questions questions) {
		if(questiondao.existsById(questionId)) {
			questiondao.save(questions);
		}
		
	}

	@Override
	public boolean removeQuestion(int questionId) throws ResourceNotFoundException{
		Questions questions=questiondao.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question not found for this id :: " + questionId));
		questiondao.deleteQuestionById(questionId);
		if(questions == null)
			return false;
		else
			return true;
		
	}

	@Override
	public boolean removeSurvey(int surveyId)throws ResourceNotFoundException {
		Survey survey=surveydao.findById(surveyId).orElseThrow(() -> new ResourceNotFoundException("Survey not found for this id :: " + surveyId));
		if(!questiondao.existsById(surveyId)) {
		surveydao.deleteSurveyById(surveyId);
		}
		if(survey == null)
			return false;
		else
			return true;
		
	}

	@Override
	public List<Responses> findResponsesById(int respondentId) {
		
		return responsesdao.findResponsesById(respondentId);
	}

	@Override
	public List<Feedback> findAllFeedback() {
		
		return feedbackdao.findAll();
	}

	@Override
	public Surveyor authSurveyor(String surveyorUsername, String surveyorPassword) {
		
		return surveyordao.authSurveyor(surveyorUsername,surveyorPassword);
	}

	
	
	
}