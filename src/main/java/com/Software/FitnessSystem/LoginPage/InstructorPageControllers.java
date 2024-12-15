package com.Software.FitnessSystem.LoginPage;
import com.Software.FitnessSystem.InstructorPageNavigation.InteractForInstructorPage;
import com.Software.FitnessSystem.InstructorPageNavigation.NavigationControllerForInstructor;
import com.Software.FitnessSystem.InstructorPageNavigation.NotificationsPage;
import com.Software.FitnessSystem.InstructorPageNavigation.ProgramManagementPage;
import com.Software.FitnessSystem.InstructorPageNavigation.ProgressTrackingInstructorPage;

import java.util.Scanner;

public class InstructorPageControllers {
	private NavigationControllerForInstructor navigationController = new NavigationControllerForInstructor();
	private InteractForInstructorPage interactForInstructorPage;
	private NotificationsPage notificationsPage;
	private ProgramManagementPage programManagementPage;
	private ProgressTrackingInstructorPage progressTrackingInstructorPage;
	
	public InstructorPageControllers() {
    	interactForInstructorPage = new InteractForInstructorPage(this);
    	notificationsPage = new NotificationsPage(this);
    	programManagementPage = new ProgramManagementPage(this);
    	progressTrackingInstructorPage = new ProgressTrackingInstructorPage(this);
    }
	
	@SuppressWarnings("resource")
	public boolean navigateToManagementPage() {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
        navigateToPage(choiceNumber);
        return true;
    }
	
	public boolean navigateToPage(int page) {
        switch (page) {
        case 1 -> navigationController.navigateTo(programManagementPage, this);
        case 2 -> navigationController.navigateTo(interactForInstructorPage, this);
        case 3 -> navigationController.navigateTo(progressTrackingInstructorPage, this);
        case 4 -> navigationController.navigateTo(notificationsPage, this);
        case 5 -> {
        	System.out.print("\n");
        	new LoginPageController();
        }
        case 6 -> {
            System.err.println("\n\nExiting program. Goodbye!");
            System.exit(0);
        }
        default -> System.out.println("Invalid selection. Please try again.");
        }
        
        return true;
    }
	
	private void displayMainMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Program Management");
        System.out.println("2. Client Interaction.");
        System.out.println("3. Progress Tracking.");
        System.out.println("4. Notifications and Updates.");
        System.out.println("5. Logout.");
        System.out.println("6. Exit.");
        System.out.print("\nEnter your choice: ");
    }

}