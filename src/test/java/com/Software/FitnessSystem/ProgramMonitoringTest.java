package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.ProgramMonitoringControls;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class ProgramMonitoringTest {
	ProgramMonitoringControls programMonitoring;
    AdminPagesController adminControllers;
    App app;
    
    public ProgramMonitoringTest() {
        this.app = new App();
        this.adminControllers = new AdminPagesController();
        this.programMonitoring = new ProgramMonitoringControls();
    }
    
	@Given("I am on the {string} page")
	public void i_am_on_the_page(String string) {
		boolean expected = true;
        boolean actual = adminControllers.navigateToPage(2);
        assertTrue(expected == actual);
	}
	
	@When("I select the option to view all programs")
	public void i_select_the_option_to_view_all_programs() {
        boolean expected = true;
        boolean actual = ProgramMonitoringControls.viewAllPrograms();
        assertTrue(expected == actual);
    }
	
	@Then("I should see a list of all programs")
	public void i_should_see_a_list_of_all_programs() {
    	boolean expected = true;
        boolean actual = ProgramMonitoringControls.areAllProgramsVisible();
        assertTrue(expected == actual);
    }
	
	@When("I view the enrollment statistics")
	public void i_view_the_enrollment_statistics() {
		boolean expected = true;
        boolean actual = ProgramMonitoringControls.viewTheEnrollmentStatistics();
        assertTrue(expected == actual);
	}
	
	@Then("I should see the most popular programs")
	public void i_should_see_the_most_popular_programs() {
		boolean expected = true;
        boolean actual = ProgramMonitoringControls.verifyIsDisplayed();
        assertTrue(expected == actual);
	}
	
	@When("I generate a reports")
	public void i_generate_a_reports() {
		boolean expected = true;
        boolean actual = ProgramMonitoringControls.generateReportsOption(App.getProgramEnrollmentMap(), "", false);
        assertTrue(expected == actual);
	}
	
	@Then("I should see reports on revenue, attendance, and client progress")
	public void i_should_see_reports_on_revenue_attendance_and_client_progress() {
		boolean expected = true;
        boolean actual = ProgramMonitoringControls.getIsReportsPrinted();
        assertTrue(expected == actual);
	}
	
	@When("I generate a report for a specific program")
	public void i_generate_a_report_for_a_specific_program() {
		boolean expected = true;
		ProgramMonitoringControls.accessToPrintPrograms(App.getProgramEnrollmentMap(), false);
		String programName = ProgramMonitoringControls.askTheNameOfTheProgram();
        boolean actual = ProgramMonitoringControls.generateReportsOption(App.getProgramEnrollmentMap(), programName, true);
        assertTrue(expected == actual);
	}
	
	@Then("I should see report on revenue, attendance, and client progress")
	public void i_should_see_report_on_revenue_attendance_and_client_progress() {
		boolean expected = true;
        boolean actual = ProgramMonitoringControls.getIsReportsPrinted();
        assertTrue(expected == actual);
	}
	
	@When("I view the program status")
	public void i_view_the_program_status() {
		boolean expected = true;
        boolean actual = ProgramMonitoringControls.trackActiveAndCompletedPrograms(App.getProgramEnrollmentMap());
        assertTrue(expected == actual);
	}
	
	@Then("I should see a list of active and completed programs")
	public void i_should_see_a_list_of_active_and_completed_programs() {
		boolean expected = true;
        boolean actual = ProgramMonitoringControls.getIsProgramStatusPrinted();
        assertTrue(expected == actual);
	}
}