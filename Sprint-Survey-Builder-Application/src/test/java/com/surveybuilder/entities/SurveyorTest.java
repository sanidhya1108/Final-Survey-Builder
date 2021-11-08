package com.surveybuilder.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class SurveyorTest {

private Surveyor surveyor=new Surveyor();
	   
	

	@Test
	void testGetSurveyorId() {
		int mockId = 1;
		surveyor.setSurveyorId( mockId);
		int id = surveyor.getSurveyorId();
		
		assertThat(id).isEqualTo(mockId);
	    
	}

	
	@Test
	void testSetSurveyorId() {
		int mockId = 1;
		surveyor.setSurveyorId( mockId);
		int id = surveyor.getSurveyorId();
		
		assertThat(id).isEqualTo(mockId);
	}

	
	@Test
	void testGetUserName() {
		String mockUserName = "akshay@gmail.com";
		surveyor.setSurveyorUsername(mockUserName);
		String username = surveyor.getSurveyorUsername();
		
		assertThat(username).isEqualTo(mockUserName);
	}

	@Test
	void testSetUserName() {
		String mockUserName = "akshay@gmail.com";
		surveyor.setSurveyorUsername(mockUserName);
		String username = surveyor.getSurveyorUsername();
		
		assertThat(username).isEqualTo(mockUserName);
	}

	@Test
	void testGetPassword() {
		String mockPass = "Sid123";
		surveyor.setSurveyorPassword(mockPass);
		String pass = surveyor.getSurveyorPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

	@Test
	void testSetPassword() {
		String mockPass = "Sid123";
		surveyor.setSurveyorPassword(mockPass);
		String pass = surveyor.getSurveyorPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

}
