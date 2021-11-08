package com.surveybuilder.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surveybuilder.entities.Admin;
import com.surveybuilder.entities.Surveyor;


@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	Surveyor save(Surveyor surveyor);
	@Query("select a from Admin a where (a.adminUsername  = ?1 and a.adminPassword = ?2)")
	Admin authAdmin(String adminUsername, String adminPassword);
	
}