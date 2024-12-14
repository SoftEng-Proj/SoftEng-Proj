package com.Software.FitnessSystem.InstructorPageNavigation;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.InstructorControllers.InteractForInstructorControls;
import com.Software.FitnessSystem.InstructorControllers.ProgressTrackingInstructorControls;
import com.Software.FitnessSystem.LoginPage.InstructorPageControllers;

public class ProgressTrackingInstructorPage extends BasePage {
	
	private InstructorPageControllers instructorController;
	private ProgressTrackingInstructorControls progressTrackingInstructorControls ;
	
	public ProgressTrackingInstructorPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
		this.progressTrackingInstructorControls=new ProgressTrackingInstructorControls();
		
	}
	
	
	@Override
    public void display() {
        System.out.println("\nManagement Menu:");
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
                
            	progressTrackingInstructorControls.sendReminder(clientname, reminderMessage);
                break;
            case 3:
            	System.out.println("Enter the name of the client:");
                String cname = scanner.nextLine();
                
                System.out.print("Enter the recommendation: ");
                String recommendationMsg = scanner.nextLine();
                
            	progressTrackingInstructorControls.sendReminder(cname, recommendationMsg);
            	
                break;
            case 4:
     	
            	 goBack();       	
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
