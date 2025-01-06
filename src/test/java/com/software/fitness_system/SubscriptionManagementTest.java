package com.software.fitness_system;
import static com.software.fitness_system.AdminControllers.SubscriptionManagementControls.*;
import static com.software.fitness_system.AdminControllers.SubscriptionPlan.addToSubscriptionPlanMap;
import static com.software.fitness_system.App.*;
import static com.software.fitness_system.LoadAndSaveEntities.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.software.fitness_system.AdminControllers.SubscriptionPlan;
import com.software.fitness_system.AdminControllers.SubscriptionPlan.PlanType;
import com.software.fitness_system.LoginPage.AdminPagesController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
	
    @Given("I add a new subscription plan \\(e.g., Basic or Premium)")
    public void i_add_a_new_subscription_plan_e_g_basic_or_premium() {
    	boolean expected = true;
        boolean actual = doAdding("Test", 120.0, 120, "new");
        addToSubscriptionPlanMap(PlanType.FREE);
        assertEquals(expected, actual);
    }
    
    @Then("the new plan should be available for clients and instructors.")
    public void the_new_plan_should_be_available_for_clients_and_instructors() {
    	boolean expected = true;
        boolean actual = saveCustomSubscriptionPlanToFile(getSubscriptionPlanMap(), SUBSCRIPTION_PLAN_FILENAME);
        assertEquals(expected, actual);
    }
    
    @Given("I update an existing subscription plan with {string} as {string}")
    public void i_update_an_existing_subscription_plan_with_as(String type, String value) {
        boolean expected = true;
        boolean actual;
        
        switch (type.toLowerCase()) {
            case "price":
                actual = doAmendment(Double.parseDouble(value), getSubscriptionPlanMap().get("New Plan"), type);
                break;
            case "duration":
                actual = doAmendment(Integer.parseInt(value), getSubscriptionPlanMap().get("New Plan"), type);
                break;
            case "description":
                actual = doAmendment(value, getSubscriptionPlanMap().get("New Plan"), type);
                break;
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
        
        amendedPlanPrinting(getSubscriptionPlanMap().get("New Plan"));
        assertEquals(expected, actual);
    }
    
    @When("the plan is updated")
    public void the_plan_is_updated() {
        assertTrue(getSubscriptionPlanMap().containsKey("New Plan"));
    }
    
    @Then("the updated plan should be available for clients and instructors with {string} set to {string}")
    public void the_updated_plan_should_be_available_for_clients_and_instructors_with_set_to(String string, String string2) {
    	boolean expected = true;
        boolean actual = saveCustomSubscriptionPlanToFile(getSubscriptionPlanMap(), SUBSCRIPTION_PLAN_FILENAME);
        assertEquals(expected, actual);
    }
    
    @Given("I delete a subscription plan")
    public void i_delete_a_subscription_plan() {
    	boolean expected = true;
        boolean actual = doRemoving("New Plan");
        assertEquals(expected, actual);
    }
    
    @Then("the plan should no longer be available for clients and instructors.")
    public void the_plan_should_no_longer_be_available_for_clients_and_instructors() {
    	boolean expected = true;
        boolean actual = (!getSubscriptionPlanMap().containsKey("New Plan"));
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