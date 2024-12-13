package com.Software.FitnessSystem.ClientPageNavigation;

import com.Software.FitnessSystem.ClientControllers.ProgressTrackingControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;

public class ProgressTrackingPage extends BasePage {
	private ClientPageControllers clientController;
	private ProgressTrackingControls progressTrackingControls;
	private String type;
	private String value;
	private String date;
	
	public ProgressTrackingPage(ClientPageControllers clientController) {
		this.clientController = clientController;
		this.progressTrackingControls = progressTrackingControls;
	}
	
    @Override
    public void display() {
        System.out.println("\nPrograss Tracking Menu:");
        System.out.println("1. Add a New Milestone.");
        System.out.println("2. Show all Milestones.");
        System.out.println("3. Go Back.");
    }
    
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
            	getMilestoneInfo();
                progressTrackingControls.addMilestone(type, value, date);
                break;
            case 2:
            	progressTrackingControls.showProgress();
                break;
            case 3:
            	System.out.println("\nReturning to the main menu...");
            	clientController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public void getMilestoneInfo() {
    	System.out.print("Enter milestone type (e.g., Weight, BMI, Attendance): ");
        type = scanner.nextLine();
        System.out.print("Enter milestone value: ");
        value = scanner.nextLine();
        System.out.print("Enter milestone date (Year-Month-Day): ");
        date = scanner.nextLine();
    }
}