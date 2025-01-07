package com.software.fitness_system;
import static org.junit.Assert.*;

import com.software.fitness_system.instructor_controllers.NotificationControls;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotificationsForInstructorTest {
	App app;
	
	public NotificationsForInstructorTest(App obj){
		this.app = obj;
	}
	
	@Given("there is a program titled {string}")
	public void there_is_a_program_titled(String string) {
		boolean expected=true;
	    boolean actual =NotificationControls.ProgramExists();
		assertTrue(expected==actual);
	}
	
	@When("I update the schedule of {string} to {string}")
	public void i_update_the_schedule_of_to(String string, String string2) {
		String expected="Schedule changed";
		String actual =NotificationControls.addProgramScheduleChange("Fit", "Change");
		assertTrue(expected.equals(actual));
	}
	
	@Then("clients should receive a notification about the updated schedule")
	public void clients_should_receive_a_notification_about_the_updated_schedule() {
	    boolean expected=true;
		boolean actual =NotificationControls.ChangeSent();
		assertTrue(expected==actual);
	}
	
	@When("I announce {string} with details {string}")
	public void i_announce_with_details(String string, String string2) {
		String expected="Announcement made.";
	    String actual =NotificationControls.AddanAnnouncement("Hi");
		assertTrue(expected.equals(actual));
	}
	
	@Then("all clients should receive the announcement")
	public void all_clients_should_receive_the_announcement() {
		boolean expected=true;
		boolean actual =NotificationControls.AnnouncementSent();
		assertTrue(expected==actual);
	}
}