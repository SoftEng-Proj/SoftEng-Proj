package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.ContentManagementControls;
import com.Software.FitnessSystem.AdminControllers.UserManagementControls;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class tester {
	App app;
    UserManagementControls managementControls;
	
	public tester() {
		this.app = new App();
		managementControls = new UserManagementControls();
	}
    
    @Test
    public void i_review_user_feedback_or_complaints() {
		boolean expected = true;
		ContentManagementControls.setHandledFeedbackMap(App.getHandledFeedbackMap());
        boolean actual = ContentManagementControls.reviewArticleAndTips(App.getUserFeedbackMap());
        assertTrue(expected == actual);
	}
	
	@Test
	public void i_should_be_able_to_handle_them_appropriately() {
		boolean expected = true;
		ContentManagementControls.setHandledFeedbackMap(App.getHandledFeedbackMap());
		Map<String, Content> feedback = App.getUserFeedbackMap();
		ContentManagementControls.accessToPrinter(feedback);
        boolean actual = ContentManagementControls.respondToFeedback(feedback);
        assertTrue(expected == actual);
	}
}