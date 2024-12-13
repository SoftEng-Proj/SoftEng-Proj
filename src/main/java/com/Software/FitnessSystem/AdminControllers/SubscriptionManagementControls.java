package com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubscriptionManagementControls {
	private static boolean isPrinted = false;
	private static String userTupe = "";
	private static User user;
	
	@SuppressWarnings("resource")
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
            	isDone = true;
                return isDone;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
		return isDone;
	}
	
	private static void showMainMenu() {
        System.err.println("\nChoose an option:");
        System.err.println("1. Add a new Subscription Plan");
        System.err.println("2. Edit an existing Subscription Plan");
        System.err.println("3. Delete a Subscription Plan");
        System.err.println("4. Go Back.");
        System.err.println(">> Enter your choice: ");
    }
	
	public static boolean printSubscriptionPlan() {
		isPrinted = false;
		
		for (CustomPlan plan : App.getSubscriptionPlanMap().values()) {
            System.out.println("\nPlan: " + plan.getName());
            System.out.println("1. Price: " + plan.getPrice());
            System.out.println("2. Duration: " + plan.getDuration() + " days");
            System.out.println("3. Description: " + plan.getDescription());
            System.out.println("-------------------------------------");
            isPrinted = true;
        }
		return isPrinted;
	}
	
	public static boolean returnIsPrinted() {
		return isPrinted;
	}
	
	@SuppressWarnings("resource")
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
        App.getSubscriptionPlanMap().put(planName, newCustomPlan);
        
        System.out.println("Subscription Plan added successfully.");
        return true;
    }
	
	@SuppressWarnings("resource")
	private static boolean editSubscriptionPlan() {
		Scanner scanner = new Scanner(System.in);
		Boolean isUpdated = false;
		
		System.out.println("Do you want to edit a plan? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the plan name to edit (e.g., BASIC, PREMIUM, ...):");
            String planName = scanner.nextLine().toUpperCase();
            
            try {
                CustomPlan plan = App.getSubscriptionPlanMap().get(planName);
                
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
	
	private static void printModifyMenu() {
		System.err.println("\nWhat do you want to edit?");
        System.err.println("1. Price");
        System.err.println("2. Duration");
        System.err.println("3. Description");
        System.err.println("4. Stop");
        System.err.println(">> Enter your choice: ");
	}
	
	private static void amendedPlanPrinting(CustomPlan plan) {
		System.err.println("\nSubscription Plan:");
        System.err.println("Plan: " + plan.getName());
        System.err.println("1. Price: " + plan.getPrice());
        System.err.println("2. Duration: " + plan.getDuration() + " days");
        System.err.println("3. Description: " + plan.getDescription());
	}
	
	@SuppressWarnings("resource")
	private static boolean removeSubscriptionPlan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the plan name to edit (e.g., BASIC, PREMIUM, ...):");
        String planName = scanner.nextLine().toUpperCase();
        App.getSubscriptionPlanMap().remove(planName);
        return true;
	}
	
	@SuppressWarnings("resource")
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
	
	private static void printChoiceMenu() {
		System.err.println("\nWhat would you like to do?");
        System.err.println("1. Update the subscription plan type");
        System.err.println("2. Renew subscription plan");
        System.err.println("3. Give the user a free trial period");
        System.err.println("4. Go Back.");
        System.err.println(">> Enter your choice: ");
	}
	
	@SuppressWarnings("resource")
	private static CustomPlan askAboutPlanType() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter the user's subscription plan (BASIC or PREMIUM or ...):");
        String planTypeInput = scanner.nextLine().toUpperCase();
        
        CustomPlan planType;
        try {
            planType = App.getSubscriptionPlanMap().get(planTypeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid subscription plan type.");
            return App.getSubscriptionPlanMap().get("BASIC");
        }
        
        return planType;
	}
	
	@SuppressWarnings("resource")
	private static String askAboutTheNewPlanType() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter the user's new subscription plan (BASIC or PREMIUM or ...):");
        String planTypeInput = scanner.nextLine().toUpperCase();
        return planTypeInput;
	}
	
	@SuppressWarnings("resource")
	private static boolean printUsersWithThisPlanType(CustomPlan planType) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Do you want to see Clients or Instructors? (C/I):");
	    String choice = scanner.nextLine().toUpperCase();
	    
	    System.out.println("\nUsers with subscription plan: " + planType);
	    System.out.println("=======================================");
	    
	    if (choice.equals("C")) {
	        userTupe = "C";
	        App.getClientsMap().values().stream()
	                .filter(client -> client.getSubscriptionPlan() != null && client.getSubscriptionPlan().getPlanType() != null
	                        && client.getSubscriptionPlan().getPlanType().getName().equals(planType.getName()))
	                .forEach(client -> System.out.println("Client: " + client.getUsername() + " - Logins: " + client.getLogins()));
	    } else if (choice.equals("I")) {
	        userTupe = "I";
	        App.getInstructorsMap().values().stream()
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
	
	@SuppressWarnings("resource")
	private static boolean selectUserToUpdateHisSubscriptionPlan() {
        boolean isFound = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the username of the user you want to update:");
        String username = scanner.nextLine();
        
        User user = null;
        if(userTupe.equals("C")) {
        	user = App.getClientsMap().get(username);
        } else if (userTupe.equals("I")) {
        	user = App.getInstructorsMap().get(username);
        }
        
        if (user != null) {
            System.out.println("User found: " + username);
            SubscriptionManagementControls.user = user;
            isFound = true;
        } else {
            System.out.println("User not found.");
            SubscriptionManagementControls.user = null;
            isFound = false;
        }
        
        return isFound;
	}
	
	public static <T extends User> boolean updateUserSubscriptionPlan(SubscriptionPlan subscriptionPlan, T user,
			String newPlanType, boolean justRenew, boolean renewAndReverseSubscription) {
		
		boolean isUpdated = false;
        if (subscriptionPlan != null) {
        	if(renewAndReverseSubscription && !justRenew) {
            	subscriptionPlan.setPlanType(App.getSubscriptionPlanMap().get(newPlanType));
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
	
	public static <T extends User> void giveTheUserNewSubscriptionOpportunity(SubscriptionPlan subscriptionPlan, T user) {
    	int login = user.getLogins();
        if (subscriptionPlan != null) {
        	double price = subscriptionPlan.getPlanType().getPrice();
            int freeOpportunityDays = calculateFreeOpportunity(price);
            
            login = user.getLogins();
            login -= freeOpportunityDays;
            user.setLogins(login);
            System.out.println("User " + user.getUsername() + " has received " + freeOpportunityDays + " free days.");
        }
    }
	
	private static int calculateFreeOpportunity(double price) {
	    int baseFreeDays = 3;
	    int multiplier = (int) (price / 30);
	    
	    if (multiplier < 1) {
	        return baseFreeDays;
	    }
	    
	    return baseFreeDays * multiplier;
	}
}