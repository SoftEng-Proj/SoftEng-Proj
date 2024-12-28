package com.Software.FitnessSystem;
import static com.Software.FitnessSystem.LoadAndSaveEntities.*;
import com.Software.FitnessSystem.AdminControllers.CustomPlan;
import com.Software.FitnessSystem.AdminControllers.ProgramEnrollment;
import com.Software.FitnessSystem.AdminControllers.SubscriptionPlan;
import com.Software.FitnessSystem.ClientControllers.FitnessMilestone;
import com.Software.FitnessSystem.ClientControllers.Profile;
import com.Software.FitnessSystem.InstructorControllers.Program;
import com.Software.FitnessSystem.LoginPage.LoginPageController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main application class to manage the fitness system, including loading data, handling login, and saving data.
 * @author Muath Hassoun
 * @author Alaa Alawneh
 * @author Ammar Shafii
 */
public class App {
	public static final String SUBSCRIPTION_PLAN_FILENAME = "src/main/resources/Files/SubscriptionPlan.json";
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
	public static final String CLIENT_PROFILES_FILENAME = "src/main/resources/Files/Client_Profiles.json";
	public static final String MILESTONES_FILENAME = "src/main/resources/Files/Milestones.json";
	public static final String PROGRAM_RATINGS_FILENAME = "src/main/resources/Files/Program_Ratings.json";
    public static final String PROGRAM_REVIEWS_FILENAME = "src/main/resources/Files/Program_Reviews.json";
    public static final String PROGRAM_SUGGESTIONS_FILENAME = "src/main/resources/Files/Program_Suggestions.json";
	public static final String INSTRUCTOR_MSGS_FOR_CLIENTS = "src/main/resources/Files/Instructor_Msgs_For_Clients.json";
	public static final String PROGRAM_FORUM_MSGS = "src/main/resources/Files/Program_Forum_Msgs.json";
	public static final String FEEDBACK_TOCLIENT = "src/main/resources/Files/Feedback_ToClient.json";
	public static final String INSTRUCTOR_REMINDER = "src/main/resources/Files/Instructor_Reminder.json";
	public static final String INSTRUCTOR_RECCOMENDATION = "src/main/resources/Files/Instructor_Recommendation.json";
	public static final String INSTRUCTOR_ANNOUNCEMENTS = "src/main/resources/Files/Instructor_Announcements.json";
	public static final String PROGRAMSCHEDULE_CHANGE = "src/main/resources/Files/ProgramSchedule_Change.json";
	public static final String PROGRESS_FILE = "src/main/resources/Files/Progress_File.json";
	
    private static final Map<String, User> UserSubscriptionPlan = new HashMap<>();
    private static final Map<String, CustomPlan> CustomSubscriptionPlan = new HashMap<>();
    private static final Map<String, Admin> AdminsMap = new HashMap<>();
    private static final Map<String, Instructor> InstructorsMap = new HashMap<>();
    private static final Map<String, Instructor> PendingInstructorsMap = new HashMap<>();
    private static final Map<String, Client> ClientsMap = new HashMap<>();
    private static final Map<String, Program> FitnessProgramsMap = new HashMap<>();
    private static Map<String, ProgramEnrollment> ProgramEnrollmentMap = new HashMap<>();
    private static final Map<String, Content> InstructorTipsMap = new HashMap<>();
    private static final Map<String, Content> PendingInstructorTipsMap = new HashMap<>();
    private static final Map<String, Content> HealthTipsMap = new HashMap<>();
    private static final Map<String, Content> PendingHealthTipsMap = new HashMap<>();
    private static final Map<String, Content> UserFeedbackMap = new HashMap<>();
    private static final Map<String, String> HandledFeedbackMap = new HashMap<>();
    private static final Map<String, Profile> ClientProfileMap = new HashMap<>();
    private static final Map<String, Map<String, Integer>> ProgramRatings = new HashMap<>();
    private static final Map<String, Map<String, String>> ProgramReviews = new HashMap<>();
    private static final Map<String, Map<String, String>> ProgramSuggestions = new HashMap<>();
    private static final Map<String, String> InstructorMessagesForClientsMap= new HashMap<>();
    private static final Map<String, String> ProgramForumMsgsMap= new HashMap<>();
    private static final Map<String, String> FeedbackToClientMap= new HashMap<>();
    private static final List<FitnessMilestone> MilestonesList = new ArrayList<>();
    private static final Map<String, String> InstructorReminderMap= new HashMap<>();
    private static final Map<String, String> InstructorRecommendationMap= new HashMap<>();
    private static final List<String> InstructorAnnouncementMap= new ArrayList<>();
    private static final Map<String, String> ProgramScheduleChangeMap= new HashMap<>();
    private static final Map<String, String> ProgressListMap= new HashMap<>();
    
    private static Instructor Instructor;
    private static Client Client;

    public static void main(String[] args) {
        new App();
        printWelcomeMessage();
        new LoginPageController();
    }
    
    /**
     * Constructs an instance of the Fitness Management System.
     * Initializes all system data by loading it from persistent storage.
     * Also sets up user subscription plans and program enrollment statistics.
     */
    public App() {
    	loadCustomSubscriptionPlanFromFile(CustomSubscriptionPlan, SUBSCRIPTION_PLAN_FILENAME);
    	loadAdminsFromFile(AdminsMap, ADMIN_ACCOUNTS_FILENAME);
		loadInstructorsFromFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
		loadClientsFromFile(ClientsMap, CLIENT_ACCOUNTS_FILENAME);
    	loadInstructorsFromFile(PendingInstructorsMap, PENDING_INSTRUCTOR_ACCOUNTS_FILENAME);
    	loadFitnessProgramsFromFile(FitnessProgramsMap, FITNESS_PROGRAMS_FILENAME);
    	loadContentsFromFile(InstructorTipsMap, TIPS_AND_ARTICLES_FILENAME);
    	loadContentsFromFile(PendingInstructorTipsMap, PENDING_TIPS_AND_ARTICLES_FILENAME);
    	loadContentsFromFile(HealthTipsMap, HEALTH_TIPS_FILENAME);
    	loadContentsFromFile(PendingHealthTipsMap, PENDING_HEALTH_TIPS_FILENAME);
    	loadContentsFromFile(UserFeedbackMap, USER_FEEDBACK_FILENAME);
    	loadHandledFeedbackFromFile(HandledFeedbackMap, USER_FEEDBACK_HANDLE_FILENAME);
    	loadClientProfilesFromFile(ClientProfileMap, CLIENT_PROFILES_FILENAME);
    	loadMilestonesFromFile(MilestonesList, MILESTONES_FILENAME);
    	loadProgramRatingsFromFile(ProgramRatings, PROGRAM_RATINGS_FILENAME);
        loadProgramReviewsFromFile(ProgramReviews, PROGRAM_REVIEWS_FILENAME);
        loadProgramSuggestionsFromFile(ProgramSuggestions, PROGRAM_SUGGESTIONS_FILENAME);
    	loadInstructorMsgsToClientsFromFile(InstructorMessagesForClientsMap, INSTRUCTOR_MSGS_FOR_CLIENTS);
        loadProgramForumMsgsFromFile(ProgramForumMsgsMap, PROGRAM_FORUM_MSGS);
        loadFeedbackToClientFromFile(FeedbackToClientMap, FEEDBACK_TOCLIENT);
        loadInstructorReminderFromFile(InstructorReminderMap, INSTRUCTOR_REMINDER);
        loadInstructorRecommednationFromFile(InstructorRecommendationMap, INSTRUCTOR_RECCOMENDATION);
        loadProgramScheduleChangeFromFile(ProgramScheduleChangeMap, PROGRAMSCHEDULE_CHANGE);
        loadProgressListFromFile(ProgressListMap, PROGRESS_FILE);

		SubscriptionPlan.convertFromPlanTypeToCustomPlan();
		fillUserSubscriptionPlanMap();
    	ProgramEnrollmentMap = ProgramEnrollment.enrolmentStatistics(FitnessProgramsMap);
    }
    
    /**
     * Prints a welcome message to the console.
     * @author Muath Hassoun
     */
    public static void printWelcomeMessage() {
    	System.err.println("============================================================");
        System.err.println("            Welcome to Fitness Management System            ");
        System.err.println("============================================================\n");
    }
    
    /**
     * Logs in a user based on their username, password, and role.
     * Updates login statistics and session data for the user.
     * @author Muath Hassoun
     * @param userName The username of the user.
     * @param role The role of the user ("Admin", "Instructor", or "Client").
     * @return A string indicating the result of the login attempt:
     *         "AdminLoggedIn", "InstructorLoggedIn", "ClientLoggedIn",
     *         "InvalidLogIn", or "NoOneLoggedIn".
     */
	public static String login(String userName, String role) {
        LocalDateTime currentDateTime = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        
        switch (role) {
        case "Admin":
        	AdminsMap.get(userName);
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
	
	/**
	 * Handles the login process for an instructor.
	 * Updates the instructor's last login time and increments the login count.
	 * Saves updated instructor data back to persistent storage.
	 * @author Muath Hassoun
	 * @param formattedDateTime The current date and time formatted as a string.
	 * @return A string indicating a successful instructor login: "InstructorLoggedIn".
	 */
	public static String instructorLogIn(String formattedDateTime) {
		Instructor.setLastLogin(formattedDateTime);
		Instructor.setLogins(Instructor.getLogins() + 1);
    	saveInstructorsToFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
    	return "InstructorLoggedIn";
	}
	
	/**
	 * Handles the login process for a client.
	 * Updates the client's last login time and increments the login count.
	 * Saves updated client data back to persistent storage.
	 * @author Muath Hassoun
	 * @param formattedDateTime The current date and time formatted as a string.
	 * @return A string indicating a successful client login: "ClientLoggedIn".
	 */
	public static String clientLogIn(String formattedDateTime) {
		Client.setLastLogin(formattedDateTime);
    	Client.setLogins(Client.getLogins() + 1);
    	saveClientsToFile(ClientsMap, ADMIN_ACCOUNTS_FILENAME);
    	return "ClientLoggedIn";
	}
	
	/**
	 * Fills the user subscription plan map with clients and instructors.
	 * @author Muath Hassoun
	 */
	private static void fillUserSubscriptionPlanMap() {
	    if (ClientsMap != null && !ClientsMap.isEmpty()) {
	        for (Client client : ClientsMap.values()) {
	            UserSubscriptionPlan.put(client.getUsername(), client);
	        }
	    }

	    if (InstructorsMap != null && !InstructorsMap.isEmpty()) {
	        for (Instructor instructor : InstructorsMap.values()) {
	            UserSubscriptionPlan.put(instructor.getUsername(), instructor);
	        }
	    }
	}
	
	/**
	 * Saves the custom subscription plan changes to the corresponding file.
	 * @author Muath Hassoun
	 */
	public static void saveCustomSubscriptionPlanChanges() {
	    saveCustomSubscriptionPlanToFile(CustomSubscriptionPlan, SUBSCRIPTION_PLAN_FILENAME);
	}
	
	/**
	 * Saves changes to all accounts (Admin, Instructor, and Client).
	 * @author Muath Hassoun
	 * @return A boolean indicating whether the changes were saved successfully.
	 */
	public static boolean saveAccountChanges() {
	    saveAdminsToFile(AdminsMap, ADMIN_ACCOUNTS_FILENAME);
	    saveInstructorsToFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
	    saveInstructorsToFile(PendingInstructorsMap, PENDING_INSTRUCTOR_ACCOUNTS_FILENAME);
	    saveClientsToFile(ClientsMap, CLIENT_ACCOUNTS_FILENAME);
	    return true;
	}
	
	/**
	 * Saves changes to fitness programs.
	 * @author Muath Hassoun
	 */
	public static void saveFitnessProgramsChanges() {
	    saveFitnessProgramsToFile(FitnessProgramsMap, FITNESS_PROGRAMS_FILENAME);
	}
	
	/**
	 * Saves feedback to clients.
	 * @author Ammar Shafii
	 */
	public static void saveFeedbackToClientChanges() {
	    saveFeedbackToClientToFile(FeedbackToClientMap, FEEDBACK_TOCLIENT);
	}
	
	/**
	 * Saves instructor messages for clients.
	 * @author Ammar Shafii
	 */
	public static void saveInstructorMSGSForClientsChanges() {
	    saveInstructorMsgsToClientsToFile(InstructorMessagesForClientsMap, INSTRUCTOR_MSGS_FOR_CLIENTS);
	}
	
	/**
	 * Saves changes to program forum messages.
	 * @author Ammar Shafii
	 */
	public static void saveProgramForumMsgsChanges() {
	    saveProgramForumMsgsToFile(ProgramForumMsgsMap, PROGRAM_FORUM_MSGS);
	}
	
	/**
	 * Saves changes to milestones.
	 *
	 * @author Alaa Alawneh
	 */
	public static void saveMilestoneChanges() {
	    saveMilestonesToFile(getMilestonesList(), MILESTONES_FILENAME);
	}
	
	/**
	 * Saves changes to instructor tips and articles.
	 *
	 * @author Muath Hassoun
	 */
	public static void saveInstructorTipsChanges() {
	    saveContentsToFile(InstructorTipsMap, TIPS_AND_ARTICLES_FILENAME);
	    saveContentsToFile(PendingInstructorTipsMap, PENDING_TIPS_AND_ARTICLES_FILENAME);
	}
	
	/**
	 * Saves changes to health tips.
	 *
	 * @author Muath Hassoun
	 */
	public static void saveHealthTipsChanges() {
	    saveContentsToFile(HealthTipsMap, HEALTH_TIPS_FILENAME);
	    saveContentsToFile(PendingHealthTipsMap, PENDING_HEALTH_TIPS_FILENAME);
	}
	
	/**
	 * Saves user feedback changes.
	 *
	 * @author Muath Hassoun
	 */
	public static void saveUserFeedbackChanges() {
	    saveContentsToFile(UserFeedbackMap, USER_FEEDBACK_FILENAME);
	    saveHandledFeedbackToFile(HandledFeedbackMap, USER_FEEDBACK_HANDLE_FILENAME);
	}
	
	/**
	 * Saves changes to client profiles.
	 *
	 * @author Alaa Alawneh
	 */
	public static void saveClientProfileChanges() {
	    saveClientProfileToFile(ClientProfileMap, CLIENT_PROFILES_FILENAME);
	}
	
	/**
	 * Saves changes to program ratings.
	 *
	 * @author Alaa Alawneh
	 */
	public static void saveProgramRatingsChanges() {
	    saveProgramRatingsToFile(ProgramRatings, PROGRAM_RATINGS_FILENAME);
	}
	
	/**
	 * Saves changes to program reviews.
	 *
	 * @author Alaa Alawneh
	 */
	public static void saveProgramReviewsChanges() {
	    saveProgramReviewsToFile(ProgramReviews, PROGRAM_REVIEWS_FILENAME);
	}
	
	/**
	 * Saves changes to program suggestions.
	 *
	 * @author Alaa Alawneh
	 */
	public static void saveProgramSuggestionsChanges() {
	    saveProgramSuggestionsToFile(ProgramSuggestions, PROGRAM_SUGGESTIONS_FILENAME);
	}
    
    /**
     * Returns the map containing custom subscription plans.
     * @author Muath Hassoun
     * @return a map of custom subscription plans
     */
    public static Map<String, CustomPlan> getSubscriptionPlanMap() {
        return CustomSubscriptionPlan;
    }
    
    /**
     * Returns the map containing all admin accounts.
     * @author Muath Hassoun
     * @return a map of admin accounts
     */
    public static Map<String, Admin> getAdminsMap() {
        return AdminsMap;
    }
    
    /**
     * Adds a new instructor account to the InstructorsMap.
     * @author Muath Hassoun
     * @param username the username of the instructor
     * @param instructorAccount the instructor account object
     */
    public static void putNewInstructor(String username, Instructor instructorAccount) {
        InstructorsMap.put(username, instructorAccount);
    }
    
    /**
     * Returns the map containing all instructor accounts.
     * @author Muath Hassoun
     * @return a map of instructor accounts
     */
    public static Map<String, Instructor> getInstructorsMap() {
        return InstructorsMap;
    }
    
    /**
     * Returns the map containing all pending instructor accounts.
     * @author Muath Hassoun
     * @return a map of pending instructor accounts
     */
    public static Map<String, Instructor> getPendingInstructorsMap() {
        return PendingInstructorsMap;
    }
    
    /**
     * Adds a new client account to the ClientsMap.
     * @author Muath Hassoun
     * @param username the Username of the client
     * @param clientAccount the client account object
     */
    public static void putNewClient(String username, Client clientAccount) {
        ClientsMap.put(username, clientAccount);
    }
    
    /**
     * Returns the map containing all client accounts.
     * @author Muath Hassoun
     * @return a map of client accounts
     */
    public static Map<String, Client> getClientsMap() {
        return ClientsMap;
    }
    
    /**
     * Returns the map containing all fitness programs.
     * @author Muath Hassoun
     * @return a map of fitness programs
     */
    public static Map<String, Program> getFitnessProgramsMap() {
        return FitnessProgramsMap;
    }
    
    /**
     * Returns the map containing all program enrollments.
     * @author Muath Hassoun
     * @return a map of program enrollments
     */
    public static Map<String, ProgramEnrollment> getProgramEnrollmentMap() {
        return ProgramEnrollmentMap;
    }
    
    /**
     * Returns the map containing all instructor tips.
     * @author Muath Hassoun
     * @return a map of instructor tips
     */
    public static Map<String, Content> getInstructorTipsMap() {
        return InstructorTipsMap;
    }
    
    /**
     * Returns the map containing all pending instructor tips.
     * @author Muath Hassoun
     * @return a map of pending instructor tips
     */
    public static Map<String, Content> getPendingInstructorTipsMap() {
        return PendingInstructorTipsMap;
    }
    
    /**
     * Returns the map containing all health tips.
     * @author Muath Hassoun
     * @return a map of health tips
     */
    public static Map<String, Content> getHealthTipsMap() {
        return HealthTipsMap;
    }
    
    /**
     * Returns the map containing all pending health tips.
     * @author Muath Hassoun
     * @return a map of pending health tips
     */
    public static Map<String, Content> getPendingHealthTipsMap() {
        return PendingHealthTipsMap;
    }
    
    /**
     * Returns the map containing all user feedback.
     * @author Muath Hassoun
     * @return a map of user feedback
     */
    public static Map<String, Content> getUserFeedbackMap() {
        return UserFeedbackMap;
    }
    
    /**
     * Returns the map containing all handled feedback.
     * @author Muath Hassoun
     * @return a map of handled feedback
     */
    public static Map<String, String> getHandledFeedbackMap() {
        return HandledFeedbackMap;
    }
    
    /**
     * Returns the map containing all client profiles.
     * @author Alaa Alawneh
     * @return a map of client profiles
     */
    public static Map<String, Profile> getClientProfileMap() {
        return ClientProfileMap;
    }
    
    /**
     * Returns the list containing all fitness milestones.
     * @author Alaa Alawneh
     * @return a list of fitness milestones
     */
    public static List<FitnessMilestone> getMilestonesList() {
        return MilestonesList;
    }
    
    /**
     * Returns the map containing program ratings.
     * @author Alaa Alawneh
     * @return a map of program ratings
     */
    public static Map<String, Map<String, Integer>> getProgramRatings() {
        return ProgramRatings;
    }
    
    /**
     * Returns the map containing program reviews.
     * @author Alaa Alawneh
     * @return a map of program reviews
     */
    public static Map<String, Map<String, String>> getProgramReviews() {
        return ProgramReviews;
    }
    
    /**
     * Returns the map containing program suggestions.
     * @author Alaa Alawneh
     * @return a map of program suggestions
     */
    public static Map<String, Map<String, String>> getProgramSuggestions() {
        return ProgramSuggestions;
    }
    
    /**
     * Returns the map containing instructor messages for clients.
     * @author Ammar Shafii
     * @return a map of instructor messages for clients
     */
    public static Map<String, String> getInstructorMessagesForClientMap() {
        return InstructorMessagesForClientsMap;
    }
    
    /**
     * Returns the map containing program forum messages.
     * @author Ammar Shafii
     * @return a map of program forum messages
     */
    public static Map<String, String> getProgramForumMsgsMap() {
        return ProgramForumMsgsMap;
    }
    
    /**
     * Returns the map containing feedback to clients.
     * @author Ammar Shafii
     * @return a map of feedback to clients
     */
    public static Map<String, String> getFeedbackToClientMap() {
        return FeedbackToClientMap;
    }
    
    /**
     * Returns the map containing instructor reminders.
     * @author Ammar Shafii
     * @return a map of instructor reminders
     */
    public static Map<String, String> getInstructorReminderMap() {
        return InstructorReminderMap;
    }
    
    /**
     * Returns the map containing instructor recommendations.
     * @author Ammar Shafii
     * @return a map of instructor recommendations
     */
    public static Map<String, String> getInstructorRcommednationMap() {
        return InstructorRecommendationMap;
    }
    
    /**
     * Returns the list containing instructor announcements.
     * @author Ammar Shafii
     * @return a list of instructor announcements
     */
    public static List<String> getInstructorAnnouncementsMap() {
        return InstructorAnnouncementMap;
    }
    
    /**
     * Returns the map containing program schedule changes.
     * @author Ammar Shafii
     * @return a map of program schedule changes
     */
    public static Map<String, String> getProgramScheduleChangeMap() {
        return ProgramScheduleChangeMap;
    }
    
    /**
     * Returns the map containing progress list data.
     * @author Ammar Shafii
     * @return a map of progress list data
     */
    public static Map<String, String> getProgressListMap() {
        return ProgressListMap;
    }
}