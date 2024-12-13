package com.Software.FitnessSystem.InstructorPageNavigation;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.InstructorControllers.ProgramManagementControls;
import com.Software.FitnessSystem.LoginPage.InstructorPageControllers;

public class ProgramManagementPage extends BasePage {
	
	private InstructorPageControllers instructorController;
	private ProgramManagementControls programManagementControls ;
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
	
	
	
	public ProgramManagementPage (InstructorPageControllers instructorController) {
		this.instructorController=instructorController;
		this.programManagementControls=new ProgramManagementControls();
		
	}
	
	
	
    @Override
    public void display() {
        System.out.println("\nManagement Menu:");
        System.out.println("1. Create a new fitness program.");
        System.out.println("2. Update a fitness program.");
        System.out.println("3. Delete a fitness program.");
        System.out.println("4. Set a schedule for group sessions.");
        System.out.println("5. Go back.");
       
    }

    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
                EnterProgramInfo();
                programManagementControls.createProgram(progName, progDuration, progLevel, progGoal, progLinks, progPrice);
                
                break;
            case 2:
            	EnterUpdatedProgramInfo();
                programManagementControls.updateProgram(UpdateProgName, newProgDuration, newProgLevel, newProgGoal, newProgLinks, newProgPrice);
                
                break;
            case 3:
            	System.out.println("Enter the name of the program to be deleted:");
                String deleteProgName = scanner.nextLine();
                programManagementControls.deleteProgram(deleteProgName);
                
                break;
            case 4:
            	System.out.println("Enter the name of the program to set the schedule for:");
                String programName = scanner.nextLine();
                System.out.println("Choose the schedule type: (1) Online, (2) In-person");
                String scheduleChoice = scanner.nextLine();
                String scheduleType = scheduleChoice.equals("1") ? "Online" : "In-person";
                programManagementControls.setSchedule(programName, scheduleType);
                break;
            case 5:
             goBack();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        App.saveFitnessProgramsChanges();
    }
    
    
    public void EnterProgramInfo() {
    	System.out.println("Enter the name of the new program:");
        progName = scanner.nextLine();
        System.out.println("Enter the duration of the program:");
         progDuration = scanner.nextLine();
        System.out.println("Enter the difficulty level:");
         progLevel = scanner.nextLine();
        System.out.println("Enter the goal of the program:");
        progGoal = scanner.nextLine();
        System.out.println("Enter the video tutorial or images related to Program:");
         progLinks = scanner.nextLine();
        System.out.println("Enter the price of the new program:");
        progPrice = scanner.nextLine();
    }
    
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