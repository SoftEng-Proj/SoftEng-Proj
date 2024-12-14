package com.Software.FitnessSystem.ClientPageNavigation;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.ClientControllers.ProgramExplorationEnrollmentControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;

public class ProgramExplorationEnrollmentPage extends BasePage {
	private ClientPageControllers clientController;
    @SuppressWarnings("unused")
	private ProgramExplorationEnrollmentControls programExplorationEnrollmentControls;
    
    public ProgramExplorationEnrollmentPage(ClientPageControllers clientController, Client currentClient) {
        this.clientController = clientController;
        this.programExplorationEnrollmentControls = new ProgramExplorationEnrollmentControls(currentClient);
    }
    
    @Override
    public void display() {
        System.out.println("\nProgram Exploration and Enrollment Menu:");
        System.out.println("1. Filter Programs by Difficulty Level.");
        System.out.println("2. Filter Programs by Focus Area.");
        System.out.println("3. Enroll in a Program.");
        System.out.println("4. View Program Schedule.");
        System.out.println("5. Go Back.");
    }
    
    @Override
    public void executeOption(int choice) {
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
                ProgramExplorationEnrollmentControls.enrollInProgram();
                break;
            case 4:
                System.out.print("Enter Program Name to View Schedule: ");
                String ProgramName = scanner.nextLine();
                ProgramExplorationEnrollmentControls.viewProgramSchedule(ProgramName);
                break;
            case 5:
                System.out.println("\nReturning to the main menu...");
                clientController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}