package com.Software.FitnessSystem;
import static org.junit.Assert.assertEquals;
import com.Software.FitnessSystem.ClientControllers.AccountManagementControls;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountManagementTest {
	AccountManagementControls accountManagement;
    App app;
    
    public AccountManagementTest(App ap, AccountManagementControls am) {
        this.app = ap;
        this.accountManagement = am;
    }
    
	@When("I select {string} as my dietary preference")
	public void i_select_as_my_dietary_preference(String dietaryPreference) {
		String expected = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), dietaryPreference, "none");
        assertEquals(expected, acutal);
	}
	
	@When("I add {string} as a restriction")
	public void i_add_as_a_restriction(String restriction) {
		String expected = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high proten", restriction);
        assertEquals(expected, acutal);
		
	}

	@When("I save the changes")
	public void i_save_the_changes() {
		String expected = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high proten", "vegan");
        assertEquals(expected, acutal);
	}

	@Then("my dietary preferences should be updated")
	public void my_dietary_preferences_should_be_updated() {
		String expected = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high proten", "vegan");
        assertEquals(expected, acutal);
	}


	@When("I enter my personal details including age {string} and fitness goals {string}")
	public void i_enter_my_personal_details_including_age_and_fitness_goals(String string, String string2) {
		String expcted = "Profile Created Successfully";
		String acutal = AccountManagementControls.createProfile("active", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@When("I specify my dietary preferences or restrictions as {string}")
	public void i_specify_my_dietary_preferences_or_restrictions_as(String string) {
		String expcted = "Dietary Preferences Updated";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high proten", "vegan");
        assertEquals(expcted, acutal);
	}

	@When("I submit the form")
	public void i_submit_the_form() {
		String expcted = "Profile Created Successfully";
		String acutal = AccountManagementControls.createProfile("active", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@Then("my profile should be created")
	public void my_profile_should_be_created() {
		String expcted = "Profile Created Successfully";
		String acutal = AccountManagementControls.createProfile("active", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@Then("I should see a confirmation message {string}")
	public void i_should_see_a_confirmation_message(String string) {
		String expcted = "Profile Created Successfully";
		String acutal = AccountManagementControls.createProfile("active", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
        assertEquals(expcted, acutal);
	}


	@When("I update my age to {string}")
	public void i_update_my_age_to(String string) {
		String expcted = "Updated Personal Details successfully";
		String acutal = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@When("I change my fitness goals to {string}")
	public void i_change_my_fitness_goals_to(String string) {
		String expcted = "Updated Personal Details successfully";
		String acutal = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@Then("my profile should be updated")
	public void my_profile_should_be_updated() {
		String expcted = "Updated Personal Details successfully";
		String acutal = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", "gain muscle");
        assertEquals(expcted, acutal);
	}
}   