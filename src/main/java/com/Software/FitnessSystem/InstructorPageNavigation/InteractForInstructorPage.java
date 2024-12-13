package com.Software.FitnessSystem.InstructorPageNavigation;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.InstructorControllers.InteractForInstructorControls;
import com.Software.FitnessSystem.LoginPage.InstructorPageControllers;


public class InteractForInstructorPage extends BasePage {
	
	private InstructorPageControllers instructorController;
	private InteractForInstructorControls interactForInstructorControls ;
	
	
	
	
	public InteractForInstructorPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
		this.interactForInstructorControls=new InteractForInstructorControls();
		
	}
	
	
	
    @Override
    public void display() {
        System.out.println("\nManagement Menu:");
        System.out.println("1. Send a message to a client.");
        System.out.println("2. Post a message on a program discussion forum.");
        System.out.println("3. Provide Feedback to a client.");
        System.out.println("4. Send a progress update to a client.");
        System.out.println("5. Go back.");
       
    }

    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:	
            	System.out.println("Enter the name of the client:");
                String clientName = scanner.nextLine();

                System.out.println("Enter your message:");
                String message = scanner.nextLine();

                interactForInstructorControls.sendMessageToClient(clientName, message);
                App.saveInstructorMSGSForClientsChanges();
                break;
              
               
            case 2:
            	System.out.println("Enter the name of the program");
            	String progname = scanner.nextLine();
            	System.out.println("Enter the message on the forum:");
            	 String msg = scanner.nextLine();
            	 
             interactForInstructorControls.sendMessageToClient(progname, msg);
             App.saveProgramForumMsgsChanges();
                break;
            case 3:
            	
            	System.out.println("Enter the name of the client");
            	String clientt = scanner.nextLine();
            	System.out.println("Enter your feedback:");
                 String feedback = scanner.nextLine();
                 
                 interactForInstructorControls.sendFeedbackToClient(clientt, feedback);
                 App.saveFeedbackToClientChanges();
                          	
                break;
            case 4:
            	
            	
            	//to be created later.
            	
            	
                break;
            case 5:
             goBack();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

}
