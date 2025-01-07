package com.software.fitness_system.admin_page_navigation;
import static com.software.fitness_system.App.getClientsMap;
import static com.software.fitness_system.App.getInstructorsMap;
import static com.software.fitness_system.App.getSubscriptionPlanMap;
import static com.software.fitness_system.admin_controllers.SubscriptionManagementControls.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.software.fitness_system.User;
import com.software.fitness_system.admin_controllers.CustomPlan;
import com.software.fitness_system.admin_controllers.SubscriptionManagementControls;
import com.software.fitness_system.admin_controllers.SubscriptionPlan;

/**
 * Represents the Co-Subscription Management page for the admin in the fitness system.
 * This page allows the admin to manage subscription plans, modify or remove them,
 * and handle subscription details for both clients and instructors.
 * It also provides the ability to view subscription details and navigate back to the main menu.
 * 
 * @author Muath Hassoun
 */
public class CoSubscriptionManagementPage {
	/**
     * Adds a new subscription plan by collecting details from the user through the console.
     * 
     * @return true if the subscription plan is added successfully; false otherwise.
     */
	public static boolean addSubscriptionPlan() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the plan name:");
        String planName = scanner.nextLine();
        
        System.out.println("Enter the price of the plan:");
        double price;
        try {
            price = scanner.nextDouble();
        } catch(InputMismatchException | NumberFormatException ex) {
        	price = 0.0;
        }
        
        System.out.println("Enter the duration of the plan (in days):");
        int duration;
        try {
        	duration = scanner.nextInt();
        } catch(InputMismatchException | NumberFormatException ex) {
        	duration = 30;
        }
        scanner.nextLine();
        
        System.out.println("Enter the description of the plan:");
        String description = scanner.nextLine();
        
        boolean isAdded = doAdding(planName.toUpperCase(), price, duration, description);

        if (isAdded) {
            System.out.println("Subscription Plan added successfully.");
        } else {
            System.out.println("Failed to add Subscription Plan.");
        }
        return isAdded;
    }
	
	/**
	 * Allows the user to edit an existing subscription plan by selecting a plan and modifying its properties.
	 * Users can edit the price, duration, and description of a plan.
	 * 
	 * @return true if the plan is updated successfully; false otherwise.
	 */
	public static boolean editSubscriptionPlan() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Do you want to edit a plan? (yes/no)");
	    if (!scanner.nextLine().equalsIgnoreCase("yes")) {
	        return false;
	    }
	    
	    System.out.println("Enter the plan name to edit (e.g., BASIC, PREMIUM, ...):");
	    String planName = scanner.nextLine().toUpperCase();
	    CustomPlan plan = getSubscriptionPlanMap().get(planName);
	    
	    if (plan == null) {
	        System.out.println("Invalid plan name.");
	        return false;
	    }
	    
	    boolean isUpdated = false;
	    while (true) {
	        printModifyMenu();
	        int choice = getValidChoice(scanner, 1, 4);
	        
	        if (choice == 4) {
	            break;
	        }
	        
	        isUpdated = updatePlanProperty(scanner, plan, choice) || isUpdated;
	    }
	    
	    if (isUpdated) {
	        amendedPlanPrinting(plan);
	    }
	    
	    return isUpdated;
	}
	
	/**
	 * Updates the selected property of the subscription plan.
	 * 
	 * @param scanner Scanner object for user input
	 * @param plan    Subscription plan to be updated
	 * @param choice  User's choice of property to update
	 * @return true if the property was updated, false otherwise
	 */
	private static boolean updatePlanProperty(Scanner scanner, CustomPlan plan, int choice) {
	    Object data;
	    switch (choice) {
	        case 1:
	            System.out.println("Enter new price:");
	            data = getValidDouble(scanner);
	            return doAmendment(data, plan, "price");
	        case 2:
	            System.out.println("Enter new duration (in days):");
	            data = getValidInt(scanner);
	            return doAmendment(data, plan, "duration");
	        case 3:
	            System.out.println("Enter new description:");
	            data = scanner.nextLine();
	            return doAmendment(data, plan, "description");
	        default:
	            System.out.println("Invalid choice.");
	            return false;
	    }
	}
	
	/**
	 * Displays the menu for modifying subscription plan properties.
	 */
	private static void printModifyMenu() {
	    System.out.println("\nWhat do you want to edit?");
	    System.out.println("1. Price");
	    System.out.println("2. Duration");
	    System.out.println("3. Description");
	    System.out.println("4. Stop");
	    System.out.print(">> Enter your choice: ");
	}
	
	/**
	 * Gets a valid integer input from the user within the specified range.
	 * 
	 * @param scanner Scanner object for user input
	 * @param min     Minimum valid value
	 * @param max     Maximum valid value
	 * @return Valid integer input
	 */
	private static int getValidChoice(Scanner scanner, int min, int max) {
	    while (true) {
	        try {
	            int choice = Integer.parseInt(scanner.nextLine());
	            if (choice >= min && choice <= max) {
	                return choice;
	            }
	        } catch (NumberFormatException e) {
	        }
	        System.out.print("Invalid input. Please enter a number between " + min + " and " + max + ": ");
	    }
	}
	
	/**
	 * Gets a valid double input from the user.
	 * 
	 * @param scanner Scanner object for user input
	 * @return Valid double input
	 */
	private static double getValidDouble(Scanner scanner) {
	    while (true) {
	        try {
	            return Double.parseDouble(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.print("Invalid input. Please enter a valid number: ");
	        }
	    }
	}
	
	/**
	 * Gets a valid integer input from the user.
	 * 
	 * @param scanner Scanner object for user input
	 * @return Valid integer input
	 */
	private static int getValidInt(Scanner scanner) {
	    while (true) {
	        try {
	            return Integer.parseInt(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.print("Invalid input. Please enter a valid number: ");
	        }
	    }
	}
	
	/**
     * Removes an existing subscription plan by its name.
     * 
     * @return true if the subscription plan was removed successfully; false otherwise.
     */
	public static boolean removeSubscriptionPlan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the plan name to edit (e.g., BASIC, PREMIUM, ...):");
        String planName = scanner.nextLine().toUpperCase();
        return doRemoving(planName);
	}
	
	/**
	 * Prints the list of users (clients or instructors) who have the specified subscription plan.
	 * 
	 * @param planType The subscription plan type to filter users by.
	 * @return True if users with the specified plan are found; false otherwise.
	 */
	public static boolean printUsersWithThisPlanType(CustomPlan planType) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Do you want to see Clients or Instructors? (C/I):");
	    String choice = scanner.nextLine().toUpperCase();
	    
	    System.out.println("\nUsers with subscription plan: " + planType);
	    System.out.println("=======================================");
	    
	    if (choice.equals("C")) {
	        userTupe = "C";
	        getClientsMap().values().stream()
	                .filter(client -> client.getSubscriptionPlan() != null && client.getSubscriptionPlan().getPlanType() != null
	                        && client.getSubscriptionPlan().getPlanType().getName().equals(planType.getName()))
	                .forEach(client -> System.out.println("Client: " + client.getUsername() + " - Logins: " + client.getLogins()));
	    } else if (choice.equals("I")) {
	        userTupe = "I";
	        getInstructorsMap().values().stream()
	                .filter(instructor -> instructor.getSubscriptionPlan() != null && instructor.getSubscriptionPlan().getPlanType() != null
	                        && instructor.getSubscriptionPlan().getPlanType().getName().equals(planType.getName()))
	                .forEach(instructor -> System.out.println("Instructor: " + instructor.getUsername() + " - Logins: " + instructor.getLogins()));
	    } else {
	        System.out.println("Invalid choice. Please select either 'C' or 'I'.");
	        return false;
	    }
	    
	    System.out.println("=======================================");
	    return true;
	}
	
	/**
	 * Prompts the user to select a specific user (client or instructor) to update their subscription plan.
	 * 
	 * @return True if the user is found; false otherwise.
	 */
	public static boolean selectUserToUpdateHisSubscriptionPlan() {
        boolean isFound = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the username of the user you want to update:");
        String username = scanner.nextLine();
        
        User user = null;
        if(userTupe.equals("C")) {
        	user = getClientsMap().get(username);
        } else if (userTupe.equals("I")) {
        	user = getInstructorsMap().get(username);
        }
        
        if (user != null) {
            System.out.println("User found: " + username);
            SubscriptionManagementControls.user = user;
            isFound = true;
        } else {
            System.out.println("User not found.");
            SubscriptionManagementControls.user = null;
        }
        
        return isFound;
	}
	
	/**
	 * Provides the user with a free subscription trial based on the subscription plan.
	 * 
	 * @param subscriptionPlan The {@link SubscriptionPlan} object associated with the user.
	 * @param user             The user receiving the free trial.
	 * @param <T>              A type parameter extending {@link User}.
	 */
	public static <T extends User> void giveTheUserNewSubscriptionOpportunity(SubscriptionPlan subscriptionPlan, T user) {
    	int login;
        if (subscriptionPlan != null) {
        	double price = subscriptionPlan.getPlanType().getPrice();
            int freeOpportunityDays = calculateFreeOpportunity(price);
            
            login = user.getLogins();
            login -= freeOpportunityDays;
            user.setLogins(login);
            System.out.println("User " + user.getUsername() + " has received " + freeOpportunityDays + " free days.");
        }
    }
	
	/**
	 * Calculates the number of free trial days based on the subscription plan's price.
	 * 
	 * @param price The price of the subscription plan.
	 * @return The calculated number of free trial days.
	 */
	private static int calculateFreeOpportunity(double price) {
	    int baseFreeDays = 3;
	    int multiplier = (int) (price / 30);
	    
	    if (multiplier < 1) {
	        return baseFreeDays;
	    }
	    
	    return baseFreeDays * multiplier;
	}
}