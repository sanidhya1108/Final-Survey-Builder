package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.surveybuilder.entities.Respondent;




@Repository
public interface RespondentDao extends JpaRepository<Respondent, Integer>{
	@Query("select r from Respondent r where r.respondentId = ?1")
	public Respondent findRespondentById(int id);

	@Query("select a from Respondent a where (a.respondentUsername  = ?1 and a.respondentPassword = ?2)")
	public Respondent authRespondent(String RespondentUsername, String pass);
}