package com.Software.FitnessSystem;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.ProgramMonitoringControls.*;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramMonitoringTest {
    AdminPagesController adminControllers;
    App app;
    
    public ProgramMonitoringTest(App obj, AdminPagesController admin) {
		this.app = obj;
        this.adminControllers = admin;
    }
    
	@Given("I am on the {string} page")
	public void i_am_on_the_page(String string) {
		boolean expected = true;
        boolean actual = adminControllers.navigateToPage(2, adminControllers);
        assertEquals(expected, actual);
	}
	
	@When("I select the option to view all programs")
	public void i_select_the_option_to_view_all_programs() {
        boolean expected = true;
        boolean actual = viewAllPrograms();
        assertEquals(expected, actual);
    }
	
	@Then("I should see a list of all programs")
	public void i_should_see_a_list_of_all_programs() {
    	boolean expected = true;
        boolean actual = areAllProgramsVisible();
        assertEquals(expected, actual);
    }
	
	@When("I view the enrollment statistics")
	public void i_view_the_enrollment_statistics() {
		boolean expected = true;
        boolean actual = viewTheEnrollmentStatistics();
        assertEquals(expected, actual);
	}
	
	@Then("I should see the most popular programs")
	public void i_should_see_the_most_popular_programs() {
		boolean expected = true;
        boolean actual = verifyIsDisplayed();
        assertEquals(expected, actual);
	}
	
	@When("I generate a reports")
	public void i_generate_a_reports() {
		boolean expected = true;
        boolean actual = generateReportsOption(getProgramEnrollmentMap(), "", false);
        assertEquals(expected, actual);
	}
	
	@Then("I should see reports on revenue, attendance, and client progress")
	public void i_should_see_reports_on_revenue_attendance_and_client_progress() {
		boolean expected = true;
        boolean actual = getIsReportsPrinted();
        assertEquals(expected, actual);
	}
	
	@When("I generate a report for a specific program")
	public void i_generate_a_report_for_a_specific_program() {
		boolean expected = true;
		accessToPrintPrograms(getProgramEnrollmentMap(), false);
		String programName = askTheNameOfTheProgram();
        boolean actual = generateReportsOption(getProgramEnrollmentMap(), programName, true);
        assertEquals(expected, actual);
	}
	
	@Then("I should see report on revenue, attendance, and client progress")
	public void i_should_see_report_on_revenue_attendance_and_client_progress() {
		boolean expected = true;
        boolean actual = getIsReportsPrinted();
        assertEquals(expected, actual);
	}

	@When("I view the program status")
	public void i_view_the_program_status() {
		boolean expected = true;
        boolean actual = trackActiveAndCompletedPrograms(getProgramEnrollmentMap());
        assertEquals(expected, actual);
	}
	
	@Then("I should see a list of active and completed programs")
	public void i_should_see_a_list_of_active_and_completed_programs() {
		boolean expected = true;
        boolean actual = getIsProgramStatusPrinted();
        assertEquals(expected, actual);
	}
}