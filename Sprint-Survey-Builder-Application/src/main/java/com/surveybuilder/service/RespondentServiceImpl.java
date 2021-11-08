package com.surveybuilder.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surveybuilder.dao.FeedbackDao;
import com.surveybuilder.dao.RespondentDao;
import com.surveybuilder.dao.ResponsesDao;
import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Respondent;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.exception.ResourceNotFoundException;





@Service
public class RespondentServiceImpl implements RespondentService{
	@Autowired
	private RespondentDao rr =null;
	 
	@Autowired
	private FeedbackDao rr1=null;
	
	@Autowired
	private ResponsesDao rr2=null;
	
	@Override
	public Respondent createRespondentService(Respondent s) {
		
		Respondent a = rr.save(s);	
		return a ;
	}

	@Override
	public Respondent viewRespondentByIdService(int id) {
		Respondent a = rr.findRespondentById(id);
		
		if(a == null) {
			 new ResourceNotFoundException("Respondent not found for this id :: "+ id);
		}
		return a;
	}

	@Override
	public Respondent updateRespondentService(Respondent s, long id) throws ResourceNotFoundException {
		Respondent a = rr.findById((int) id).orElseThrow(() -> new ResourceNotFoundException("Respondent not found for this id :: " + id));
		
		s.setRespondentId(a.getRespondentId());
		
		final Respondent updatedA= rr.save(s);
		return updatedA;
	}

	@Override
	public boolean deleteRespondentByIdService(long id) throws ResourceNotFoundException {
		
		Respondent a = rr.findById((int) id).orElseThrow(() -> new ResourceNotFoundException("Respondent not found for this id :: " + id));
		
		rr.deleteById((int) id);
		
		if(a == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Respondent> listAllRespondentService() {
		return rr.findAll();
	}

	@Override
	public Respondent authRespondent(String RespondentUsername, String pass) {
		
		return rr.authRespondent(RespondentUsername, pass);
	}

	@Override
	public void giveResponse(Responses responses) {
		rr2.save(responses);
		
	}

	@Override
	public void giveFeedback(Feedback feedback) {
		rr1.save(feedback);
		
	}

	
	
}