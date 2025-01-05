package com.Software.FitnessSystem.LoginPage;
import java.util.Scanner;

import com.Software.FitnessSystem.ClientPageNavigation.NavigationControllerForClient;
import com.Software.FitnessSystem.ClientPageNavigation.ProgramExplorationEnrollmentPage;
import com.Software.FitnessSystem.ClientPageNavigation.ProgressTrackingPage;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.ClientPageNavigation.AccountManagementPage;
import com.Software.FitnessSystem.ClientPageNavigation.FeedbackReviewsPage;

/**
 * Controls the navigation and management of pages for clients in the fitness system.
 * 
 * This controller provides access to the following pages:
 * - Account Management
 * - Program Exploration and Enrollment
 * - Progress Tracking
 * - Feedback and Reviews
 * 
 * The class facilitates seamless navigation between these pages and handles 
 * user input from the main menu.
 * 
 * @author Alaa Alawneh
 */
public class ClientPageControllers {
    private NavigationControllerForClient navigationController = new NavigationControllerForClient();
    private AccountManagementPage accountManagementPage;
    private ProgramExplorationEnrollmentPage programExplorationPage;
    private ProgressTrackingPage progressTrackingPage;
    private FeedbackReviewsPage feedbackAndReviewsPage;
    private static boolean i_am_on_the_program_exploration_page = false;
    
    /**
     * Constructs a new {@code ClientPageControllers} instance for the specified client.
     * 
     * @param currentClient The client object associated with the current session.
     */
    public ClientPageControllers(Client currentClient) {
    	accountManagementPage = new AccountManagementPage(this);
        programExplorationPage = new ProgramExplorationEnrollmentPage(this, currentClient);
        progressTrackingPage = new ProgressTrackingPage(this, currentClient);
        feedbackAndReviewsPage = new FeedbackReviewsPage(this);
    }
    
    /**
     * Displays the main menu for the client and prompts them to select an option.
     * Based on the user's selection, it navigates to the appropriate page.
     * 
     * @return {@code true} if navigation is successful.
     */
    @SuppressWarnings("resource")
	public boolean navigateToManagementPage() {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
        navigateToPage(choiceNumber);
        return true;
    }
    
    /**
     * Navigates to a specific page based on the user's input.
     * 
     * @param page The number representing the user's choice.
     *             1 - Account Management
     *             2 - Program Exploration and Enrollment
     *             3 - Progress Tracking
     *             4 - Feedback and Reviews
     *             5 - Logout (returns to the Login Page)
     *             6 - Exit (closes the program)
     * 
     * @return {@code true} if navigation is successful.
     */
    public boolean navigateToPage(int page) {
    	i_am_on_the_program_exploration_page = (page == 2);
        switch (page) {
        case 1 -> navigationController.navigateTo(accountManagementPage, this);
        case 2 -> navigationController.navigateTo(programExplorationPage, this);
        case 3 -> navigationController.navigateTo(progressTrackingPage, this);
        case 4 -> navigationController.navigateTo(feedbackAndReviewsPage, this);
        case 5 -> {
        	System.out.print("\n");
        	new LoginPageController();
        }
        case 6 -> {
            System.err.println("\n\nExiting program. Goodbye!");
            System.exit(0);
        }
        default -> System.out.println("Invalid selection. Please try again.");
    }
    return true;
    }
    
    /**
     * Displays the main menu options for the client.
     * The menu provides six options, allowing the client to choose a page to navigate to.
     */
    private void displayMainMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Account Management.");
        System.out.println("2. Program Exploration and Enrollment.");
        System.out.println("3. Progress Tracking.");
        System.out.println("4. Feedback and Reviews.");
        System.out.println("5. Log out and return to the login page.");
        System.out.println("6. Exit.");
        System.out.print("\nEnter your choice: ");
    }
    
    /**
     * Checks if the client is currently on the Program Exploration and Enrollment page.
     * 
     * @return {@code true} if the client is on the Program Exploration page, otherwise {@code false}.
     */
    public static boolean isOnProgramExplorationPage() {
        return i_am_on_the_program_exploration_page;
    }
}