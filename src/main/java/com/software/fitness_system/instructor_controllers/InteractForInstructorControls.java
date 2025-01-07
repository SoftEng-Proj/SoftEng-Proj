package com.software.fitness_system.instructor_controllers;

import java.util.Map;

import com.software.fitness_system.App;
import com.software.fitness_system.basics.Client;

/**
 * It provides the controls for the InteractForInstructorPage to be able to send
 * a message to a client, post on a program forum, send feedback to a client, or send
 * a progress report. 
 * 
 * 
 * @author Ammar Shafii
 */
public class InteractForInstructorControls {
	
	
	private static Map<String, String> InstructorMessages = App.getInstructorMessagesForClientMap();
	private static Map<String, String> InstructorFeedback= App.getFeedbackToClientMap();
	private static Map<String, Client> clientsMap = App.getClientsMap();
	private static Map<String, Program> programMap = App.getFitnessProgramsMap();
	private static Map<String, String> progressMap = App.getProgressListMap();
	private static Map<String, String> ForumMessages= App.getProgramForumMsgsMap();

	private static boolean MSGG=false;
	private static boolean prgs=false;
	private static boolean Feedbackprovided=false;
	private static boolean isForumPage=false;


	/**
     * It sends a message to a client.
     * 
     * @return "Message sent" if client exists, "Message not sent" if client doesn't exist.
     * @param clientName Name of client
     * @param message The message to send.
     */
	 public static String sendMessageToClient(String clientName, String message) {
		 MSGG = false;
		   if (clientsMap.containsKey(clientName)) {
	            InstructorMessages.put(clientName, message);
	            System.out.println("Message sent to \"" + clientName + "\": " + message);
	            MSGG=true;
	            return "Message sent";
	       } else {
	            return "Message not sent";
	       }
	 }
	 
	 /**
	     * It posts a message on a program discussion forum
	     * 
	     * @return "Forum sent" if program exists, "Forum not sent" if prorgam doesn't exist.
	     * @param programname Name of program
	     * @param message The message to send.
	     */
	 public static String sendMessageToProgramForum(String programname, String message)  {
		  isForumPage = true;
		 if (programMap.containsKey(programname)) {
	            ForumMessages.put(programname, message);
	            System.out.println("Message sent to \"" +programname + "\": " + message);
	            return "Forum sent";
	        } else {
	            return "Forum not sent";
	        }
	 }
	 
	 /**
	     * Checks if on forum page or not, for test purposes.
	     * 
	     * @return true if on forum page, false otherwise.
	     * 
	     * 
	     */
	 public static boolean ForumPage() {
		 return isForumPage;
	 }

	 /**
	     * It sends a feedback to a client.
	     * 
	     * @return "Feedback sent" if client exists, "Feedback not sent" if client doesn't exist.
	     * @param clientName Name of client
	     * @param feedback The feedback to send.
	     */
	 public static String sendFeedbackToClient(String clientName, String feedback) {
	        if (clientsMap.containsKey(clientName)) {
	        	InstructorFeedback.put(clientName, feedback);
	            System.out.println("Feedback sent to \"" + clientName + "\": " + feedback);

	            Feedbackprovided=true;
	            return "Feedback sent";
	        } else {
	            return "Feedback not sent";
	        }
	    }
	 
	 
	 /**
	     * It sends a progress message to a client.
	     * 
	     * @return "Progress sent" if client exists, "Progress not sent" if client doesn't exist.
	     * @param clientName Name of client
	     * @param message The progress message to send.
	     */
	 public static String sendProgressToClient(String clientName, String message) {
	       
		 if (clientsMap.containsKey(clientName)) {
	            progressMap.put(clientName, message);
	            System.out.println("Progress sent to \"" + clientName + "\": " + message);
	           
	            prgs=true;
	            return "Progress sent";
	        } else {
	            return "not sent";
	        }
		 
	    }
	 
	 public static boolean MSGisVisible() {
		 return MSGG;
	 }
	 /**
	     * It ensures a client exists for test purposes
	     *   
	     */
	 public static boolean MakeSureOfClient() {
		 clientsMap.put("Omar", new Client("Omar", "Client Details","0","0","0"));
		 return true;
	 }
	 
	 
	 /**
	     * It ensures a program exists for test purposes
	     *   
	     */
	 public static void MakeSureOfProgram() {
		 programMap.put("Fit", new Program ("Fit","10 days","10-5-2024","beginner","0","0","0"));
	 }
	 
	 
	 /**
	     * Checks if a progress message is passed ,for test purposes.
	     * 
	     * @return true if message sent, false otherwise.
	     * 
	     * 
	     */
	 public static boolean ProgressReview() {
		 return prgs;
	 }
	 
	 /**
	     * Checks if a feedback is sent ,for test purposes.
	     * 
	     * @return true if feedback sent, false otherwise.
	     * 
	     * 
	     */
	 public static boolean Feedbackprovide() {
		 return Feedbackprovided;
	 }
}