package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.surveybuilder.entities.Surveyor;

public interface SurveyorDao extends JpaRepository<Surveyor,Integer>{
	@Query("select a from Surveyor a where (a.surveyorUsername  = ?1 and a.surveyorPassword = ?2)")
	Surveyor authSurveyor(String surveyorUsername, String surveyorPassword);

	
	

}