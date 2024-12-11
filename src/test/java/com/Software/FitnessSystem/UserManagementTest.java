package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.UserManagementControls;
import com.Software.FitnessSystem.AdminPageNavigation.UserManagementPage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class UserManagementTest {
    UserManagementControls managementControls;
    AdminPagesController adminControllers;
    App app;
    
    public UserManagementTest() {
        this.app = new App();
        this.adminControllers = new AdminPagesController();
        this.managementControls = new UserManagementControls();
    }
    
    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
    	
    	String expected = "AdminLoggedIn";
    	String actual = App.login("AdminUser", "AdminPassword", "Admin");
        assertTrue(expected.equals(actual));
    }
    
    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page() {
    	boolean expected = true;
        boolean actual = adminControllers.navigateToManagementPage();
        assertTrue(expected == actual);
    }
    
    @When("I fill in the details for a new user")
    public void i_fill_in_the_details_for_a_new_user() {
    	String fName = "John";
    	String lName = "Doe";
    	String email = "johndoe@example.com";
    	String userName = "John6565Doe";
    	String password = "password123";
    	String role = "Instructor";
    	UserManagementPage.setUserValues(fName, lName, email, userName, password, role);
    	adminControllers.managementPage.executeOption(1);
    	
    	String expected = "Instructor_Added";
    	String actual = adminControllers.managementPage.getStringResolution();
    	assertTrue(expected.equals(actual));
    }
    
    @Then("the new user account should be created successfully")
    public void the_new_user_account_should_be_created_successfully() {
    	boolean expected = true;
        boolean actual = UserManagementControls.verifyUserCreation("JohnDoe", "Instructor");
        assertTrue(expected == actual);
    }
    
    @When("I fill in the details for a new user")
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
    
    @Then("the new user account should be created successfully")
    public void the_new_client_account_should_be_created_successfully() {
    	boolean expected = true;
        boolean actual = UserManagementControls.verifyUserCreation("John29Doe", "Client");
        assertTrue(expected == actual);
    }
    
    @Given("I am on the {string} page")
    public void i_am_on_the_page() {
    	boolean expected = true;
        boolean actual = adminControllers.navigateToPage(1);
        assertTrue(expected == actual);
    }
    
    @Given("I have selected an existing user")
    public void i_have_selected_an_existing_user() {
        boolean expected = true;
    	boolean actual = UserManagementControls.selectUser("JohnDoe", "Instructor");
        assertTrue(expected == actual);
    }
    
    @Given("I have selected an existing user")
    public void i_have_selected_an_existing_client() {
        boolean expected = true;
    	boolean actual = UserManagementControls.selectUser("John29Doe", "Client");
        assertTrue(expected == actual);
    }
    
    @When("I edit the user details")
    public void i_edit_the_user_details() {
        boolean expected = true;
        boolean actual = UserManagementControls.editUserDetails("JohnDoe", "Instructor");
        assertTrue(expected == actual);
    }
    
    @When("I edit the user details")
    public void i_edit_the_client_details() {
        boolean expected = true;
        boolean actual = UserManagementControls.editUserDetails("John29Doe", "Client");
        assertTrue(expected == actual);
    }
    
    @When("I save the changes")
    public void i_save_the_changes() {
    	boolean expected = true;
        boolean actual = UserManagementControls.saveChanges();
        assertTrue(expected == actual);
    }
    
    @Then("the user account should be updated successfully")
    public void the_user_account_should_be_updated_successfully() {
    	boolean expected = true;
    	UserManagementControls.editUserDetails("JohnDoe", "Instructor");
        boolean actual = managementControls.verifyUserUpdate("JohnDoe", "Instructor");
        assertTrue(expected == actual);
    }
    
    @Then("the user account should be updated successfully")
    public void the_client_account_should_be_updated_successfully() {
    	boolean expected = true;
    	UserManagementControls.editUserDetails("John29Doe", "Client");
        boolean actual = managementControls.verifyUserUpdate("John29Doe", "Client");
        assertTrue(expected == actual);
    }
    
    @Given("I have selected an active user")
    public void i_have_selected_an_active_user() {
    	boolean expected = true;
    	boolean actual = UserManagementControls.selectUser("Activate", "Instructor");
    	assertTrue(expected == actual);
    }
    
    @Given("I have selected an active user")
    public void i_have_selected_an_active_client() {
    	boolean expected = true;
    	boolean actual = UserManagementControls.selectUser("active", "Client");
    	assertTrue(expected == actual);
    }
    
    @When("I deactivate the user account")
    public void i_deactivate_the_user_account() {
    	boolean expected = true;
    	boolean actual = UserManagementControls.deactivateUser("Activate", "Instructor");
    	assertTrue(expected == actual);
    }
    
    @When("I deactivate the user account")
    public void i_deactivate_the_client_account() {
    	boolean expected = true;
    	boolean actual = UserManagementControls.deactivateUser("active", "Client");
    	assertTrue(expected == actual);
    }
    
    @Then("the user should no longer be able to log in")
    public void the_user_should_no_longer_be_able_to_log_in() {
    	boolean expected = true;
    	UserManagementControls.deactivateUser("Activate", "Instructor");
        boolean isDeactivated = managementControls.verifyUserDeactivation("Activate", "Instructor");
        assertTrue(expected == isDeactivated);
    }
    
    @Then("the user should no longer be able to log in")
    public void the_client_should_no_longer_be_able_to_log_in() {
    	boolean expected = true;
    	UserManagementControls.deactivateUser("active", "Client");
        boolean isDeactivated = managementControls.verifyUserDeactivation("active", "Client");
        assertTrue(expected == isDeactivated);
    }
    
    @Given("there are pending instructor applications")
    public void there_are_pending_instructor_applications() {
    	boolean expected = true;
        boolean hasPending = UserManagementControls.checkPendingApplications();
        assertTrue(expected == hasPending);
    }
    
    @Given("there are pending instructor applications")
    public void there_are_not_pending_instructor_applications() {
    	boolean expected = false;
        boolean hasPending = UserManagementControls.checkPendingApplications();
        assertTrue(expected == hasPending);
    }
    
    @When("I approve an application")
    public void i_approve_an_application() {
    	boolean expected = true;
    	UserManagementControls.checkPendingApplications();
        boolean hasApproved = UserManagementControls.approveInstructors();
        assertTrue(expected == hasApproved);
    }
    
    @Then("the account should become active")
    public void their_account_should_become_active() {
    	boolean expected = true;
        boolean isActive = UserManagementControls.verifyAccountActivation();
        assertTrue(expected == isActive);
    }
    
    @When("I view activity reports")
    public void i_view_activity_reports() {
    	boolean expected = true;
        boolean actual = UserManagementControls.viewActivityReports();
        assertTrue(expected == actual);
    }
    
    @Then("I should see detailed engagement statistics for all users")
    public void i_should_see_detailed_engagement_statistics_for_all_users() {
    	boolean expected = true;
        boolean reportsLoaded = UserManagementControls.verifyActivityReports();
        assertTrue(expected == reportsLoaded);
    }
}