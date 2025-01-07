package com.software.fitness_system.instructor_page_navigation;
import com.software.fitness_system.App;
import com.software.fitness_system.infrastructure_for_pages.BasePage;
import com.software.fitness_system.instructor_controllers.InteractForInstructorControls;
import com.software.fitness_system.login_page.InstructorPageControllers;



/**
 * This Represents the Interaction For instructor page, it allows the instructor to 
 * perform several things, such as sending a message to a client, posting a message on 
 * discussion forum, providing feedback to clients and sending a progress update.
 * 
 * @author Ammar Shafii
 */
public class InteractForInstructorPage extends BasePage {
	private InstructorPageControllers instructorController;
	private static boolean isForumPage=false;
	
	
	/**
     * Constructor to initialize the InteractForInstructorPage with the provided InstructorPageControllers
     * 
     * @param instructorController The controller responsible for managing instructor page navigation and actions.
     */
	public InteractForInstructorPage (InstructorPageControllers instructorController) {
		this.instructorController = instructorController;
	}
	
	/**
     * This Displays the Interaction menu with different options for the instructor.
     * The menu includes options for sending a message to a client, posting a message on a program forum,
     * providing a feedback, sending a progress update and going back to main menu.
     * 
     */
    @Override
    public void display() {
        System.out.println("\nInteract Management Menu:");
        System.out.println("1. Send a message to a client.");
        System.out.println("2. Post a message on a program discussion forum.");
        System.out.println("3. Provide Feedback to a client.");
        System.out.println("4. Send a progress update to a client.");
        System.out.println("5. Go back.");
    }
    
    /**
     * It Executes the selected option based on the user's choice.
     * Depending on the user's input, it can send a message to a client, post a 
     * message to a program forum, provide feedback or progress report to a client or go back.
     * 
     * @param choice The option selected by the instructor.
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        switch (choice) {
            case 1:	
            	System.out.println("Enter the name of the client:");
                String clientName = scanner.nextLine();
                
                System.out.println("Enter your message:");
                String message = scanner.nextLine();

                String mssg = InteractForInstructorControls.sendMessageToClient(clientName, message);
                if(mssg.equals("Message not sent")) {
    	            System.out.println("Error: Client \"" + clientName + "\" does not exist. Please check the name and try again.");
                }
                App.saveInstructorMSGSForClientsChanges();
                break;
            case 2:
            	isForumPage = true;
            	System.out.println("Enter the name of the program");
            	String progname = scanner.nextLine();
            	System.out.println("Enter the message on the forum:");
            	String msg = scanner.nextLine();
            	 
                String msge = InteractForInstructorControls.sendMessageToProgramForum(progname, msg);
                if(msge.equals("Forum not sent")) {
    	            System.out.println("Error: Program \"" + progname + "\" does not exist. Please check the name and try again.");
                }
                App.saveProgramForumMsgsChanges();
                break;
            case 3:
            	System.out.println("Enter the name of the client");
            	String clientt = scanner.nextLine();
            	System.out.println("Enter your feedback:");
                String feedback = scanner.nextLine();
                 
                String sent = InteractForInstructorControls.sendFeedbackToClient(clientt, feedback);
            	if(sent.equals("Feedback not sent")) {
    	            System.out.println("Error: Client \"" + clientt + "\" does not exist. Please check the name and try again.");
            	}
                App.saveFeedbackToClientChanges();          	
                break;
            case 4:
            	System.out.println("Enter the name of the client");
            	String clienttt = scanner.nextLine();
            	
            	System.out.println("Enter the progress message:");
            	String MSG = scanner.nextLine();
            	
            	String notSent = InteractForInstructorControls.sendProgressToClient(clienttt, MSG);
            	if(notSent.equals("not sent")) {
    	            System.out.println("Error: Client \"" + clienttt + "\" does not exist. Please check the name and try again.");
            	}
            	App.saveProgressListChanges();            	
                break;
            case 5:
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
     * A method created for testing purposes, it ensures that user is on forum page.
     * 
     * @return isForumPage returns the boolean value.
     */
    public static boolean isForumPage() {
        InstructorPageControllers c = new InstructorPageControllers();
        InteractForInstructorPage choose = new InteractForInstructorPage(c);
        choose.executeOption(2);
    	
        return isForumPage;
    }
}
