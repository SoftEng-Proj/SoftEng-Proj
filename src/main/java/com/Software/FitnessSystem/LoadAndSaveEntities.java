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

/**
 * Utility class for handling the loading and saving of various entities
 * in the Fitness Management System. This class provides methods to
 * read data from persistent storage and save updated data back to files.
 * 
 * @author Muath Hassoun
 * @author Alaa Alawneh
 * @author Ammar Shafii
 */
public class LoadAndSaveEntities {
	/**
	 * Saves the custom subscription plan map to a file.
	 * If the file doesn't exist, a new file will be created.
	 * @author Muath Hassoun
	 * @param CustomSubscriptionPlanMap the map of custom subscription plans to save
	 * @param CustomSubscriptionPlanFile the path to the file where the data will be saved
	 * @return true if the data was saved successfully, false otherwise
	 */
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
    
	/**
	 * Loads the custom subscription plan data from a file into the provided map.
	 * If the file doesn't exist, an error message will be printed.
	 * @author Muath Hassoun
	 * @param CustomSubscriptionPlanMap the map to load the custom subscription plans into
	 * @param CustomSubscriptionPlanFile the path to the file from which to load the data
	 */
    public static void loadCustomSubscriptionPlanFromFile(Map<String, CustomPlan> CustomSubscriptionPlanMap, String CustomSubscriptionPlanFile) {
        File file = new File(CustomSubscriptionPlanFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, CustomPlan> loadedCustomSubscriptionPlan = objectMapper.readValue(file, new TypeReference<>() {});
            CustomSubscriptionPlanMap.putAll(loadedCustomSubscriptionPlan);
        } catch (IOException e) {
            System.err.println("Error loading Admins data: " + e.getMessage());
        }
    }
    
    /**
     * Saves the admin data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Muath Hassoun
     * @param adminsMap the map of admin data to save
     * @param AdminAccountsFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the admin data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Muath Hassoun
     * @param adminsMap the map to load the admin data into
     * @param AdminAccountsFile the path to the file from which to load the data
     */
    public static void loadAdminsFromFile(Map<String, Admin> adminsMap, String AdminAccountsFile) {
        File file = new File(AdminAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Admin> loadedAdmins = objectMapper.readValue(file, new TypeReference<>() {});
            adminsMap.putAll(loadedAdmins);
        } catch (IOException e) {
            System.err.println("Error loading Admins data: " + e.getMessage());
        }
    }
    
    /**
     * Saves the instructor data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Muath Hassoun
     * @param instructorsMap the map of instructor data to save
     * @param InstructorsAccountsFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the instructor data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Muath Hassoun
     * @param instructorsMap the map to load the instructor data into
     * @param InstructorsAccountsFile the path to the file from which to load the data
     */
    public static void loadInstructorsFromFile(Map<String, Instructor> instructorsMap, String InstructorsAccountsFile) {
        File file = new File(InstructorsAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Instructor> loadedInstructors = objectMapper.readValue(file, new TypeReference<>() {});
            instructorsMap.putAll(loadedInstructors);
        } catch (IOException e) {
            System.err.println("Error loading Instructors data: " + e.getMessage());
        }
    }
    
    /**
     * Saves the client data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Muath Hassoun
     * @param clientsMap the map of client data to save
     * @param clientsAccountsFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the client data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Muath Hassoun
     * @param clientsMap the map to load the client data into
     * @param clientsAccountsFile the path to the file from which to load the data
     */
    public static void loadClientsFromFile(Map<String, Client> clientsMap, String clientsAccountsFile) {
        File file = new File(clientsAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Client> loadedClients = objectMapper.readValue(file, new TypeReference<>() {});
            clientsMap.putAll(loadedClients);
        } catch (IOException e) {
            System.err.println("Error loading Clients data: " + e.getMessage());
        }
    }
    
    /**
     * Saves the fitness program data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Muath Hassoun
     * @param fitnessProgramsMap the map of fitness programs to save
     * @param fitnessProgramsFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the fitness program data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Muath Hassoun
     * @param fitnessProgramsMap the map to load the fitness program data into
     * @param fitnessProgramsFile the path to the file from which to load the data
     */
    public static void loadFitnessProgramsFromFile(Map<String, Program> fitnessProgramsMap, String fitnessProgramsFile) {
        File file = new File(fitnessProgramsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Program> loadedFitnessPrograms = objectMapper.readValue(file, new TypeReference<>() {});
            fitnessProgramsMap.putAll(loadedFitnessPrograms);
        } catch (IOException e) {
            System.err.println("Error loading Fitness Programs data: " + e.getMessage());
        }
    }
    
    /**
     * Saves the instructor tips content data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Muath Hassoun
     * @param instructorTipsMap the map of instructor tips content to save
     * @param InstructorTipsFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the instructor tips content data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Muath Hassoun
     * @param instructorTipsMap the map to load the instructor tips content into
     * @param InstructorTipsFile the path to the file from which to load the data
     */
    public static void loadContentsFromFile(Map<String, Content> instructorTipsMap, String InstructorTipsFile) {
        File file = new File(InstructorTipsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Content> loadedContent = objectMapper.readValue(file, new TypeReference<>() {});
            instructorTipsMap.putAll(loadedContent);
        } catch (IOException e) {
            System.err.println("Error loading Tips data: " + e.getMessage());
        }
    }
    
    /**
     * Saves the handled feedback data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Muath Hassoun
     * @param handledFeedbackMap the map of handled feedback to save
     * @param HandledFeedbackFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the handled feedback data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Muath Hassoun
     * @param handledFeedbackMap the map to load the handled feedback data into
     * @param HandledFeedbackFile the path to the file from which to load the data
     */
    public static void loadHandledFeedbackFromFile(Map<String, String> handledFeedbackMap, String HandledFeedbackFile) {
        File file = new File(HandledFeedbackFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedFeedbacks = objectMapper.readValue(file, new TypeReference<>() {});
            handledFeedbackMap.putAll(loadedFeedbacks);
        } catch (IOException e) {
            System.err.println("Error loading handled feedback data: " + e.getMessage());
        }
    }
    
    /**
     * Saves the client profile data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Alaa Alawneh
     * @param clientProfileMap the map of client profiles to save
     * @param clientProfilesFilename the path to the file where the data will be saved
     */
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
	
	/**
	 * Loads the client profile data from a file into the provided map.
	 * If the file doesn't exist, an error message will be printed.
	 * @author Alaa Alawneh
	 * @param clientProfileMap the map to load the client profile data into
	 * @param clientProfilesFilename the path to the file from which to load the data
	 */
	public static void loadClientProfilesFromFile(Map<String, Profile> clientProfileMap, String clientProfilesFilename) {
		File file = new File(clientProfilesFilename);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Profile> loadedClientProfiles = objectMapper.readValue(file, new TypeReference<>() {});
            clientProfileMap.putAll(loadedClientProfiles);
        } catch (IOException e) {
            System.err.println("Error loading client profiles: " + e.getMessage());
        }
	}
	
	/**
	 * Saves the fitness milestone data to a file.
	 * If the file doesn't exist, a new file will be created.
	 * @author Alaa Alawneh
	 * @param MilestonesList the list of fitness milestones to save
	 * @param milestonesFilename the path to the file where the data will be saved
	 */
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
	
	/**
	 * Loads the fitness milestone data from a file into the provided list.
	 * If the file doesn't exist, an error message will be printed.
	 * @author Alaa Alawneh
	 * @param MilestonesList the list to load the fitness milestones into
	 * @param milestonesFilename the path to the file from which to load the data
	 */
	public static void loadMilestonesFromFile(List<FitnessMilestone> MilestonesList, String milestonesFilename) {
	    File file = new File(milestonesFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        List<FitnessMilestone> loadedMilestones = objectMapper.readValue(file, new TypeReference<>() {});
	        MilestonesList.addAll(loadedMilestones);
	    } catch (IOException e) {
	        System.err.println("Error loading milestones data: " + e.getMessage());
	    }
	}
	
	/**
	 * Saves the program ratings data to a file.
	 * If the file doesn't exist, a new file will be created.
	 * @author Alaa Alawneh
	 * @param programRatings the map of program ratings to save
	 * @param programRatingsFilename the path to the file where the data will be saved
	 */
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
	
	/**
	 * Loads the program ratings data from a file into the provided map.
	 * If the file doesn't exist, an error message will be printed.
	 * @author Alaa Alawneh
	 * @param programRatings the map to load the program ratings data into
	 * @param programRatingsFilename the path to the file from which to load the data
	 */
	public static void loadProgramRatingsFromFile(Map<String, Map<String, Integer>> programRatings, String programRatingsFilename) {
		File file = new File(programRatingsFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Map<String, Integer>> loadedRatings = objectMapper.readValue(
	            file, new TypeReference<>() {});
	        programRatings.putAll(loadedRatings);
	    } catch (IOException e) {
	        System.err.println("Error loading program ratings data: " + e.getMessage());
	    }		
	}
	
	/**
	 * Saves the program reviews data to a file.
	 * If the file doesn't exist, a new file will be created.
	 * @author Alaa Alawneh
	 * @param programReviews the map of program reviews to save
	 * @param programReviewsFilename the path to the file where the data will be saved
	 */
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
	
	/**
	 * Loads the program reviews data from a file into the provided map.
	 * If the file doesn't exist, an error message will be printed.
	 * @author Alaa Alawneh
	 * @param programReviews the map to load the program reviews into
	 * @param programReviewsFilename the path to the file from which to load the data
	 */
	public static void loadProgramReviewsFromFile(Map<String, Map<String, String>> programReviews, String programReviewsFilename) {
		File file = new File(programReviewsFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Map<String, String>> loadedReviews = objectMapper.readValue(
	            file, new TypeReference<>() {});
	        programReviews.putAll(loadedReviews);
	    } catch (IOException e) {
	        System.err.println("Error loading program reviews data: " + e.getMessage());
	    }		
	}
	
	/**
	 * Saves the program suggestions data to a file.
	 * If the file doesn't exist, a new file will be created.
	 * @author Alaa Alawneh
	 * @param programSuggestions the map of program suggestions to save
	 * @param programSuggestionsFilename the path to the file where the data will be saved
	 */
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
	
	/**
	 * Loads the program suggestions data from a file into the provided map.
	 * If the file doesn't exist, an error message will be printed.
	 * @author Alaa Alawneh
	 * @param programSuggestions the map to load the program suggestions into
	 * @param programSuggestionsFilename the path to the file from which to load the data
	 */
	public static void loadProgramSuggestionsFromFile(Map<String, Map<String, String>> programSuggestions, String programSuggestionsFilename) {
		File file = new File(programSuggestionsFilename);
	    if (!file.exists()) {
	        System.err.println("File does not exist. Cannot load data.");
	        return;
	    }
	    
	    try {
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Map<String, String>> loadedSuggestions = objectMapper.readValue(
	        		file, new TypeReference<>() {});
	        programSuggestions.putAll(loadedSuggestions);
	    } catch (IOException e) {
	        System.err.println("Error loading program suggestions data: " + e.getMessage());
	    }		
	}
    
	/**
	 * Saves the instructor messages to clients data to a file.
	 * If the file doesn't exist, a new file will be created.
	 * @author Ammar Shafii
	 * @param InstructorMSGSToClientsMap the map of instructor messages to save
	 * @param InstructorMSGsFile the path to the file where the data will be saved
	 */
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
    
    /**
     * Loads the instructor messages to clients data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Ammar Shafii
     * @param InstructorMSGSToClientsMap the map to load the instructor messages to clients into
     * @param InstructorMSGsFile the path to the file from which to load the data
     */
    public static void loadInstructorMsgsToClientsFromFile(Map<String, String> InstructorMSGSToClientsMap, String InstructorMSGsFile) {
        File file = new File(InstructorMSGsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
            InstructorMSGSToClientsMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Instructor msgs: " + e.getMessage());
        }
    }
    
    /**
     * Saves the program forum messages to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Ammar Shafii
     * @param ProgramForumMsgsMap the map of program forum messages to save
     * @param ProgramForumMsgsFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the program forum messages data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Ammar Shafii
     * @param ProgramForumMsgsMap the map to load the program forum messages into
     * @param ProgramForumMsgsFile the path to the file from which to load the data
     */
    public static void loadProgramForumMsgsFromFile(Map<String, String> ProgramForumMsgsMap, String ProgramForumMsgsFile) {
        File file = new File(ProgramForumMsgsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
            ProgramForumMsgsMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading program forums msgs: " + e.getMessage());
        }
    }
    
    /**
     * Saves the feedback data to clients to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Ammar Shafii
     * @param FeedbackToClientMap the map of feedback to save
     * @param FeedbackToClientFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the feedback data to clients from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Ammar Shafii
     * @param FeedbackToClientMap the map to load the feedback to clients into
     * @param FeedbackToClientFile the path to the file from which to load the data
     */
    public static void loadFeedbackToClientFromFile(Map<String, String> FeedbackToClientMap, String FeedbackToClientFile) {
        File file = new File(FeedbackToClientFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
            FeedbackToClientMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Feedbacks to client: " + e.getMessage());
        }
    }
    
    /**
     * Saves the instructor reminder data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Ammar Shafii
     * @param InstructorReminderMap the map of instructor reminders to save
     * @param InstructorReminderFile the path to the file where the data will be saved
     */
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
    
	/**
	 * Loads the instructor reminder data from a file into the provided map.
	 * If the file doesn't exist, an error message will be printed.
	 * @author Ammar Shafii
	 * @param InstructorReminderMap the map to load the instructor reminders into
	 * @param InstructorReminderFile the path to the file from which to load the data
	 */
    public static void loadInstructorReminderFromFile(Map<String, String> InstructorReminderMap, String InstructorReminderFile) {
        File file = new File(InstructorReminderFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
            InstructorReminderMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Instructor Reminder: " + e.getMessage());
        }
    }
    
    /**
     * Saves the instructor recommendation data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Ammar Shafii
     * @param InstructorRecommednationMap the map of instructor recommendations to save
     * @param InstructorRecommednationFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the instructor recommendation data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Ammar Shafii
     * @param InstructorRecommednationMap the map to load the instructor recommendations into
     * @param InstructorRecommednationFile the path to the file from which to load the data
     */
    public static void loadInstructorRecommednationFromFile(Map<String, String> InstructorRecommednationMap, String InstructorRecommednationFile) {
        File file = new File(InstructorRecommednationFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
            InstructorRecommednationMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Instructor Recommednation: " + e.getMessage());
        }
    }
    
    /**
     * Saves the instructor announcements data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Ammar Shafii
     * @param instructorAnnouncements the list of instructor announcements to save
     * @param instructorAnnouncementsFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the instructor announcements data from a file into the provided list.
     * If the file doesn't exist, an error message will be printed.
     * @author Ammar Shafii
     * @param instructorAnnouncements the list to load the instructor announcements into
     * @param instructorAnnouncementsFile the path to the file from which to load the data
     */
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
            
            List<String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
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
	
    /**
     * Saves the program schedule change data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Ammar Shafii
     * @param ProgramScheduleChangeMap the map of program schedule changes to save
     * @param ProgramScheduleChangeFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the program schedule change data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Ammar Shafii
     * @param ProgramScheduleChangeMap the map to load the program schedule changes into
     * @param ProgramScheduleChangeFile the path to the file from which to load the data
     */
    public static void loadProgramScheduleChangeFromFile(Map<String, String> ProgramScheduleChangeMap, String ProgramScheduleChangeFile) {
        File file = new File(ProgramScheduleChangeFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
            ProgramScheduleChangeMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Program schedule: " + e.getMessage());
        }
    }
    
    /**
     * Saves the progress list data to a file.
     * If the file doesn't exist, a new file will be created.
     * @author Ammar Shafii
     * @param ProgressListMap the map of progress list to save
     * @param ProgressListFile the path to the file where the data will be saved
     */
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
    
    /**
     * Loads the progress list data from a file into the provided map.
     * If the file doesn't exist, an error message will be printed.
     * @author Ammar Shafii
     * @param ProgressListMap the map to load the progress list into
     * @param ProgressListFile the path to the file from which to load the data
     */
    public static void loadProgressListFromFile(Map<String, String> ProgressListMap, String ProgressListFile) {
        File file = new File(ProgressListFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> loadedInstructorTips = objectMapper.readValue(file, new TypeReference<>() {});
            ProgressListMap.putAll(loadedInstructorTips);
        } catch (IOException e) {
            System.err.println("Error loading Progress: " + e.getMessage());
        }
    }
}