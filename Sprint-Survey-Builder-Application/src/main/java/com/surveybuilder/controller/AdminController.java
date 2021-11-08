package com.surveybuilder.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surveybuilder.entities.Admin;
import com.surveybuilder.entities.Surveyor;
import com.surveybuilder.service.AdminService;

@RestController
@RequestMapping(path = "admin")
public class AdminController {
	@Autowired
	private AdminService service = null;

	@PostMapping(path = "admin")
	public ResponseEntity<String> createAdminController(@Valid@RequestBody Admin admin) {
		ResponseEntity<String>response=null;
		service.createAdmin(admin);
		response=new ResponseEntity<String>(admin.getAdminId()+"is created",HttpStatus.CREATED);
		return response;
	}
	@PostMapping(path="surveyor")
	public ResponseEntity<String> createSurveyor(@Valid @RequestBody Surveyor surveyor) {
		ResponseEntity<String>response=null;
		service.createSurveyor(surveyor);
		response=new ResponseEntity<String>(surveyor.getSurveyorId()+"is created",HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping(path="admin/{adminUsername}/{adminPassword}")
	public String authAdminController(@PathVariable("adminUsername") String adminUsername,@PathVariable("adminPassword") String adminPassword) {
		Admin admin=service.authAdmin(adminUsername, adminPassword);
		if( service.authAdmin(adminUsername, adminPassword) != null)
			return "login successfull";
		else
			return "login failed";
	
	}
	
}