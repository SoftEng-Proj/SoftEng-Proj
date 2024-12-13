package com.Software.FitnessSystem.AdminControllers;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.Software.FitnessSystem.Content;

public class ContentManagementControls {
	private static boolean thereIsPendingTip = false;
	private static Map<String, Content> approvedTips = new HashMap<>();
	private static Map<String, String> handledFeedback = new HashMap<>();
	
	public static void setApprovedTipsMap(Map<String, Content> approvedTips) {
		ContentManagementControls.approvedTips = approvedTips;
	}
	
	public static void setHandledFeedbackMap(Map<String, String> handledFeedback) {
		ContentManagementControls.handledFeedback = handledFeedback;
	}
	
	public static void dealWithContentTypes(Map<String, Content> tips, boolean isForFeedbacks) {
		if (reviewArticleAndTips(tips)) {
		    printTips(tips);
		    if(isForFeedbacks) {
		    	respondToFeedback(approvedTips);
		    } else {
			    approveOrRejectTheTips(approvedTips);
		    }
		}
	}
	
	public static boolean reviewArticleAndTips(Map<String, Content> tips) {
	    thereIsPendingTip = false;
	    
	    if (tips.isEmpty()) {
	        System.out.println("There's nothing to review.");
	        return thereIsPendingTip;
	    } else {
	    	thereIsPendingTip = true;
		    return thereIsPendingTip;
	    }
	}
	
	public static void accessToPrinter(Map<String, Content> tips) {
		printTips(tips);
	}
	
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
	    
	    return;
	}
	
	@SuppressWarnings("resource")
	public static boolean approveOrRejectTheTips(Map<String, Content> tips) {
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
                is = false;
            }
        }
        
		return is;
	}
	
	private static void isApprovedTip(String id, Map<String, Content> tips) {
		System.out.println("Tip ID " + id + " approved.");
        approvedTips.put(id, tips.get(id));
        tips.remove(id);
	}
	
	private static void isRejectedTip(String id, Map<String, Content> tips) {
		System.out.println("Tip ID " + id + " rejected.");
        tips.remove(id);
	}
	
	@SuppressWarnings("resource")
	public static boolean respondToFeedback(Map<String, Content> tips) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the Feedback IDs to handle, separated by commas: ");
        String input = scanner.nextLine();
        String[] idsToReview = input.split(",");
        
        boolean is = false;
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