package com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.Content;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Content Management Controls for handling tips and feedback.
 * @author Muath Hassoun
 */
public class ContentManagementControls {
    /**
     * Static flag indicating whether there are pending tips to review.
     */
    private static boolean thereIsPendingTip = false;
    
    /**
     * Map holding the approved tips, indexed by their IDs.
     */
    private static Map<String, Content> approvedTips = new HashMap<>();
    
    /**
     * Map holding the handled feedback, indexed by feedback IDs.
     */
    private static Map<String, String> handledFeedback = new HashMap<>();
    
    /**
     * Sets the map of approved tips.
     * @author Muath Hassoun
     * @param approvedTips A map of tip IDs to their corresponding Content objects.
     */
    public static void setApprovedTipsMap(Map<String, Content> approvedTips) {
        ContentManagementControls.approvedTips = approvedTips;
    }
    
    /**
     * Sets the map of handled feedback.
     * @author Muath Hassoun
     * @param handledFeedback A map of feedback IDs to their responses.
     */
    public static void setHandledFeedbackMap(Map<String, String> handledFeedback) {
        ContentManagementControls.handledFeedback = handledFeedback;
    }
    
    /**
     * Deals with content types, either reviewing feedback or approving/rejecting tips.
     * @author Muath Hassoun
     * @param tips The map of tips or feedback to review.
     * @param isForFeedbacks True if the content is for feedback, false if for tips.
     */
    public static void dealWithContentTypes(Map<String, Content> tips, boolean isForFeedbacks) {
        if (reviewArticleAndTips(tips)) {
            printTips(tips);
            if (isForFeedbacks) {
                respondToFeedback(approvedTips);
            } else {
                approveOrRejectTheTips(approvedTips);
            }
        }
    }
    
    /**
     * Reviews articles and tips to determine if there are any to process.
     * @author Muath Hassoun
     * @param tips The map of tips to review.
     * @return True if there are tips to review, false if none.
     */
    public static boolean reviewArticleAndTips(Map<String, Content> tips) {
    	if(tips == null || tips.isEmpty()) {
    		return false;
    	}
        thereIsPendingTip = true;

        if (tips.isEmpty()) {
            System.out.println("There's nothing to review.");
            return thereIsPendingTip;
        } else {
            thereIsPendingTip = true;
            return true;
        }
    }
    
    /**
     * Provides access to print the tips.
     * @author Muath Hassoun
     * @param tips The map of tips to print.
     */
    public static void accessToPrinter(Map<String, Content> tips) {
        printTips(tips);
    }
    
    /**
     * Prints the details of all the outstanding tips.
     * @author Muath Hassoun
     * @param tips The map of tips to print.
     */
    private static void printTips(Map<String, Content> tips) {
        System.out.println("\nReview of outstanding contents:\n");
        for (Map.Entry<String, Content> entry : tips.entrySet()) {
            String key = entry.getKey();
            Content content = entry.getValue();
            thereIsPendingTip = true;
            
            System.out.printf("Content ID: %s%n", key);
            System.out.printf("Type: %s%n", content.getContentType());
            System.out.printf("Description: %s%n", content.getContentDescription());
            System.out.println("---------------------------");
        }
    }
    
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
     * Marks a tip as approved and moves it to the approved tips map.
     * @author Muath Hassoun
     * @param id The ID of the tip to approve.
     * @param tips The map of tips to review.
     */
    private static void isApprovedTip(String id, Map<String, Content> tips) {
        System.out.println("Tip ID " + id + " approved.");
        approvedTips.put(id, tips.get(id));
        tips.remove(id);
    }
    
    /**
     * Marks a tip as rejected and removes it from the tips map.
     * @author Muath Hassoun
     * @param id The ID of the tip to reject.
     * @param tips The map of tips to review.
     */
    private static void isRejectedTip(String id, Map<String, Content> tips) {
        System.out.println("Tip ID " + id + " rejected.");
        tips.remove(id);
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
     * Handles a specific feedback by responding based on its content type and marking it as handled.
     * @author Muath Hassoun
     * @param id The ID of the feedback to handle.
     * @param userFeedbackMap The map of feedback to review.
     */
    private static void handleSelectFeedback(String id, Map<String, Content> userFeedbackMap) {
        Content feedback = userFeedbackMap.get(id);
        if (feedback != null) {
            String respondText = "";
            if ("Complaint".equals(feedback.getContentType())) {
                respondText = "We are sorry for the inconvenience. We are looking into your complaint.";
                System.out.println(id + " :Feedback handled successfully!");
            } else if ("Suggestion".equals(feedback.getContentType())) {
                respondText = "Thank you for your valuable suggestion. We will consider it.";
                System.out.println(id + " :Feedback handled successfully!");
            } else {
                respondText = "Thank you for your positive feedback!";
                System.out.println(id + " :Feedback handled successfully!");
            }
            userFeedbackMap.remove(id);
            handledFeedback.put(id, respondText);
        } else {
            System.out.println("No feedback found with the specified ID.");
        }
    }
}