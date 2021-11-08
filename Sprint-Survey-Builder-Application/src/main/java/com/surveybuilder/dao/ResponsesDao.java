package com.surveybuilder.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.surveybuilder.entities.Responses;

@Repository
public interface ResponsesDao extends JpaRepository<Responses,Integer>{
  @Transactional
	@Query(value="select r from Responses r where r.respondent.respondentId=:respondentId")
	List<Responses> findResponsesById(@Param("respondentId") int respondentId);

}