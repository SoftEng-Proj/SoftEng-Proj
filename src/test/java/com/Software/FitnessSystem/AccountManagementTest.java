package com.Software.FitnessSystem;

import static org.junit.Assert.assertTrue;

import com.Software.FitnessSystem.ClientControllers.AccountManagementControls;
import com.Software.FitnessSystem.ClientPageNavigation.AccountManagementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountManagementTest {
	AccountManagementControls accountManagement;
    App app;
    
    public AccountManagementTest() {
        this.app = new App();
        this.accountManagement = new AccountManagementControls();
    }
	@Given("I am on the dietary preferences settings page")
	public void i_am_on_the_dietary_preferences_settings_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		boolean expected = true;
        boolean actual = AccountManagementPage.isOnDietaryRestrictionsPage();
        assertTrue(expected == actual);
	}

	@When("I select {string} as my dietary preference")
	public void i_select_as_my_dietary_preference(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@When("I add {string} as a restriction")
	public void i_add_as_a_restriction(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(null, "", "");
		assertTrue(acutal.equals(expcted));
		
	}

	@When("I save the changes")
	public void i_save_the_changes() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@Then("my dietary preferences should be updated")
	public void my_dietary_preferences_should_be_updated() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@Given("I am on the account creation page")
	public void i_am_on_the_account_creation_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		boolean expected = true;
        boolean actual = AccountManagementPage.isOnCreateProfilePage();
        assertTrue(expected == actual);
	}

	@When("I enter my personal details including age {string} and fitness goals {string}")
	public void i_enter_my_personal_details_including_age_and_fitness_goals(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Profile Created Successfully.";
		String acutal = AccountManagementControls.createProfile(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@When("I specify my dietary preferences or restrictions as {string}")
	public void i_specify_my_dietary_preferences_or_restrictions_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@When("I submit the form")
	public void i_submit_the_form() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Profile Created Successfully.";
		String acutal = AccountManagementControls.createProfile(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@Then("my profile should be created")
	public void my_profile_should_be_created() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Profile Created Successfully.";
		String acutal = AccountManagementControls.createProfile(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@Then("I should see a confirmation message {string}")
	public void i_should_see_a_confirmation_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Profile Created Successfully.";
		String acutal = AccountManagementControls.createProfile(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@Given("I am on the profile settings page")
	public void i_am_on_the_profile_settings_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		boolean expected = true;
        boolean actual = AccountManagementPage.isOnUpdatePersonalDetailsPage();
        assertTrue(expected == actual);
	}

	@When("I update my age to {string}")
	public void i_update_my_age_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Updated Personal Details successfully.";
		String acutal = AccountManagementControls.updatePersonalDetails(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@When("I change my fitness goals to {string}")
	public void i_change_my_fitness_goals_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Updated Personal Details successfully.";
		String acutal = AccountManagementControls.updatePersonalDetails(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

	@Then("my profile should be updated")
	public void my_profile_should_be_updated() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Updated Personal Details successfully.";
		String acutal = AccountManagementControls.updatePersonalDetails(null, "", "");
		assertTrue(acutal.equals(expcted));
	}

}
