package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.ProgramMonitoringControls.*;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

/**
 * Represents the Program Monitoring page for the admin in the fitness system.
 * This page allows the admin to perform various actions related to monitoring fitness programs,
 * such as viewing programs, generating reports, tracking program statistics, and more.
 * 
 * @author Muath Hassoun
 */
public class ProgramMonitoringPage extends BasePage {
	private AdminPagesController adminController;
	
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
    public void executeOption(int choice) {
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
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}