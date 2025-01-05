package com.Software.FitnessSystem.ClientPageNavigation;
import java.util.Map;
import java.util.Scanner;

import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.ClientControllers.ProgramExplorationEnrollmentControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.InstructorControllers.Program;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;
/**
 * The ProgramExplorationEnrollmentPage class is the page where clients
 * can explore and enroll in fitness programs and provide the client with options
 * to filter programs, enroll in them, view schedules, and navigate back to the
 * main menu
 * 
 * This class extends the BasePage 
 * 
 * @author Alaa Alawneh
 */
public class ProgramExplorationEnrollmentPage extends BasePage {
	private ClientPageControllers clientController;
    @SuppressWarnings("unused")
	private ProgramExplorationEnrollmentControls programExplorationEnrollmentControls;
    private Scanner scanner;
    private Client client;
    /**
     * Constructs a ProgramExplorationEnrollmentPage with the given client controller
     * and current client
     *
     * @param clientController the controller for managing client page navigation
     * @param currentClient the current client exploring programs
     */
    public ProgramExplorationEnrollmentPage(ClientPageControllers clientController, Client currentClient) {
        this.clientController = clientController;
        this.programExplorationEnrollmentControls = new ProgramExplorationEnrollmentControls();
        this.scanner = new Scanner(System.in);
    }
    /**
     * Displays the menu options for program exploration and enrollment
     */
    @Override
    public void display() {
        System.out.println("\nProgram Exploration and Enrollment Menu:");
        System.out.println("1. Filter Programs by Difficulty Level.");
        System.out.println("2. Filter Programs by Focus Area.");
        System.out.println("3. Enroll in a Program.");
        System.out.println("4. View Program Schedule.");
        System.out.println("5. Go Back.");
    }
    /**
     * Executes the selected option by client
     *
     * @param choice the option chosen by the client
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        switch (choice) {
            case 1:
                System.out.print("Enter Difficulty Level (Beginner, Intermediate, Advanced): ");
                String difficulty = scanner.nextLine();
                ProgramExplorationEnrollmentControls.filterProgramsByDifficulty(difficulty);
                break;
            case 2:
                System.out.print("Enter Focus Area (e.g., Strength, Cardio, Yoga): ");
                String focusArea = scanner.nextLine();
                ProgramExplorationEnrollmentControls.filterProgramsByFocusArea(focusArea);
                break;
            case 3:
                System.out.println("Available Fitness Programs:");
                int i = 1;
                for (Map.Entry<String, Program> entry : ProgramExplorationEnrollmentControls.getPrograms().entrySet()) {
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

                System.out.print("Enter the number of the program you want to enroll in: ");
                int programNumber = scanner.nextInt();
                scanner.nextLine();
                ProgramExplorationEnrollmentControls.enrollInProgram(client, programNumber);
                break;
            case 4:
                System.out.print("Enter Program Name to View Schedule: ");
                String ProgramName = scanner.nextLine();
                ProgramExplorationEnrollmentControls.viewProgramSchedule(ProgramName);
                break;
            case 5:
                System.out.println("\nReturning to the main menu...");
                clientController.navigateToManagementPage();
                returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return returnValue;
    }
}