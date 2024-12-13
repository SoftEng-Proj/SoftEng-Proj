package com.Software.FitnessSystem.InstructorControllers;

import java.util.HashMap;
import java.util.Map;

public class ProgramManagementControls {
	private static Map<String, Program> ProgramsMap = new HashMap<>();
	
	
	
	 public void createProgram(String name, String duration, String level, String goal, String links, String price) {
	        Program newProgram = new Program(name, duration, level, goal, links, price);
	        ProgramsMap.put(name, newProgram);
	        System.out.println("Program created successfully: " + newProgram);
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
	        Program programToDelete = ProgramsMap.remove(name);
	        System.out.println("Program '" + name + "' deleted successfully.");
	 }
	 
	 public void setSchedule(String name, String scheduleType) {
	        Program programToSchedule = ProgramsMap.get(name);
	        programToSchedule.setSchedule(scheduleType);
	        System.out.println("Schedule for program '" + name + "' set to: " + scheduleType);
	 }

}

