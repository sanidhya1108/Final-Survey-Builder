package com.surveybuilder.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.surveybuilder.entities.Survey;

@Repository
public interface SurveyDao extends JpaRepository<Survey, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="delete from Survey s where s.surveyId=:surveyId ")
	void deleteSurveyById(@Param("surveyId") int surveyId);

}
