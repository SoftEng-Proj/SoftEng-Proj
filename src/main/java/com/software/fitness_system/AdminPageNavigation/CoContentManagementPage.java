package com.software.fitness_system.AdminPageNavigation;
import static com.software.fitness_system.AdminControllers.ContentManagementControls.*;

import java.util.Map;
import java.util.Scanner;

import com.software.fitness_system.Content;

/**
 * Represents the Co-Content Management page for the admin in the fitness system.
 * This page enables the admin to oversee and moderate content shared by instructors or users,
 * ensuring that the platform maintains quality and adheres to community guidelines.
 * 
 * @author Muath Hassoun
 */
public class CoContentManagementPage {
    /**
     * Prompts the user to approve or reject a list of tips based on their IDs.
     * @author Muath Hassoun
     * @param tips The map of tips to review.
     * @return True if any tips were approved or rejected, false if no action was taken.
     */
    public static boolean approveOrRejectTheTips(Map<String, Content> tips) {
    	if(tips == null || tips.isEmpty()) {
    		return false;
    	}
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the Tip IDs to approve/reject, separated by commas: ");
        String input = scanner.nextLine();
        String[] idsToReview = input.split(",");
        
        boolean is = false;
        for (String id : idsToReview) {
            id = id.trim();
            if (tips.containsKey(id)) {
                System.out.print("Do you approve or reject Tip ID " + id + "? (approve/reject): ");
                String decision = scanner.nextLine().trim().toLowerCase();
                
                if ("approve".equals(decision)) {
                	isApprovedTip(id, tips);
                    is = true;
                } else if ("reject".equals(decision)) {
                	isRejectedTip(id, tips);
                    is = true;
                } else {
                    System.out.println("Invalid choice for Tip ID " + id + ". Skipping...");
                    is = false;
                }
            } else {
                System.out.println("Tip ID '" + id + "' does not exist.");
                is = true;
            }
        }
        
        return is;
    }
    
    /**
     * Prompts the user to handle feedback by responding to a list of feedback IDs.
     * @author Muath Hassoun
     * @param tips The map of tips (which are feedback in this case) to handle.
     * @return True if feedback was successfully handled, false otherwise.
     */
    public static boolean respondToFeedback(Map<String, Content> tips) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the Feedback IDs to handle, separated by commas: ");
        String input = scanner.nextLine();
        String[] idsToReview = input.split(",");
        
        boolean is = true;
        for (String id : idsToReview) {
            id = id.trim();
            if (tips.containsKey(id)) {
            	handleSelectFeedback(id, tips);
                is = true;
            } else {
                System.out.println("Feedback ID '" + id + "' does not exist.");
                is = false;
            }
        }
        
        return is;
    }
    
    /**
     * Marks a tip as approved and moves it to the approved tips map.
     * @author Muath Hassoun
     * @param id The ID of the tip to approve.
     * @param tips The map of tips to review.
     */
    public static boolean isApprovedTip(String id, Map<String, Content> tips) {
        System.out.println("Tip ID " + id + " approved.");
        approvedTips.put(id, tips.get(id));
        tips.remove(id);
        return true;
    }
    
    /**
     * Marks a tip as rejected and removes it from the tips map.
     * @author Muath Hassoun
     * @param id The ID of the tip to reject.
     * @param tips The map of tips to review.
     */
    public static boolean isRejectedTip(String id, Map<String, Content> tips) {
        System.out.println("Tip ID " + id + " rejected.");
        tips.remove(id);
        return true;
    }
}