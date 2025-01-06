package com.software.fitness_system.LoginPage;
import java.util.Scanner;

import com.software.fitness_system.AdminPageNavigation.ContentManagementPage;
import com.software.fitness_system.AdminPageNavigation.NavigationControllerForAdmin;
import com.software.fitness_system.AdminPageNavigation.ProgramMonitoringPage;
import com.software.fitness_system.AdminPageNavigation.SubscriptionManagementPage;
import com.software.fitness_system.AdminPageNavigation.UserManagementPage;

/**
 * Controls navigation between admin-related pages in the fitness system.
 * This class serves as the central controller for managing admin page navigation, 
 * allowing seamless movement between pages for user management, content management, 
 * program monitoring, and subscription management.
 * <p>
 * The controller provides a main menu where the admin can select different options 
 * to navigate to specific pages or log out of the system.
 * 
 * @author Muath Hassoun
 */
public class AdminPagesController {
    public NavigationControllerForAdmin navigationController = new NavigationControllerForAdmin();
    public UserManagementPage managementPage;
    public ContentManagementPage contentPage;
    public ProgramMonitoringPage monitoringPage;
    public SubscriptionManagementPage subscriptionPage;
    
    /**
     * Constructs an instance of the {@code AdminPagesController} and initializes 
     * all the admin pages, passing the current instance to each page for reference.
     */
    public AdminPagesController() {
    	managementPage = new UserManagementPage(this);
    	contentPage = new ContentManagementPage(this);
    	monitoringPage = new ProgramMonitoringPage(this);
    	subscriptionPage = new SubscriptionManagementPage(this);
    }
    
    /**
     * Displays the main menu for the admin and waits for the user to select an option.
     * Based on the user's input, the appropriate page is displayed.
     * 
     * @return {@code true} if the navigation is successful.
     */
    public boolean navigateToManagementPage() {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
        navigateToPage(choiceNumber, this);
        return true;
    }
    
    /**
     * Navigates to a specific page based on the user's choice.
     * 
     * @param page The number representing the page to navigate to.
     *             1 - User Management Page
     *             2 - Program Monitoring Page
     *             3 - Content Management Page
     *             4 - Subscription Management Page
     *             5 - Log out and return to the login page
     *             6 - Exit the program
     * 
     * @return {@code true} if the navigation is successful.
     */
    public boolean navigateToPage(int page, AdminPagesController adminControllers) {
        switch (page) {
            case 1 -> navigationController.navigateTo(managementPage, adminControllers);
            case 2 -> navigationController.navigateTo(monitoringPage, adminControllers);
            case 3 -> navigationController.navigateTo(contentPage, adminControllers);
            case 4 -> navigationController.navigateTo(subscriptionPage, adminControllers);
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
     * Displays the main menu options for the admin.
     * The admin can select one of the available options to navigate to a specific page.
     */
    private void displayMainMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Manage accounts for instructors and clients.");
        System.out.println("2. Monitor user activity and engagement statistics.");
        System.out.println("3. Approve or reject content submissions.");
        System.out.println("4. Manage subscription plans.");
        System.out.println("5. Log out and return to the login page.");
        System.out.println("6. Exit.");
        System.out.print(">> Enter your choice: ");
    }
}