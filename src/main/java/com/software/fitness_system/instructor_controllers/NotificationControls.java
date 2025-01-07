package com.software.fitness_system.instructor_controllers;

import java.util.List;
import java.util.Map;

import com.software.fitness_system.App;


/**
 * Provides the controls for the notifications page where it allows the instructor
 * to notify about a schedule change, announce a new program, or announce a special offer.
 *  
 * @author Ammar Shafii
 */
public class NotificationControls {
	private static Map<String, String> SchedChangeMap = App.getProgramScheduleChangeMap();
	private static Map<String, Program> ProgramMap = App.getFitnessProgramsMap();
	private static List<String> AnnouncementMap = App.getInstructorAnnouncementsMap();
	private static boolean Changesent = false;
	private static boolean Announcementsent = false;
	
	/**
     * Changes a program schedule.
     * 
     * @param name Program Name
     * @param msg The new program schedule
     */
	public static String addProgramScheduleChange(String name, String msg) {
		Changesent = false;
		if(ProgramMap.containsKey(name)) {
			SchedChangeMap.put(name, msg);
			System.out.println("Schedule is updated for program: " + name);
			Changesent = true;
		    return "Schedule changed";
		}
		else {
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
		Announcementsent = true;
	    return "Announcement made.";
	}
	
	/**
     * To ensure a schedule change occures, for test purposes.
     */
	public static boolean ChangeSent() {
		return Changesent;
	}
	
	/**
     * To ensure an announcement is sent, for test purposes.
     */
	public static boolean AnnouncementSent() {
		return Announcementsent;
	}
	
	/**
     * To ensure a program exists, for test purposes. 
     * 
     * 
     */
	public static boolean ProgramExists() {
		ProgramMap.put("Fit", new Program ("Fit","20 Days","10-2-2024","2","3","4","5"));
		return true;
	}
}