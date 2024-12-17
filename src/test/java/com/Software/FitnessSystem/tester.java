package com.Software.FitnessSystem;

import static com.Software.FitnessSystem.App.login;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.Software.FitnessSystem.AdminControllers.UserManagementControls;
import com.Software.FitnessSystem.ClientControllers.AccountManagementControls;
import com.Software.FitnessSystem.ClientPageNavigation.AccountManagementPage;
import com.Software.FitnessSystem.ClientPageNavigation.ProgressTrackingPage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

class tester {
    UserManagementControls managementControls;
    AdminPagesController adminControllers;
    App app;
    
    public tester() {
        this.app = new App();
        this.adminControllers = new AdminPagesController();
        this.managementControls = new UserManagementControls();
    }
    
    @Test
    public void i_am_on_the_progress_tracking_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		boolean expected = true;
		boolean actual = ProgressTrackingPage.isAddMilestonePage();
		assertTrue(actual == expected);
	}
}