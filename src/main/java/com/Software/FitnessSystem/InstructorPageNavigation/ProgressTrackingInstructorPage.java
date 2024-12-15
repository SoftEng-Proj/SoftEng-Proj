package com.Software.FitnessSystem.InstructorPageNavigation;
import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.InstructorControllers.ProgressTrackingInstructorControls;
import com.Software.FitnessSystem.LoginPage.InstructorPageControllers;

public class ProgressTrackingInstructorPage extends BasePage {
	private InstructorPageControllers instructorController;
	
	public ProgressTrackingInstructorPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
	}
	
	@Override
    public void display() {
        System.out.println("\nProgress Tracking Management Menu:");
        System.out.println("1. View clients progress ");
        System.out.println("2. Send a reminder.");
        System.out.println("3. Send a recommendation.");
        System.out.println("4. Go back.");
    }
	
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:	
            	  viewClientProgress();
                break;
            case 2:
            	System.out.println("Enter the name of the client:");
                String clientname = scanner.nextLine();
                
                System.out.print("Enter the reminder: ");
                String reminderMessage = scanner.nextLine();
                
            	ProgressTrackingInstructorControls.sendReminder(clientname, reminderMessage);
                break;
            case 3:
            	System.out.println("Enter the name of the client:");
                String cname = scanner.nextLine();
                
                System.out.print("Enter the recommendation: ");
                String recommendationMsg = scanner.nextLine();
                
            	ProgressTrackingInstructorControls.sendReminder(cname, recommendationMsg);
                break;
            case 4:
            	System.out.println("\nReturning to the main menu...");
            	instructorController.navigateToManagementPage();       	
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    public static boolean viewClientProgress() {
        System.out.println("\nViewing progress...");
        for (FitnessMilestone progress : ProgressTrackingInstructorControls.getMilestones()) {
            System.out.println(progress);
        }
        
        return true;
    }
}
