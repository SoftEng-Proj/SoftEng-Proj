package com.Software.FitnessSystem.InstructorControllers;

import java.util.List;
import java.util.Map;

import com.Software.FitnessSystem.App;


/**
 * Provides the controls for the notifications page where it allows the instructor
 * to notify about a schedule change, announce a new program, or announce a special offer.
 *  
 * @author Ammar Shafii
 */
public class NotificationControls {
	
	private static Map<String, String> SchedChangeMap = App.getProgramScheduleChangeMap();
	private static Map<String, Program> ProgramMap=App.getFitnessProgramsMap();
	private static List<String> AnnouncementMap= App.getInstructorAnnouncementsMap();
	private static boolean Changesent=false;
	private static boolean Announcementsent=false;
	private static boolean programfound=false;

	
	
	/**
     * Changes a program schedule.
     * 
     * @param name Program Name
     * @param msg The new program schedule
     */
	public static String addProgramScheduleChange(String name, String msg) {
		if(ProgramMap.containsKey(name)) {
		SchedChangeMap.put(name, msg);
		System.out.println("Schedule is updated for program: " + name);
		Changesent=true;
		programfound=true;
	    return "Schedule changed";
		}
		else {
			System.out.println("program not found: " + name);
			return "not changed";
		}
	    
	}
	
	/**
     * Adds an announcemnt.
     * 
     * @param name The announcement detail.
     * 
     */
	public static String AddanAnnouncement(String name) {
		AnnouncementMap.add(name);
		System.out.println("An announcement is made ");
		Announcementsent=true;
	    return "Announcement made.";
	    
	}
	
	
	/**
     * To ensure a schedule change occures, for test purposes.
     * 
     * 
     */
	public static boolean ChangeSent() {
		ProgramMap.put("Fit", null);
		if (Changesent==true) {
		return true;
		}
		return false;
	    
	}
	
	/**
     * To ensure an announcement is sent, for test purposes.
     * 
     * 
     */
	public static boolean AnnouncementSent() {
		AddanAnnouncement("Hi");
		if (Announcementsent==true) {
		return true;
		}
		return false;
	    
	}
	
	/**
     * To ensure a schedule change, for test purposes. 
     * 
     * 
     */
	public static void SchedUpdate() {
		ProgramMap.put("Fit", null);
	}
	
	/**
     * to ensure a program is found. 
     */
	public static boolean ProgramFound() {
		ProgramMap.put("Fit", null);
		NotificationControls.addProgramScheduleChange("Fit", null);
		if (programfound==true) {
		return true;
		}
		else {
		return false;
		}
	}
	
	

	
}