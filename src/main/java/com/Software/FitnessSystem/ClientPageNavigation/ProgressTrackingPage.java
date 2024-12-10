package com.Software.FitnessSystem.ClientPageNavigation;

import com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.ClientControllers;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;

public class ProgressTrackingPage extends BasePage {
	private ClientControllers clientController;
	
	public ProgressTrackingPage(ClientControllers clientController) {
		this.clientController = clientController;
	}
	
    @Override
    public void display() {
        System.out.println("\nPrograss Tracking Menu:");
        System.out.println("1. Approve new instructor application.");
        System.out.println("2. Reject new instructor application.");
        System.out.println("3. Go Back.");
    }
    
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Approving new instructor application...");
                break;
            case 2:
                System.out.println("Rejecting new instructor application...");
                break;
            case 3:
            	System.out.println("\nReturning to the main menu...");
            	clientController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}