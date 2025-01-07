package com.software.fitness_system.client_controllers;
import java.util.List;

import com.software.fitness_system.App;
import com.software.fitness_system.Client;

/**
 * This class provides controls for managing and tracking fitness progress
 * It allows adding fitness milestones and viewing progress based on the recorded milestones
 * 
 * @author Alaa Alawneh
 */
public class ProgressTrackingControls {
	/**
	  * A list to store the fitness milestones
	  */
	private static List<FitnessMilestone> milestones = App.getMilestonesList();
	/**
     * Default constructor for AccountManagementControls
     * because the class uses static methods no need to make an instance
     */
    public ProgressTrackingControls() {
    	
    }
	/**
     * Add a new fitness milestone to the list of milestones
     *
     * @param type   the type of milestone
     * @param value  the value associated with the milestone
     * @param date   the date the milestone was achieved
     * @param client the client associated with the milestone
     * @return a message indicating the milestone was added successfully
     */
    public static String addMilestone(String type, String value, String date, Client client) {
        FitnessMilestone milestone = new FitnessMilestone(type, value, date, client);
        milestones.add(milestone);
        System.out.println("Milestone added: " + milestone);
        return "milestone added successfully";
    }
    /**
     * Display the progress made by the client based on recorded milestones
     *
     * @return a message summarizing the client's progress or null if no milestone is recorded
     */
    public static String showProgress() {
        if (milestones.isEmpty()) {
            System.out.println("No milestones recorded yet.");
            return null;
        }

        System.out.println("Your Fitness Milestones:\n");
        for (var x : milestones) {
            System.out.println(x + "\n");
        }
        return "You've made so much progress wow!";
    }
}