package com.Software.FitnessSystem;

import static org.junit.Assert.assertEquals;
import com.Software.FitnessSystem.ClientControllers.AccountManagementControls;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountManagementTest {
    App app;

    public AccountManagementTest(App ap) {
        this.app = ap;
    }

    @When("I select {string} as my dietary preference")
    public void i_select_as_my_dietary_preference(String dietaryPreference) {
        String expected = "Dietary Preferences Updated";
        String actual = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), dietaryPreference, "none");
        assertEquals(expected, actual);
    }

    @When("I add {string} as a restriction")
    public void i_add_as_a_restriction(String restriction) {
        String expected = "Dietary Preferences Updated";
        String actual = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high protein", restriction);
        assertEquals(expected, actual);
    }

    @When("I save the changes")
    public void i_save_the_changes() {
        String expected = "Dietary Preferences Updated";
        String actual = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high protein", "vegan");
        assertEquals(expected, actual);
    }

    @Then("my dietary preferences should be updated")
    public void my_dietary_preferences_should_be_updated() {
        String expected = "Dietary Preferences Updated";
        String actual = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high protein", "vegan");
        assertEquals(expected, actual);
    }

    @When("I enter my personal details including age {string} and fitness goals {string}")
    public void i_enter_my_personal_details_including_age_and_fitness_goals(String age, String fitnessGoals) {
        String expected = "Profile Created Successfully";
        String actual = AccountManagementControls.createProfile("John29Doe", App.getClientsMap().get("John29Doe"), age, fitnessGoals);
        assertEquals(expected, actual);
    }

    @When("I specify my dietary preferences or restrictions as {string}")
    public void i_specify_my_dietary_preferences_or_restrictions_as(String dietaryPreferences) {
        String expected = "Dietary Preferences Updated";
        String actual = AccountManagementControls.setDietaryPreferences(App.getClientsMap().get("John29Doe"), "high protein", dietaryPreferences);
        assertEquals(expected, actual);
    }
    
    @When("I submit the form")
    public void i_submit_the_form() {
        String expected = "Profile Created Successfully";
        String actual = AccountManagementControls.createProfile("active", App.getClientsMap().get("active"), "23", "gain muscle");
        assertEquals(expected, actual);
    }
    
    @Then("my profile should be created")
    public void my_profile_should_be_created() {
        String expected = "Profile Created Successfully";
        String actual = AccountManagementControls.createProfile("active", App.getClientsMap().get("active"), "23", "gain muscle");
        assertEquals(expected, actual);
    }
    
    @Then("I should see a confirmation message {string}")
    public void i_should_see_a_confirmation_message(String message) {
        String expected = "Profile Created Successfully";
        String actual = AccountManagementControls.createProfile("active", App.getClientsMap().get("active"), "23", "gain muscle");
        assertEquals(expected, actual);
    }
    
    @When("I update my age to {string}")
    public void i_update_my_age_to(String newAge) {
        String expected = "Updated Personal Details successfully";
        String actual = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), newAge, "gain muscle");
        assertEquals(expected, actual);
    }

    @When("I change my fitness goals to {string}")
    public void i_change_my_fitness_goals_to(String newFitnessGoals) {
        String expected = "Updated Personal Details successfully";
        String actual = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", newFitnessGoals);
        assertEquals(expected, actual);
    }

    @Then("my profile should be updated")
    public void my_profile_should_be_updated() {
        String expected = "Updated Personal Details successfully";
        String actual = AccountManagementControls.updatePersonalDetails(App.getClientsMap().get("John29Doe"), "24", "gain muscle");
        assertEquals(expected, actual);
    }
}