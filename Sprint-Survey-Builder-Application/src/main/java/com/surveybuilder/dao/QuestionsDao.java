package com.surveybuilder.dao;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.surveybuilder.entities.Questions;

public interface QuestionsDao extends JpaRepository<Questions, Integer>{
  
  @Modifying
	@Transactional
	@Query(value="delete from Questions q where q.questionId=:questionId")
	public void deleteQuestionById(@Param("questionId") int questionId);

}