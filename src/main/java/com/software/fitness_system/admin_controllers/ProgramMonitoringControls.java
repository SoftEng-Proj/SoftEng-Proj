package com.software.fitness_system.admin_controllers;
import static com.software.fitness_system.App.*;

import java.util.AbstractMap;
import java.util.Map;

/**
 * Provides administrative controls for monitoring fitness program enrollment, 
 * generating reports, and tracking the status of programs (Active or Completed).
 * Includes functionalities to display all programs, view enrollment statistics,
 * and generate detailed reports.
 * <p>
 * This class relies on `ProgramEnrollment` for data representation.
 * <p>
 * Author: Muath Hassoun
 */
public class ProgramMonitoringControls {
    private static boolean areProgramsDisplayed = true;
    private static boolean hasItBeenDisplayed = true;
    private static boolean isReportsPrinted = false;
    private static boolean isProgramStatusPrinted = false;
    
    /**
     * Displays all fitness programs.
     * 
     * @return true if programs were successfully displayed; false otherwise.
     */
    public static boolean viewAllPrograms() {
        areProgramsDisplayed = true;
        Map<String, ProgramEnrollment> programs = getProgramEnrollmentMap();
        
        if (programs.isEmpty()) {
            System.out.println("No programs available to display.");
            areProgramsDisplayed = false;
            return false;
        }

        System.out.println("\n--- All Fitness Programs ---");
        printPrograms(programs, false);

        return areProgramsDisplayed;
    }

    /**
     * Checks if all programs are currently visible.
     * 
     * @return true if programs are displayed; false otherwise.
     */
    public static boolean areAllProgramsVisible() {
        return areProgramsDisplayed;
    }
    
    /**
     * Displays statistics of programs, sorted by the number of enrollments.
     * 
     * @return true if statistics were successfully displayed; false otherwise.
     */
    public static boolean viewTheEnrollmentStatistics() {
        hasItBeenDisplayed = true;
        Map<String, ProgramEnrollment> programs = getProgramEnrollmentMap();

        if (programs.isEmpty()) {
            System.out.println("No programs available to display.");
            hasItBeenDisplayed = false;
            return false;
        }

        System.out.println("\n--- Most Popular Programs by Enrollment ---");
        printPrograms(programs, true);

        return hasItBeenDisplayed;
    }
    
    /**
     * Checks if the enrollment statistics are displayed.
     * 
     * @return true if statistics are displayed; false otherwise.
     */
    public static boolean verifyIsDisplayed() {
        return hasItBeenDisplayed;
    }

    /**
     * Prints a list of fitness programs.
     * 
     * @param programs The map of programs to print.
     * @param isLimited If true, limits the display to the top 6 programs.
     */
    public static void printPrograms(Map<String, ProgramEnrollment> programs, boolean isLimited) {
		int counter = isLimited ? 6 : programs.size();
		
		programs.entrySet().stream()
        .sorted((e1, e2) ->
            Integer.compare(
                e2.getValue().getEnrollments(),
                e1.getValue().getEnrollments()
            )
        )
        .limit(counter)
        .forEach(entry ->
            System.out.println(
                "Program: " + entry.getKey() +
                ", Enrollments: " + entry.getValue().getEnrollments() +
                ", Status: " + entry.getValue().getStatus()
            ));
	}
    
    public static void accessToPrintPrograms(Map<String, ProgramEnrollment> programs, boolean isLimited) {
		printPrograms(programs, isLimited);
	}
	
    /**
     * Generates reports for all programs or a specific program.
     * 
     * @param programs The map of programs to generate reports for.
     * @param specifiedProgramName The name of the specific program (if any).
     * @param isSpecified If true, generates a report for a specific program.
     * @return true if reports were generated; false otherwise.
     */
    public static boolean generateReportsOption(Map<String, ProgramEnrollment> programs, String specifiedProgramName, boolean isSpecified) {
        isReportsPrinted = false;
        
        if (!isSpecified) {
            System.out.println("--- Reports on Revenue, Attendance, and Client Progress ---");
            for (Map.Entry<String, ProgramEnrollment> entry : programs.entrySet()) {
                printTheReport(entry);
                isReportsPrinted = true;
            }
        } else {
            System.out.println("--- Report on Revenue, Attendance, and Client Progress ---");
            ProgramEnrollment specifiedProgram = programs.get(specifiedProgramName);

            if (specifiedProgram != null) {
                Map.Entry<String, ProgramEnrollment> entry = new AbstractMap.SimpleEntry<>(specifiedProgramName, specifiedProgram);
                printTheReport(entry);
                isReportsPrinted = true;
            }
        }

        return isReportsPrinted;
    }
    
    public static boolean getIsReportsPrinted() {
		return isReportsPrinted;
	}

    /**
     * Prints a detailed report for a program.
     * 
     * @param entry The program entry to print the report for.
     */
    private static void printTheReport(Map.Entry<String, ProgramEnrollment> entry) {
        String programName = entry.getKey();
        ProgramEnrollment program = entry.getValue();
        
        double revenue = program.getEnrollments() * 20.0;
        int attendance = program.getEnrollments();
        String clientProgress = "Good";

        Report report = new Report(programName, revenue, attendance, clientProgress);
        report.displayReport();
    }

    /**
     * Tracks active and completed programs.
     * 
     * @param programs The map of programs to track.
     * @return true if the program statuses were tracked; false otherwise.
     */
    public static boolean trackActiveAndCompletedPrograms(Map<String, ProgramEnrollment> programs) {
        isProgramStatusPrinted = false;
        System.out.println("\n--- Active Programs ---");
        trackActivePrograms(programs);
        System.out.println("\n--- Completed Programs ---");
        trackCompletedPrograms(programs);
        isProgramStatusPrinted = true;
        return true;
    }
    
    /**
     * @param programs The map of programs to track.
     */
    private static void trackActivePrograms(Map<String, ProgramEnrollment> programs) {
        programs.entrySet().stream()
            .filter(entry -> entry.getValue().getStatus().equalsIgnoreCase("Active"))
            .forEach(entry ->
                System.out.println("Program: " + entry.getKey() + ", Enrollments: " + entry.getValue().getEnrollments()));
    }
    
    /**
     * @param programs The map of programs to track.
     */
    private static void trackCompletedPrograms(Map<String, ProgramEnrollment> programs) {
        programs.entrySet().stream()
            .filter(entry -> entry.getValue().getStatus().equalsIgnoreCase("Completed"))
            .forEach(entry ->
                System.out.println("Program: " + entry.getKey() + ", Enrollments: " + entry.getValue().getEnrollments()));
    }
    
    public static boolean getIsProgramStatusPrinted(){
        return isProgramStatusPrinted;
	}
}