
package com.surveybuilder.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.surveybuilder.dao.AdminDao;
import com.surveybuilder.dao.SurveyorDao;
import com.surveybuilder.entities.Admin;
import com.surveybuilder.entities.Surveyor;
import com.surveybuilder.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {

	@Autowired
	private AdminService adminService;
	
	@MockBean
	private AdminDao adminDao;
	
	@Test //to create Admin
	public void testCreateAdmin() throws Exception
	{
		Admin ad = new Admin();
		ad.setAdminId(14);
		ad.setAdminUsername("Ase");
		ad.setAdminPassword("##");
		ad.setUserType("admin");
		Mockito.when(adminDao.save(ad)).thenReturn(ad);
	assertThat(adminService.createAdmin(ad)).isEqualTo(ad);
	}

	
	@MockBean
	private SurveyorDao surveyorDao;
	
	@Test //to create Surveyor
	public void testCreateSurveyor() throws Exception
	{
		Surveyor su = new Surveyor();
		su.setSurveyorId(100);
		su.setSurveyorUsername("Aqe123");
		su.setSurveyorPassword("$$$");
		su.setUserType("Surveyor");
		Mockito.when(surveyorDao.save(su)).thenReturn(su);
		assertThat(adminService.createSurveyor(su)).isEqualTo(su);
		
	}
}
