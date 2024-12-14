package com.Software.FitnessSystem;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.InstructorControllers.Program;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadAndSaveEntities {
    public static void saveAdminsToFile(Map<String, Admin> adminsMap, String AdminAccountsFile) {
        File file = new File(AdminAccountsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, adminsMap);
        } catch (IOException e) {
            System.err.println("Error saving Admins data: " + e.getMessage());
        }
    }
    
    public static void loadAdminsFromFile(Map<String, Admin> adminsMap, String AdminAccountsFile) {
        File file = new File(AdminAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Admin> loadedAdmins = objectMapper.readValue(file, new TypeReference<Map<String, Admin>>() {});
            adminsMap.putAll(loadedAdmins);
        } catch (IOException e) {
            System.err.println("Error loading Admins data: " + e.getMessage());
        }
    }
    
    public static void saveInstructorsToFile(Map<String, Instructor> instructorsMap, String InstructorsAccountsFile) {
        File file = new File(InstructorsAccountsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, instructorsMap);
        } catch (IOException e) {
            System.err.println("Error saving Instructors data: " + e.getMessage());
        }
    }
    
    public static void loadInstructorsFromFile(Map<String, Instructor> instructorsMap, String InstructorsAccountsFile) {
        File file = new File(InstructorsAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Instructor> loadedInstructors = objectMapper.readValue(file, new TypeReference<Map<String, Instructor>>() {});
            instructorsMap.putAll(loadedInstructors);
        } catch (IOException e) {
            System.err.println("Error loading Instructors data: " + e.getMessage());
        }
    }
    
    public static void saveClientsToFile(Map<String, Client> clientsMap, String clientsAccountsFile) {
        File file = new File(clientsAccountsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, clientsMap);
        } catch (IOException e) {
            System.err.println("Error saving Clients data: " + e.getMessage());
        }
    }
    
    public static void loadClientsFromFile(Map<String, Client> clientsMap, String clientsAccountsFile) {
        File file = new File(clientsAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Client> loadedClients = objectMapper.readValue(file, new TypeReference<Map<String, Client>>() {});
            clientsMap.putAll(loadedClients);
        } catch (IOException e) {
            System.err.println("Error loading Clients data: " + e.getMessage());
        }
    }
    
    public static void saveFitnessProgramsToFile(Map<String, Program> fitnessProgramsMap, String fitnessProgramsFile) {
        File file = new File(fitnessProgramsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, fitnessProgramsMap);
        } catch (IOException e) {
            System.err.println("Error saving Fitness Programs data: " + e.getMessage());
        }
    }
    
    public static void loadFitnessProgramsFromFile(Map<String, Program> fitnessProgramsMap, String fitnessProgramsFile) {
        File file = new File(fitnessProgramsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Program> loadedFitnessPrograms = objectMapper.readValue(file, new TypeReference<Map<String, Program>>() {});
            fitnessProgramsMap.putAll(loadedFitnessPrograms);
        } catch (IOException e) {
            System.err.println("Error loading Fitness Programs data: " + e.getMessage());
        }
    }
    
    public static void saveContentsToFile(Map<String, Content> instructorTipsMap, String InstructorTipsFile) {
        File file = new File(InstructorTipsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, instructorTipsMap);
        } catch (IOException e) {
            System.err.println("Error saving Tips data: " + e.getMessage());
        }
    }
    
    public static void loadContentsFromFile(Map<String, Content> instructorTipsMap, String InstructorTipsFile) {
        File file = new File(InstructorTipsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Content> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, Content>>() {});
            instructorTipsMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
    
    public static void saveHandledFeedbackToFile(Map<String, String> handledFeedbackMap, String HandledFeedbackFile) {
        File file = new File(HandledFeedbackFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, handledFeedbackMap);
        } catch (IOException e) {
            System.err.println("Error saving handled feedback Tips data: " + e.getMessage());
        }
    }
    
    public static void loadHandledFeedbackFromFile(Map<String, String> handledFeedbackMap, String HandledFeedbackFile) {
        File file = new File(HandledFeedbackFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            handledFeedbackMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading handled feedback data: " + e.getMessage());
        }
    }
    
    
    public static void saveInstructorMsgsToClientsToFile(Map<String, String> InstructorMSGSToClientsMap, String InstructorMSGsFile) {
        File file = new File(InstructorMSGsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, InstructorMSGSToClientsMap);
        } catch (IOException e) {
            System.err.println("Error saving handled feedback Tips data: " + e.getMessage());
        }
    }
    
    
    public static void loadInstructorMsgsToClientsFromFile(Map<String, String> InstructorMSGSToClientsMap, String InstructorMSGsFile) {
        File file = new File(InstructorMSGsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            InstructorMSGSToClientsMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
    
    
    
    public static void saveProgramForumMsgsToFile(Map<String, String> ProgramForumMsgsMap, String ProgramForumMsgsFile) {
        File file = new File(ProgramForumMsgsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, ProgramForumMsgsMap);
        } catch (IOException e) {
            System.err.println("Error saving program forums msgs data: " + e.getMessage());
        }
    }
    
    
    public static void loadProgramForumMsgsFromFile(Map<String, String> ProgramForumMsgsMap, String ProgramForumMsgsFile) {
        File file = new File(ProgramForumMsgsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            ProgramForumMsgsMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
    
    public static void saveFeedbackToClientToFile(Map<String, String> FeedbackToClientMap, String FeedbackToClientFile) {
        File file = new File(FeedbackToClientFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, FeedbackToClientMap);
        } catch (IOException e) {
            System.err.println("Error saving program forums msgs data: " + e.getMessage());
        }
    }
    
    
    
    public static void loadFeedbackToClientFromFile(Map<String, String> FeedbackToClientMap, String FeedbackToClientFile) {
        File file = new File(FeedbackToClientFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            FeedbackToClientMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
    
    
    
    public static void saveMilestonesToFile(List<FitnessMilestone> MilestonesList, String milestonesFilename) {
		File file = new File(milestonesFilename);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, MilestonesList);
        } catch (IOException e) {
            System.err.println("Error saving milestones data: " + e.getMessage());
        }
	}
	public static void loadMilestonesFromFile(List<FitnessMilestone> MilestonesList, String milestonesFilename) {
	    File file = new File(milestonesFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }

	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<FitnessMilestone> loadedMilestones = objectMapper.readValue(file, new TypeReference<List<FitnessMilestone>>() {});
	        MilestonesList.addAll(loadedMilestones);
	    } catch (IOException e) {
	        System.err.println("Error loading milestones data: " + e.getMessage());
	    }
	}
    
    
	public static void saveInstructorReminderToFile(Map<String, String> InstructorReminderMap, String InstructorReminderFile) {
        File file = new File(InstructorReminderFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, InstructorReminderMap);
        } catch (IOException e) {
            System.err.println("Error saving reminders data: " + e.getMessage());
        }
    }
    
    
    public static void loadInstructorReminderFromFile(Map<String, String> InstructorReminderMap, String InstructorReminderFile) {
        File file = new File(InstructorReminderFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            InstructorReminderMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
    
    
    public static void saveInstructorRecommendationToFile(Map<String, String> InstructorRecommednationMap, String InstructorRecommednationFile) {
        File file = new File(InstructorRecommednationFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, InstructorRecommednationMap);
        } catch (IOException e) {
            System.err.println("Error saving reminders data: " + e.getMessage());
        }
    }
    
    
    public static void loadInstructorRecommednationFromFile(Map<String, String> InstructorRecommednationMap, String InstructorRecommednationFile) {
        File file = new File(InstructorRecommednationFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            InstructorRecommednationMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
	
    
    public static void saveInstructorAnnouncemntToFile(List<String> InstructorAnnouncementsMap, String InstructorAnnouncementsFile) {
        File file = new File(InstructorAnnouncementsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, InstructorAnnouncementsMap);
        } catch (IOException e) {
            System.err.println("Error saving reminders data: " + e.getMessage());
        }
    }
    
    
    public static void loadInstructorAnnouncemntFromFile(List<String> InstructorAnnouncementsMap, String InstructorAnnouncementsFile) {
        File file = new File(InstructorAnnouncementsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<List<String>>() {});
            InstructorAnnouncementsMap.addAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
	
    
    
    public static void saveProgramScheduleChangeToFile(Map<String, String> ProgramScheduleChangeMap, String ProgramScheduleChangeFile) {
        File file = new File(ProgramScheduleChangeFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, ProgramScheduleChangeMap);
        } catch (IOException e) {
            System.err.println("Error saving reminders data: " + e.getMessage());
        }
    }
    
    
    public static void loadProgramScheduleChangeFromFile(Map<String, String> ProgramScheduleChangeMap, String ProgramScheduleChangeFile) {
        File file = new File(ProgramScheduleChangeFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            ProgramScheduleChangeMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
    
    
    public static void saveProgressListToFile(Map<String, String> ProgressListMap, String ProgressListFile) {
        File file = new File(ProgressListFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, ProgressListMap);
        } catch (IOException e) {
            System.err.println("Error saving reminders data: " + e.getMessage());
        }
    }
    
    
    public static void loadProgressListFromFile(Map<String, String> ProgressListMap, String ProgressListFile) {
        File file = new File(ProgressListFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            ProgressListMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
	
    
    
    
    
    
    
}