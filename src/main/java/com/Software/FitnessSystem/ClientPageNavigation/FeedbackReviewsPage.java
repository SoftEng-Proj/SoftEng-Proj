package com.Software.FitnessSystem.ClientPageNavigation;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.ClientControllers.FeedbackReviewsControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;
/**
 * The FeedbackReviewsPage class represents the user interface for managing
 * feedback and reviews related to programs
 * It also provides options to rate
 * review or suggest improvements for programs
 * This class extends BasePage
 * 
 * @author Alaa Alawneh.
 */
public class FeedbackReviewsPage extends BasePage {
    private ClientPageControllers clientController;
    /**
     * Construct a FeedbackReviewsPage with the client controller
     *
     * @param clientController  the controller for managing client navigation
     */
    public FeedbackReviewsPage(ClientPageControllers clientController) {
        this.clientController = clientController;
    }
    /**
     * Display the menu with options for the client to choose
     */
    @Override
    public void display() {
        System.out.println("\nFeedback & Reviews Menu:");
        System.out.println("1. Rate the Program.");
        System.out.println("2. Write a Review.");
        System.out.println("3. Submit a Suggestion.");
        System.out.println("4. Go Back.");
    }
    /**
     * Execute the menu option selected by client
     *
     * @param choice   the option selected by client
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter the Program ID: ");
        String programId = scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Enter Rating (1-5): ");
                int rating = Integer.parseInt(scanner.nextLine());
                FeedbackReviewsControls.submitRating(username, programId, rating);
                App.saveProgramRatingsChanges();
                break;
            case 2:
                System.out.print("Enter your Review: ");
                String review = scanner.nextLine();
                FeedbackReviewsControls.submitReview(username, programId, review);
                App.saveProgramReviewsChanges();
                break;
            case 3:
                System.out.print("Enter your Suggestion: ");
                String suggestion = scanner.nextLine();
                FeedbackReviewsControls.submitSuggestion(username, programId, suggestion);
                App.saveProgramSuggestionsChanges();
                break;
            case 4:
                System.out.println("\nReturning to the main menu...");
                clientController.navigateToManagementPage();
                returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return returnValue;
    }
}