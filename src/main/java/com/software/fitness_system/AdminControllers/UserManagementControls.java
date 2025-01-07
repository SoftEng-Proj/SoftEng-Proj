package com.software.fitness_system.AdminControllers;
import static com.software.fitness_system.App.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.software.fitness_system.Client;
import com.software.fitness_system.Instructor;
import com.software.fitness_system.User;

/**
 * This class provides various administrative controls for managing user accounts, including instructors and clients.
 * It allows creating, editing, deactivating users, approving pending instructors, and viewing activity reports.
 * 
 * @author Muath Hassoun
 */
public class UserManagementControls {
	private static final Map<String, Instructor> ApprovedInstructorsMap = new HashMap<>();
	private static final List<String> deactivateInstructor = new ArrayList<>();
	private static final List<String> deactivateClient = new ArrayList<>();
	public static final List<String> updatedInstructor = new ArrayList<>();
	public static final List<String> updatedClient = new ArrayList<>();
	
	private static final String instructor = "Instructor";
	private static final String client = "Client";
	
    private static Instructor newInstructor;
    private static Client newClient;
    private static boolean thereAreActivations = false;
    
    private static final LocalDateTime currentDateTime = LocalDateTime.now();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final String formattedDateTime = currentDateTime.format(formatter);
    
    /**
     * Creates a new user account based on the provided details.
     *
     * @param fName    The first name of the user.
     * @param lName    The last name of the user.
     * @param email    The email address of the user.
     * @param userName The username for the account.
     * @param password The password for the account.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return A string indicating the status of the operation ("Instructor_Added", "Client_Added", or "Fail").
     */
	public static String fillUserDetails(String fName, String lName, String email, String userName, String password, String role) {
        return switch (role) {
            case instructor -> {
                instructorNewAccount(fName, lName, email, userName, password);
                yield role + "_Added";
            }
            case client -> {
                clientNewAccount(fName, lName, email, userName, password);
                yield role + "_Added";
            }
            default -> "Fail";
        };
	}
	
	private static void instructorNewAccount(String fName, String lName, String email, String userName, String password) {
		newInstructor = new Instructor(fName, lName, email, userName, password);
        newInstructor.setLastLogin(formattedDateTime);
        newInstructor.setLogins(1);
        newInstructor.setSubscriptionPlan(new SubscriptionPlan(getSubscriptionPlanMap().get("BASIC")));
		putNewInstructor(userName, newInstructor);
	}
	
	private static void clientNewAccount(String fName, String lName, String email, String userName, String password) {
		newClient = new Client(fName, lName, email, userName, password);
		newClient.setLastLogin(formattedDateTime);
		newClient.setLogins(1);
		newClient.setSubscriptionPlan(new SubscriptionPlan(getSubscriptionPlanMap().get("BASIC")));
		putNewClient(userName, newClient);
	}
	
	/**
     * Verifies if a user account has been successfully created.
     *
     * @param userName The username of the account.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return True if the account was successfully created; otherwise, false.
     */
	public static boolean verifyUserCreation(String userName, String role) {
        return switch (role) {
            case "Instructor" -> {
                putNewInstructor(userName, newInstructor);
                yield getInstructorsMap().containsKey(userName);
            }
            case "Client" -> {
                putNewClient(userName, newClient);
                yield getClientsMap().containsKey(userName);
            }
            default -> false;
        };
	}
	
	/**
     * Selects a user account for subsequent operations.
     *
     * @param username The username of the account.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return True if the user exists; otherwise, false.
     */
	public static boolean checkTheUser(String username, String role) {
        return switch (role) {
            case "Instructor" -> {
                yield getInstructorsMap().containsKey(username);
            }
            case "Client" -> {
                yield getClientsMap().containsKey(username);
            }
            default -> false;
        };
	}
	
	/**
	 * Updates the details of a user by verifying and replacing null or empty values with the current data.
	 *
	 * @param <T>      The type of user, extending the `User` class.
	 * @param editUser The user object to update. Must not be null.
	 * @param fName    The new first name of the user. If null or empty, the existing first name will be retained.
	 * @param lName    The new last name of the user. If null or empty, the existing last name will be retained.
	 * @param email    The new email of the user. If null or empty, the existing email will be retained.
	 * @param username The new username of the user. If null or empty, the existing username will be retained.
	 * @param password The new password of the user. If null or empty, the existing password will be retained.
	 * 
	 * @throws IllegalArgumentException If the `editUser` object is null.
	 */
	public static <T extends User> boolean checkNewData(T editUser, String fName, String lName,
	        String email, String username, String password) {
	    if (editUser == null) {
	        throw new IllegalArgumentException("The editUser object cannot be null.");
	    }
	    
	    fName = (fName == null || fName.isEmpty()) ? editUser.getFirstName() : fName;
	    lName = (lName == null || lName.isEmpty()) ? editUser.getLastName() : lName;
	    email = (email == null || email.isEmpty()) ? editUser.getEmail() : email;
	    username = (username == null || username.isEmpty()) ? editUser.getUsername() : username;
	    password = (password == null || password.isEmpty()) ? editUser.getPassword() : password;
	    
	    return saveEditUserNewData(editUser, fName, lName, email, username, password);
	}
	
	/**
	 * Saves the updated details of a user by assigning the provided values to their respective fields.
	 *
	 * @param <T>      The type of user, extending the `User` class.
	 * @param editUser The user object to update.
	 * @param fName    The new first name of the user. Must not be null.
	 * @param lName    The new last name of the user. Must not be null.
	 * @param email    The new email of the user. Must not be null.
	 * @param username The new username of the user. Must not be null.
	 * @param password The new password of the user. Must not be null.
	 * 
	 * @return `true` if the user data is successfully saved.
	 */
	private static <T extends User> boolean saveEditUserNewData(T editUser, String fName, String lName,
			String email, String username, String password) {
		editUser.setFirstName(fName);
		editUser.setLastName(lName);
		editUser.setEmail(email);
		editUser.setUsername(username);
		editUser.setPassword(password);
		return true;
	}
	
	/**
     * Deactivates a user account.
     *
     * @param username The username of the account to deactivate.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return True if the account was successfully deactivated; otherwise, false.
     */
	public static boolean deactivateUser(String username, String role) {
		switch(role) {
		case "Instructor":
			getInstructorsMap().remove(username);
			deactivateInstructor.remove(username);
			deactivateInstructor.add(username);
			return !getInstructorsMap().containsKey(username);
		case "Client":
			getClientsMap().remove(username);
			deactivateClient.remove(username);
			deactivateClient.add(username);
			return !getClientsMap().containsKey(username);
		default:
			return false;
		}
	}
	
	/**
     * Verifies if a user account has been deactivated successfully.
     *
     * @param username The username of the deactivated account.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return True if the deactivation was successful; otherwise, false.
     */
	public boolean verifyUserDeactivation(String username, String role) {
        return switch (role) {
            case "Instructor" -> deactivateInstructor.contains(username);
            case "Client" -> deactivateClient.contains(username);
            default -> false;
        };
	}
	
	/**
     * Checks for pending instructor applications.
     *
     * @return True if there are pending applications; otherwise, false.
     */
	public static boolean checkPendingApplications() {
	    Map<String, Instructor> pendingInstructors = getPendingInstructorsMap();
	    
	    if (pendingInstructors == null || pendingInstructors.isEmpty()) {
	        return false;
	    } else {
	    	System.out.print("\n");
	        System.out.printf("%-15s %-15s %-25s %-20s %-20s\n", "First Name", "Last Name", "Email", "Username", "Password");
	        System.out.println("-------------------------------------------------------------------------------------------");
	        
	        for (Instructor instructor : pendingInstructors.values()) {
	            System.out.printf("%-15s %-15s %-25s %-20s %-20s\n", 
	                instructor.getFirstName(), 
	                instructor.getLastName(), 
	                instructor.getEmail(), 
	                instructor.getUsername(), 
	                instructor.getPassword());
	        }
	        System.out.println("\n");
	        return true;
	    }
	}
	
	/**
	 * Processes the approval of instructors based on the provided usernames.
	 *
	 * @param usernames          Array of usernames to approve.
	 * @param pendingInstructors Map of pending instructors.
	 * @param instructorsMap     Map of approved instructors.
	 * @return True if any instructors were approved; otherwise, false.
	 */
	public static boolean processApprovals(String[] usernames, Map<String, Instructor> pendingInstructors, 
	                                        Map<String, Instructor> instructorsMap) {
	    boolean anyApproved = false;
	    for (String username : usernames) {
	        username = username.trim();
	        if (pendingInstructors.containsKey(username)) {
	            Instructor approvedInstructor = pendingInstructors.remove(username);
	            instructorsMap.put(username, approvedInstructor);
	            ApprovedInstructorsMap.put(username, approvedInstructor);
	            System.out.println("Instructor '" + username + "' approved successfully.");
	            anyApproved = true;
	        } else {
	            System.out.println("Username '" + username + "' not found in pending applications.");
	        }
	    }
	    
	    return anyApproved;
	}
	
	/**
     * Verifies if any instructor accounts were successfully approved.
     *
     * @return True if there are approved instructor accounts; otherwise, false.
     */
	public static boolean verifyAccountActivation() {
	    if (ApprovedInstructorsMap.isEmpty()) {
	        System.out.println("No approved instructor accounts found.");
	        return false;
	    }
	    
	    printApprovedInstructorsHeader();
	    ApprovedInstructorsMap.values().stream()
	    .filter(inst -> getInstructorsMap().containsKey(inst.getUsername()))
	    .forEach(inst -> verifyAndPrintInstructor(inst));
	    
	    return true;
	}
	
	private static void printApprovedInstructorsHeader() {
	    System.out.println("Approved Instructors:");
	    System.out.printf("%-15s %-15s %-25s %-20s\n", "First Name", "Last Name", "Email", "Username");
	    System.out.println("-----------------------------------------------------------------------------");
	}
	
	private static void verifyAndPrintInstructor(Instructor inst) {
	    System.out.printf("%-15s %-15s %-25s %-20s\n",
	            inst.getFirstName(),
	            inst.getLastName(),
	            inst.getEmail(),
	            inst.getUsername());
	}
	
	/**
     * Displays and verifies activity reports for instructors and clients.
     *
     * @return True if activity reports were successfully viewed and verified; otherwise, false.
     */
	public static boolean viewAndVerifyReportsActivity() {
		if(!viewActivityReports()) {
			return false;
		} else {
			return verifyActivityReports();
		}
	}
	
	/**
     * Displays activity reports for instructors and clients.
     *
     * @return True if activity reports were displayed successfully; otherwise, false.
     */
	public static boolean viewActivityReports() {
		if (getClientsMap().isEmpty() && getInstructorsMap().isEmpty()) {
            System.out.println("No activity reports available.");
            return false;
        }
		
        System.out.println("\nActivity Reports:");
        System.out.printf("%-20s %-15s %-20s\n", "Username", "Logins", "Last Login");
        System.out.println("---------------------------------------------------------");
        
        if(!getClientsMap().isEmpty()) {
            for (Client entry : getClientsMap().values()) {
            	String username = entry.getFirstName() + " " + entry.getLastName();
                int logins = entry.getLogins();
                String lastLogin = entry.getLastLogin();
                
                System.out.printf("%-20s %-15d %-20s\n", username, logins, lastLogin);
            }
            
            thereAreActivations = true;
        }
        
        if(!getInstructorsMap().isEmpty()) {
        	for (Instructor entry : getInstructorsMap().values()) {
        		String username = entry.getFirstName() + " " + entry.getLastName();
                int logins = entry.getLogins();
                String lastLogin = entry.getLastLogin();
                
                System.out.printf("%-20s %-15d %-20s\n", username, logins, lastLogin);
            }
            
            thereAreActivations = true;
        }
        return true;
	}
	
	/**
     * Verifies if there are any activity reports.
     *
     * @return True if activity reports exist; otherwise, false.
     */
	public static boolean verifyActivityReports() {
	    return thereAreActivations;
	}
}