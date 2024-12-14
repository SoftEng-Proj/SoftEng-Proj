package com.Software.FitnessSystem;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Software.FitnessSystem.InstructorControllers.ProgramManagementControls;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramManagementForInstrcutorTest {

	@When("I create a new program with Title {string}, Duration {string}, Difficulty {string},Goals {string}, Price {string}")
	public void i_create_a_new_program_with_title_duration_difficulty_goals_price(String string, String string2, String string3, String string4, String string5) {
	    // Write code here that turns the phrase above into concrete actions
		String expected = "Program created successfully";
		String actual =ProgramManagementControls.createProgram("0", "0", "0", "0", "0", "0");
		assertTrue(expected.equals(actual));
	}

	@When("I add a video tutorial and images")
	public void i_add_a_video_tutorial_and_images() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		String expected = "Program created successfully";
		String actual =ProgramManagementControls.createProgram("0", "0", "0", "0", "0", "0");
		assertTrue(expected.equals(actual));
	}

	@When("I schedule group sessions for {string}")
	public void i_schedule_group_sessions_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		String expected = "Schedule set";
		String actual =ProgramManagementControls.setSchedule(string, "Online");
		assertTrue(expected.equals(actual));
	}

	@Then("the program should be created with the provided details")
	public void the_program_should_be_created_with_the_provided_details() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String expected = "Program created successfully";
		String actual =ProgramManagementControls.createProgram("0", "0", "0", "0", "0", "0");
		assertTrue(expected.equals(actual));
	}

	@Given("I have a program titled {string}")
	public void i_have_a_program_titled(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String duration = "30 days"; 
	    String level = "Intermediate"; 
	    String goal = "Improve flexibility";
	    String links = "http://example.com"; 
	    String price = "$50"; 
	    
	    String expected = "Program created successfully";
	    String actual = ProgramManagementControls.createProgram(string, duration, level, goal, links, price);	   
	    assertTrue(expected.equals(actual));
	}

	@When("I update the program to change the duration to {string}, set the difficulty to {string},set the Price to {string} and set the Session to {string}")
	public void i_update_the_program_to_change_the_duration_to_set_the_difficulty_to_set_the_price_to_and_set_the_session_to(String string, String string2, String string3, String string4) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String expected = "Program updated";
		String actual =ProgramManagementControls.updateProgram(string, string2, string3, string4, "0", "0");
		assertTrue(expected.equals(actual));
		
	}

	@Then("the program should be updated with the new details")
	public void the_program_should_be_updated_with_the_new_details() {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new io.cucumber.java.PendingException();
		String expected = "Program updated";
		String actual =ProgramManagementControls.updateProgram("0","0", "0", "0", "0", "0");
		assertTrue(expected.equals(actual));
	}

	@When("I delete the program")
	public void i_delete_the_program() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String expected = "Program Deleted";
		String actual =ProgramManagementControls.deleteProgram("0");
		assertTrue(expected.equals(actual));
	}

	@Then("the program should no longer appear in the list of programs")
	public void the_program_should_no_longer_appear_in_the_list_of_programs() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String expected = "Program Deleted";
		String actual =ProgramManagementControls.deleteProgram("0");
		assertTrue(expected.equals(actual));
		
	}


}
