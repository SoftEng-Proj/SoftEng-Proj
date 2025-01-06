package com.software.fitness_system.InstructorPageNavigation;
import com.software.fitness_system.App;
import com.software.fitness_system.InfrastructureForPages.BasePage;
import com.software.fitness_system.InstructorControllers.ProgramManagementControls;
import com.software.fitness_system.LoginPage.InstructorPageControllers;



/**
 * Represents the program management page for the instructor where an instructor
 * has the option for creating,updating,deleting and setting a program schedule for 
 * a program.
 *  
 * @author Ammar Shafii
 */
public class ProgramManagementPage extends BasePage {
	private final InstructorPageControllers instructorController;
	private String progName;
	private String progDuration;
	private String progLevel;
	private String progGoal;
	private String progLinks;
	private String progPrice;
	private String UpdateProgName;
	private String newProgDuration;
	private String newProgLevel;
	private String newProgGoal;
	private String newProgLinks;
	private String newProgPrice;
	
	
	/**
     * Constructor to initialize the program management page with the provided InstructorPageController
     * 
     * @param instructorController The controller responsible for managing instructor page navigation and actions.
     */
	public ProgramManagementPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
	}
	
	
	
	/**
     * Displays the program management page with options of creating, updating, deleting and 
     * setting a schedule type for a program.
     *  
     * 
     */
    @Override
    public void display() {
        System.out.println("\nProgram Management Menu:");
        System.out.println("1. Create a new fitness program.");
        System.out.println("2. Update a fitness program.");
        System.out.println("3. Delete a fitness program.");
        System.out.println("4. Set a schedule for group sessions.");
        System.out.println("5. Go back.");
    }
    
    
    
    
    /**
     * Executes the selected option based on the user's choice.
     * Based on the user's input, it can either create, update , delete or set a 
     * program schedule type.      
     * 
     * @param choice The option selected by the instructor.
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        switch (choice) {
            case 1:
                EnterProgramInfo();
                ProgramManagementControls.createProgram(progName, progDuration, progLevel, progGoal, progLinks, progPrice);
                App.saveFitnessProgramsChanges();
                break;
            case 2:
            	EnterUpdatedProgramInfo();
                String result = ProgramManagementControls.updateProgram(UpdateProgName, newProgDuration, newProgLevel, newProgGoal, newProgLinks, newProgPrice);
                if(result.equals("not updated")) {
                	System.out.println("Program not found");
                }
                App.saveFitnessProgramsChanges();
                break;
            case 3:
            	System.out.println("Enter the name of the program to be deleted:");
                String deleteProgName = scanner.nextLine();
                String deleted = ProgramManagementControls.deleteProgram(deleteProgName);
                if(deleted.equals("not deleted")) {
                	System.out.println("Program not found");
                }
                App.saveFitnessProgramsChanges();
                break;
            case 4:
            	System.out.println("Enter the name of the program to set the schedule for:");
                String programName = scanner.nextLine();
                System.out.println("Choose the schedule type: (1) Online, (2) In-person");
                String scheduleChoice = scanner.nextLine();
                String scheduleType = scheduleChoice.equals("1") ? "Online" : "In-person";
                ProgramManagementControls.setSchedule(programName, scheduleType);
                App.saveFitnessProgramsChanges();
                break;
            case 5:
            	System.out.println("\nReturning to the main menu...");
            	instructorController.navigateToManagementPage();
            	returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        App.saveFitnessProgramsChanges();
        return returnValue;
    }
    
    
    
    /**
     * Reads the info of the program to be created.      
     * 
     * 
     */
    public void EnterProgramInfo() {
    	System.out.println("Enter the name of the new program:");
        progName = scanner.nextLine();
        System.out.println("Enter the duration of the program:");
        progDuration = scanner.nextLine();
        System.out.println("Enter the difficulty level:");
        progLevel = scanner.nextLine();
        System.out.println("Enter the goal of the program:");
        progGoal = scanner.nextLine();
        System.out.println("Enter the video tutorial or images link related to Program:");
        progLinks = scanner.nextLine();
        System.out.println("Enter the price of the new program:");
        progPrice = scanner.nextLine();
    }
    
    
    /**
     * The info of program to be updated.       
     */
    public void EnterUpdatedProgramInfo() {
    	System.out.println("Enter the name of the program to be updated:");
    	UpdateProgName = scanner.nextLine();
        System.out.println("Enter the new duration:");
        newProgDuration = scanner.nextLine();
        System.out.println("Enter the new difficulty level:");
        newProgLevel = scanner.nextLine();
        System.out.println("Enter the new goal:");
        newProgGoal = scanner.nextLine();
        System.out.println("Enter the new tutorial or images related to Program:");
        newProgLinks = scanner.nextLine();
        System.out.println("Enter the new price of the program:");
        newProgPrice = scanner.nextLine();
    }
}