package com.Software.FitnessSystem;
import static org.junit.Assert.*;

import org.junit.Test;

import com.Software.FitnessSystem.AdminControllers.AdminPagesController;
import com.Software.FitnessSystem.AdminControllers.UserManagementControls;
import com.Software.FitnessSystem.AdminPageNavigation.UserManagementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class tester {
	App app;
	private AdminPagesController adminControllers;
    UserManagementControls managementControls;
	
	public tester() {
		this.app = new App();
		adminControllers = new AdminPagesController();
		managementControls = new UserManagementControls();
	}
	
	@Test
    public void i_fill_in_the_details_for_a_new_user() {
    	String fName = "John";
    	String lName = "Doe";
    	String email = "johndoe@example.com";
    	String userName = "JohnDoe";
    	String password = "password123";
    	String role = "Instructor";
    	UserManagementPage.setUserValues(fName, lName, email, userName, password, role);
    	adminControllers.managementPage.executeOption(1);
    	
    	String expected = "Instructor_Added";
    	String actual = adminControllers.managementPage.getStringResolution();
    	assertTrue(expected.equals(actual));
    }
    
    @Test
    public void i_fill_in_the_details_for_a_new_client() {
    	String fName = "John";
    	String lName = "Doe";
    	String email = "johndoe@example.com";
    	String userName = "John29Doe";
    	String password = "password123";
    	String role = "Client";
    	UserManagementPage.setUserValues(fName, lName, email, userName, password, role);
    	adminControllers.managementPage.executeOption(2);
    	
    	String expected = "Client_Added";
    	String actual = adminControllers.managementPage.getStringResolution();
    	assertTrue(expected.equals(actual));
    }
    
    @Test
    public void i_edit_the_user_details() {
        boolean expected = true;
        boolean actual = managementControls.editUserDetails("JohnDoe", "Instructor");
        assertTrue(expected == actual);
    }
    
    @Test
    public void i_edit_the_client_details() {
        boolean expected = true;
        boolean actual = managementControls.editUserDetails("John29Doe", "Client");
        assertTrue(expected == actual);
    }
}