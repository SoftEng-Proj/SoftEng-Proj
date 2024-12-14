package com.Software.FitnessSystem.InstructorControllers;

import java.util.List;
import java.util.Map;

import com.Software.FitnessSystem.App;

public class NotificationControls {
	
	private static Map<String, String> SchedChangeMap = App.getProgramScheduleChangeMap();
	private static Map<String, Program> ProgramMap=App.getFitnessProgramsMap();
	private static List<String> AnnouncementMap= App.getInstructorAnnouncementsMap();
	private static boolean Changesent=false;
	private static boolean Announcementsent=false;
	private static boolean programfound=false;

	
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
	
	public static String AddanAnnouncement(String name) {
		AnnouncementMap.add(name);
		System.out.println("An announcement is made ");
		Announcementsent=true;
	    return "Announcement made.";
	    
	}
	
	public static boolean ChangeSent() {
		if (Changesent==true) {
		return true;
		}
		return false;
	    
	}
	
	public static boolean AnnouncementSent() {
		if (Announcementsent==true) {
		return true;
		}
		return false;
	    
	}
	
	public static boolean ProgramFound() {
		if (programfound==true) {
		return true;
		}
		else {
		return false;
		}
	}
	
	

	
}