package com.Software.FitnessSystem.AdminControllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.Software.FitnessSystem.InstructorControllers.Program;

public class ProgramEnrollment {
	private String programName;
    private int enrollments;
    private String status;
	
    public ProgramEnrollment(String programName, int enrollments, String status) {
        this.programName = programName;
        this.enrollments = enrollments;
        this.status = status;
    }
	
	public ProgramEnrollment() {
	}
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public int getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(int enrollments) {
		this.enrollments = enrollments;
	}
	
	public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public static Map<String, ProgramEnrollment> enrolmentStatistics(Map<String, Program> fitnessProgramsMap) {
    	Map<String, ProgramEnrollment> enrolmentStatisticsMap = new HashMap<>();
    	Map<String, Integer> statisticsMap = new HashMap<>();
    	Map<String, String> durationMap = new HashMap<>();
    	
    	if(fitnessProgramsMap == null || fitnessProgramsMap.isEmpty()) {
    		return enrolmentStatisticsMap;
    	}
    	
    	fillStatisticsMap(statisticsMap, fitnessProgramsMap);
    	fillDurationMap(durationMap, fitnessProgramsMap);
    	fillEnrolmentStatisticsMap(statisticsMap, durationMap, enrolmentStatisticsMap);
    	return enrolmentStatisticsMap;
    }
    
    // from clients
    private static void fillStatisticsMap(Map<String, Integer> statisticsMap, Map<String, Program> fitnessProgramsMap) {
    	for(Program entry : fitnessProgramsMap.values()) {
    		statisticsMap.merge(entry.getName(), 1, Integer::sum);
    	}
    }
    
    private static void fillDurationMap(Map<String, String> durationMap, Map<String, Program> fitnessProgramsMap) {
    	for(Program entry : fitnessProgramsMap.values()) {
    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    		try {
    			String endDate = formatDate(entry.getEndAt());
    		    LocalDate programDate = LocalDate.parse(endDate, formatter);
    		    if (programDate.isAfter(LocalDate.now())) {
    		    	durationMap.merge(entry.getName(), "Active", (oldValue, newValue) -> newValue);
    		    } else {
    		    	durationMap.merge(entry.getName(), "Completed", (oldValue, newValue) -> newValue);
    		    }
    		} catch (DateTimeParseException e) {
    		    System.out.println("Invalid date format for program: " + entry.getName());
    		    e.printStackTrace();
    		}
    	}
    }
    
    private static String formatDate(String date) {
        String[] parts = date.split("-");
        if (parts[0].length() == 1) {
            parts[0] = "0" + parts[0];
        }
        if (parts[1].length() == 1) {
            parts[1] = "0" + parts[1];
        }
        return String.join("-", parts);
    }
    
    private static void fillEnrolmentStatisticsMap(Map<String, Integer> statisticsMap, Map<String, String> durationMap,
    		Map<String, ProgramEnrollment> enrolmentStatisticsMap) {
    	
    	Set<String> keys = statisticsMap.keySet();
    	for (String key : keys) {
    	    int count = statisticsMap.get(key);
    	    String status = durationMap.get(key);
    	    enrolmentStatisticsMap.put(key, new ProgramEnrollment(key, count, status));
    	}
    }
}