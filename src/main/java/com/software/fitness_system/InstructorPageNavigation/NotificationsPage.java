package com.software.fitness_system.InstructorPageNavigation;
import com.software.fitness_system.App;
import com.software.fitness_system.InfrastructureForPages.BasePage;
import com.software.fitness_system.InstructorControllers.NotificationControls;
import com.software.fitness_system.LoginPage.InstructorPageControllers;


/**
 * It represents the notifications page where an instructor can notify about a program
 * schedule change, make an announcement or a new offer.
 * 
 * 
 * @author Ammar Shafii
 */
public class NotificationsPage extends BasePage {
	private String Programname;
	private String NewSchedule; 
	private String announcement; 
	
	private InstructorPageControllers instructorController;
	
	
	/**
     * Constructor to initialize the NotifcationsPage with the provided IstructorPageController.
     * 
     * @param instructorController The controller responsible for managing instructor page navigation and actions.
     */
	public NotificationsPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
	}
	
	
	
	/**
     * Displays the notification menu where an instructor has the options to notify
     * about a a program schedule change, make an announcement or make a new offer.
     *  
     * 
     */
    @Override
    public void display() {
        System.out.println("\nNotifications Management Menu:");
        System.out.println("1. Notify about program schedule change.");
        System.out.println("2. Announce new programs or offers.");
        System.out.println("3. Go back");
    }
    
    
    
    
    /**
     * Executes the selected option based on the user's choice.
     * Depending on the user's input, it can notify about a program schedule change, 
     * a new announcement, or new offers.
     *
     * 
     * @param choice The option selected by the instructor.
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        switch (choice) {
            case 1:
                ProgramInfo();
            	System.out.println("Enter program's schedule change:");
            	NewSchedule = scanner.nextLine();
            	String result = NotificationControls.addProgramScheduleChange(Programname, NewSchedule);
            	if(result.equals("not changed")) {
            		System.out.println("program not found: " + Programname);
            	}
            	
            	App.saveProgramSchedChangeChanges();
                break;
            case 2:
                System.out.println("Enter the Announcement:");
                announcement = scanner.nextLine();
                NotificationControls.AddanAnnouncement(announcement);
                App.saveAnnouncementChanges();               
                break;
            case 3:
            	System.out.println("\nReturning to the main menu...");
            	instructorController.navigateToManagementPage();
            	returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return returnValue;
    }
    
    /**
     * Takes the input name of a program.
     */
    public void ProgramInfo() {
    	System.out.println("Enter name of program:");
        Programname = scanner.nextLine();
    }
}