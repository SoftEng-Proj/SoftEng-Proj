package com.Software.FitnessSystem;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.LoadAndSaveEntities.*;
import static com.Software.FitnessSystem.AdminControllers.SubscriptionManagementControls.*;
import com.Software.FitnessSystem.AdminControllers.SubscriptionPlan;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SubscriptionManagementTest {
    AdminPagesController adminControllers;
    App app;

    public SubscriptionManagementTest(App obj, AdminPagesController admin) {
        this.app = obj;
        this.adminControllers = admin;
    }
	
	@Given("I edit a subscription plan")
	public void i_edit_a_subscription_plan() {
		boolean expected = true;
		Client user = getClientsMap().get("John29Doe");
        boolean actual = updateUserSubscriptionPlan(
        		new SubscriptionPlan(getSubscriptionPlanMap().get("BASIC")), user, "no", true, false);
        assertEquals(expected, actual);
	}
	
	@Then("the changes should be saved successfully")
	public void the_changes_should_be_saved_successfully() {
		boolean expected = true;
        boolean actual = saveCustomSubscriptionPlanToFile(getSubscriptionPlanMap(), SUBSCRIPTION_PLAN_FILENAME);
        assertEquals(expected, actual);
	}
	
	@Given("I add or update a plan \\(e.g., Basic or Premium)")
	public void i_add_or_update_a_plan_e_g_basic_or_premium() {
		boolean expected = true;
        boolean actual = dealWithSubscriptionPlan();
        assertEquals(expected, actual);
	}
	
	@Then("the plan should be available for clients and instructors.")
	public void the_plan_should_be_available_for_clients_and_instructors() {
		boolean expected = true;
        boolean actual = saveCustomSubscriptionPlanToFile(getSubscriptionPlanMap(), SUBSCRIPTION_PLAN_FILENAME);
        assertEquals(expected, actual);
	}
	
	@Given("I view subscription details")
	public void i_view_subscription_details() {
		boolean expected = true;
        boolean actual = printSubscriptionPlan();
        assertEquals(expected, actual);
	}
	
	@Then("I should see the details for clients and instructors")
	public void i_should_see_the_details_for_clients_and_instructors() {
		boolean expected = true;
        boolean actual = returnIsPrinted();
        assertEquals(expected, actual);
	}
}