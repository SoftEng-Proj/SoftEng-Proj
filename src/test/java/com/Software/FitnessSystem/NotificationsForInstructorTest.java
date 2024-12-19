package com.Software.FitnessSystem;
import com.Software.FitnessSystem.InstructorControllers.NotificationControls;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationsForInstructorTest {

	@Given("there is a program titled {string}")
	public void there_is_a_program_titled(String string) {
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new io.cucumber.java.PendingException();
		boolean expected=true;
		boolean actual =NotificationControls.ProgramFound();
		assertTrue(expected==actual);
	}

	@Given("{string} is enrolled in the {string} program")
	public void is_enrolled_in_the_program(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		boolean expected=true;
		boolean actual =NotificationControls.ProgramFound();
		assertTrue(expected==actual);
		
	}

	@When("I update the schedule of {string} to {string}")
	public void i_update_the_schedule_of_to(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected="Schedule changed";
		
		String actual =NotificationControls.addProgramScheduleChange("Fit", null);
		assertTrue(expected.equals(actual));
		
		
	}

	@Then("{string} should receive a notification about the updated schedule")
	public void should_receive_a_notification_about_the_updated_schedule(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		boolean expected=true;
		boolean actual =NotificationControls.ChangeSent();
		assertTrue(expected==actual);
		
		
		
	}

	@When("I announce {string} with details {string}")
	public void i_announce_with_details(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		String expected="Announcement made";
		String actual =NotificationControls.AddanAnnouncement("Hi");
		assertTrue(expected.equals(actual));
		
	}

	@Then("all clients should receive the announcement")
	public void all_clients_should_receive_the_announcement() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		boolean expected=true;
		boolean actual =NotificationControls.ChangeSent();
		assertTrue(expected==actual);
	}


}
