package com.Software.FitnessSystem.AdminPageNavigation;

import com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;

public class ApprovalsPage extends BasePage {
	private AdminControllers adminController;
	
	public ApprovalsPage(AdminControllers adminController) {
		this.adminController = adminController;
	}
	
    @Override
    public void display() {
        System.out.println("\nApprovals Menu:");
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
            	adminController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}