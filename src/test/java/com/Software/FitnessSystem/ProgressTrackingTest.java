package com.Software.FitnessSystem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

import com.Software.FitnessSystem.ClientControllers.ProgressTrackingControls;
public class ProgressTrackingTest {
	ProgressTrackingControls pg = new ProgressTrackingControls();
	@Given("I am logged into my account")
	public void i_am_logged_into_my_account() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("I am on the progress tracking page")
	public void i_am_on_the_progress_tracking_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I update my milestone with {string} as {string}")
	public void i_update_my_milestone_with_as(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("my milestone should be recorded")
	public void my_milestone_should_be_recorded() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "milestone added successfully";
		String actual = ProgressTrackingControls.addMilestone("0",  "0",  "0");
		assertTrue(expected.equals(actual));
	}

	@Then("I should see a confirmation message saying {string}")
	public void i_should_see_a_confirmation_message_saying(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("I have completed the program {string}")
	public void i_have_completed_the_program(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I go to the {string} section")
	public void i_go_to_the_section(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see the badge {string}")
	public void i_should_see_the_badge(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see a message saying {string}")
	public void i_should_see_a_message_saying(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}