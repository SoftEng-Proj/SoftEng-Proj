package com.Software.FitnessSystem.AdminControllers;
import static com.Software.FitnessSystem.App.*;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramMonitoringControls {
	private static boolean areProgramsDisplayed = true;
	private static boolean hasItBeenDisplayed = true;
	private static boolean isReportsPrinted = false;
	private static boolean isProgramStatusPrinted = false;
	
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
	
	public static boolean areAllProgramsVisible() {
		return areProgramsDisplayed;
	}
	
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
	
	public static boolean verifyIsDisplayed() {
		return hasItBeenDisplayed;
	}
	
	private static void printPrograms(Map<String, ProgramEnrollment> programs, boolean isLimited) {
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
	
	@SuppressWarnings("resource")
	public static boolean chooseReportGenerationOption() {
		Scanner scanner = new Scanner(System.in);
		printTheGenerateQuestion();
		
		int choice = -1;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice, please choose 1 or 2.");
                    printTheGenerateQuestion();
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number (1 or 2).");
                scanner.nextLine();
                printTheGenerateQuestion();
            }
        }
        
        switch(choice) {
        case 1:
        	System.out.println("Generating report for all programs...");
        	return generateReportsOption(getProgramEnrollmentMap(), "Null", false);
        case 2:
        	System.out.print("\n");
        	printPrograms(getProgramEnrollmentMap(), false);
        	String programName = askTheNameOfTheProgram();
        	System.out.println("\nReport generation in progress for the program: \"" + programName + "\".");
        	return generateReportsOption(getProgramEnrollmentMap(), programName, true);
        case 3:
        	return true;
        }
		return false;
	}
	
	private static void printTheGenerateQuestion() {
		System.err.println("\nDo you want to generate a report for all programs or a specific program?");
        System.err.println("1. All programs");
        System.err.println("2. Specific program");
        System.err.println("3. Go Back.");
        System.err.println(">> Enter your choice: ");
	}
	
	@SuppressWarnings("resource")
	public static String askTheNameOfTheProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the program name:");
        String programName = scanner.nextLine();
        return programName;
    }
	
	public static boolean generateReportsOption(Map<String, ProgramEnrollment> programs, String specifiedProgramName, boolean isSpecified) {
        isReportsPrinted = false;
        
        if(!isSpecified) {
            System.out.println("--- Reports on Revenue, Attendance, and Client Progress ---");
            for (Map.Entry<String, ProgramEnrollment> entry : programs.entrySet()) {
            	printTheReport(entry);
                isReportsPrinted = true;
            }
        } else if(isSpecified) {
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
	
	private static void printTheReport(Map.Entry<String, ProgramEnrollment> entry) {
        String programName = entry.getKey();
        ProgramEnrollment program = entry.getValue();
        
        double revenue = program.getEnrollments() * 20.0;
        int attendance = program.getEnrollments();
        String clientProgress = "Good";
        
        Report report = new Report(programName, revenue, attendance, clientProgress);
        report.displayReport();
	}
	
	public static boolean getIsReportsPrinted() {
		return isReportsPrinted;
	}
	
	public static boolean trackActiveAndCompletedPrograms(Map<String, ProgramEnrollment> programs) {
		isProgramStatusPrinted = false;
        System.out.println("\n--- Active Programs ---");
        trackActivePrograms(programs);
        System.out.println("\n--- Completed Programs ---");
        trackCompletedPrograms(programs);
        isProgramStatusPrinted = true;
        return isProgramStatusPrinted;
    }
	
	private static void trackActivePrograms(Map<String, ProgramEnrollment> programs) {
		programs.entrySet().stream()
        .filter(entry -> entry.getValue().getStatus().equalsIgnoreCase("Active"))
        .forEach(entry ->
        System.out.println(
        		"Program: " + entry.getKey() +
        		", Enrollments: " + entry.getValue().getEnrollments()
        		));
	}
	
	private static void trackCompletedPrograms(Map<String, ProgramEnrollment> programs) {
		programs.entrySet().stream()
        .filter(entry -> entry.getValue().getStatus().equalsIgnoreCase("Completed"))
        .forEach(entry -> 
        System.out.println(
        		"Program: " + entry.getKey() +
        		", Enrollments: " + entry.getValue().getEnrollments()
        		));
	}
	
	public static boolean getIsProgramStatusPrinted(){
        return isProgramStatusPrinted;
	}
}