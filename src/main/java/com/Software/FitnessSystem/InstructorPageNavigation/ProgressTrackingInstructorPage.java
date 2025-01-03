package com.Software.FitnessSystem.InstructorPageNavigation;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.InstructorControllers.ProgressTrackingInstructorControls;
import com.Software.FitnessSystem.LoginPage.InstructorPageControllers;




/**
 * Represents the progress tracking page where an instructor can view the milestones 
 * of the clients, send a reminder to a specific client or send a recommendation.
 * 
 * @author Ammar Shafii
 */
public class ProgressTrackingInstructorPage extends BasePage {
	private InstructorPageControllers instructorController;
	private static boolean viewed=false;
	
	
	/**
     * Constructor to initialize the ProgressTrackingPage with the provided IntructorPageController.
     * 
     * @param instructorController The controller responsible for managing instructor page navigation and actions.
     */
	public ProgressTrackingInstructorPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
	}
	
	
	/**
     * It displays the main menu for progress tracking page where an instructor has the 
     * options of viewing clients' progress, send a reminder to a client or a recommendation.
     */
	@Override
    public void display() {
        System.out.println("\nProgress Tracking Management Menu:");
        System.out.println("1. View clients progress ");
        System.out.println("2. Send a reminder.");
        System.out.println("3. Send a recommendation.");
        System.out.println("4. Go back.");
    }
	
	
	
	/**
     * Executes the selected option based on the user's choice.
     * Based on the user's input, it can either view the clients' progress, send a reminder
     * to them, or send a recommendation.
     * 
     * @param choice The option selected by the instructor.
     */
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
            	App.saveInstructorReminderChanges();
            
                break;
            case 3:
            	System.out.println("Enter the name of the client:");
                String cname = scanner.nextLine();
                
                System.out.print("Enter the recommendation: ");
                String recommendationMsg = scanner.nextLine();
                
            	ProgressTrackingInstructorControls.sendRecommendation(cname, recommendationMsg);
            	App.saveInstructorRecommendationChanges();
                break;
            case 4:
            	System.out.println("\nReturning to the main menu...");
            	instructorController.navigateToManagementPage();       	
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    
    /**
     * 
     * Prints clients' progress
     * 
     * @return true At the end of the viewing process.
     */
    public static boolean viewClientProgress() {
    	viewed=true;
        System.out.println("\nViewing progress...");
        for (FitnessMilestone progress : ProgressTrackingInstructorControls.getMilestones()) {
            System.out.println(progress);
        }
        
        return true;
    }
    public static boolean ViewedCheck() {
    	if (viewed==true){
    		return true;
    	}
    	return false;
    }
}
