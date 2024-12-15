package com.Software.FitnessSystem.InstructorControllers;

import java.util.Map;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;

public class InteractForInstructorControls {
	
	
	private static Map<String, String> InstructorMessages = App.getInstructorMessagesForClientMap();
	private static Map<String, String> InstructorFeedback= App.getFeedbackToClientMap();
	private static Map<String, Client> clientsMap = App.getClientsMap();
	private static Map<String, Program> programMap = App.getFitnessProgramsMap();
	private static Map<String, String> progressMap = App.getProgressListMap();
	private static Map<String, String> ForumMessages= App.getProgramForumMsgsMap();

	private static boolean MSGG=false;
	private static boolean Clienntt=false;
	private static boolean prgs=false;
	private static boolean Feedbackprovided=false;


	
	 public static String sendMessageToClient(String clientName, String message) {
	       
		 if (clientsMap.containsKey(clientName)) {
	            InstructorMessages.put(clientName, message);
	            System.out.println("Message sent to \"" + clientName + "\": " + message);
	            MSGG=true;
	            return "Message sent";
	        } else {
	            System.out.println("Error: Client \"" + clientName + "\" does not exist. Please check the name and try again.");
	            return "Message not sent";
	        }
		 
	    }
	 
	 public static String sendMessageToProgramForum(String programname, String message)  {
		 
		 if (programMap.containsKey(programname)) {
	            ForumMessages.put(programname, message);
	            System.out.println("Message sent to \"" +programname + "\": " + message);
	            return "Forum sent";
	        } else {
	            System.out.println("Error: Client \"" + programname + "\" does not exist. Please check the name and try again.");
	            return "Forum not sent";
	        }
		 
	    }
		 
	 
	 public static String sendFeedbackToClient(String clientName, String feedback) {
	        if (clientsMap.containsKey(clientName)) {
	        	InstructorFeedback.put(clientName, feedback);
	            System.out.println("Feedback sent to \"" + clientName + "\": " + feedback);
	            Clienntt=true;
	            Feedbackprovided=true;
	            return "Feedback sent";
	        } else {
	            System.out.println("Error: Client \"" + clientName + "\" does not exist. Please check the name and try again.");
	            return "Feedback not sent";
	        }
	    }
	 
	 
	 public static String sendProgressToClient(String clientName, String message) {
	       
		 if (clientsMap.containsKey(clientName)) {
	            progressMap.put(clientName, message);
	            System.out.println("Progress sent to \"" + clientName + "\": " + message);
	            Clienntt=true;
	            prgs=true;
	            return "Progress sent";
	        } else {
	            System.out.println("Error: Client \"" + clientName + "\" does not exist. Please check the name and try again.");
	            return "not sent";
	        }
		 
	    }
	 
	 public static boolean MSGisVisible() {
		 if (MSGG==true) {
			 return true;
		 }
		 else {
			 return false;
		 } 
	 }
	 
	 public static boolean isClient() {
		 if (Clienntt==true) {
			 return true;
		 }
		 else {
			 return false;
		 } 
	 }
	 
	 public static boolean ProgressReview() {
		 if (prgs==true) {
			 return true;
		 }
		 else {
			 return false;
		 } 
	 }
	 
	 public static boolean Feedbackprovide() {
		 if (Feedbackprovided==true) {
			 return true;
		 }
		 else {
			 return false;
		 } 
	 }
	 
	 
	 
	 


}
