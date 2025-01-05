package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.SubscriptionManagementControls.*;
import static com.Software.FitnessSystem.AdminPageNavigation.CoSubscriptionManagementPage.*;

import com.Software.FitnessSystem.AdminControllers.CustomPlan;
import com.Software.FitnessSystem.AdminControllers.SubscriptionPlan;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

import java.util.Scanner;

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
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
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
                returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
        return returnValue;
    }
    
	/**
     * Displays the main menu for managing subscription plans and handles user interaction.
     * Users can add, edit, delete, or exit the subscription plan management menu.
     * 
     * @return true if an operation was completed successfully, or the user chooses to go back; false otherwise.
     */
	public static boolean dealWithSubscriptionPlan() {
		showMainMenu();
		boolean isDone = false;
		
		Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
            	isDone = addSubscriptionPlan();
                break;
            case 2:
        		printSubscriptionPlan();
        		isDone = editSubscriptionPlan();
                break;
            case 3:
        		printSubscriptionPlan();
            	isDone = removeSubscriptionPlan();
                break;
            case 4:
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
		return isDone;
	}
	
	/**
     * Displays the main menu options for subscription plan management.
     */
	private static void showMainMenu() {
        System.err.println("\nChoose an option:");
        System.err.println("1. Add a new Subscription Plan");
        System.err.println("2. Edit an existing Subscription Plan");
        System.err.println("3. Delete a Subscription Plan");
        System.err.println("4. Go Back.");
        System.err.println(">> Enter your choice: ");
    }
	
	/**
	 * Deals with a user's subscription plan by performing various operations such as updating,
	 * renewing, or applying free trials to the subscription plan.
	 * This method interacts with the user to determine the desired action and executes accordingly.
	 */
	private static void dealWithUsersSubscriptionPlan() {
		CustomPlan planType = askAboutPlanType();
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan(planType);
        if(!printUsersWithThisPlanType(planType)) {
        	return;
        }
        
        if(!selectUserToUpdateHisSubscriptionPlan()) {
        	return;
        }
        
        Scanner scanner = new Scanner(System.in);
        printChoiceMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
            	String newPlanType = askAboutTheNewPlanType();
                boolean updated = updateUserSubscriptionPlan(subscriptionPlan, user, newPlanType, false, true);
                System.out.println(updated ? "Subscription plan updated successfully." : "Failed to update subscription plan.");
                break;
            case 2:
                boolean renewed = updateUserSubscriptionPlan(subscriptionPlan, user, "Nothing",  true, false);
                System.out.println(renewed ? "Subscription plan renewed successfully." : "Failed to renew subscription plan.");
                break;
            case 3:
                giveTheUserNewSubscriptionOpportunity(subscriptionPlan, user);
                System.out.println("Free trial period applied. Remaining logins: " + user.getLogins());
                break;
            case 4:
            	return;
            default:
                System.out.println("Invalid choice.");
        }
    }
	
	/**
	 * Prints a choice menu for subscription-related actions.
	 * Options include updating the plan type, renewing the plan, or giving a free trial.
	 */
	private static void printChoiceMenu() {
		System.err.println("\nWhat would you like to do?");
        System.err.println("1. Update the subscription plan type");
        System.err.println("2. Renew subscription plan");
        System.err.println("3. Give the user a free trial period");
        System.err.println("4. Go Back.");
        System.err.println(">> Enter your choice: ");
	}
	
	/**
	 * Prompts the user to input their current subscription plan type.
	 * 
	 * @return The selected {@link CustomPlan} object.
	 */
	private static CustomPlan askAboutPlanType() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter the user's subscription plan (BASIC or PREMIUM or ...):");
        String planTypeInput = scanner.nextLine().toUpperCase();
        
        CustomPlan planType;
        try {
            planType = getSubscriptionPlanMap().get(planTypeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid subscription plan type.");
            return getSubscriptionPlanMap().get("BASIC");
        }
        
        return planType;
	}
	
	/**
	 * Prompts the user to input a new subscription plan type.
	 * 
	 * @return The new subscription plan type as a String.
	 */
	private static String askAboutTheNewPlanType() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter the user's new subscription plan (BASIC or PREMIUM or ...):");
        return scanner.nextLine().toUpperCase();
	}
}