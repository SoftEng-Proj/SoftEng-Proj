package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.ProgramEnrollment;
import com.Software.FitnessSystem.ClientControllers.ProgressTrackingControls;
import com.Software.FitnessSystem.ClientPageNavigation.ProgressTrackingPage;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressTrackingTest {
	ProgressTrackingControls progressTrackingControls;
	ProgramEnrollment programEnrollment;
	App app;
	Client client;
	
	public ProgressTrackingTest(App ap,ProgressTrackingControls ptc, ProgramEnrollment pe) {
		this.app = ap;
        this.progressTrackingControls = ptc;
        this.programEnrollment = pe;
        this.client = client;
	}
	@Given("I am logged into my account")
	public void i_am_logged_into_my_account() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "ClientLoggedIn";
    	String actual = App.login("John29Doe", "Client");
        assertTrue(expected.equals(actual));
	}

	@Given("I am on the progress tracking page")
	public void i_am_on_the_progress_tracking_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		boolean expected = true;
		boolean actual = ProgressTrackingPage.isAddMilestonePage();
		assertTrue(actual == expected);
	}

	@When("I update my milestone with {string} as {string}")
	public void i_update_my_milestone_with_as(String type, String value) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
        String date = "2025-01-01";
		String expected = "milestone added successfully";
		String actual = ProgressTrackingControls.addMilestone(type, value, date, client);
		assertTrue(expected.equals(actual));
	}

	@Then("my milestone should be recorded")
	public void my_milestone_should_be_recorded() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String type = "Weight Loss";
        String value = "5kg";
        String date = "2025-01-01";
		String expected = "milestone added successfully";
		String actual = ProgressTrackingControls.addMilestone(type, value, date, client);
		assertTrue(expected.equals(actual));
	}

	@Then("I should see a confirmation message saying {string}")
	public void i_should_see_a_confirmation_message_saying(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String type = "Weight Loss";
        String value = "5kg";
        String date = "2025-01-01";
		String expected = "milestone added successfully";
		String actual = ProgressTrackingControls.addMilestone(type, value, date, client);
		assertTrue(expected.equals(actual));
	}

	@Given("I have completed the program {string}")
	public void i_have_completed_the_program(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Completed";
		String actual = programEnrollment.getStatus();
		assertTrue(expected.equals(actual));
	}

	@When("I go to the {string} section")
	public void i_go_to_the_section(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException(); showProgress
		boolean expected = true;
		boolean actual = ProgressTrackingPage.isShowProgressPage();
		assertTrue(actual == expected);
	}

	@Then("I should see the badge {string}")
	public void i_should_see_the_badge(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "You've made so much progress wow!";
		String actual = ProgressTrackingControls.showProgress();
		assertTrue(expected.equals(actual));
	}

	@Then("I should see a message saying {string}")
	public void i_should_see_a_message_saying(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "You've made so much progress wow!";
		String actual = ProgressTrackingControls.showProgress();
		assertTrue(expected.equals(actual));
	}
}