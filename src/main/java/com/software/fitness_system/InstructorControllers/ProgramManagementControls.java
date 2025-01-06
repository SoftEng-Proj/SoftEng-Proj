package com.software.fitness_system.InstructorControllers;
import java.time.LocalDate;
import java.util.Map;

import com.software.fitness_system.App;



/**
 *  Provides the controls for the program management page where we can create, update, delete
 *  and set a program schedule type.
 * 
 * 
 * @author Ammar Shafii
 */
public class ProgramManagementControls {
	private static Map<String, Program> ProgramsMap = App.getFitnessProgramsMap();
	private static boolean progCreated=false;
	private static boolean progUpdated=false;
	private static boolean progDeleted=false;
	private static boolean tutorialAdded=false;

	
	 /**
     * Creates a program.
     * 
     * @param name The name of program
     * @param duration the period for the program
     * @param level the level of the program
     * @param goal the goal of the program
     * @param links the provided link for the program
     * @param price Price of the program
     * @return "Program created successfully" When a program is created.
     */
	public static String createProgram(String name, String duration, String level, String goal, String links, String price) {
		String endDate = calculateProgramEnd(name, duration);
	    Program newProgram = new Program(name, duration, endDate, level, goal, links, price);
	    ProgramsMap.put(name, newProgram);
	    progCreated=true;
	    tutorialAdded=true;
	    
	    System.out.println("Program:" +name+ "successfully created");
	   
	    return "Program created successfully";
	}
	
	/**
     * Calculates the end of a program.
     * 
     * @param name The name of program
     * @param duration the period for the program
     * @return LocalDate.now().toString() Returns current date.
     * @return endDate.toString() Returns program end date.
     */
	private static String calculateProgramEnd(String name, String duration) {
	    int daysToAdd = 0;
	    try {
	        daysToAdd = Integer.parseInt(duration);
	    } catch (NumberFormatException e) {
	        if (duration.contains(" days")) {
	            try {
	                daysToAdd = Integer.parseInt(duration.replaceAll("\\D+", ""));
	            } catch (NumberFormatException ex) {
	                System.out.println("Invalid duration format for program: " + name);
	                return LocalDate.now().toString();
	            }
	        } else {
	            System.out.println("Invalid duration format for program: " + name);
	            return LocalDate.now().toString();
	        }
	    }
	    
	    LocalDate endDate = LocalDate.now().plusDays(daysToAdd);
	    return endDate.toString();
	}
	
	
	/**
     * Updates a program.
     * 
     * @param name The name of program to be updated.
     * @param newDuration the updated period for the program
     * @param newLevel the updated level of the program
     * @param newGoal the updated goal of the program
     * @param newLinks the updated provided link for the program
     * @param newPrice  Updated Price of the program
     * @return "Program updated" When a program is updated.
     * 
     */
	public static String updateProgram(String name, String newDuration, String newLevel, String newGoal, String newLinks, String newPrice) {
		
		if (ProgramsMap.containsKey(name)) {
		 Program programToUpdate = ProgramsMap.get(name);
		 programToUpdate.setDuration(newDuration);
	     programToUpdate.setLevel(newLevel);
	     programToUpdate.setGoal(newGoal);
	     programToUpdate.setLinks(newLinks);
	     programToUpdate.setPrice(newPrice);
	     progUpdated=true;
	     System.out.println("Program:" +name+ "successfully updated");
		  
	     return "Program updated";
	     
		}
		else {
			System.out.println("Program not found");
			 return "not updated";
		}
	     
	 }
	 
	
	/**
     * Deletes a program.
     * 
     * @param name The name of program to be deleted.
     * @return "Program deleted" When a program is deleted.
     * 
     */
	public static String deleteProgram(String name) {
		if (ProgramsMap.containsKey(name)) {
		 ProgramsMap.remove(name);
		 progDeleted=true;
		 System.out.println("Program:" +name+ "successfully removed");
	     return "Program Deleted";
		}
		else {
			 System.out.println("Program not found");
			 return "not deleted";
		}
	 }
	 
	/**
     * Sets the program schedule type.
     * 
     * @param name The name of program.
     * @param scheduleType The type of the program schedule
     * @return "Schedule set" When a program schedule type is set.
     */
	 public static String setSchedule(String name, String scheduleType) {
		// createProgram("Muscle Build", "60 days", "beginner", "strength", "link", "50");
		 Program programToSchedule = ProgramsMap.get(name);
	     programToSchedule.setSchedule(scheduleType);
	     return "Schedule set";
	 }
	 
	 /**
	     * Checks if a program is created, for test purposes.
	     * @return true When a program is created, false otherwise
	     *
	     */
	 public static boolean ProgCreated() {
		
		 if (progCreated==true) {
			 return true;
		 }
		 return false;
	 }
	 
	 /**
	     * Checks if a program is updated, for test purposes.
	     * @return true When a program is updated, false otherwise
	     */
	 public static boolean ProgUpdated() {
		
		 if (progUpdated==true) {
			 return true;
		 }
		 return false;
	 }
	 
	 /**
	     * Checks if a program is deleted, for test purposes.
	     * @return true When a program is deleted, false otherwise
	     */
	 public static boolean ProgDeleted() {
			
		 if (progDeleted==true) {
			 return true;
		 }
		 return false;
	 }
	 
	 /**
	     * Checks if a tutorial link is added, for test purposes.
	     * @return true When a tutorial link is added, false otherwise
	     */
	 public static boolean TutorialAdded() {
			
		 if (tutorialAdded==true) {
			 return true;
		 }
		 return false;
	 }
	 
	 
	 
	 
}