package com.software.fitness_system.ClientControllers;
import java.util.Map;

import com.software.fitness_system.App;
import com.software.fitness_system.Client;
import com.software.fitness_system.InstructorControllers.Program;

/**
 * This class helps clients explore and enroll in fitness programs
 * 
 * @author Alaa Alawneh
 */
public class ProgramExplorationEnrollmentControls {
    private static Map<String, Program> programs = App.getFitnessProgramsMap();
    
    /**
     * Constructor
     */
    public ProgramExplorationEnrollmentControls() {
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
        for (Program program : getPrograms().values()) {
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
        for (Program program : getPrograms().values()) {
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
    public static String enrollInProgram(Client client, int programNumber) {
        if (client == null) {
            System.out.println("No client found!");
            return null;
        }
        
        if (programNumber < 1 || programNumber > programs.size()) {
            System.out.println("Invalid program selection.");
            return null;
        }
        
        Program selectedProgram = (Program) programs.values().toArray()[programNumber - 1];
        client.setEnrolledProgram(selectedProgram);
        System.out.println(client.getUsername() + " has been enrolled in the " + selectedProgram.getName() + " program.");
        
        App.saveAccountChanges();
        return "enrolled in program succsesfully";
    }

    /**
     * This method shows the schedule of a specific program
     *
     * @param programName The name of the program whose schedule you want to see
     * @return A message saying the schedule was displayed or an error message if the program was not found
     */
    public static String viewProgramSchedule(String programName) {
        for (Program program : getPrograms().values()) {
            if (program.getName().equalsIgnoreCase(programName)) {
                System.out.println("Schedule for Program \"" + programName + "\": " + program.getSchedule());
                return "program schedule displayed succsesfully";
            }
        }
        
        System.out.println("Program named \"" + programName + "\" not found.");
        return null;
    }

	public static Map<String, Program> getPrograms() {
		return programs;
	}

	public static void setPrograms(Map<String, Program> programs) {
		ProgramExplorationEnrollmentControls.programs = programs;
	}
}