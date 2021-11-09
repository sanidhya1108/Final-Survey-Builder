package com.surveybuilder.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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
void testSetAdminId() {
	
	int mockId = 1;
	admin.setAdminId( mockId);
	int id = admin.getAdminId();
	
	assertThat(id).isEqualTo(mockId);
}
@Test
void testGetUserName() {
	String mockUserName = "akshay@gmail.com";
	admin.setAdminUsername(mockUserName);
	String name = admin.getAdminUsername();
	assertThat(name).isEqualTo(mockUserName);
}

@Test
void testSetUserName() {
	String mockUserName = "akshay@gmail.com";
	admin.setAdminUsername(mockUserName);
	String name = admin.getAdminUsername();
	
	assertThat(name).isEqualTo(mockUserName);
}
/*
 * @Test void testGetPassword() { String mockPassword="xyzz";
 * admin.setAdminPassword(mockPassword); String
 * password=admin.getAdminUsername();
 * assertThat(password).isEqualTo(mockPassword); }
 * 
 * @Test void testSetPassword() { String MockPassword="xyzz";
 * admin.setAdminPassword(MockPassword); String
 * password=admin.getAdminUsername();
 * assertThat(password).isEqualTo(MockPassword); }
 */
}


