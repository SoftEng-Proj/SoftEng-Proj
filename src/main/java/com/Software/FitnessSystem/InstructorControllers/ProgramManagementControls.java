package com.Software.FitnessSystem.InstructorControllers;
import java.time.LocalDate;
import java.util.Map;

import com.Software.FitnessSystem.App;

public class ProgramManagementControls {
	private static Map<String, Program> ProgramsMap = App.getFitnessProgramsMap();
	
	public void createProgram(String name, String duration, String level, String goal, String links, String price) {
		String endDate = calculateProgramEnd(name, duration);
	    Program newProgram = new Program(name, duration, endDate, level, goal, links, price);
	    ProgramsMap.put(name, newProgram);
	    System.out.println("Program created successfully: " + newProgram);
	}
	
	private String calculateProgramEnd(String name, String duration) {
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
	
	public void updateProgram(String name, String newDuration, String newLevel, String newGoal, String newLinks, String newPrice) {
		 Program programToUpdate = ProgramsMap.get(name);
		 programToUpdate.setDuration(newDuration);
	     programToUpdate.setLevel(newLevel);
	     programToUpdate.setGoal(newGoal);
	     programToUpdate.setLinks(newLinks);
	     programToUpdate.setPrice(newPrice);
	 }
	 
	public void deleteProgram(String name) {
		 ProgramsMap.remove(name);
	     System.out.println("Program '" + name + "' deleted successfully.");
	 }
	 
	 public void setSchedule(String name, String scheduleType) {
		 Program programToSchedule = ProgramsMap.get(name);
	     programToSchedule.setSchedule(scheduleType);
	     System.out.println("Schedule for program '" + name + "' set to: " + scheduleType);
	 }
}