package com.Software.FitnessSystem.ClientControllers;

import java.util.List;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;

public class ProgressTrackingControls {
	private static List<FitnessMilestone> milestones = App.getMilestonesList();

    public static String addMilestone(String type, String value, String date, Client client) {
        FitnessMilestone milestone = new FitnessMilestone(type, value, date, client);
        milestones.add(milestone);
        System.out.println("Milestone added: " + milestone);
        return "milestone added successfully";
    }

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