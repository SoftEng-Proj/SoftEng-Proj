package com.Software.FitnessSystem;
import static org.junit.Assert.*;

import org.junit.Test;

import com.Software.FitnessSystem.AdminControllers.UserManagementControls;
import com.Software.FitnessSystem.AdminPageNavigation.UserManagementPage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

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
    public void i_view_activity_reports() {
    	boolean expected = true;
        boolean actual = UserManagementControls.viewActivityReports();
        assertTrue(expected == actual);
        i_should_see_detailed_engagement_statistics_for_all_users();
        UserManagementControls.saveChanges();
    }
    
    public void i_should_see_detailed_engagement_statistics_for_all_users() {
    	boolean expected = true;
        boolean reportsLoaded = UserManagementControls.verifyActivityReports();
        assertTrue(expected == reportsLoaded);
    }
}