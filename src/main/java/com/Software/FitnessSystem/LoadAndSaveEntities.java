package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.CustomPlan;
import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.ClientControllers.Profile;
import com.Software.FitnessSystem.InstructorControllers.Program;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadAndSaveEntities {
	public static boolean saveCustomSubscriptionPlanToFile(Map<String, CustomPlan> CustomSubscriptionPlanMap, String CustomSubscriptionPlanFile) {
        File file = new File(CustomSubscriptionPlanFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, CustomSubscriptionPlanMap);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving Admins data: " + e.getMessage());
            return false;
        }
    }
    
    public static void loadCustomSubscriptionPlanFromFile(Map<String, CustomPlan> CustomSubscriptionPlanMap, String CustomSubscriptionPlanFile) {
        File file = new File(CustomSubscriptionPlanFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, CustomPlan> loadedCustomSubscriptionPlan = objectMapper.readValue(file, new TypeReference<Map<String, CustomPlan>>() {});
            CustomSubscriptionPlanMap.putAll(loadedCustomSubscriptionPlan);
        } catch (IOException e) {
            System.err.println("Error loading Admins data: " + e.getMessage());
        }
    }
    
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
            Map<String, Content> loadedContent = objectMapper.readValue(file, new TypeReference<Map<String, Content>>() {});
            instructorTipsMap.putAll(loadedContent);
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
            Map<String, String> loadedFeedbacks = objectMapper.readValue(file, new TypeReference<Map<String, String>>() {});
            handledFeedbackMap.putAll(loadedFeedbacks);
        } catch (IOException e) {
            System.err.println("Error loading handled feedback data: " + e.getMessage());
        }
    }
    
	public static void saveClientProfileToFile(Map<String, Profile> clientProfileMap, String clientProfilesFilename) {
		File file = new File(clientProfilesFilename);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, clientProfileMap);
        } catch (IOException e) {
            System.err.println("Error saving client profiles: " + e.getMessage());
        }
	}
	
	public static void loadClientProfilesFromFile(Map<String, Profile> clientProfileMap, String clientProfilesFilename) {
		File file = new File(clientProfilesFilename);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Profile> loadedClientProfiles = objectMapper.readValue(file, new TypeReference<Map<String, Profile>>() {});
            clientProfileMap.putAll(loadedClientProfiles);
        } catch (IOException e) {
            System.err.println("Error loading client profiles: " + e.getMessage());
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
	
	public static void saveProgramRatingsToFile(Map<String, Map<String, Integer>> programRatings, String programRatingsFilename) {
		File file = new File(programRatingsFilename);
	    if (!file.exists()) {
	        System.err.println("The file does not exist. A new file will be created.");
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.writeValue(file, programRatings);
	    } catch (IOException e) {
	        System.err.println("Error saving program ratings data: " + e.getMessage());
	    }		
	}
	
	public static void loadProgramRatingsFromFile(Map<String, Map<String, Integer>> programRatings, String programRatingsFilename) {
		File file = new File(programRatingsFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Map<String, Integer>> loadedRatings = objectMapper.readValue(
	            file, new TypeReference<Map<String, Map<String, Integer>>>() {});
	        programRatings.putAll(loadedRatings);
	    } catch (IOException e) {
	        System.err.println("Error loading program ratings data: " + e.getMessage());
	    }		
	}
	
	public static void saveProgramReviewsToFile(Map<String, Map<String, String>> programReviews, String programReviewsFilename) {
		File file = new File(programReviewsFilename);
	    if (!file.exists()) {
	        System.err.println("The file does not exist. A new file will be created.");
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.writeValue(file, programReviews);
	    } catch (IOException e) {
	        System.err.println("Error saving program reviews data: " + e.getMessage());
	    }		
	}
	
	public static void loadProgramReviewsFromFile(Map<String, Map<String, String>> programReviews, String programReviewsFilename) {
		File file = new File(programReviewsFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Map<String, String>> loadedReviews = objectMapper.readValue(
	            file, new TypeReference<Map<String, Map<String, String>>>() {});
	        programReviews.putAll(loadedReviews);
	    } catch (IOException e) {
	        System.err.println("Error loading program reviews data: " + e.getMessage());
	    }		
	}
	
	public static void saveProgramSuggestionsToFile(Map<String, Map<String, String>> programSuggestions, String programSuggestionsFilename) {
		File file = new File(programSuggestionsFilename);
	    if (!file.exists()) {
	        System.err.println("The file does not exist. A new file will be created.");
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.writeValue(file, programSuggestions);
	    } catch (IOException e) {
	        System.err.println("Error saving program suggestions data: " + e.getMessage());
	    }		
	}
	
	public static void loadProgramSuggestionsFromFile(Map<String, Map<String, String>> programSuggestions, String programSuggestionsFilename) {
		File file = new File(programSuggestionsFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Map<String, String>> loadedSuggestions = objectMapper.readValue(
	        		file, new TypeReference<Map<String, Map<String, String>>>() {});
	        programSuggestions.putAll(loadedSuggestions);
	    } catch (IOException e) {
	        System.err.println("Error loading program suggestions data: " + e.getMessage());
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
            System.err.println("Error saving Instructor msgs: " + e.getMessage());
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
            System.err.println("Error loading Instructor msgs: " + e.getMessage());
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
            System.err.println("Error saving program forums msgs: " + e.getMessage());
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
            System.err.println("Error loading program forums msgs: " + e.getMessage());
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
            System.err.println("Error saving Feedbacks to client: " + e.getMessage());
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
            System.err.println("Error loading Feedbacks to client: " + e.getMessage());
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
            System.err.println("Error saving Instructor Reminder: " + e.getMessage());
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
            System.err.println("Error loading Instructor Reminder: " + e.getMessage());
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
            System.err.println("Error saving Instructor Recommednation: " + e.getMessage());
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
            System.err.println("Error loading Instructor Recommednation: " + e.getMessage());
        }
    }
    
    public static void saveInstructorAnnouncementToFile(List<String> instructorAnnouncements, String instructorAnnouncementsFile) {
        File file = new File(instructorAnnouncementsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, instructorAnnouncements);
            System.out.println("Instructor announcements saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving instructor announcements: " + e.getMessage());
        }
    }
    
    public static void loadInstructorAnnouncementFromFile(List<String> instructorAnnouncements, String instructorAnnouncementsFile) {
        File file = new File(instructorAnnouncementsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (!isJsonArray(file, objectMapper)) {
                System.err.println("Error: The file does not contain a valid JSON array.");
                return;
            }
            
            List<String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<List<String>>() {});
            instructorAnnouncements.addAll(loadedInstructorTips);
            System.out.println("Instructor announcements loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading instructor announcements: " + e.getMessage());
        }
    }
    
    private static boolean isJsonArray(File file, ObjectMapper objectMapper) {
        try {
        	JsonNode jsonContent = objectMapper.readTree(file);
            return jsonContent.isArray();
        } catch (IOException e) {
            System.err.println("Error reading the JSON structure: " + e.getMessage());
            return false;
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
            System.err.println("Error saving Program schedule: " + e.getMessage());
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
            System.err.println("Error loading Program schedule: " + e.getMessage());
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
            System.err.println("Error saving Progress: " + e.getMessage());
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
            System.err.println("Error loading Progress: " + e.getMessage());
        }
    }
}