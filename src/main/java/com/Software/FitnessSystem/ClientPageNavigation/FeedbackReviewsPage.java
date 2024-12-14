package com.Software.FitnessSystem.ClientPageNavigation;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.ClientControllers.FeedbackReviewsControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;

public class FeedbackReviewsPage extends BasePage {
	 private ClientPageControllers clientController;
	 private FeedbackReviewsControls feedbackReviewsControls;

	    public FeedbackReviewsPage(ClientPageControllers clientController) {
	        this.clientController = clientController;
	        this.feedbackReviewsControls = new FeedbackReviewsControls();
	    }

	    @Override
	    public void display() {
	        System.out.println("\nFeedback & Reviews Menu:");
	        System.out.println("1. Rate the Program.");
	        System.out.println("2. Write a Review.");
	        System.out.println("3. Submit a Suggestion.");
	        System.out.println("4. Go Back.");
	    }

	    @Override
	    public void executeOption(int choice) {
	        System.out.print("Enter your Username: ");
	        String username = scanner.nextLine();
	        
	        System.out.print("Enter the Program ID: ");
	        String programId = scanner.nextLine();

	        switch (choice) {
            case 1:
                System.out.print("Enter Rating (1-5): ");
                int rating = Integer.parseInt(scanner.nextLine());
                feedbackReviewsControls.submitRating(username, programId, rating);
                App.saveProgramRatingsChanges();
                break;

            case 2:
                System.out.print("Enter your Review: ");
                String review = scanner.nextLine();
                feedbackReviewsControls.submitReview(username, programId, review);
                App.saveProgramReviewsChanges();
                break;

            case 3:
                System.out.print("Enter your Suggestion: ");
                String suggestion = scanner.nextLine();
                feedbackReviewsControls.submitSuggestion(username, programId, suggestion);
                App.saveProgramSuggestionsChanges();
                break;

            case 4:
            	System.out.println("\nReturning to the main menu...");
                clientController.navigateToManagementPage();
                break;


            default:
                System.out.println("Invalid choice. Please try again.");
            }
	    }
}
