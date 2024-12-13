package com.Software.FitnessSystem;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.ClientControllers.Profile;
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

	public static void saveClientProfileToFile(Map<String, Profile> clientProfileMap,
			String clientProfilesFilename) {
		File file = new File(clientProfilesFilename);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, clientProfileMap);
        } catch (IOException e) {
            System.err.println("Error saving handled feedback Tips data: " + e.getMessage());
        }
		
	}

	public static void loadClientProfilesFromFile(Map<String, Profile> clientProfileMap,
			String clientProfilesFilename) {
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
            System.err.println("Error loading handled feedback data: " + e.getMessage());
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
}