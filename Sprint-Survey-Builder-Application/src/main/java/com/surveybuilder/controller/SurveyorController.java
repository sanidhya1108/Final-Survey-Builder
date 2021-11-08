package com.surveybuilder.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Questions;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.entities.Survey;
import com.surveybuilder.entities.Surveyor;
import com.surveybuilder.exception.ResourceNotFoundException;
import com.surveybuilder.service.SurveyorService;

@RestController
@RequestMapping
public class SurveyorController {
	@Autowired
	private SurveyorService service;
	
	
	
	@PostMapping(path="survey")											//For creating a survey
	public ResponseEntity<String>saveSurvey(@Valid @RequestBody Survey survey){
		ResponseEntity<String>response=null;
		//List<Questions> questions=null;
		service.addSurvey(survey);
		response=new ResponseEntity<String>(survey.getSurveyId()+" is created", HttpStatus.CREATED);
		return response;
	}
	
	
	@PostMapping(path="questions") 
	public ResponseEntity<String>saveQuestion(@Valid @RequestBody Questions questions){
	  ResponseEntity<String>response=null;
	  service.addQuestion(questions);
	  response=new ResponseEntity<String>(questions.getQuestionId()+" is created",HttpStatus.CREATED); 
	  return response; 
	  }

	
	
	  @GetMapping(path="allsurvey") 
	  public List<Questions> getAllSurvey(){ 
		  return service.findAllSurvey(); }
	  
	
	  @GetMapping(path="survey/{surveyId}") 
	  public Survey getSurveyById(@PathVariable("surveyId")int surveyId) throws ResourceNotFoundException { 
		  return service.findSurveyById(surveyId); }
	 
	  
	  @GetMapping(path="respondent/{respondentId}")
	  public List<Responses> findResponsesById(@PathVariable int respondentId) throws ResourceNotFoundException{
		  return service.findResponsesById(respondentId);
	  }
	  @GetMapping(path="feedback")
	  public List<Feedback> findAllFeedback(){
		  return service.findAllFeedback();
	  }
	  @GetMapping(path="surveyor/{surveyorUsername}/{surveyorPassword}")
	  public String authSurveyor(@PathVariable("surveyorUsername") String surveyorUsername,@PathVariable("surveyorPassword") String surveyorPassword) {
	  Surveyor surveyor=service.authSurveyor(surveyorUsername, surveyorPassword);
	  if( service.authSurveyor(surveyorUsername, surveyorPassword) != null)
			return "login successfull";
		else
			return "login failed";
	  }
	  @DeleteMapping(path="questions/{questionId}") 
	  public void deleteQuestion(@PathVariable int questionId) throws ResourceNotFoundException { 
		  service.removeQuestion(questionId); 
		  }
	 
	  @DeleteMapping(path="survey/{surveyId}") 
	  public void deleteSurvey(@PathVariable int surveyId) throws ResourceNotFoundException{ 
		  service.removeSurvey(surveyId); 
		  
		  }
}