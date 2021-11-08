package com.surveybuilder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.surveybuilder.entities.Feedback;
@Repository
public interface FeedbackDao extends JpaRepository<Feedback,Integer>{

}