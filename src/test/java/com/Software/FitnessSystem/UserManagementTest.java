package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.AdminPagesController;
import com.Software.FitnessSystem.AdminControllers.UserManagementControls;
import com.Software.FitnessSystem.AdminPageNavigation.UserManagementPage;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class UserManagementTest {
    UserManagementControls managementControls;
    AdminPagesController adminControllers;
    App app;
    
    /**
     * @author DELL
     * @param no parameters
     * 
     */
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
    	String userName = "JohnDoe";
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
        UserManagementPage.setUsername("JohnDoe", "Instructor");
    	adminControllers.managementPage.executeOption(3);
    	boolean actual = adminControllers.managementPage.getBooleanResolution();
        assertTrue(expected == actual);
    }
    
    @Given("I have selected an existing user")
    public void i_have_selected_an_existing_client() {
        boolean expected = true;
        UserManagementPage.setUsername("John29Doe", "Client");
    	adminControllers.managementPage.executeOption(4);
    	boolean actual = adminControllers.managementPage.getBooleanResolution();
        assertTrue(expected == actual);
    }
    
    @When("I edit the user details")
    public void i_edit_the_user_details() {
        boolean expected = true;
        boolean actual = managementControls.editUserDetails("JohnDoe", "Instructor");
        assertTrue(expected == actual);
    }
    
    @When("I edit the user details")
    public void i_edit_the_client_details() {
        boolean expected = true;
        boolean actual = managementControls.editUserDetails("John29Doe", "Client");
        assertTrue(expected == actual);
    }
    
    @When("I save the changes")
    public void i_save_the_changes() {
    	managementControls.saveChanges();
        System.out.println("Changes saved.");
    }
    
    @Then("the user account should be updated successfully")
    public void the_user_account_should_be_updated_successfully() {
        boolean isUpdated = managementControls.verifyUserUpdate("JaneDoe");
        assert isUpdated : "User account update failed.";
        System.out.println("User account updated successfully.");
    }
    
    @Given("I have selected an active user")
    public void i_have_selected_an_active_user() {
    	UserManagementControls.selectUser("ActiveUser", "");
        System.out.println("Selected an active user.");
    }
    
    @When("I deactivate the user account")
    public void i_deactivate_the_user_account() {
    	managementControls.deactivateUser("ActiveUser");
        System.out.println("Deactivated user account.");
    }
    
    @Then("the user should no longer be able to log in")
    public void the_user_should_no_longer_be_able_to_log_in() {
        boolean isDeactivated = managementControls.verifyUserDeactivation("ActiveUser");
        assert isDeactivated : "User deactivation failed.";
        System.out.println("User can no longer log in.");
    }
    
    @Given("there are pending instructor applications")
    public void there_are_pending_instructor_applications() {
        boolean hasPending = managementControls.checkPendingApplications();
        assert hasPending : "No pending instructor applications.";
        System.out.println("Found pending instructor applications.");
    }
    
    @When("I approve an application")
    public void i_approve_an_application() {
    	managementControls.approveApplication("PendingInstructor");
        System.out.println("Approved an instructor application.");
    }
    
    @Then("the instructor should receive an approval notification")
    public void the_instructor_should_receive_an_approval_notification() {
        boolean notificationSent = managementControls.verifyNotification("PendingInstructor");
        assert notificationSent : "Approval notification not sent.";
        System.out.println("Instructor received approval notification.");
    }
    
    @Then("their account should become active")
    public void their_account_should_become_active() {
        boolean isActive = managementControls.verifyAccountActivation("PendingInstructor");
        assert isActive : "Instructor account activation failed.";
        System.out.println("Instructor account is now active.");
    }
    
    @When("I view activity reports")
    public void i_view_activity_reports() {
    	managementControls.viewActivityReports();
        System.out.println("Viewed activity reports.");
    }
    
    @Then("I should see detailed engagement statistics for all users")
    public void i_should_see_detailed_engagement_statistics_for_all_users() {
        boolean reportsLoaded = managementControls.verifyActivityReports();
        assert reportsLoaded : "Failed to load engagement statistics.";
        System.out.println("Engagement statistics displayed successfully.");
    }
}