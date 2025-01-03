package com.Software.FitnessSystem;
import com.Software.FitnessSystem.InstructorControllers.InteractForInstructorControls;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientInteractionForInstructorTest {
	App app;
	
    public ClientInteractionForInstructorTest(App obj) {
		this.app = obj;
    }
    
	@Given("I am logged in as an instructor")
	public void i_am_logged_in_as_an_instructor() {
		String expected = "InstructorLoggedIn";
    	String actual = App.login("AmmarAr", "Instructor");
        assertTrue(expected.equals(actual));
	}
	
	@Given("I have an enrolled client named {string}")
	public void i_have_an_enrolled_client_named(String string) {
		boolean expected=true;
		boolean actual=InteractForInstructorControls.MakeSureOfClient();
		assertTrue(expected==actual);
	}
	
	@When("I send a message to {string} which says {string}")
	public void i_send_a_message_to_which_says(String string, String string2) {
		String expected= "Message sent";
		String actual = InteractForInstructorControls.sendMessageToClient("Omar", "Hi");
		assertTrue(expected.equals(actual));
	}
	
	@Then("the client should receive the message")
	public void the_client_should_receive_the_message() {
		boolean expected=true;
		boolean actual=InteractForInstructorControls.MSGisVisible();
		assertTrue(expected==actual);
	}
	
	@Given("I am on the dicussion forum for the program {string}")
	public void i_am_on_the_dicussion_forum_for_the_program(String string) {
		boolean expected = true;
		InteractForInstructorControls.sendMessageToProgramForum("Fit", "Hello");
		boolean actual = InteractForInstructorControls.ForumPage();
		assertTrue(actual == expected);
	}
	
	@When("I post a message on the forum which says {string}")
	public void i_post_a_message_on_the_forum_which_says(String string) {
		String expected= "Forum sent";
	    InteractForInstructorControls.MakeSureOfProgram();
		String actual = InteractForInstructorControls.sendMessageToProgramForum("Fit", "Hey");
		assertTrue(expected.equals(actual));
	}
	
	@Then("the message should be visible to all enrolled clients")
	public void the_message_should_be_visible_to_all_enrolled_clients() {
		boolean expected=true;
		boolean actual=InteractForInstructorControls.MSGisVisible();
		assertTrue(expected==actual);
	}
	
	@Given("I have a client named {string}")
	public void i_have_a_client_named(String string) {
		boolean expected=true;
		boolean actual=InteractForInstructorControls.MakeSureOfClient();
		assertTrue(expected==actual);
	}
	
	@When("I provide feedback to {string} with the content {string}")
	public void i_provide_feedback_to_with_the_content(String string, String string2) {
		String expected= "Feedback sent";
		String actual = InteractForInstructorControls.sendFeedbackToClient("Omar", "Good");
		assertTrue(expected.equals(actual));
	}
	
	@Then("the client should receive the feedback")
	public void the_client_should_receive_the_feedback() {
		boolean expected=true;
		boolean actual = InteractForInstructorControls.Feedbackprovide();
		assertTrue(expected==actual);
	}
	
	@When("I provide a progress report to {string} with the content '{string}'")
	public void i_provide_a_progress_report_to_with_the_content(String string, String string2) {
		String expected= "Progress sent";
	    String actual = InteractForInstructorControls.sendProgressToClient("Omar", "Good Progress");
		assertTrue(expected.equals(actual));
	}
	
	@Then("the client should receive the progress report")
	public void the_client_should_receive_the_progress_report() {
		boolean expected=true;
		boolean actual=InteractForInstructorControls.ProgressReview();
		assertTrue(expected==actual);
		
	}
}