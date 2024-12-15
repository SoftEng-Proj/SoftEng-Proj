package acceptance;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.LoadAndSaveEntities;
import com.Software.FitnessSystem.AdminControllers.SubscriptionManagementControls;
import com.Software.FitnessSystem.AdminControllers.SubscriptionPlan;
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
		boolean expected = true;
		Client user = App.getClientsMap().get("John29Doe");
        boolean actual = SubscriptionManagementControls.updateUserSubscriptionPlan(
        		new SubscriptionPlan(App.getSubscriptionPlanMap().get("BASIC")), user, "no", true, false);
        assertTrue(expected == actual);
	}
	
	@Then("the changes should be saved successfully")
	public void the_changes_should_be_saved_successfully() {
		boolean expected = true;
        boolean actual = LoadAndSaveEntities.saveCustomSubscriptionPlanToFile(App.getSubscriptionPlanMap(), App.SUBSCRIPTION_PLAN_FILENAME);
        assertTrue(expected == actual);
	}
	
	@When("I add or update a plan \\(e.g., Basic or Premium)")
	public void i_add_or_update_a_plan_e_g_basic_or_premium() {
		boolean expected = true;
        boolean actual = SubscriptionManagementControls.dealWithSubscriptionPlan();
        assertTrue(expected == actual);
	}
	
	@Then("the plan should be available for clients and instructors.")
	public void the_plan_should_be_available_for_clients_and_instructors() {
		boolean expected = true;
        boolean actual = LoadAndSaveEntities.saveCustomSubscriptionPlanToFile(App.getSubscriptionPlanMap(), App.SUBSCRIPTION_PLAN_FILENAME);
        assertTrue(expected == actual);
	}
	
	@When("I view subscription details")
	public void i_view_subscription_details() {
		boolean expected = true;
        boolean actual = SubscriptionManagementControls.printSubscriptionPlan();
        assertTrue(expected == actual);
	}
	
	@Then("I should see the details for clients and instructors")
	public void i_should_see_the_details_for_clients_and_instructors() {
		boolean expected = true;
        boolean actual = SubscriptionManagementControls.returnIsPrinted();
        assertTrue(expected == actual);
	}
}