package com.surveybuilder.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import com.surveybuilder.dao.QuestionsDao;
import com.surveybuilder.dao.SurveyDao;
import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Questions;
import com.surveybuilder.entities.Survey;

@RunWith(SpringRunner.class)
@SpringBootTest
class SurveyorServiceTest {
	
	@Autowired
	private SurveyorService surveyorService;
	
	@MockBean
	private SurveyDao surveyDao;
	
	@Test //to add Survey
	public void testAddSurvey() throws Exception
	{
		Survey sur = new Survey();
		sur.setSurveyId(1000);
		sur.setSurveyTitle("HR");
		//sur.setSurveyDate(2021-11-1);
		//sur.setSurveyLastDate(2021-12-1);
		Mockito.when(surveyDao.save(sur)).thenReturn(sur);
		assertThat(surveyorService.addSurvey(sur)).isEqualTo(sur);
	}
	
	@MockBean
	private QuestionsDao queDao;
	
	
	@Test // to add questions to survey
	public void testAddQuestions() throws Exception
	{
		Questions que = new Questions();
		que.setQuestionId(1);
		que.setQuestionContent("How is hr Services");
		que.setOption1("a");
		que.setOption2("b");
		que.setOption3("c");
		Mockito.when(queDao.save(que)).thenReturn(que);
		assertThat(surveyorService.addQuestion(que)).isEqualTo(que);
	}
	
	@Test //to find All survey
	public void testFindAllSurvey() throws Exception
	{
		List<Questions> lq = new ArrayList<Questions>();
		Questions questions = new Questions();
		lq.add(questions);
		Mockito.when(queDao.findAll()).thenReturn(lq);
		List<Questions> result =surveyorService.findAllSurvey();
		assertThat(lq).isEqualTo(result);
		
	}
	

	@Test //delete Questions
	public void testRemoveQuestions() throws Exception
	{
		Questions ques =new Questions();
		ques.setQuestionId(11);
		surveyorService.removeQuestion(11);
		verify(queDao,times(1)).deleteQuestionById(11);
	}
	
	@Test //delete Survey
	public void testRemoveSurvey() throws Exception
	{
		Survey s = new Survey();
		s.setSurveyId(1000);
		surveyorService.removeSurvey(1000);
		verify(surveyDao,times(1)).deleteSurveyById(1000);
	}
	
	@MockBean
	private FeedbackDao fDao;
	
	
	@Test //to find All feedback
	public void testFindAllFeedBack() throws Exception
	{
		List<Feedback> fb = new ArrayList<Feedback>();
		Feedback feedback  = new Feedback();
		fb.add(feedback);
		Mockito.when(fDao.findAll()).thenReturn(fb);
		List<Feedback> result =surveyorService.findAllFeedback();
		assertThat(fb).isEqualTo(result);
	}
	
	
}
