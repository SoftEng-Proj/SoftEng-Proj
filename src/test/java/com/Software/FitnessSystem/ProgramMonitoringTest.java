package com.Software.FitnessSystem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class ProgramMonitoringTest {
	@Given("I am on the {string} page")
	public void i_am_on_the_page(String string) {
		System.out.println("Reviewing wellness article");
	}

	@When("I view the enrollment statistics")
	public void i_view_the_enrollment_statistics() {
		System.out.println("Reviewing wellness article");
	}

	@Then("I should see the most popular programs")
	public void i_should_see_the_most_popular_programs() {
		System.out.println("Reviewing wellness article");
	}

	@When("I generate a report")
	public void i_generate_a_report() {
		System.out.println("Reviewing wellness article");
	}

	@Then("I should see reports on revenue, attendance, and client progress")
	public void i_should_see_reports_on_revenue_attendance_and_client_progress() {
		System.out.println("Reviewing wellness article");
	}

	@When("I view the program status")
	public void i_view_the_program_status() {
		System.out.println("Reviewing wellness article");
	}

	@Then("I should see a list of active and completed programs")
	public void i_should_see_a_list_of_active_and_completed_programs() {
		System.out.println("Reviewing wellness article");
	}
}