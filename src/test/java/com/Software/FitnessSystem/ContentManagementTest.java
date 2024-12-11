package com.Software.FitnessSystem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class ContentManagementTest {
	@Given("I am on the {string} page")
	public void i_am_on_the_page(String string) {
		System.out.println("Reviewing wellness article");
	}

	@When("I review a wellness article, tip, or recipe")
	public void i_review_a_wellness_article_tip_or_recipe() {
		System.out.println("Reviewing wellness article");
	}

	@Then("I can approve or reject the submission")
	public void i_can_approve_or_reject_the_submission() {
		System.out.println("Reviewing wellness article");
	}

	@When("I review user feedback and complaints")
	public void i_review_user_feedback_and_complaints() {
		System.out.println("Reviewing wellness article");
	}
	
	@Then("I should be able to handle them appropriately")
	public void i_should_be_able_to_handle_them_appropriately() {
		System.out.println("Reviewing wellness article");
	}
}