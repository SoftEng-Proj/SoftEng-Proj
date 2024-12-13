package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.SubscriptionManagementControls;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

class SubscriptionManagementTest {
	SubscriptionManagementControls subscriptionManagement;
    AdminPagesController adminControllers;
    App app;
    
    public SubscriptionManagementTest() {
        this.app = new App();
        this.adminControllers = new AdminPagesController();
        this.subscriptionManagement = new SubscriptionManagementControls();
    }
    
	@Given("I am on the {string} page")
	public void i_am_on_the_page(String string) {
		boolean expected = true;
        boolean actual = adminControllers.navigateToPage(4);
        assertTrue(expected == actual);
	}
	
	@When("I edit a subscription plan")
	public void i_edit_a_subscription_plan() {
		
	}
	
	@Then("the changes should be saved successfully")
	public void the_changes_should_be_saved_successfully() {
		
	}
	
	@When("I add or update a plan \\(e.g., Basic or Premium)")
	public void i_add_or_update_a_plan_e_g_basic_or_premium() {
		
	}
	
	@Then("the plan should be available for clients and instructors.")
	public void the_plan_should_be_available_for_clients_and_instructors() {
		
	}
	
	@When("I view subscription details")
	public void i_view_subscription_details() {
		System.out.println("Reviewing wellness article");
	}
	
	@Then("I should see the details for clients and instructors")
	public void i_should_see_the_details_for_clients_and_instructors() {
		System.out.println("Reviewing wellness article");
	}
}