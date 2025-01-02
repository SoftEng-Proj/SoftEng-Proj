package com.Software.FitnessSystem;
import com.Software.FitnessSystem.ClientControllers.ProgramExplorationEnrollmentControls;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramExplorationEnrollmentTest {
	App app;
	public ProgramExplorationEnrollmentTest(App ap){
		this.app = ap;
	}
	
	@Given("I am on the program exploration page")
	public void i_am_on_the_program_exploration_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException(); i_am_on_the_program_exploration_page
		boolean expected = true;
        boolean actual = ClientPageControllers.isOnProgramExplorationPage();
        assertTrue(expected == actual);
		
	}

	@When("I filter programs by difficulty level {string}")
	public void i_filter_programs_by_difficulty_level(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Programs filtered By Difficulty";
		String acutal = ProgramExplorationEnrollmentControls.filterProgramsByDifficulty("string");
		assertTrue(acutal.equals(expcted));
	}

	@When("I filter programs by focus area {string}")
	public void i_filter_programs_by_focus_area(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Programs filtered By focus area";
		String acutal = ProgramExplorationEnrollmentControls.filterProgramsByFocusArea("string");
		assertTrue(acutal.equals(expcted));
	}

	@Then("I should see a list of programs that match my filters")
	public void i_should_see_a_list_of_programs_that_match_my_filters() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "Programs filtered By Difficulty";
		String acutal = ProgramExplorationEnrollmentControls.filterProgramsByDifficulty("Advanced");
		assertTrue(acutal.equals(expcted));
	}

	@Given("I have selected a program named {string}")
	public void i_have_selected_a_program_named(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram();
		assertTrue(acutal.equals(expcted));
	}

	@When("I click on the {string} button")
	public void i_click_on_the_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram();
		assertTrue(acutal.equals(expcted));
	}

	@Then("I should be enrolled in the program")
	public void i_should_be_enrolled_in_the_program() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram();
		assertTrue(acutal.equals(expcted));
	}

	@Then("I should see the program's schedule displayed")
	public void i_should_see_the_program_s_schedule_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}

	@Given("I am enrolled in the program {string}")
	public void i_am_enrolled_in_the_program(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "enrolled in program succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.enrollInProgram();
		assertTrue(acutal.equals(expcted));
	}

	@When("I select the program {string}")
	public void i_select_the_program(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}

	@Then("I should see the schedule for the program")
	public void i_should_see_the_schedule_for_the_program() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}

	@Then("the schedule should include session dates and times")
	public void the_schedule_should_include_session_dates_and_times() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expcted = "program schedule displayed succsesfully";
		String acutal = ProgramExplorationEnrollmentControls.viewProgramSchedule("CrossFit Challenge");
		assertTrue(acutal.equals(expcted));
	}
}
