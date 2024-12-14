package com.Software.FitnessSystem.InstructorPageNavigation;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.InstructorControllers.NotificationControls;
import com.Software.FitnessSystem.InstructorControllers.ProgramManagementControls;
import com.Software.FitnessSystem.LoginPage.InstructorPageControllers;

public class NotificationsPage extends BasePage {
	private String Programname;
	private String NewSchedule; 
	private String announcement; 
	
	private InstructorPageControllers instructorController;
	private NotificationControls notificationControls ;
	
	
	public NotificationsPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
		this.notificationControls=new NotificationControls();
		
	}
	
	
	
	

    @Override
    public void display() {
        System.out.println("\nManagement Menu:");
        System.out.println("1. Notify about program schedule change.");
        System.out.println("2. Announce new programs or offers.");
        System.out.println("3. Go back");
        
    }

    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
                              ProgramInfo();
            	System.out.println("Enter program's schedule change:");
            	NewSchedule = scanner.nextLine();
            	NotificationControls.addProgramScheduleChange(Programname, NewSchedule);
            	
                break;
            case 2:
                System.out.println("Enter the Announcement:");
                announcement = scanner.nextLine();
                NotificationControls.AddanAnnouncement(announcement);
                break;
            case 3:
                goBack();
                break;
           
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    public void ProgramInfo() {
    	System.out.println("Enter name of program:");
        Programname = scanner.nextLine();
    }
}