package com.Software.FitnessSystem;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class UserManagementTest {
    App app;
    AdminControllers adminProcedures;
    
    /**
     * @author DELL
     * @param
     * 
     */
    public UserManagementTest() {
        this.app = new App();
        this.adminProcedures = new AdminControllers();
    }
    
    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
    	String expected = "AdminLoggedIn";
    	String actual = app.login("AdminUser", "AdminPassword", "Admin");
        assertTrue(expected.equals(actual));
    }
    
    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String page) {
    	boolean exp = true;
        boolean real = adminProcedures.navigateToManagementPage();
        assertTrue(exp == real);
    }
    
    @When("I fill in the details for a new user")
    public void i_fill_in_the_details_for_a_new_user() {
        adminProcedures.fillUserDetails("John", "Doe", "johndoe@example.com", "JohnDoe", "password123", "Instructor");
        System.out.println("Filled in details for a new user.");
    }
    
    @When("I submit the form")
    public void i_submit_the_form() {
        adminProcedures.submitForm();
        System.out.println("Form submitted.");
    }
    
    @Then("the new user account should be created successfully")
    public void the_new_user_account_should_be_created_successfully() {
        boolean isCreated = adminProcedures.verifyUserCreation("JohnDoe");
        assert isCreated : "User account creation failed.";
        System.out.println("New user account created successfully.");
    }
    
    @Given("I am on the {string} page")
    public void i_am_on_the_page(int page) {
        adminProcedures.navigateToPage(page);
        System.out.println("On the " + page + " page.");
    }
    
    @Given("I have selected an existing user")
    public void i_have_selected_an_existing_user() {
        adminProcedures.selectUser("JaneDoe");
        System.out.println("Selected existing user.");
    }
    
    @When("I edit the user details")
    public void i_edit_the_user_details() {
        adminProcedures.editUserDetails("JaneDoe", "janedoe_new@example.com", "newpassword456");
        System.out.println("Edited user details.");
    }
    
    @When("I save the changes")
    public void i_save_the_changes() {
        adminProcedures.saveChanges();
        System.out.println("Changes saved.");
    }
    
    @Then("the user account should be updated successfully")
    public void the_user_account_should_be_updated_successfully() {
        boolean isUpdated = adminProcedures.verifyUserUpdate("JaneDoe");
        assert isUpdated : "User account update failed.";
        System.out.println("User account updated successfully.");
    }
    
    @Given("I have selected an active user")
    public void i_have_selected_an_active_user() {
        adminProcedures.selectUser("ActiveUser");
        System.out.println("Selected an active user.");
    }
    
    @When("I deactivate the user account")
    public void i_deactivate_the_user_account() {
        adminProcedures.deactivateUser("ActiveUser");
        System.out.println("Deactivated user account.");
    }
    
    @Then("the user should no longer be able to log in")
    public void the_user_should_no_longer_be_able_to_log_in() {
        boolean isDeactivated = adminProcedures.verifyUserDeactivation("ActiveUser");
        assert isDeactivated : "User deactivation failed.";
        System.out.println("User can no longer log in.");
    }
    
    @Given("there are pending instructor applications")
    public void there_are_pending_instructor_applications() {
        boolean hasPending = adminProcedures.checkPendingApplications();
        assert hasPending : "No pending instructor applications.";
        System.out.println("Found pending instructor applications.");
    }
    
    @When("I approve an application")
    public void i_approve_an_application() {
        adminProcedures.approveApplication("PendingInstructor");
        System.out.println("Approved an instructor application.");
    }
    
    @Then("the instructor should receive an approval notification")
    public void the_instructor_should_receive_an_approval_notification() {
        boolean notificationSent = adminProcedures.verifyNotification("PendingInstructor");
        assert notificationSent : "Approval notification not sent.";
        System.out.println("Instructor received approval notification.");
    }
    
    @Then("their account should become active")
    public void their_account_should_become_active() {
        boolean isActive = adminProcedures.verifyAccountActivation("PendingInstructor");
        assert isActive : "Instructor account activation failed.";
        System.out.println("Instructor account is now active.");
    }
    
    @When("I view activity reports")
    public void i_view_activity_reports() {
        adminProcedures.viewActivityReports();
        System.out.println("Viewed activity reports.");
    }
    
    @Then("I should see detailed engagement statistics for all users")
    public void i_should_see_detailed_engagement_statistics_for_all_users() {
        boolean reportsLoaded = adminProcedures.verifyActivityReports();
        assert reportsLoaded : "Failed to load engagement statistics.";
        System.out.println("Engagement statistics displayed successfully.");
    }
}