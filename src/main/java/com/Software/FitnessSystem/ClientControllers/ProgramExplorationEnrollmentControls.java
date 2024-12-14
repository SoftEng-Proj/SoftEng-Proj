package com.Software.FitnessSystem.ClientControllers;

import java.util.Map;
import java.util.Scanner;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.InstructorControllers.Program;
import com.Software.FitnessSystem.Client;

public class ProgramExplorationEnrollmentControls {
	private static Map<String, Program> programs = App.getFitnessProgramsMap();
	private static Client currentClient;
	
	public ProgramExplorationEnrollmentControls(Client currentClient) {
        ProgramExplorationEnrollmentControls.currentClient = currentClient;
    }

	public static String filterProgramsByDifficulty(String difficulty) {
		System.out.println("\nPrograms matching difficulty level: " + difficulty);
	    for (Program program : programs.values()) {
	        if (program.getLevel().equalsIgnoreCase(difficulty)) {
	            System.out.println("Program Name: " + program.getName());
	            System.out.println("Goal: " + program.getGoal());
	            System.out.println("Difficulty: " + program.getLevel());
	            System.out.println();
	        }
	    }
	    return "Programs filtered By Difficulty";

    }

    public static String filterProgramsByFocusArea(String focusArea) {
    	System.out.println("\nPrograms focusing on: " + focusArea);
        for (Program program : programs.values()) {
            if (program.getGoal().equalsIgnoreCase(focusArea)) {
                System.out.println("Program Name: " + program.getName());
                System.out.println("Goal: " + program.getGoal());
                System.out.println("Difficulty: " + program.getLevel());
                System.out.println();
            }
        }
        return "Programs filtered By focus area";
    }

    public static String enrollInProgram() {
        if (currentClient == null) {
            System.out.println("No client found!");
            return null;
        }

        System.out.println("Available Fitness Programs:");
        int i = 1;
        for (Map.Entry<String, Program> entry : programs.entrySet()) {
            Program program = entry.getValue();
            System.out.println(i + ". " + program.getName());
            System.out.println("   Duration: " + program.getDuration());
            System.out.println("   Level: " + program.getLevel());
            System.out.println("   Goal: " + program.getGoal());
            System.out.println("   Price: " + program.getPrice());
            System.out.println("   Schedule: " + program.getSchedule());
            System.out.println("   Links: " + program.getLinks());
            System.out.println("   End Date: " + program.getEndAt());
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of the program you want to enroll in:");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > programs.size()) {
            System.out.println("Invalid program selection.");
            return null;
        }

        Program selectedProgram = (Program) programs.values().toArray()[choice - 1];
        currentClient.setEnrolledProgram(selectedProgram);
        System.out.println(currentClient.getUsername() + " has been enrolled in the " + selectedProgram.getName() + " program.");

        App.saveAccountChanges();
        return "enrolled in program succsesfully";
    }

    public static String viewProgramSchedule(String programName) {
        for (Program program : programs.values()) {
            if (program.getName().equalsIgnoreCase(programName)) {
                System.out.println("Schedule for Program \"" + programName + "\": " + program.getSchedule());
                return programName;
            }
        }
        System.out.println("Program named \"" + programName + "\" not found.");
        return "program schedule displayed succsesfully";
    }
    
}
