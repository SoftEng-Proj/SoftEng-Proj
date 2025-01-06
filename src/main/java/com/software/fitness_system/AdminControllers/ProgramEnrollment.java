package com.software.fitness_system.AdminControllers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.software.fitness_system.InstructorControllers.Program;

/**
 * Represents the enrollment statistics for a fitness program.
 * This class contains information about the program's name, the number of enrollments, 
 * and the program's status (e.g., Active or Completed).
 * It also provides utility methods to generate and manage enrollment statistics 
 * from a map of fitness programs.
 * 
 * @author Muath Hassoun
 */
public class ProgramEnrollment {
    private String programName;
    private int enrollments;
    private String status;

    /**
     * Parameterized constructor to initialize a ProgramEnrollment object with specific details.
     * 
     * @param programName The name of the fitness program.
     * @param enrollments The number of enrollments in the fitness program.
     * @param status The status of the program (e.g., "Active", "Completed").
     */
    public ProgramEnrollment(String programName, int enrollments, String status) {
        this.programName = programName;
        this.enrollments = enrollments;
        this.status = status;
    }

    /**
     * Default constructor.
     * Initializes a ProgramEnrollment object with default values.
     */
    public ProgramEnrollment() {
    }

    /**
     * Retrieves the name of the fitness program.
     *
     * @return The name of the program.
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * Sets the name of the fitness program.
     *
     * @param programName The name to set for the program.
     */
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    /**
     * Retrieves the number of enrollments for the fitness program.
     * 
     * @return The number of enrollments.
     */
    public int getEnrollments() {
        return enrollments;
    }

    /**
     * Sets the number of enrollments for the fitness program.
     *
     * @param enrollments The number of enrollments to set.
     */
    public void setEnrollments(int enrollments) {
        this.enrollments = enrollments;
    }

    /**
     * Retrieves the status of the fitness program.
     * 
     * @return The status of the program (e.g., "Active", "Completed").
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the fitness program.
     * 
     * @param status The status to set for the program.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Generates enrollment statistics from a map of fitness programs.
     * 
     * @param fitnessProgramsMap A map of fitness programs where the key is the program name 
     *                           and the value is a Program object.
     * @return A map of enrollment statistics, where the key is the program name 
     *         and the value is a ProgramEnrollment object.
     */
    public static Map<String, ProgramEnrollment> enrolmentStatistics(Map<String, Program> fitnessProgramsMap) {
        Map<String, ProgramEnrollment> enrolmentStatisticsMap = new HashMap<>();
        Map<String, Integer> statisticsMap = new HashMap<>();
        Map<String, String> durationMap = new HashMap<>();

        if (fitnessProgramsMap == null || fitnessProgramsMap.isEmpty()) {
            return enrolmentStatisticsMap;
        }

        fillStatisticsMap(statisticsMap, fitnessProgramsMap);
        fillDurationMap(durationMap, fitnessProgramsMap);
        fillEnrolmentStatisticsMap(statisticsMap, durationMap, enrolmentStatisticsMap);
        return enrolmentStatisticsMap;
    }

    /**
     * Populates the statistics map with the number of enrollments for each program.
     * 
     * @param statisticsMap The map to populate with enrollment counts.
     * @param fitnessProgramsMap The map of fitness programs to extract data from.
     */
    private static void fillStatisticsMap(Map<String, Integer> statisticsMap, Map<String, Program> fitnessProgramsMap) {
        for (Program entry : fitnessProgramsMap.values()) {
            statisticsMap.merge(entry.getName(), 1, Integer::sum);
        }
    }

    /**
     * Populates the duration map with the status (Active/Completed) of each program.
     * 
     * @param durationMap The map to populate with program statuses.
     * @param fitnessProgramsMap The map of fitness programs to extract data from.
     */
    private static void fillDurationMap(Map<String, String> durationMap, Map<String, Program> fitnessProgramsMap) {
        for (Program entry : fitnessProgramsMap.values()) {
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
                e.fillInStackTrace();
            }
        }
    }

    /**
     * Formats a date string to ensure day and month values have two digits.
     * 
     * @param date The date string to format.
     * @return A formatted date string.
     */
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

    /**
     * Populates the enrollment statistics map with ProgramEnrollment objects.
     * 
     * @param statisticsMap The map containing enrollment counts.
     * @param durationMap The map containing program statuses.
     * @param enrolmentStatisticsMap The map to populate with ProgramEnrollment objects.
     */
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