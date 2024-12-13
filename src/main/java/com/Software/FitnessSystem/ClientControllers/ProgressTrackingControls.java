package com.Software.FitnessSystem.ClientControllers;

import java.util.ArrayList;
import java.util.List;

public class ProgressTrackingControls {
	private static List<FitnessMilestone> milestones;

    public ProgressTrackingControls() {
        ProgressTrackingControls.milestones = new ArrayList<>();
    }

    public static String addMilestone(String type, String value, String date) {
        FitnessMilestone milestone = new FitnessMilestone(type, value, date);
        milestones.add(milestone);
        System.out.println("Milestone added: " + milestone);
        return "milestone added successfully";
    }

    public  void showProgress() {
        if (milestones.isEmpty()) {
            System.out.println("No milestones recorded yet.");
            return;
        }

        System.out.println("Your Fitness Milestones:\n");
        for (var x : milestones) {
            System.out.println(x + "\n");
        }
    }
}