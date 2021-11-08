package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Respondent;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.exception.ResourceNotFoundException;


public interface RespondentService {
	public Respondent createRespondentService(Respondent s);
	public Respondent viewRespondentByIdService(int id);
	public Respondent updateRespondentService(Respondent s, long id) throws ResourceNotFoundException;
	public boolean deleteRespondentByIdService(long id) throws ResourceNotFoundException;
	public List<Respondent> listAllRespondentService();
	public Respondent authRespondent(String RespondentUsername, String pass);
	public void giveResponse(Responses responses);
	public void giveFeedback(Feedback feedback);
}