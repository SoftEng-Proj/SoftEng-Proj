package com.software.fitness_system.admin_controllers;
import java.util.HashMap;
import java.util.Map;

import com.software.fitness_system.Content;

/**
 * Content Management Controls for handling tips and feedback.
 * @author Muath Hassoun
 */
public class ContentManagementControls {
    private static boolean thereIsPendingTip = false;
    public static Map<String, Content> approvedTips = new HashMap<>();
    public static Map<String, String> handledFeedback = new HashMap<>();
    
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
    public static void printTips(Map<String, Content> tips) {
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
     * Handles a specific feedback by responding based on its content type and marking it as handled.
     * @author Muath Hassoun
     * @param id The ID of the feedback to handle.
     * @param userFeedbackMap The map of feedback to review.
     */
    public static boolean handleSelectFeedback(String id, Map<String, Content> userFeedbackMap) {
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
            return true;
        } else {
            System.out.println("No feedback found with the specified ID.");
            return false;
        }
    }
}