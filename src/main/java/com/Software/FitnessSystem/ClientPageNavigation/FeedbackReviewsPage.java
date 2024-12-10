package com.Software.FitnessSystem.ClientPageNavigation;

import com.Software.FitnessSystem.ClientControllers.FeedbackReviewsControls;
import com.Software.FitnessSystem.ClientControllers.ClientControllers;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;

public class FeedbackReviewsPage extends BasePage {
	 private ClientControllers clientController;
	 private FeedbackReviewsControls feedbackReviewsControls;

	    public FeedbackReviewsPage(ClientControllers clientController) {
	        this.clientController = clientController;
	        this.feedbackReviewsControls = new FeedbackReviewsControls();
	    }

	    @Override
	    public void display() {
	        System.out.println("\nFeedback & Reviews Menu:");
	        System.out.println("1. Rate the Program.");
	        System.out.println("2. Write a Review.");
	        System.out.println("3. Submit a Suggestion.");
	        System.out.println("4. View Your Feedback.");
	        System.out.println("5. Go Back.");
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
                break;

            case 2:
                System.out.print("Enter your Review: ");
                String review = scanner.nextLine();
                feedbackReviewsControls.submitReview(username, programId, review);
                break;

            case 3:
                System.out.print("Enter your Suggestion: ");
                String suggestion = scanner.nextLine();
                feedbackReviewsControls.submitSuggestion(username, programId, suggestion);
                break;

            case 4:
                feedbackReviewsControls.viewFeedback(username, programId);
                break;

            case 5:
                System.out.println("\nReturning to the main menu...");
                clientController.navigateToManagementPage();
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
            }
	    }
}
