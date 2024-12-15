package acceptance;

import static org.junit.Assert.assertTrue;

import com.Software.FitnessSystem.ClientControllers.FeedbackReviewsControls;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeedbackReviewsTest {
	@When("I rate the program {string} out of {int} stars")
	public void i_rate_the_program_out_of_stars(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Rating Submited succsesfully";
		String actual = FeedbackReviewsControls.submitRating("", "", 0);
		assertTrue(actual.equals(expected));
	}

	@When("I submit my rating")
	public void i_submit_my_rating() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Rating Submited succsesfully";
		String actual = FeedbackReviewsControls.submitRating("", "", 0);
		assertTrue(actual.equals(expected));
	}

	@Then("my rating should be saved")
	public void my_rating_should_be_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Rating Submited succsesfully";
		String actual = FeedbackReviewsControls.submitRating("", "", 0);
		assertTrue(actual.equals(expected));
	}

	@When("I write a review {string}")
	public void i_write_a_review(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Review Submited succsesfully";
		String actual = FeedbackReviewsControls.submitReview("", "", "");
		assertTrue(actual.equals(expected));
	}

	@When("I submit my review")
	public void i_submit_my_review() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Review Submited succsesfully";
		String actual = FeedbackReviewsControls.submitReview("", "", "");
		assertTrue(actual.equals(expected));
	}

	@Then("my review should be saved")
	public void my_review_should_be_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Review Submited succsesfully";
		String actual = FeedbackReviewsControls.submitReview("", "", "");
		assertTrue(actual.equals(expected));
	}

	@When("I navigate to the {string} section")
	public void i_navigate_to_the_section(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Suggestion Submited succsesfully";
		String actual = FeedbackReviewsControls.submitSuggestion("", "", "");
		assertTrue(actual.equals(expected));
	}

	@When("I submit a suggestion {string}")
	public void i_submit_a_suggestion(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Suggestion Submited succsesfully";
		String actual = FeedbackReviewsControls.submitSuggestion("", "", "");
		assertTrue(actual.equals(expected));
	}

	@Then("my suggestion should be sent to the instructor")
	public void my_suggestion_should_be_sent_to_the_instructor() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		String expected = "Suggestion Submited succsesfully";
		String actual = FeedbackReviewsControls.submitSuggestion("", "", "");
		assertTrue(actual.equals(expected));
	}
}
