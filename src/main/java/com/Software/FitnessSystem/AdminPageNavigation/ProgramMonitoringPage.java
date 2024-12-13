package com.Software.FitnessSystem.AdminPageNavigation;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.AdminControllers.ProgramMonitoringControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

public class ProgramMonitoringPage extends BasePage {
	private AdminPagesController adminController;
	
	public ProgramMonitoringPage(AdminPagesController adminController) {
		this.adminController = adminController;
	}
	
	@Override
	public void display() {
	    System.out.println("\nProgram Monitoring Menu:");
	    System.out.println("1. View all programs.");
	    System.out.println("2. View statistics on the most popular programs by enrollment.");
	    System.out.println("3. Generate reports on revenue, attendance, and client progress.");
	    System.out.println("4. Track active and completed programs.");
	    System.out.println("5. Go Back.");
	}
    
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
            	ProgramMonitoringControls.viewAllPrograms();
                break;
            case 2:
            	ProgramMonitoringControls.viewTheEnrollmentStatistics();
                break;
            case 3:
            	ProgramMonitoringControls.chooseReportGenerationOption();
                break;
            case 4:
            	ProgramMonitoringControls.trackActiveAndCompletedPrograms(App.getProgramEnrollmentMap());
                break;
            case 5:
            	System.out.println("\nReturning to the main menu...");
            	adminController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}