package com.Software.FitnessSystem.LoginPage;
import java.util.Scanner;

import com.Software.FitnessSystem.ClientPageNavigation.NavigationControllerForClient;
import com.Software.FitnessSystem.ClientPageNavigation.ProgressTrackingPage;
import com.Software.FitnessSystem.ClientPageNavigation.AccountManagementPage;
//import com.Software.FitnessSystem.ClientPageNavigation.ProgramExplorationPage;
import com.Software.FitnessSystem.ClientPageNavigation.FeedbackReviewsPage;

public class ClientPageControllers {
    private NavigationControllerForClient navigationController = new NavigationControllerForClient();
    private AccountManagementPage accountManagementPage;
    //private ProgramExplorationPage programExplorationPage;
    private ProgressTrackingPage progressTrackingPage;
    private FeedbackReviewsPage feedbackAndReviewsPage;
    //private int mainListNumber = 0;
    
    public ClientPageControllers() {
    	accountManagementPage = new AccountManagementPage(this);
        //programExplorationPage = new ProgramExplorationPage(this);
        progressTrackingPage = new ProgressTrackingPage(this);
        feedbackAndReviewsPage = new FeedbackReviewsPage(this);
    }
    
    @SuppressWarnings("resource")
	public boolean navigateToManagementPage() {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
       // mainListNumber = choiceNumber;
        navigateToPage(choiceNumber);
        return true;
    }
    
    public boolean navigateToPage(int page) {
        switch (page) {
        case 1 -> navigationController.navigateTo(accountManagementPage, this);
        //case 2 -> navigationController.navigateTo(programEnrollmentPage, this);
        case 3 -> navigationController.navigateTo(progressTrackingPage, this);
        case 4 -> navigationController.navigateTo(feedbackAndReviewsPage, this);
        case 5 -> {
            System.out.println("\n\nExiting program. Goodbye!");
            System.exit(0);
        }
        default -> System.out.println("Invalid selection. Please try again.");
    }
    return true;
    }
    
    private void displayMainMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Account Management.");
        System.out.println("2. Program Exploration and Enrollment.");
        System.out.println("3. Progress Tracking.");
        System.out.println("4. Feedback and Reviews.");
        System.out.println("5. Exit.");
        System.out.print("\nEnter your choice: ");
    }
}