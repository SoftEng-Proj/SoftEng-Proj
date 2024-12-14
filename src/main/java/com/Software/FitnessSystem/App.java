package com.Software.FitnessSystem;
import com.Software.FitnessSystem.AdminControllers.ProgramEnrollment;
import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.InstructorControllers.Program;
import com.Software.FitnessSystem.LoginPage.LoginPageController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
	public static final String USERS_SUBSCRIPTION_PLAN_FILENAME = "src/main/resources/Files/UsersSubscriptionPlan.json";
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
	public static final String INSTRUCTOR_MSGS_FOR_CLIENTS = "src/main/resources/Files/Instructor_Msgs_For_Clients.json";
	public static final String PROGRAM_FORUM_MSGS = "src/main/resources/Files/Program_Forum_Msgs.json";
	public static final String FEEDBACK_TOCLIENT = "src/main/resources/Files/Feedback_ToClient.json";
	public static final String MILESTONES_FILENAME = "src/main/resources/Files/Milestones.json";
	public static final String INSTRUCTOR_REMINDER = "src/main/resources/Files/Instructor_Reminder.json";
	public static final String INSTRUCTOR_RECCOMENDATION = "src/main/resources/Files/Instructor_Recommendation.json";
	public static final String INSTRUCTOR_ANNOUNCEMENTS = "src/main/resources/Files/Instructor_Announcements.json";
	public static final String PROGRAMSCHEDULE_CHANGE = "src/main/resources/Files/ProgramSchedule_Change.json";
	public static final String PROGRESS_FILE = "src/main/resources/Files/Progress_File.json";

	


	
    private static Map<String, User> UserSubscriptionPlan = new HashMap<>();
    private static Map<String, Admin> AdminsMap = new HashMap<>();
    private static Map<String, Instructor> InstructorsMap = new HashMap<>();
    private static Map<String, Instructor> PendingInstructorsMap = new HashMap<>();
    private static Map<String, Client> ClientsMap = new HashMap<>();
    private static Map<String, Program> FitnessProgramsMap = new HashMap<>();
    private static Map<String, ProgramEnrollment> ProgramEnrollmentMap = new HashMap<>();
    private static Map<String, Content> InstructorTipsMap = new HashMap<>();
    private static Map<String, Content> PendingInstructorTipsMap = new HashMap<>();
    private static Map<String, Content> HealthTipsMap = new HashMap<>();
    private static Map<String, Content> PendingHealthTipsMap = new HashMap<>();
    private static Map<String, Content> UserFeedbackMap = new HashMap<>();
    private static Map<String, String> HandledFeedbackMap = new HashMap<>();
    private static Map<String, String> InstructorMessagesForClientsMap= new HashMap<>();
    private static Map<String, String> ProgramForumMsgsMap= new HashMap<>();
    private static Map<String, String> FeedbackToClientMap= new HashMap<>();
    private static List<FitnessMilestone> MilestonesList = new ArrayList<>();
    private static Map<String, String> InstructorReminderMap= new HashMap<>();
    private static Map<String, String> InstructorRecommendationMap= new HashMap<>();
    private static List<String> InstructorAnnouncementMap= new ArrayList<>();
    private static Map<String, String> ProgramScheduleChangeMap= new HashMap<>();
    private static Map<String, String> ProgressListMap= new HashMap<>();
    
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
    	LoadAndSaveEntities.loadInstructorMsgsToClientsFromFile(InstructorMessagesForClientsMap, INSTRUCTOR_MSGS_FOR_CLIENTS);
        LoadAndSaveEntities.loadProgramForumMsgsFromFile(ProgramForumMsgsMap, PROGRAM_FORUM_MSGS);
        LoadAndSaveEntities.loadFeedbackToClientFromFile(FeedbackToClientMap, FEEDBACK_TOCLIENT);
        LoadAndSaveEntities.loadMilestonesFromFile(MilestonesList, MILESTONES_FILENAME);
        LoadAndSaveEntities.loadInstructorReminderFromFile(InstructorReminderMap, INSTRUCTOR_REMINDER);
        LoadAndSaveEntities.loadInstructorRecommednationFromFile(InstructorRecommendationMap, INSTRUCTOR_RECCOMENDATION);
        LoadAndSaveEntities.loadInstructorAnnouncemntFromFile(InstructorAnnouncementMap, INSTRUCTOR_ACCOUNTS_FILENAME);
        LoadAndSaveEntities.loadProgramScheduleChangeFromFile(ProgramScheduleChangeMap, PROGRAMSCHEDULE_CHANGE);
        LoadAndSaveEntities.loadProgressListFromFile(ProgressListMap, PROGRESS_FILE);
        
    	ProgramEnrollmentMap = ProgramEnrollment.enrolmentStatistics(FitnessProgramsMap);
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
        	if(UserSubscriptionPlan.get(userName).getLogins() >= Instructor.getLogins()) {
        		return instructorLogIn(formattedDateTime);
        	} else {
        		return "InvalidLogIn";
        	}
        case "Client":
        	Client = ClientsMap.get(userName);
        	if(UserSubscriptionPlan.get(userName).getLogins() >= Client.getLogins()) {
        		return clientLogIn(formattedDateTime);
        	} else {
        		return "InvalidLogIn";
        	}
        default:
        	return "NoOneLoggedIn";
        }
	}
	
	public static String instructorLogIn(String formattedDateTime) {
		Instructor.setLastLogin(formattedDateTime);
		Instructor.setLogins(Instructor.getLogins() + 1);
    	LoadAndSaveEntities.saveInstructorsToFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
    	return "InstructorLoggedIn";
	}
	
	public static String clientLogIn(String formattedDateTime) {
		Client.setLastLogin(formattedDateTime);
    	Client.setLogins(Client.getLogins() + 1);
    	LoadAndSaveEntities.saveClientsToFile(ClientsMap, ADMIN_ACCOUNTS_FILENAME);
    	return "ClientLoggedIn";
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
	
	public static boolean saveInstructorAnnouncementsChanges() {
		LoadAndSaveEntities.saveInstructorAnnouncemntToFile(InstructorAnnouncementMap, INSTRUCTOR_ANNOUNCEMENTS);
		
		return true;
	}
	
	public static boolean saveProgramScheduleChangeChanges() {
		LoadAndSaveEntities.saveProgramScheduleChangeToFile(ProgramScheduleChangeMap, PROGRAMSCHEDULE_CHANGE);
		
		return true;
	}
	
	public static boolean saveFeedbackToClientChanges() {
		LoadAndSaveEntities.saveFeedbackToClientToFile(FeedbackToClientMap, FEEDBACK_TOCLIENT);
		
		return true;
	}
	
	public static void saveInstructorMSGSForClientsChanges() {
    	LoadAndSaveEntities.saveInstructorMsgsToClientsToFile(InstructorMessagesForClientsMap, INSTRUCTOR_MSGS_FOR_CLIENTS);
	}
	
	public static boolean saveProgramForumMsgsChanges() {
		LoadAndSaveEntities.saveProgramForumMsgsToFile(ProgramForumMsgsMap, PROGRAM_FORUM_MSGS);
		
		return true;
	}
	
	public static void saveMilestoneChanges() {
    	LoadAndSaveEntities.saveMilestonesToFile(getMilestonesList(), MILESTONES_FILENAME);
	}
	
	public static void saveProgressListChanges() {
    	LoadAndSaveEntities.saveProgressListToFile(ProgressListMap, PROGRESS_FILE);
	}
	
	public static boolean saveInstructorTipsChanges() {
		LoadAndSaveEntities.saveContentsToFile(InstructorTipsMap, TIPS_AND_ARTICLES_FILENAME);
		LoadAndSaveEntities.saveContentsToFile(PendingInstructorTipsMap, PENDING_TIPS_AND_ARTICLES_FILENAME);
		
		return true;
	}
	public static boolean saveInstructorReminderChanges() {
		LoadAndSaveEntities.saveInstructorReminderToFile(InstructorReminderMap, INSTRUCTOR_REMINDER);
		
		return true;
	}
	
	public static boolean saveInstructorRcommendationChanges() {
		LoadAndSaveEntities.saveInstructorRecommendationToFile(InstructorRecommendationMap, INSTRUCTOR_RECCOMENDATION);
		
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
	
	public static Map<String, User> getUserSubscriptionPlanMap() {
		return UserSubscriptionPlan;
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
	
	public static void putNewFitnessPrograms(String programName, Program fitnessProgram) {
		FitnessProgramsMap.put(programName, fitnessProgram);
	}
	public static Map<String, Program> getFitnessProgramsMap() {
		return FitnessProgramsMap;
	}
	public static Map<String, ProgramEnrollment> getProgramEnrollmentMap() {
		return ProgramEnrollmentMap;
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
	
	public static Map<String, String> getInstructorMessagesForClientMap() {
		return InstructorMessagesForClientsMap;
	}
	
	public static void setInstructorMessagesForClientMap (Map<String, String> instructorMessageMap) {
		InstructorMessagesForClientsMap=instructorMessageMap;
	}
	
	
	public static Map<String, String> getProgramForumMsgsMap() {
		return ProgramForumMsgsMap;
	}
	
	public static void setProgramForumMsgsMap (Map<String, String> programForumMsgsMap) {
		ProgramForumMsgsMap=programForumMsgsMap;
	}
	
	public static Map<String, String> getFeedbackToClientMap() {
		return FeedbackToClientMap;
	}
	
	public static void setFeedbackToClientMap (Map<String, String> feedbackMap) {
		ProgramForumMsgsMap=feedbackMap;
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
	
	
	public static List<FitnessMilestone> getMilestonesList() {
		return MilestonesList;
	}

	public static void setMilestonesMap(List<FitnessMilestone> milestonesList) {
		MilestonesList = milestonesList;
	}
	
	
	public static Map<String, String> getInstructorReminderMap() {
		return InstructorReminderMap;
	}
	
	public static void setInstructorReminderMap (Map<String, String> reminderMap) {
		InstructorReminderMap=reminderMap;
	}
	
	
	
	public static Map<String, String> getInstructorRcommednationMap() {
		return InstructorRecommendationMap;
	}
	
	public static void setInstructorRecommendationMap (Map<String, String> recommendationMap) {
		InstructorRecommendationMap=recommendationMap;
	}
	
	public static List<String> getInstructorAnnouncementsMap() {
		return InstructorAnnouncementMap;
	}
	
	public static void setInstructorAnnouncementsMap (List<String> instructorAnnouncementsMap) {
		InstructorAnnouncementMap=instructorAnnouncementsMap;
	}
	
	
	public static Map<String, String> getProgramScheduleChangeMap() {
		return ProgramScheduleChangeMap;
	}
	
	public static void setProgramScheduleChangeMap (Map<String, String> prorgamScheduleChangeMap) {
		ProgramScheduleChangeMap=prorgamScheduleChangeMap;
	}
	
	
	public static Map<String, String> getProgressListMap() {
		return ProgressListMap;
	}
	
	public static void setProgressListMap (Map<String, String> progressListMap) {
		ProgressListMap=progressListMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}