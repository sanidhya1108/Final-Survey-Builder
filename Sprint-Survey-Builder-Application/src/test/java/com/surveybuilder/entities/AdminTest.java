package com.surveybuilder.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.surveybuilder.entities.Admin;

public class AdminTest {
private Admin admin=new Admin();

@Test
void testGetAdminId() {
	int mockId = 1;
	admin.setAdminId( mockId);
	int id = admin.getAdminId();
	
	assertThat(id).isEqualTo(mockId);
    
}
@Test
void testSetRespondentId() {
	
	int mockId = 1;
	admin.setAdminId( mockId);
	int id = admin.getAdminId();
	
	assertThat(id).isEqualTo(mockId);
}
@Test
void testGetEmailId() {
	String mockEmail = "akshay@gmail.com";
	admin.setAdminUsername(mockEmail);
	String email = admin.getAdminUsername();
	assertThat(email).isEqualTo(mockEmail);
}

@Test
void testSetEmailId() {
	String mockEmail = "akshay@gmail.com";
	admin.setAdminUsername(mockEmail);
	String email = admin.getAdminUsername();
	
	assertThat(email).isEqualTo(mockEmail);
}
//@Test
//void testGetPassword() {
//	String mockPassword="xyzz";
//	admin.setAdminPassword(mockPassword);
//	String password=admin.getAdminUsername();
//	assertThat(password).isEqualTo(mockPassword);
//}
//
//@Test
//void testSetPassword() {
//	String MockPassword="xyzz";
//	admin.setAdminPassword(MockPassword);
//	String password=admin.getAdminUsername();
//	assertThat(password).isEqualTo(MockPassword);
//}
}
