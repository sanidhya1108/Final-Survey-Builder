package com.surveybuilder.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import com.surveybuilder.entities.Respondent;

class RespondentTest {

	private Respondent respondent = new Respondent();
	   
	

	@Test
	void testGetRespondentId() {
		int mockId = 1;
		respondent.setRespondentId( mockId);
		int id = respondent.getRespondentId();
		
		assertThat(id).isEqualTo(mockId);
	    
	}

	
	@Test
	void testSetRespondentId() {
		int mockId = 1;
		respondent.setRespondentId(mockId);
		long id = respondent.getRespondentId();
		
		assertThat(id).isEqualTo(mockId);
	}

	@Test
	void testGetName() {
		String mockName = "Sid";
		respondent.setRespondentName(mockName);
		String name = respondent.getRespondentName();
		
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testSetName() {
		String mockName = "Sid";
		
		respondent.setRespondentName(mockName);
		String name = respondent.getRespondentName();
		assertThat(name).isEqualTo(mockName);
	}

	@Test
	void testGetEmailId() {
		String mockUserName = "akshay@gmail.com";
		respondent.setRespondentUsername(mockUserName);
		String username = respondent.getRespondentUsername();
		
		assertThat(username).isEqualTo(mockUserName);
	}

	@Test
	void testSetEmailId() {
		String mockUserName = "akshay@gmail.com";
		respondent.setRespondentUsername(mockUserName);
		String username = respondent.getRespondentUsername();
		
		assertThat(username).isEqualTo(mockUserName);
	}

	@Test
	void testGetPassword() {
		String mockPass = "Sid123";
		respondent.setRespondentPassword(mockPass);
		String pass = respondent.getRespondentPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

	@Test
	void testSetPassword() {
		String mockPass = "Sid123";
		respondent.setRespondentPassword(mockPass);
		String pass = respondent.getRespondentPassword();
		
		assertThat(pass).isEqualTo(mockPass);
	}

}




