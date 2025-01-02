package com.Software.FitnessSystem;
import static org.junit.Assert.assertEquals;
import com.Software.FitnessSystem.ClientControllers.AccountManagementControls;
import com.Software.FitnessSystem.ClientPageNavigation.AccountManagementPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountManagementTest {
	AccountManagementControls accountManagement;
    App app;
    
    public AccountManagementTest(App ap, AccountManagementControls am) {
        this.app = ap;
        this.accountManagement = am;
    }
	@Given("I am on the dietary preferences settings page")
	public void i_am_on_the_dietary_preferences_settings_page() {
		boolean expected = true;
        boolean actual = AccountManagementPage.isOnDietaryRestrictionsPage();
        assertEquals(expected, actual);
	}

	@When("I select {string} as my dietary preference")
	public void i_select_as_my_dietary_preference(String dietaryPreference) {
		String expected = "Dietary preferences updated successfully";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), dietaryPreference, "none");
        assertEquals(expected, acutal);
	}

	@When("I add {string} as a restriction")
	public void i_add_as_a_restriction(String restriction) {
		String expected = "Dietary preferences updated successfully";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high proten", restriction);
        assertEquals(expected, acutal);
		
	}

	@When("I save the changes")
	public void i_save_the_changes() {
		String expected = "Dietary preferences updated successfully";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high proten", "vegan");
        assertEquals(expected, acutal);
	}

	@Then("my dietary preferences should be updated")
	public void my_dietary_preferences_should_be_updated() {
		String expected = "Dietary preferences updated successfully";
		String acutal = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high proten", "vegan");
        assertEquals(expected, acutal);
	}

	@Given("I am on the account creation page")
	public void i_am_on_the_account_creation_page() {
		boolean expected = true;
        boolean actual = AccountManagementPage.isOnCreateProfilePage();
        assertEquals(expected, actual);
	}

	@When("I enter my personal details including age {string} and fitness goals {string}")
	public void i_enter_my_personal_details_including_age_and_fitness_goals(String string, String string2) {
		String expcted = "Profile created successfully";
		String acutal = AccountManagementControls.createProfile("John29Doe", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
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
		String expcted = "Profile created successfully";
		String acutal = AccountManagementControls.createProfile("John29Doe", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@Then("my profile should be created")
	public void my_profile_should_be_created() {
		String expcted = "Profile created successfully";
		String acutal = AccountManagementControls.createProfile("John29Doe", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@Then("I should see a confirmation message {string}")
	public void i_should_see_a_confirmation_message(String string) {
		String expcted = "Profile created successfully";
		String acutal = AccountManagementControls.createProfile("John29Doe", App.getClientsMap().get("John29Doe"), "23", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@Given("I am on the profile settings page")
	public void i_am_on_the_profile_settings_page() {
		boolean expected = true;
        boolean actual = AccountManagementPage.isOnUpdatePersonalDetailsPage();
        assertEquals(expected, actual);
	}

	@When("I update my age to {string}")
	public void i_update_my_age_to(String string) {
		String expcted = "Profile updated successfully";
		String acutal = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@When("I change my fitness goals to {string}")
	public void i_change_my_fitness_goals_to(String string) {
		String expcted = "Profile updated successfully";
		String acutal = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", "gain muscle");
        assertEquals(expcted, acutal);
	}

	@Then("my profile should be updated")
	public void my_profile_should_be_updated() {
		String expcted = "Profile updated successfully";
		String acutal = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", "gain muscle");
        assertEquals(expcted, acutal);
	}
}   