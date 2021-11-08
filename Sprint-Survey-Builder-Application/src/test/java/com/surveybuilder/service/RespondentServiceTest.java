package com.surveybuilder.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.surveybuilder.dao.FeedbackDao;
import com.surveybuilder.dao.RespondentDao;
import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Respondent;





@RunWith(SpringRunner.class)
@SpringBootTest
class RespondentServiceTest {

	@Autowired
	private RespondentService respondentService;
	   
	@MockBean
	private RespondentDao respondentDao;

	@MockBean
	private FeedbackDao feedbackDao;
	
	@MockBean
	
	private Feedback feedbackService;
	@Test
	public void testCreateRespondentService() throws Exception {
		Respondent res=new Respondent ();
		res.setRespondentId(8);
		res.setRespondentName("abc");
		res.setRespondentUsername("abc");
		res.setRespondentPassword("abc");
		res.setUserType("abc");
		Mockito.when(respondentDao.save(res)).thenReturn(res);
		assertThat(respondentService.createRespondentService(res)).isEqualTo(res);
	}
	

	@Test
	void testViewRespondentByIdController() throws Exception {
		
		Respondent respondent = getRespondent();

	    Mockito.when(respondentDao.findRespondentById( Mockito.anyInt())).thenReturn(respondent);

	    Respondent result = respondentService.viewRespondentByIdService(8);
	    
	    assertThat(respondent).isEqualTo(result);

	}

	@Test
	void testUpdateRespondentController() throws Exception {
		
		Optional<Respondent> a = Optional.of(getRespondent());
		
		
		Respondent respondent = getRespondent();
	  
	    Mockito.when(respondentDao.findById( Mockito.anyInt())).thenReturn(a);
	    Mockito.when(respondentDao.save(Mockito.any(Respondent.class))).thenReturn(respondent);
	    
	    Respondent result = respondentService.updateRespondentService(respondent, 8);
	    
	    assertThat(respondent).isEqualTo(result);
	}

	@Test
	void testDeleteRespondentByIdController() throws Exception {
		Respondent respondent = getRespondent();

	    Mockito.when(respondentDao.findRespondentById(Mockito.anyInt())).thenReturn(respondent);

	    Respondent result = respondentService.viewRespondentByIdService(8);
	    
	    assertThat(respondent).isEqualTo(result);
	}

	@Test
	void testListAllRespondentController() throws Exception {

		List<Respondent> a = new ArrayList<Respondent>();
		
		Respondent respondent = getRespondent();
		a.add(respondent);
	    
	    Mockito.when(respondentDao.findAll()).thenReturn(a);
	   
	    List<Respondent> result = respondentService.listAllRespondentService();
	    
	    
	    assertThat(a).isEqualTo(result);
	}
	
	
	private Respondent getRespondent() {
		Respondent a = new Respondent();
		
		a.setRespondentId(8);
		a.setRespondentUsername("abc");
		a.setRespondentName("abc");
		a.setRespondentPassword("abc");
		a.setUserType("abc");
		
		return a;
	}
}
