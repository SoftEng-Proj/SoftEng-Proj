package com.Software.FitnessSystem;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.ContentManagementControls.*;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

import static org.junit.Assert.assertEquals;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContentManagementTest {
    AdminPagesController adminControllers;
    App app;
    
    public ContentManagementTest() {
		this.app = new App();
        this.adminControllers = new AdminPagesController();
    }
	
	@Given("I am logged in as an admin")
	public void i_am_logged_in_as_an_admin() {
		String expected = "AdminLoggedIn";
    	String actual = login("AdminUser", "AdminPassword", "Admin");
        assertEquals(expected, actual);
	}
	
	@When("I navigate to the {string} page")
	public void i_navigate_to_the_page(String string) {
		boolean expected = true;
        boolean actual = adminControllers.navigateToPage(3, adminControllers);
        assertEquals(expected, actual);
	}
	
	@When("I review a wellness article, tip, or recipe")
	public void i_review_a_wellness_article_tip_or_recipe() {
		boolean expected = true;
		Map<String, Content> tips = getPendingInstructorTipsMap();
		setApprovedTipsMap(tips);
        boolean actual = reviewArticleAndTips(tips);
        assertEquals(expected, actual);
	}
	
	@Then("I can approve or reject the submission")
	public void i_can_approve_or_reject_the_submission() {
		boolean expected = true;
		Map<String, Content> tips = getPendingInstructorTipsMap();
		setApprovedTipsMap(tips);
		accessToPrinter(tips);
        boolean actual = approveOrRejectTheTips(getInstructorTipsMap());
        assertEquals(expected, actual);
	}
	
	@When("I review an article or tip on health and wellness")
	public void i_review_an_article_or_tip_on_health_and_wellness() {
		boolean expected = true;
		Map<String, Content> tips = getPendingInstructorTipsMap();
		setApprovedTipsMap(tips);
        boolean actual = reviewArticleAndTips(tips);
        assertEquals(expected, actual);
	}
	
	@When("I review user feedback or complaints")
	public void i_review_user_feedback_or_complaints() {
		boolean expected = true;
		setHandledFeedbackMap(getHandledFeedbackMap());
        boolean actual = reviewArticleAndTips(getUserFeedbackMap());
        assertEquals(expected, actual);
	}
	
	@Then("I should be able to handle them appropriately")
	public void i_should_be_able_to_handle_them_appropriately() {
		boolean expected = true;
		setHandledFeedbackMap(getHandledFeedbackMap());
		Map<String, Content> feedback = getUserFeedbackMap();
		accessToPrinter(feedback);
        boolean actual = respondToFeedback(feedback);
        assertEquals(expected, actual);
	}
}