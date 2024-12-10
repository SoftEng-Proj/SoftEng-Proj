package com.Software.FitnessSystem.ClientControllers;

import java.util.ArrayList;
import java.util.List;

public class ProgressTrackingControls {
	private List<FitnessMilestone> milestones;

    public ProgressTrackingControls() {
        this.milestones = new ArrayList<>();
    }

    public void addMilestone(String type, String value, String date) {
        FitnessMilestone milestone = new FitnessMilestone(type, value, date);
        milestones.add(milestone);
        System.out.println("Milestone added: " + milestone);
    }

    public void showProgress() {
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