package com.software.fitness_system.admin_page_navigation;
import static com.software.fitness_system.App.*;
import static com.software.fitness_system.admin_controllers.ProgramMonitoringControls.*;

import java.util.Scanner;

import com.software.fitness_system.infrastructure_for_pages.BasePage;
import com.software.fitness_system.login_page.AdminPagesController;

/**
 * Represents the Program Monitoring page for the admin in the fitness system.
 * This page allows the admin to perform various actions related to monitoring fitness programs,
 * such as viewing programs, generating reports, tracking program statistics, and more.
 * 
 * @author Muath Hassoun
 */
public class ProgramMonitoringPage extends BasePage {
	private final AdminPagesController adminController;
	
	/**
     * Constructor to initialize the ProgramMonitoringPage with the provided AdminPagesController.
     * 
     * @param adminController The controller responsible for managing admin page navigation and actions.
     */
	public ProgramMonitoringPage(AdminPagesController adminController) {
		this.adminController = adminController;
	}
	
	/**
     * Displays the Program Monitoring menu with available options for the admin.
     * The menu includes options for viewing programs, tracking statistics, generating reports, 
     * and returning to the main menu.
     */
	@Override
	public void display() {
	    System.out.println("\nProgram Monitoring Menu:");
	    System.out.println("1. View all programs.");
	    System.out.println("2. View statistics on the most popular programs by enrollment.");
	    System.out.println("3. Generate reports on revenue, attendance, and client progress.");
	    System.out.println("4. Track active and completed programs.");
	    System.out.println("5. Go Back.");
	}
    
	/**
     * Executes the selected option based on the user's choice.
     * Depending on the user's input, it will either display programs, view statistics,
     * generate reports, track programs, or navigate back to the management page.
     * 
     * @param choice The option selected by the admin.
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        switch (choice) {
            case 1:
            	viewAllPrograms();
                break;
            case 2:
            	viewTheEnrollmentStatistics();
                break;
            case 3:
            	chooseReportGenerationOption();
                break;
            case 4:
            	trackActiveAndCompletedPrograms(getProgramEnrollmentMap());
                break;
            case 5:
            	System.out.println("\nReturning to the main menu...");
            	adminController.navigateToManagementPage();
            	returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return returnValue;
    }
    
    /**
     * Displays the report generation menu and processes the user's choice.
     */
	public static void chooseReportGenerationOption() {
        Scanner scanner = new Scanner(System.in);
        printTheGenerateQuestion();
        
        boolean validInput = false;
        int choice = inputData(scanner, validInput);
        choice(choice);
    }
	
	private static int inputData(Scanner scan, boolean validInput) {
        while (!validInput) {
            try {
                int choice = scan.nextInt();
                if (choice == 1 || choice == 2) {
                    validInput = true;
                    return choice;
                } else {
                    System.out.println("Invalid choice, please choose 1 or 2.");
                    printTheGenerateQuestion();
                    return 0;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number (1 or 2).");
                scan.nextLine();
                printTheGenerateQuestion();
            }
        }
        
        return 0;
	}
	
	private static void choice(int choice) {
		switch (choice) {
        case 1:
            System.out.println("Generating report for all programs...");
            generateReportsOption(getProgramEnrollmentMap(), "Null", false);
            return;
        case 2:
            System.out.print("\n");
            printPrograms(getProgramEnrollmentMap(), false);
            String programName = askTheNameOfTheProgram();
            System.out.println("\nReport generation in progress for the program: \"" + programName + "\".");
            generateReportsOption(getProgramEnrollmentMap(), programName, true);
        default:
        	System.out.println("Invalid input! Please enter a number (1 or 2).");
		}
	}
	
    /**
     * Prompts the user to choose between generating reports for all programs 
     * or a specific program.
     */
    private static void printTheGenerateQuestion() {
        System.err.println("\nDo you want to generate a report for all programs or a specific program?");
        System.err.println("1. All programs");
        System.err.println("2. Specific program");
        System.err.println("3. Go Back.");
        System.err.println(">> Enter your choice: ");
    }
    
    /**
     * Prompts the user to enter the name of a specific program.
     * 
     * @return The name of the program entered by the user.
     */
	public static String askTheNameOfTheProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the program name:");
        return scanner.nextLine();
    }
}