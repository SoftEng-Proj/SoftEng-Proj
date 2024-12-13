package com.Software.FitnessSystem.InstructorControllers;

import java.util.Map;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;

public class InteractForInstructorControls {
	
	
	private static Map<String, String> InstructorMessages = App.getInstructorMessagesForClientMap();
	private static Map<String, String> InstructorFeedback= App.getFeedbackToClientMap();
	private static Map<String, Client> clientsMap = App.getClientsMap();
	private static Map<String, Program> programMap = App.getFitnessProgramsMap();

	
	
	 public void sendMessageToClient(String clientName, String message) {
	       
		 if (clientsMap.containsKey(clientName)) {
	            InstructorMessages.put(clientName, message);
	            System.out.println("Message sent to \"" + clientName + "\": " + message);
	        } else {
	            System.out.println("Error: Client \"" + clientName + "\" does not exist. Please check the name and try again.");
	        }
	    }
	 
	 public void sendMessageToProgramForum(String programname, String message)  {
		 
		 if (programMap.containsKey(programname)) {
	            InstructorMessages.put(programname, message);
	            System.out.println("Message sent to \"" +programname + "\": " + message);
	        } else {
	            System.out.println("Error: Client \"" + programname + "\" does not exist. Please check the name and try again.");
	        }
	    }
		 
	 
	 public void sendFeedbackToClient(String clientName, String feedback) {
	        if (clientsMap.containsKey(clientName)) {
	        	InstructorFeedback.put(clientName, feedback);
	            System.out.println("Feedback sent to \"" + clientName + "\": " + feedback);
	        } else {
	            System.out.println("Error: Client \"" + clientName + "\" does not exist. Please check the name and try again.");
	        }
	    }
	 


}
