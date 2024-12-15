package com.Software.FitnessSystem.AdminControllers;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.LoadAndSaveEntities.*;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.Instructor;
import com.Software.FitnessSystem.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * This class provides various administrative controls for managing user accounts, including instructors and clients.
 * It allows creating, editing, deactivating users, approving pending instructors, and viewing activity reports.
 * 
 * @author Muath Hassoun
 */
public class UserManagementControls {
	private static Map<String, Instructor> ApprovedInstructorsMap = new HashMap<>();
	private static List<String> deactivateInstructor = new ArrayList<>();
	private static List<String> deactivateClient = new ArrayList<>();
	private static List<String> updatedInstructor = new ArrayList<>();
	private static List<String> updatedClient = new ArrayList<>();
	
    private static Instructor newInstructor;
    private static Instructor returnedInstructor;
    private static Client newClient;
    private static Client returnedClient;
    private static boolean thereAreActivations = false;
    
    private static LocalDateTime currentDateTime = LocalDateTime.now();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static String formattedDateTime = currentDateTime.format(formatter);
    
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
		switch(role) {
		case "Instructor":
			instructorNewAccount(fName, lName, email, userName, password);
			return role + "_Added";
		case "Client":
			clientNewAccount(fName, lName, email, userName, password);
			return role + "_Added";
		default:
			return "Fail";
		}
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
		switch(role) {
		case "Instructor":
			putNewInstructor(userName, newInstructor);
			boolean isInstructorCreated = getInstructorsMap().containsKey(userName) ? true : false;
			return isInstructorCreated;
		case "Client":
			putNewClient(userName, newClient);
			boolean isClientCreated = getClientsMap().containsKey(userName) ? true : false;
			return isClientCreated;
		default:
			return false;
		}
	}
	
	/**
     * Selects a user account for subsequent operations.
     *
     * @param username The username of the account.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return True if the user exists; otherwise, false.
     */
	public static boolean selectUser(String username, String role) {
		switch(role) {
		case "Instructor":
			returnedInstructor = getInstructorsMap().get(username);
			return true;
		case "Client":
			returnedClient = getClientsMap().get(username);
			return true;
		default:
			return false;
		}
	}
	
	/**
     * Retrieves the currently selected instructor.
     *
     * @return The selected instructor.
     */
	public static Instructor getReturnedInstructor() {
		return returnedInstructor;
	}
	
	/**
     * Retrieves the currently selected client.
     *
     * @return The selected client.
     */
	public static Client getReturnedClient() {
		return returnedClient;
	}
	
	/**
     * Edits the details of a user account.
     *
     * @param username The username of the account to edit.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return True if the details were successfully updated; otherwise, false.
     */
	public static boolean editUserDetails(String username, String role) {
		switch(role) {
		case "Instructor":
			try {
			    Instructor editInstructor = getInstructorsMap().get(username);
			    if (editInstructor == null) {
			        System.out.println("Instructor with username '" + username + "' not found.");
			        return false;
			    }
			    
			    editInstructorDetails(editInstructor);
			    printingAMessageOfSsuccess(editInstructor);
			    saveInstructorsToFile(getInstructorsMap(), INSTRUCTOR_ACCOUNTS_FILENAME);
			    return true;
			} catch (Exception e) {
			    System.err.println("An error occurred while editing the instructor: " + e.getMessage());
			    e.printStackTrace();
			    return false;
			}
		case "Client":
			try {
				Client editClient = getClientsMap().get(username);
			    if (editClient == null) {
			        System.out.println("Client with username '" + username + "' not found.");
			        return false;
			    }
			    
			    editClientDetails(editClient);
			    printingAMessageOfSsuccess(editClient);
				saveClientsToFile(getClientsMap(), CLIENT_ACCOUNTS_FILENAME);
			    return true;
			} catch (Exception e) {
			    System.err.println("An error occurred while editing the instructor: " + e.getMessage());
			    e.printStackTrace();
			    return false;
			}
		default:
			return false;
		}
	}
	
	@SuppressWarnings("resource")
	private static void editInstructorDetails(Instructor editInstructor) {
	    Scanner scanner = new Scanner(System.in);
	    updatedInstructor.remove(editInstructor.getUsername());
	    updatedInstructor.add(editInstructor.getUsername());
	    
	    System.out.println("\nCurrent First Name: " + editInstructor.getFirstName());
	    System.out.print("Enter new First Name (leave blank to keep unchanged): ");
	    String newFirstName = scanner.nextLine();
	    if (!newFirstName.trim().isEmpty()) {
	    	editInstructor.setFirstName(newFirstName);
	    }
	    
	    System.out.println("Current Last Name: " + editInstructor.getLastName());
	    System.out.print("Enter new Last Name (leave blank to keep unchanged): ");
	    String newLastName = scanner.nextLine();
	    if (!newLastName.trim().isEmpty()) {
	    	editInstructor.setLastName(newLastName);
	    }
	    
	    System.out.println("Current Email: " + editInstructor.getEmail());
	    System.out.print("Enter new Email (leave blank to keep unchanged): ");
	    String newEmail = scanner.nextLine();
	    if (!newEmail.trim().isEmpty()) {
	    	editInstructor.setEmail(newEmail);
	    }
	    
	    System.out.println("Current Username: " + editInstructor.getUsername());
	    System.out.print("Enter new Username (leave blank to keep unchanged): ");
	    String newUsername = scanner.nextLine();
	    if (!newUsername.trim().isEmpty()) {
	    	editInstructor.setUsername(newUsername);
	    }
	    
	    System.out.println("Current Password: " + editInstructor.getPassword());
	    System.out.print("Enter new Password (leave blank to keep unchanged): ");
	    String newPassword = scanner.nextLine();
	    if (!newPassword.trim().isEmpty()) {
	    	editInstructor.setPassword(newPassword);
	    }
	}
	
	@SuppressWarnings("resource")
	private static void editClientDetails(Client editClient) {
	    Scanner scanner = new Scanner(System.in);
	    updatedClient.remove(editClient.getUsername());
	    updatedClient.add(editClient.getUsername());
	    
	    System.out.println("\nCurrent First Name: " + editClient.getFirstName());
	    System.out.print("Enter new First Name (leave blank to keep unchanged): ");
	    String newFirstName = scanner.nextLine();
	    if (!newFirstName.trim().isEmpty()) {
	    	editClient.setFirstName(newFirstName);
	    }
	    
	    System.out.println("Current Last Name: " + editClient.getLastName());
	    System.out.print("Enter new Last Name (leave blank to keep unchanged): ");
	    String newLastName = scanner.nextLine();
	    if (!newLastName.trim().isEmpty()) {
	    	editClient.setLastName(newLastName);
	    }
	    
	    System.out.println("Current Email: " + editClient.getEmail());
	    System.out.print("Enter new Email (leave blank to keep unchanged): ");
	    String newEmail = scanner.nextLine();
	    if (!newEmail.trim().isEmpty()) {
	    	editClient.setEmail(newEmail);
	    }
	    
	    System.out.println("Current Username: " + editClient.getUsername());
	    System.out.print("Enter new Username (leave blank to keep unchanged): ");
	    String newUsername = scanner.nextLine();
	    if (!newUsername.trim().isEmpty()) {
	    	editClient.setUsername(newUsername);
	    }
	    
	    System.out.println("Current Password: " + editClient.getPassword());
	    System.out.print("Enter new Password (leave blank to keep unchanged): ");
	    String newPassword = scanner.nextLine();
	    if (!newPassword.trim().isEmpty()) {
	    	editClient.setPassword(newPassword);
	    }
	}
	
	private static <T extends User> void printingAMessageOfSsuccess(T editUser) {
		System.out.println("\nUser details updated successfully!");
	    System.out.println("First Name: " + editUser.getFirstName());
	    System.out.println("Last Name: " + editUser.getLastName());
	    System.out.println("Email: " + editUser.getEmail());
	    System.out.println("Username: " + editUser.getUsername());
	    System.out.println("Password: " + editUser.getPassword());
	}
	
	/**
     * Verifies if a user account's details have been updated successfully.
     *
     * @param username The username of the updated account.
     * @param role     The role of the user ("Instructor" or "Client").
     * @return True if the update was successful; otherwise, false.
     */
	public boolean verifyUserUpdate(String username, String role) {
		switch(role) {
		case "Instructor":
			return updatedInstructor.contains(username);
		case "Client":
			return updatedClient.contains(username);
		default:
			return false;
		}
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
		switch(role) {
		case "Instructor":
			return deactivateInstructor.contains(username);
		case "Client":
			return deactivateClient.contains(username);
		default:
			return false;
		}
	}
	
	/**
     * Checks and approves pending instructor applications.
     *
     * @return True if pending applications were approved; otherwise, false.
     */
	public static boolean checkAndApproveInstructors() {
		if(!checkPendingApplications()) {
			return false;
		} else {
			approveInstructors();
			return verifyAccountActivation();
		}
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
     * Approves pending instructor applications.
     *
     * @return True if any instructors were approved; otherwise, false.
     */
	@SuppressWarnings("resource")
	public static boolean approveInstructors() {
	    Map<String, Instructor> pendingInstructors = getPendingInstructorsMap();
	    Map<String, Instructor> instructorsMap = getInstructorsMap();
	    
	    if (pendingInstructors == null || pendingInstructors.isEmpty()) {
	        System.out.println("No pending applications to approve.");
	        return false;
	    }
	    
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the usernames of the instructors to approve (separate with commas): ");
	    String input = scanner.nextLine();
	    
	    String[] usernames = input.split(",");
	    boolean anyApproved = false;
	    
	    System.out.print("\n");
	    for (String username : usernames) {
	        username = username.trim();
	        if (pendingInstructors.containsKey(username)) {
	            Instructor approvedInstructor = pendingInstructors.remove(username);
	            instructorsMap.put(username, approvedInstructor);
	            ApprovedInstructorsMap.put(username, approvedInstructor);
	            anyApproved = true;
	        } else {
	            System.out.println("Username '" + username + "' not found in pending applications.");
	        }
	    }
	    
	    if (!anyApproved) {
	        System.out.println("No instructors were approved.");
	        return false;
	    }
	    return true;
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
	    
	    System.out.println("Approved Instructors:");
	    System.out.printf("%-15s %-15s %-25s %-20s\n", "First Name", "Last Name", "Email", "Username");
	    System.out.println("-----------------------------------------------------------------------------");
	    
	    for (Instructor inst : ApprovedInstructorsMap.values()) {
	    	if(getInstructorsMap().containsKey(inst.getUsername())) {
		        System.out.printf("%-15s %-15s %-25s %-20s\n",
                        inst.getFirstName(),
                        inst.getLastName(),
                        inst.getEmail(),
                        inst.getUsername());
	    	}
	    }
	    return true;
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