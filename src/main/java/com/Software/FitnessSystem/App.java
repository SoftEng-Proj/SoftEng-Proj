package com.Software.FitnessSystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.Software.FitnessSystem.LoginPage.LoginPageController;

public class App {
	public static final String ADMIN_ACCOUNTS_FILENAME = "src/main/resources/Files/Admins_File.json";
	public static final String INSTRUCTOR_ACCOUNTS_FILENAME = "src/main/resources/Files/Instructors_File.json";
	public static final String PENDING_INSTRUCTOR_ACCOUNTS_FILENAME = "src/main/resources/Files/Pending_Instructors.json";
	public static final String CLIENT_ACCOUNTS_FILENAME = "src/main/resources/Files/Clients_File.json";
	public static final String FITNESS_PROGRAMS_FILENAME = "src/main/resources/Files/Fitness_Programs.json";
	public static final String TIPS_AND_ARTICLES_FILENAME = "src/main/resources/Files/Tips_And_Articles.json";
	public static final String PENDING_TIPS_AND_ARTICLES_FILENAME = "src/main/resources/Files/Pending_Tips_And_Articles.json";
	public static final String HEALTH_TIPS_FILENAME = "src/main/resources/Files/Health_Tips.json";
	public static final String PENDING_HEALTH_TIPS_FILENAME = "src/main/resources/Files/Pending_Health_Tips.json";
	public static final String USER_FEEDBACK_FILENAME = "src/main/resources/Files/User_Feedback.json";
	public static final String USER_FEEDBACK_HANDLE_FILENAME = "src/main/resources/Files/User_Feedback_Handle.json";
	
    private static Map<String, Map<String, String>> AccountsMap = new HashMap<>();
    private static Map<String, Admin> AdminsMap = new HashMap<>();
    private static Map<String, Instructor> InstructorsMap = new HashMap<>();
    private static Map<String, Instructor> PendingInstructorsMap = new HashMap<>();
    private static Map<String, Client> ClientsMap = new HashMap<>();
    private static Map<String, FitnessPrograms> FitnessProgramsMap = new HashMap<>();
    private static Map<String, Content> InstructorTipsMap = new HashMap<>();
    private static Map<String, Content> PendingInstructorTipsMap = new HashMap<>();
    private static Map<String, Content> HealthTipsMap = new HashMap<>();
    private static Map<String, Content> PendingHealthTipsMap = new HashMap<>();
    private static Map<String, Content> UserFeedbackMap = new HashMap<>();
    private static Map<String, String> HandledFeedbackMap = new HashMap<>();
    
    private static Admin Admin;
    private static Instructor Instructor;
    private static Client Client;
    
    public static void main(String[] args) {
        new App();
        printWelcomeMessage();
        new LoginPageController();
    }
    
    public App() {
    	LoadAndSaveEntities.loadAdminsFromFile(AdminsMap, ADMIN_ACCOUNTS_FILENAME);
    	LoadAndSaveEntities.loadInstructorsFromFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
    	LoadAndSaveEntities.loadInstructorsFromFile(PendingInstructorsMap, PENDING_INSTRUCTOR_ACCOUNTS_FILENAME);
    	LoadAndSaveEntities.loadClientsFromFile(ClientsMap, CLIENT_ACCOUNTS_FILENAME);
    	LoadAndSaveEntities.loadFitnessProgramsFromFile(FitnessProgramsMap, FITNESS_PROGRAMS_FILENAME);
    	LoadAndSaveEntities.loadContentsFromFile(InstructorTipsMap, TIPS_AND_ARTICLES_FILENAME);
    	LoadAndSaveEntities.loadContentsFromFile(PendingInstructorTipsMap, PENDING_TIPS_AND_ARTICLES_FILENAME);
    	LoadAndSaveEntities.loadContentsFromFile(HealthTipsMap, HEALTH_TIPS_FILENAME);
    	LoadAndSaveEntities.loadContentsFromFile(PendingHealthTipsMap, PENDING_HEALTH_TIPS_FILENAME);
    	LoadAndSaveEntities.loadContentsFromFile(UserFeedbackMap, USER_FEEDBACK_FILENAME);
    	LoadAndSaveEntities.loadHandledFeedbackFromFile(HandledFeedbackMap, USER_FEEDBACK_HANDLE_FILENAME);
    }
    
    public static void printWelcomeMessage() {
    	System.err.println("============================================================");
        System.err.println("            Welcome to Fitness Management System            ");
        System.err.println("============================================================\n");
    }
    
	public static String login(String userName, String password, String role) {
    	LocalDateTime currentDateTime = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        
        switch (role) {
        case "Admin":
        	Admin = AdminsMap.get(userName);
        	return "AdminLoggedIn";
        case "Instructor":
        	Instructor = InstructorsMap.get(userName);
        	Instructor.setLastLogin(formattedDateTime);
        	Instructor.setLogins(Instructor.getLogins() + 1);
        	LoadAndSaveEntities.saveInstructorsToFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
        	
        	return "InstructorLoggedIn";
        case "Client":
        	Client = ClientsMap.get(userName);
        	Client.setLastLogin(formattedDateTime);
        	Client.setLogins(Client.getLogins() + 1);
        	LoadAndSaveEntities.saveClientsToFile(ClientsMap, ADMIN_ACCOUNTS_FILENAME);
        	
        	return "ClientLoggedIn";
        default:
        	return "NoOneLoggedIn";
        }
	}
	
	public static boolean saveAccountChanges() {
		LoadAndSaveEntities.saveAdminsToFile(AdminsMap, ADMIN_ACCOUNTS_FILENAME);
		LoadAndSaveEntities.saveInstructorsToFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
		LoadAndSaveEntities.saveInstructorsToFile(PendingInstructorsMap, PENDING_INSTRUCTOR_ACCOUNTS_FILENAME);
		LoadAndSaveEntities.saveClientsToFile(ClientsMap, CLIENT_ACCOUNTS_FILENAME);
		
		return true;
	}
	
	public static boolean saveFitnessProgramsChanges() {
		LoadAndSaveEntities.saveFitnessProgramsToFile(FitnessProgramsMap, FITNESS_PROGRAMS_FILENAME);
		
		return true;
	}
	
	public static boolean saveInstructorTipsChanges() {
		LoadAndSaveEntities.saveContentsToFile(InstructorTipsMap, TIPS_AND_ARTICLES_FILENAME);
		LoadAndSaveEntities.saveContentsToFile(PendingInstructorTipsMap, PENDING_TIPS_AND_ARTICLES_FILENAME);
		
		return true;
	}
	
	public static boolean saveHealthTipsChanges() {
		LoadAndSaveEntities.saveContentsToFile(HealthTipsMap, HEALTH_TIPS_FILENAME);
		LoadAndSaveEntities.saveContentsToFile(PendingHealthTipsMap, PENDING_HEALTH_TIPS_FILENAME);
		
		return true;
	}
	
	public static boolean saveUserFeedbackChanges() {
		LoadAndSaveEntities.saveContentsToFile(UserFeedbackMap, USER_FEEDBACK_FILENAME);
		LoadAndSaveEntities.saveHandledFeedbackToFile(HandledFeedbackMap, USER_FEEDBACK_HANDLE_FILENAME);
		
		return true;
	}
	
	public static void putNewAccount(String role, Map<String, String> user) {
		AccountsMap.put(role, user);
	}
	public static Map<String, Map<String, String>> getAccountsMap() {
		return AccountsMap;
	}
	
	public static void putNewAdmin(String username, Admin adminAccount) {
		AdminsMap.put(username, adminAccount);
	}
	public static Map<String, Admin> getAdminsMap() {
		return AdminsMap;
	}
	
	public static void putNewInstructor(String username, Instructor instructorAccount) {
		InstructorsMap.put(username, instructorAccount);
	}
	public static Map<String, Instructor> getInstructorsMap() {
		return InstructorsMap;
	}
	
	public static void putPnedingInstructor(String username, Instructor instructorAccount) {
		PendingInstructorsMap.put(username, instructorAccount);
	}
	public static Map<String, Instructor> getPendingInstructorsMap() {
		return PendingInstructorsMap;
	}
	
	public static void putNewClient(String username, Client clientAccount) {
		ClientsMap.put(username, clientAccount);
	}
	public static Map<String, Client> getClientsMap() {
		return ClientsMap;
	}
	
	public static void putNewFitnessPrograms(String programName, FitnessPrograms fitnessProgram) {
		FitnessProgramsMap.put(programName, fitnessProgram);
	}
	public static Map<String, FitnessPrograms> getFitnessProgramsMap() {
		return FitnessProgramsMap;
	}
	
	public static Map<String, Content> getInstructorTipsMap() {
		return InstructorTipsMap;
	}
	public static Map<String, Content> getPendingInstructorTipsMap() {
		return PendingInstructorTipsMap;
	}
	
	public static Map<String, Content> getHealthTipsMap() {
		return HealthTipsMap;
	}
	public static Map<String, Content> getPendingHealthTipsMap() {
		return PendingHealthTipsMap;
	}
	
	public static Map<String, Content> getUserFeedbackMap() {
		return UserFeedbackMap;
	}
	public static Map<String, String> getHandledFeedbackMap() {
		return HandledFeedbackMap;
	}
	
	public static Admin getAdminAccount() {
		return Admin;
	}
	
	public static Instructor getInstructorAccount() {
		return Instructor;
	}
	
	public static Client getClientAccount() {
		return Client;
	}
}