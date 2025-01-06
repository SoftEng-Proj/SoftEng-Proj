package com.software.fitness_system.AdminControllers;
import static com.software.fitness_system.App.*;

import com.software.fitness_system.User;

/**
 * Provides controls for managing subscription plans and user subscriptions.
 * Includes functionality for adding, editing, deleting, and viewing subscription plans,
 * as well as updating user subscription details.
 * 
 * @author Muath Hassoun
 */
public class SubscriptionManagementControls {
	private static boolean isPrinted = false;
	public static String userTupe = "";
	public static User user;
	
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
     * Adds a subscription plan to the subscription map.
     *
     * @param planName    the name of the subscription plan (must be unique).
     * @param price       the price of the subscription plan.
     * @param duration    the duration of the subscription plan (in days).
     * @param description a brief description of the subscription plan.
     * @return true if the plan is successfully added; false otherwise.
     */
	public static boolean doAdding(String planName, double price, int duration, String description) {
		CustomPlan newCustomPlan = new CustomPlan(planName, price, duration, description);
        getSubscriptionPlanMap().put(planName, newCustomPlan);
        return true;
	}
	
	/**
	 * Processes amendments to subscription plan properties.
	 * Can include logging, validation, or applying additional rules.
	 * 
	 * @param data The new value to be set
	 * @param plan Subscription plan to be updated
	 * @param type The type of property being modified (e.g., "price", "duration", "description")
	 * @return true if the amendment is successful; false otherwise
	 */
	public static <T> boolean doAmendment(T data, CustomPlan plan, String type) {
	    try {
	        switch (type.toLowerCase()) {
	            case "price" -> {
	                if (data instanceof Double) {
	                    plan.setPrice((double) data);
	                    logAmendment(type, data);
	                    return true;
	                }
	            }
	            case "duration" -> {
	                if (data instanceof Integer) {
	                    plan.setDuration((int) data);
	                    logAmendment(type, data);
	                    return true;
	                }
	            }
	            case "description" -> {
	                if (data instanceof String) {
	                    plan.setDescription((String) data);
	                    logAmendment(type, data);
	                    return true;
	                }
	            }
	            default -> {
	                System.err.println("Invalid property type: " + type);
	            }
	        }
	    } catch (Exception e) {
	        System.err.println("Type mismatch for property: " + type + ". Expected a different type.");
	    }
	    return false;
	}
	
	/**
	 * Logs the details of an amendment.
	 * 
	 * @param type The type of property being modified
	 * @param data The new value of the property
	 */
	private static <T> void logAmendment(String type, T data) {
	    System.out.println("Successfully updated " + type + " to: " + data);
	}
	
	/**
     * Prints the updated details of a subscription plan after editing.
     * 
     * @param plan The subscription plan that was updated.
     */
	public static void amendedPlanPrinting(CustomPlan plan) {
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
	public static boolean doRemoving(String planName) {
		getSubscriptionPlanMap().remove(planName);
        return true;
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
}