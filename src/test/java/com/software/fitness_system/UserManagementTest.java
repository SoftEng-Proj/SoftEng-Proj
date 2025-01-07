package com.software.fitness_system;
import static com.software.fitness_system.App.*;
import static com.software.fitness_system.admin_controllers.UserManagementControls.*;
import static org.junit.Assert.assertEquals;

import com.software.fitness_system.admin_controllers.UserManagementControls;
import com.software.fitness_system.login_page.AdminPagesController;

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
    
    @When("I fill in the details for a new client")
    public void i_fill_in_the_details_for_a_new_client() {
    	String fName = "John";
    	String lName = "Doe";
    	String email = "johndoe@example.com";
    	String userName = "John6565Doe";
    	String password = "password123";
    	String role = "Client";
    	
    	String expected = "Client_Added";
    	String actual = fillUserDetails(fName, lName, email, userName, password, role);
        assertEquals(expected, actual);
    }

    @Then("the new client account should be created successfully")
    public void the_new_client_account_should_be_created_successfully() {
    	boolean expected = true;
        boolean actual = verifyUserCreation("JohnDoe", "Client");
        assertEquals(expected, actual);
    }

    @When("I fill in the details for a new instructor")
    public void i_fill_in_the_details_for_a_new_instructor() {
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

    @Then("the new instructor account should be created successfully")
    public void the_new_instructor_account_should_be_created_successfully() {
    	boolean expected = true;
        boolean actual = verifyUserCreation("JohnDoe", "Instructor");
        assertEquals(expected, actual);
    }

    @Given("I have selected an existing client")
    public void i_have_selected_an_existing_client() {
    	boolean expected = true;
    	boolean actual = checkTheUser("JohnDoe", "Client");
        assertEquals(expected, actual);
    }

    @When("I edit the client details")
    public void i_edit_the_client_details() {
    	boolean expected = true;
    	boolean actual = checkTheUser("JohnDoe", "Client");
        assertEquals(expected, actual);
    }
    
    @Then("the client account should be updated successfully")
    public void the_client_account_should_be_updated_successfully() {
    	boolean expected = true;
    	Client editInstructor = getClientsMap().get("JohnDoe");
        boolean actual = checkNewData(editInstructor, "John", "Doe", "email", "JohnDoe", "password12");
        assertEquals(expected, actual);
    }
    
    @Given("I have selected an existing instructor")
    public void i_have_selected_an_existing_instructor() {
    	boolean expected = true;
    	boolean actual = checkTheUser("JohnDoe", "Instructor");
        assertEquals(expected, actual);
    }
    
    @When("I edit the instructor details")
    public void i_edit_the_instructor_details() {
    	boolean expected = true;
    	boolean actual = checkTheUser("JohnDoe", "Instructor");
        assertEquals(expected, actual);
    }
    
    @Then("the instructor account should be updated successfully")
    public void the_instructor_account_should_be_updated_successfully() {
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

    @Given("I have selected an active client")
    public void i_have_selected_an_active_client() {
    	boolean expected = true;
    	boolean actual = checkTheUser("active", "Client");
        assertEquals(expected, actual);
    }

    @When("I deactivate the client account")
    public void i_deactivate_the_client_account() {
    	boolean expected = true;
    	boolean actual = deactivateUser("active", "Client");
        assertEquals(expected, actual);
    }

    @Then("the client should no longer be able to log in")
    public void the_client_should_no_longer_be_able_to_log_in() {
    	boolean expected = true;
    	deactivateUser("active", "Client");
        boolean isDeactivated = managementControls.verifyUserDeactivation("active", "Client");
        assertEquals(expected, isDeactivated);
    }
    
    @Given("I have selected an active instructor")
    public void i_have_selected_an_active_instructor() {
    	boolean expected = true;
    	boolean actual = checkTheUser("Activate", "Instructor");
        assertEquals(expected, actual);
    }

    @When("I deactivate the instructor account")
    public void i_deactivate_the_instructor_account() {
    	boolean expected = true;
    	boolean actual = deactivateUser("Activate", "Instructor");
        assertEquals(expected, actual);
    }
    
    @Then("the instructor should no longer be able to log in")
    public void the_instructor_should_no_longer_be_able_to_log_in() {
    	boolean expected = true;
    	deactivateUser("Activate", "Instructor");
        boolean isDeactivated = managementControls.verifyUserDeactivation("Activate", "Instructor");
        assertEquals(expected, isDeactivated);;
    }
    
    @Given("there are pending instructor applications")
    public void there_are_pending_instructor_applications() {
    	boolean expected = true;
        boolean hasPending = checkPendingApplications();
        assertEquals(expected, hasPending);
    }
    
    @When("I approve a instructor application")
    public void iApproveAInstructorApplication() {
    	boolean expected = true;
    	
    	String[] list = {"ActivatePend"};
        boolean hasApproved = processApprovals(list, getPendingInstructorsMap(), getInstructorsMap());
        assertEquals(expected, hasApproved);
    }
    
    /*
     *     
    @When("i approve a instructor application")
    public void i_approve_a_instructor_application() {
    	boolean expected = true;
    	
    	String[] list = {"ActivatePend"};
        boolean hasApproved = processApprovals(list, getPendingInstructorsMap(), getInstructorsMap());
        assertEquals(expected, hasApproved);
    }
     */
    
    @Then("the instructor account should become active")
    public void the_instructor_account_should_become_active() {
    	boolean expected = true;
        boolean isActive = verifyAccountActivation();
        assertEquals(expected, isActive);
    }
    
    @When("I view activity reports")
    public void i_view_activity_reports() {
    	boolean expected = true;
        boolean actual = viewAndVerifyReportsActivity();
        assertEquals(expected, actual);
    }
    
    @Then("I should see detailed engagement statistics for all users")
    public void i_should_see_detailed_engagement_statistics_for_all_users() {
    	boolean expected = true;
        boolean reportsLoaded = verifyActivityReports();
        assertEquals(expected, reportsLoaded);
    }
}