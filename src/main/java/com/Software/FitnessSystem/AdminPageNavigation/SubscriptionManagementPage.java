package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.SubscriptionManagementControls.*;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

/**
 * Represents the Subscription Management page for the admin in the fitness system.
 * This page allows the admin to manage subscription plans, modify or remove them,
 * and handle subscription details for both clients and instructors.
 * It also provides the ability to view subscription details and navigate back to the main menu.
 * 
 * @author Muath Hassoun
 */
public class SubscriptionManagementPage extends BasePage {
    private final AdminPagesController adminController;
    
    /**
     * Constructor to initialize the SubscriptionManagementPage with the provided AdminPagesController.
     * 
     * @param adminController The controller responsible for managing admin page navigation and actions.
     */
	public SubscriptionManagementPage(AdminPagesController adminController) {
        this.adminController = adminController;
    }
    
	/**
     * Displays the Subscription Management menu with available options for the admin.
     * The menu includes options for creating, modifying, or removing subscription plans,
     * managing subscription plans for clients and instructors, viewing subscription details,
     * and returning to the main menu.
     */
    @Override
    public void display() {
        System.out.println("\nSubscription Management Menu:");
        System.out.println("1. Create, modify, or remove a subscription plan.");
        System.out.println("2. Manage subscription plans for clients and instructors.");
        System.out.println("3. View subscription details.");
        System.out.println("4. Go Back.");
    }
    
    /**
     * Executes the selected option based on the user's choice.
     * The method handles the creation, modification, or removal of subscription plans,
     * managing user subscriptions, viewing subscription details, and navigation back to the management page.
     * 
     * @param choice The option selected by the admin.
     */
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
            	dealWithSubscriptionPlan();
            	saveCustomSubscriptionPlanChanges();
                break;
            case 2:
            	dealWithUsersSubscriptionPlan();
            	saveAccountChanges();
                break;
            case 3:
            	printSubscriptionPlan();
                break;
            case 4:
                System.out.println("\nReturning to the main menu...");
                adminController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}