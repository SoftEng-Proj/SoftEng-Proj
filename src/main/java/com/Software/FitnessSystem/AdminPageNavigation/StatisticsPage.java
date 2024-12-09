package com.Software.FitnessSystem.AdminPageNavigation;

import com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;

public class StatisticsPage extends BasePage {
	private AdminControllers adminController;
	
	public StatisticsPage(AdminControllers adminController) {
		this.adminController = adminController;
	}
	
    @Override
    public void display() {
        System.out.println("\nStatistics Menu:");
        System.out.println("1. View user activity statistics.");
        System.out.println("2. View engagement statistics.");
        System.out.println("3. Go Back.");
    }
    
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Displaying user activity statistics...");
                break;
            case 2:
                System.out.println("Displaying engagement statistics...");
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