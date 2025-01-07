package com.software.fitness_system;
import static org.junit.Assert.assertTrue;

import com.software.fitness_system.client_controllers.ProgramExplorationEnrollmentControls;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramExplorationEnrollmentTest {
	App app;
	
	public ProgramExplorationEnrollmentTest(App app) {
		this.app = app;
	}
	
	@Given("I filter programs by difficulty level {string}")
	public void i_filter_programs_by_difficulty_level(String difficultyLevel) {
		String expcted = "Programs filtered By Difficulty";
		String acutal = ProgramExplorationEnrollmentControls.filterProgramsByDifficulty("Intermediate");
		assertTrue(acutal.equals(expcted));
	}
	
	@When("I filter programs by focus area {string}")
	public void i_filter_programs_by_focus_area(String focusArea) {
		String expcted = "Programs filtered By focus area";
		String acutal = ProgramExplorationEnrollmentControls.filterProgramsByFocusArea("High-intensity functional movements");
		assertTrue(acutal.equals(expcted));
	}
	
	@Then("I should see a list of programs that match my filters")
	public void i_should_see_a_list_of_programs_that_match_my_filters() {
		String expcted = "Programs filtered By Difficulty";
		String acutal = ProgramExplorationEnrollmentControls.filterProgramsByDifficulty("Advanced");
		assertTrue(acutal.equals(expcted));
	}
	
	@Given("I have selected a program named {string}")
	public void i_have_selected_a_program_named(String programName) {
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram(App.getClientsMap().get("active"), 13);
		assertTrue(acutal.equals(expcted));
	}
	
	@When("I click on the Enroll button")
	public void i_click_on_the_button() {
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram(App.getClientsMap().get("active"), 13);
		assertTrue(acutal.equals(expcted));
	}
	
	@Then("I should be enrolled in the program")
	public void i_should_be_enrolled_in_the_program() {
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram(App.getClientsMap().get("active"), 13);
		assertTrue(acutal.equals(expcted));
	}
	
	@Then("I should see the program's schedule displayed")
	public void i_should_see_the_program_s_schedule_displayed() {
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}
	
	@Given("I am enrolled in the program {string}")
	public void i_am_enrolled_in_the_program(String string) {
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram(App.getClientsMap().get("active"), 13);
		assertTrue(acutal.equals(expcted));
	}
	
	@When("I select the program {string}")
	public void i_select_the_program(String string) {
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}
	
	@Then("I should see the schedule for the program")
	public void i_should_see_the_schedule_for_the_program() {
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}
	
	@Then("the schedule should include session dates and times")
	public void the_schedule_should_include_session_dates_and_times() {
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}
}