package com.Software.FitnessSystem.AdminControllers;
import static com.Software.FitnessSystem.App.*;
import com.Software.FitnessSystem.User;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Provides controls for managing subscription plans and user subscriptions.
 * Includes functionality for adding, editing, deleting, and viewing subscription plans,
 * as well as updating user subscription details.
 * 
 * @author Muath Hassoun
 */
public class SubscriptionManagementControls {
	private static boolean isPrinted = false;
	private static String userTupe = "";
	private static User user;
	public SubscriptionManagementControls() {}
	
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
     * Prints the details of all subscription plans currently available.
     * 
     * @return true if subscription plans are printed successfully; false if no plans exist.
     */
	public static boolean printSubscriptionPlan() {
		isPrinted = false;
		
		for (CustomPlan plan : getSubscriptionPlanMap().values()) {
            System.out.println("\nPlan: " + plan.getName());
            System.out.println("1. Price: " + plan.getPrice());
            System.out.println("2. Duration: " + plan.getDuration() + " days");
            System.out.println("3. Description: " + plan.getDescription());
            System.out.println("-------------------------------------");
            isPrinted = true;
        }
		return isPrinted;
	}
	
	/**
     * Returns the current status of the `isPrinted` flag, indicating whether subscription plans were printed.
     * 
     * @return true if plans have been printed; false otherwise.
     */
	public static boolean returnIsPrinted() {
		return isPrinted;
	}
	
	/**
     * Adds a new subscription plan by collecting details from the user through the console.
     * 
     * @return true if the subscription plan is added successfully; false otherwise.
     */
	private static boolean addSubscriptionPlan() {
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
        
        CustomPlan newCustomPlan = new CustomPlan(planName.toUpperCase(), price, duration, description);
        getSubscriptionPlanMap().put(planName, newCustomPlan);
        
        System.out.println("Subscription Plan added successfully.");
        return true;
    }
	
	/**
     * Allows the user to edit an existing subscription plan by selecting a plan and modifying its properties.
     * Users can edit the price, duration, and description of a plan.
     * 
     * @return true if the plan is updated successfully; false otherwise.
     */
	private static boolean editSubscriptionPlan() {
		Scanner scanner = new Scanner(System.in);
		boolean isUpdated = false;
		
		System.out.println("Do you want to edit a plan? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the plan name to edit (e.g., BASIC, PREMIUM, ...):");
            String planName = scanner.nextLine().toUpperCase();
            
            try {
                CustomPlan plan = getSubscriptionPlanMap().get(planName);
                
                boolean isStoped = false;
                while(!isStoped) {
                    printModifyMenu();
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (choice) {
                    case 1:
                        System.out.println("Enter new price:");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        plan.setPrice(newPrice);
                        isUpdated = true;
                        break;
                    case 2:
                        System.out.println("Enter new duration (in days):");
                        int newDuration = scanner.nextInt();
                        scanner.nextLine();
                        plan.setDuration(newDuration);
                        isUpdated = true;
                        break;
                    case 3:
                        System.out.println("Enter new description:");
                        String newDescription = scanner.nextLine();
                        plan.setDescription(newDescription);
                        isUpdated = true;
                        break;
                    case 4:
                    	isStoped = true;
                    	isUpdated = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        isUpdated = true;
                    }
                }
                
                amendedPlanPrinting(plan);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid plan name.");
                isUpdated = false;
            }
        }
        
        return isUpdated;
	}
	
	/**
     * Displays the menu for modifying subscription plan properties.
     */
	private static void printModifyMenu() {
		System.err.println("\nWhat do you want to edit?");
        System.err.println("1. Price");
        System.err.println("2. Duration");
        System.err.println("3. Description");
        System.err.println("4. Stop");
        System.err.println(">> Enter your choice: ");
	}
	
	/**
     * Prints the updated details of a subscription plan after editing.
     * 
     * @param plan The subscription plan that was updated.
     */
	private static void amendedPlanPrinting(CustomPlan plan) {
		System.err.println("\nSubscription Plan:");
        System.err.println("Plan: " + plan.getName());
        System.err.println("1. Price: " + plan.getPrice());
        System.err.println("2. Duration: " + plan.getDuration() + " days");
        System.err.println("3. Description: " + plan.getDescription());
	}
	
	/**
     * Removes an existing subscription plan by its name.
     * 
     * @return true if the subscription plan was removed successfully; false otherwise.
     */
	private static boolean removeSubscriptionPlan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the plan name to edit (e.g., BASIC, PREMIUM, ...):");
        String planName = scanner.nextLine().toUpperCase();
        getSubscriptionPlanMap().remove(planName);
        return true;
	}
	
	/**
	 * Deals with a user's subscription plan by performing various operations such as updating,
	 * renewing, or applying free trials to the subscription plan.
	 * This method interacts with the user to determine the desired action and executes accordingly.
	 */
	public static void dealWithUsersSubscriptionPlan() {
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
	
	/**
	 * Prints the list of users (clients or instructors) who have the specified subscription plan.
	 * 
	 * @param planType The subscription plan type to filter users by.
	 * @return True if users with the specified plan are found; false otherwise.
	 */
	private static boolean printUsersWithThisPlanType(CustomPlan planType) {
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
	private static boolean selectUserToUpdateHisSubscriptionPlan() {
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
	 * Updates the subscription plan of a user.
	 * 
	 * @param subscriptionPlan             The {@link SubscriptionPlan} object associated with the user.
	 * @param user                         The user whose subscription plan is being updated.
	 * @param newPlanType                  The new subscription plan type.
	 * @param justRenew                    Flag indicating if the plan is only being renewed.
	 * @param renewAndReverseSubscription  Flag indicating if the plan type should be reversed and renewed.
	 * @param <T>                          A type parameter extending {@link User}.
	 * @return True if the subscription plan is updated successfully; false otherwise.
	 */
	public static <T extends User> boolean updateUserSubscriptionPlan(SubscriptionPlan subscriptionPlan, T user,
			String newPlanType, boolean justRenew, boolean renewAndReverseSubscription) {
		
		boolean isUpdated = false;
        if (subscriptionPlan != null) {
        	if(renewAndReverseSubscription && !justRenew) {
            	subscriptionPlan.setPlanType(getSubscriptionPlanMap().get(newPlanType));
            	user.setSubscriptionPlan(subscriptionPlan);
            	user.setLogins(0);
            	isUpdated = true;
        	} else if(justRenew && !renewAndReverseSubscription) {
        		user.setLogins(0);
        		isUpdated = true;
        	}
        	return isUpdated;
        }
        
        return isUpdated;
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