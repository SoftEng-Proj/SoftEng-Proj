package com.Software.FitnessSystem;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.UserManagementControls.*;
import com.Software.FitnessSystem.AdminControllers.UserManagementControls;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementTest {
    UserManagementControls managementControls;
    AdminPagesController adminControllers;
    App app;

    public UserManagementTest(App obj, AdminPagesController admin, UserManagementControls userManag) {
        this.app = obj;
        this.adminControllers = admin;
        this.managementControls = userManag;
    }
    
    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
    	String expected = "AdminLoggedIn";
    	String actual = login("AdminUser", "Admin");
        assertEquals(expected, actual);
    }
    
    @When("I fill in the details for a new user")
    public void i_fill_in_the_details_for_a_new_user() {
    	String fName = "John";
    	String lName = "Doe";
    	String email = "johndoe@example.com";
    	String userName = "John6565Doe";
    	String password = "password123";
    	String role = "Instructor";
    	
    	String expected = "Instructor_Added";
    	String actual = fillUserDetails(fName, lName, email, userName, password, role);
        assertEquals(expected, actual);
    }
    
    @Then("the new user account should be created successfully")
    public void the_new_user_account_should_be_created_successfully() {
    	boolean expected = true;
        boolean actual = verifyUserCreation("JohnDoe", "Instructor");
        assertEquals(expected, actual);
    }
    
    @Given("I have selected an existing user")
    public void i_have_selected_an_existing_user() {
        boolean expected = true;
    	boolean actual = selectUser("JohnDoe", "Instructor");
        assertEquals(expected, actual);
    }
    
    @When("I edit the user details")
    public void i_edit_the_user_details() {
        boolean expected = true;
        Instructor editInstructor = getInstructorsMap().get("JohnDoe");
        boolean actual = checkNewData(editInstructor, "John", "Doe", "email", "JohnDoe", "password12");
        assertEquals(expected, actual);
    }
    
    @When("I save the changed data")
    public void i_save_the_changed_data() {
    	boolean expected = true;
        boolean actual = saveAccountChanges();
        assertEquals(expected, actual);
    }
    
    @Then("the user account should be updated successfully")
    public void the_user_account_should_be_updated_successfully() {
    	boolean expected = true;
    	Instructor editInstructor = getInstructorsMap().get("JohnDoe");
        boolean actual = checkNewData(editInstructor, "John", "Doe", "email", "JohnDoe", "password12");
        assertEquals(expected, actual);
    }
    
    @Given("I have selected an active user")
    public void i_have_selected_an_active_user() {
    	boolean expected = true;
    	boolean actual = selectUser("Activate", "Instructor");
        assertEquals(expected, actual);
    }
    
    @When("I deactivate the user account")
    public void i_deactivate_the_user_account() {
    	boolean expected = true;
    	boolean actual = deactivateUser("Activate", "Instructor");
        assertEquals(expected, actual);
    }
    
    @Then("the user should no longer be able to log in")
    public void the_user_should_no_longer_be_able_to_log_in() {
    	boolean expected = true;
    	deactivateUser("Activate", "Instructor");
        boolean isDeactivated = managementControls.verifyUserDeactivation("Activate", "Instructor");
        assertEquals(expected, isDeactivated);
    }
    
    @Given("there are pending instructor applications")
    public void there_are_pending_instructor_applications() {
    	boolean expected = true;
        boolean hasPending = checkPendingApplications();
        assertEquals(expected, hasPending);
    }
    
    @When("I approve an application")
    public void i_approve_an_application() {
    	boolean expected = true;
    	
    	String[] list = {"ActivatePend"};
        boolean hasApproved = approveInstructors(list, true);
        assertEquals(expected, hasApproved);
    }
    
    @Then("the account should become active")
    public void their_account_should_become_active() {
    	boolean expected = true;
        boolean isActive = verifyAccountActivation();
        assertEquals(expected, isActive);
    }
    
    @When("I view activity reports")
    public void i_view_activity_reports() {
    	boolean expected = true;
        boolean actual = viewActivityReports();
        assertEquals(expected, actual);
    }
    
    @Then("I should see detailed engagement statistics for all users")
    public void i_should_see_detailed_engagement_statistics_for_all_users() {
    	boolean expected = true;
        boolean reportsLoaded = verifyActivityReports();
        assertEquals(expected, reportsLoaded);
    }
}