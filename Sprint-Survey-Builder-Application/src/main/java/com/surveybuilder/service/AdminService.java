package com.surveybuilder.service;

import java.util.List;

import com.surveybuilder.entities.Admin;
import com.surveybuilder.entities.Feedback;
import com.surveybuilder.entities.Responses;
import com.surveybuilder.entities.Surveyor;

public interface AdminService {
	public Admin createAdmin(Admin admin);
	public Surveyor createSurveyor(Surveyor surveyor);
	public Admin authAdmin(String adminUsername, String adminPassword);
	
}