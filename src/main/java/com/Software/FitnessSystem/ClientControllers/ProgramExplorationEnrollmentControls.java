package com.Software.FitnessSystem.ClientControllers;

import java.util.Map;
import java.util.Scanner;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.InstructorControllers.Program;
import com.Software.FitnessSystem.Client;

/**
 * This class helps clients explore and enroll in fitness programs
 * 
 * @author Alaa Alawneh
 */
public class ProgramExplorationEnrollmentControls {
    private static Map<String, Program> programs = App.getFitnessProgramsMap();

    private static Client currentClient;

    /**
     * Constructor to set the current client
     *
     * @param currentClient The client who is using this feature
     */
    public ProgramExplorationEnrollmentControls(Client currentClient) {
        ProgramExplorationEnrollmentControls.currentClient = currentClient;
    }

    /**
     * This method filters fitness programs by difficulty level
     * It shows all the programs that match the given difficulty
     *
     * @param difficulty The difficulty level to filter by
     * @return A message saying programs were filtered by difficulty
     */
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

    /**
     * This method filters fitness programs by their focus area
     * It shows all the programs that match the given focus area
     *
     * @param focusArea The focus area to filter by
     * @return A message saying programs were filtered by focus area
     */
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

    /**
     * This method lets the client enroll in a fitness program
     * The user can choose a program from a list of available programs
     *
     * @return A message saying the enrollment was successful or null if unsuccessful
     */
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
        return "enrolled in program successfully";
    }

    /**
     * This method shows the schedule of a specific program
     *
     * @param programName The name of the program whose schedule you want to see
     * @return A message saying the schedule was displayed or an error message if the program was not found
     */
    public static String viewProgramSchedule(String programName) {
        for (Program program : programs.values()) {
            if (program.getName().equalsIgnoreCase(programName)) {
                System.out.println("Schedule for Program \"" + programName + "\": " + program.getSchedule());
                return programName;
            }
        }

        System.out.println("Program named \"" + programName + "\" not found.");
        return "program schedule displayed successfully";
    }
}
