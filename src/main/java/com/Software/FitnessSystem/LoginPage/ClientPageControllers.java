package com.Software.FitnessSystem.LoginPage;
import java.util.Scanner;

import com.Software.FitnessSystem.ClientPageNavigation.NavigationControllerForClient;
import com.Software.FitnessSystem.ClientPageNavigation.ProgramExplorationEnrollmentPage;
import com.Software.FitnessSystem.ClientPageNavigation.ProgressTrackingPage;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.ClientPageNavigation.AccountManagementPage;
//import com.Software.FitnessSystem.ClientPageNavigation.ProgramExplorationPage;
import com.Software.FitnessSystem.ClientPageNavigation.FeedbackReviewsPage;

public class ClientPageControllers {
    private NavigationControllerForClient navigationController = new NavigationControllerForClient();
    private AccountManagementPage accountManagementPage;
    private ProgramExplorationEnrollmentPage programExplorationPage;
    private ProgressTrackingPage progressTrackingPage;
    private FeedbackReviewsPage feedbackAndReviewsPage;
    private static boolean i_am_on_the_program_exploration_page = false;
    
    public ClientPageControllers(Client currentClient) {
    	accountManagementPage = new AccountManagementPage(this);
        programExplorationPage = new ProgramExplorationEnrollmentPage(this, currentClient);
        progressTrackingPage = new ProgressTrackingPage(this, currentClient);
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
    	i_am_on_the_program_exploration_page = (page == 2);
        switch (page) {
        case 1 -> navigationController.navigateTo(accountManagementPage, this);
        case 2 -> navigationController.navigateTo(programExplorationPage, this);
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
    public static boolean isOnProgramExplorationPage() {
        return i_am_on_the_program_exploration_page;
    }
}