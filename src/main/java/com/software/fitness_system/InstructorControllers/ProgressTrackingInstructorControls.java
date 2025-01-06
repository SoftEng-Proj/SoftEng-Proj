package com.software.fitness_system.InstructorControllers;
import java.util.List;
import java.util.Map;

import com.software.fitness_system.App;
import com.software.fitness_system.Client;
import com.software.fitness_system.ClientControllers.FitnessMilestone;
import com.software.fitness_system.ClientControllers.Profile;


/**
 *  Provides the controls for the progress tracking page where it allows us to 
 *  view the clients' progress, send a reminder to a client, or send a recommendation.
 * 
 * 
 * 
 * @author Ammar Shafii
 */
public class ProgressTrackingInstructorControls {
	private static List<FitnessMilestone> progressList = App.getMilestonesList();
	private static Map<String, String>   reminderList= App.getInstructorReminderMap();
	private static Map<String, String>   recommendationList= App.getInstructorRecommednationMap();
	private static Map<String, Profile>   client= App.getClientProfileMap();
	private static Map<String, Client>   clientt= App.getClientsMap();


    private static boolean checkIfReceived= false;
    private static boolean receivedRecomm= false;
    
    
    
    /**
	 *  Gets the clients' milestones.
	 * @return progressList The client's milestones.
	 */
	public static List<FitnessMilestone> getMilestones() {
        return progressList;
    }
	
	
	
	/**
	 *  Sends a reminder for the client.
	 * @param clientName Name of the client
	 * @param reminderMessage The reminder message
	 * 
	 * 
	 * @return true When a client is found, false otherwise
	 */
	public static boolean sendReminder(String clientName, String reminderMessage) {
		if (client.containsKey(clientName)||clientt.containsKey(clientName)) {
        reminderList.put(clientName, reminderMessage);
        checkIfReceived=true;
        
        System.out.println("The reminder for:" +clientName+ "is sent.");
        return true;
		}
		else {
			System.out.println("Client not found");
			return false;
		}
    }
	
	/**
	 *  For test purposes.
	 * 
	 * @return true When a reminder is received, false otherwise
	 */
	public static boolean ReceivedCheck() {
		//client.put("Ali", null);
     //   sendReminder("Ali","Test");
        if (checkIfReceived==true) {
            return true;
        }
        return false;
	}
	
	
	/**
	 *  Send a recommendation for the client.
	 * @param clientName Name of the client
	 * @param recommendationMessage The recommendation message
	 * 
	 * 
	 * @return true When a client is found, false otherwise
	 */
	public static boolean sendRecommendation(String clientName, String recommendationMessage) {
		if (client.containsKey(clientName)||clientt.containsKey(clientName)) {
        recommendationList.put(clientName, recommendationMessage);
        receivedRecomm=true;
        System.out.println("The recommendation for:" +clientName+ "is sent.");

        return true;
		}
		else {
			System.out.println("Client not found");

			return false;
		}
    }
	
	/**
	 *  For test purposes, ensures a client exists to check if reminder works.
	 * @param name Name of the client
	 * @param msg The reminder message
	 * 
	 * 
	 * @return true When a reminder is sent, false otherwise.
	 */
	public static boolean Reminderr(String name, String msg) {
        client.put(name, null);
        sendReminder(name,msg);
        return true;
	}
        
        
	/**
	 *  For test purposes, ensures a client exists to check if recommendation works.
	 * @param namee Name of the client
	 * @param msgg The reminder message
	 * 
	 * 
	 * @return true when a recommendation is sent, false otherwise.
	 */
        public static boolean Recommendationn(String namee, String msgg) {
            client.put(namee, null);
            sendRecommendation(namee,msgg);
            return true;
        
	}
        
        public static boolean ReceivedRecommCheck() {
    		
            if (receivedRecomm==true) {
                return true;
            }
            return false;
    	}
	
}