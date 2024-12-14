package com.Software.FitnessSystem.InstructorControllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;

public class ProgressTrackingInstructorControls {
	
	private static List<FitnessMilestone> progressList = App.getMilestonesList();
	private static Map<String, String>   reminderList= App.getInstructorReminderMap();
	private static Map<String, String>   recommendationList= App.getInstructorRcommednationMap();
    private static boolean checkIfReceived= false;
    


	
	public static List<FitnessMilestone> getMilestones() {
        return progressList;
    }
	
	
	public static boolean sendReminder(String clientName, String reminderMessage) {
        
        reminderList.put(clientName, reminderMessage);
        checkIfReceived=true;
        
        return true;
    }
	
public static boolean ReceivedCheck() {
        
        if (checkIfReceived==true) {
        
        return true;
        }
        return false;
    }
	
	
	
	
	
public static boolean sendRecommendation(String clientName, String recommendationMessage) {
        
        recommendationList.put(clientName, recommendationMessage);
        
        return true;
    }
}


