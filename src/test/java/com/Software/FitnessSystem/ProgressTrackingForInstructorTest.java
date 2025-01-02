package com.Software.FitnessSystem;
import com.Software.FitnessSystem.InstructorControllers.ProgressTrackingInstructorControls;
import com.Software.FitnessSystem.InstructorPageNavigation.ProgressTrackingInstructorPage;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressTrackingForInstructorTest {
	
	
App app;
    
    public ProgressTrackingForInstructorTest(App obj) {
		this.app = obj;
    }


@When("I view the progress of {string}")
public void i_view_the_progress_of(String string) {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	boolean expected = true;
	boolean actual= ProgressTrackingInstructorPage.viewClientProgress();
	assertTrue(expected==actual);
}

@Then("I should see {string} progress details with a completion rate of {string} and attendance of {string}")
public void i_should_see_progress_details_with_a_completion_rate_of_and_attendance_of(String string, String string2, String string3) {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	boolean expected = true;
	boolean actual= ProgressTrackingInstructorPage.ViewedCheck();
	assertTrue(expected==actual);
}

@Given("I have an enrolled client named {string} with a completion rate of {string}")
public void i_have_an_enrolled_client_named_with_a_completion_rate_of(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	boolean expected = true;
	boolean actual= ProgressTrackingInstructorPage.viewClientProgress();
	assertTrue(expected==actual);
	
}

@When("I send a motivational reminder to {string} which says '{string}'")
public void i_send_a_motivational_reminder_to_which_says(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	boolean expected = true;
	boolean actual= ProgressTrackingInstructorControls.Reminderr("Ali","Eat");
	assertTrue(expected==actual);
	
}

@Then("the client should receive a reminder message")
public void the_client_should_receive_a_reminder_message() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException(); 
	boolean expected = true;
	boolean actual= ProgressTrackingInstructorControls.ReceivedCheck();
	assertTrue(expected==actual);
	
}



@When("I send a recommendation to {string} which says {string}")
public void i_send_a_recommendation_to_which_says(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	boolean expected = true;
	boolean actual= ProgressTrackingInstructorControls.Recommendationn("Ali", "More effort");
	assertTrue(expected==actual);
}



@Then("the client should receive a recommendation message")
public void theClientShouldReceiveARecommendationMessage() {
    // Write code here that turns the phrase above into concrete actions
   // throw new io.cucumber.java.PendingException();
	boolean expected = true;
	boolean actual= ProgressTrackingInstructorControls.ReceivedRecommCheck();
	assertTrue(expected==actual);
	
}




}
