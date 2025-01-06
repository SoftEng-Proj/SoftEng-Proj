package com.software.fitness_system.AdminPageNavigation;
import static com.software.fitness_system.AdminControllers.UserManagementControls.*;
import static com.software.fitness_system.App.*;

import java.util.Map;
import java.util.Scanner;

import com.software.fitness_system.Instructor;
import com.software.fitness_system.User;
import com.software.fitness_system.InfrastructureForPages.BasePage;
import com.software.fitness_system.LoginPage.AdminPagesController;

/**
 * Represents the User Management page for the admin in the fitness system.
 * This page allows the admin to perform various actions related to user accounts, including:
 * - Adding new instructor and client accounts.
 * - Updating instructor and client account details.
 * - Deactivating accounts for instructors and clients.
 * - Approving new instructor registrations.
 * - Monitoring user activity and engagement statistics.
 * <p>
 * It also provides methods for prompting the user for details and saving account changes.
 * 
 * @author Muath Hassoun
 */
public class UserManagementPage extends BasePage {
	private static AdminPagesController AdminPagesController;
	private static String fName;
	private static String lName;
	private static String email;
	private static String username;
	private static String password;
	private static String role;
	
	private String stringResolution = "";
	/**
     * Sets the details for the user.
     * 
     * @param fName First name of the user.
     * @param lName Last name of the user.
     * @param email Email address of the user.
     * @param username Username for the user.
     * @param password Password for the user.
     * @param role Role of the user (e.g., Instructor, Client).
     */
	public static void setUserValues(String fName, String lName, String email, String username, String password, String role) {
		UserManagementPage.fName = fName;
		UserManagementPage.lName = lName;
		UserManagementPage.email = email;
		UserManagementPage.username = username;
		UserManagementPage.password = password;
		UserManagementPage.role = role;
	}
	
	/**
     * Sets the username and role for the user.
     * 
     * @param username The username of the user.
     * @param role The role of the user (e.g., Instructor, Client).
     */
	public static void setUsername(String username, String role) {
		UserManagementPage.username = username;
		UserManagementPage.role = role;
	}
	
	/**
     * Constructor to initialize the UserManagementPage with the provided AdminPagesController.
     * 
     * @param AdminPagesController The controller responsible for managing admin page navigation and actions.
     */
	public UserManagementPage(AdminPagesController AdminPagesController) {
		UserManagementPage.AdminPagesController = AdminPagesController;
	}
	
	/**
     * Displays the User Management menu with available options for the admin.
     * The menu includes options for adding, updating, deactivating accounts, and viewing reports.
     */
    @Override
    public void display() {
        System.out.println("\nUser Management Menu:");
        System.out.println("1. Add new instructor account.");
        System.out.println("2. Add new client account.");
        System.out.println("3. Update instructor account.");
        System.out.println("4. Update client account.");
        System.out.println("5. Deactivate instructor account.");
        System.out.println("6. Deactivate client account.");
        System.out.println("7. Approve new instructor registrations.");
        System.out.println("8. Monitor user activity and engagement statistics.");
        System.out.println("9. Go Back.");
    }
    
    /**
     * Executes the selected option based on the user's choice.
     * The method handles the creation, updating, deactivation of user accounts, and approval of registrations.
     * 
     * @param choice The option selected by the admin.
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        switch (choice) {
            case 1:
            	promptUserForDetails();
            	UserManagementPage.role = "Instructor";
            	stringResolution = fillUserDetails(fName, lName, email, username, password, role);
            	printingAMessageOfSsuccess();
                break;
            case 2:
            	promptUserForDetails();
            	UserManagementPage.role = "Client";
            	stringResolution = fillUserDetails(fName, lName, email, username, password, role);
            	printingAMessageOfSsuccess();
                break;
            case 3:
            	printUserDetails(getInstructorsMap());
            	selecteAUser();
            	UserManagementPage.role = "Instructor";
            	if(checkTheUser(username, role)) {
            		CoUserManagementPage.editUserDetails(username, role);
            	}
                break;
            case 4:
            	printUserDetails(getClientsMap());
            	selecteAUser();
            	UserManagementPage.role = "Client";
            	if(checkTheUser(username, role)) {
            		CoUserManagementPage.editUserDetails(username, role);
            	}
                break;
            case 5:
            	printUserDetails(getInstructorsMap());
            	selecteAUser();
            	UserManagementPage.role = "Instructor";
            	if(checkTheUser(username, role)) {
                	deactivateUser(username, role);
            	}
                break;
            case 6:
            	printUserDetails(getClientsMap());
            	selecteAUser();
            	UserManagementPage.role = "Client";
            	if(checkTheUser(username, role)) {
                	deactivateUser(username, role);
            	}
                break;
            case 7:
            	checkAndApproveInstructors();
                break;
            case 8:
            	viewAndVerifyReportsActivity();
                break;
            case 9:
            	System.out.println("\nReturning to the main menu...");
            	AdminPagesController.navigateToManagementPage();
            	returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
        saveAccountChanges();
        return returnValue;
    }
    
    /**
     * Prompts the admin to enter user details (first name, last name, email, username, password).
     */
	private void promptUserForDetails() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter first name: ");
        UserManagementPage.fName = scanner.nextLine();
        
        System.out.print("Enter last name: ");
        UserManagementPage.lName = scanner.nextLine();
        
        System.out.print("Enter email: ");
        UserManagementPage.email = scanner.nextLine();
        
        System.out.print("Enter username: ");
        UserManagementPage.username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        UserManagementPage.password = scanner.nextLine();
    }
    
    /**
     * Prints a success message with the newly created user details.
     */
    private void printingAMessageOfSsuccess() {
    	System.out.println("\nA new user account has been established successfully!");
	    System.out.println("First Name: " + UserManagementPage.fName);
	    System.out.println("Last Name: " + UserManagementPage.lName);
	    System.out.println("Email: " + UserManagementPage.email);
	    System.out.println("\nUsername: " + UserManagementPage.username);
	    System.out.println("Password: " + UserManagementPage.password);
    }
    
    /**
     * Prints the user details from a given user map (instructors or clients).
     *
     * @param userMap The map containing user details (instructors or clients).
     */
	private <T extends User> void printUserDetails(Map<String, T> userMap) {
	    if (!(userMap == null || userMap.isEmpty())) {
	    	System.out.println();
	        System.out.printf("%-20s %-15s %-15s %-25s\n", "Username", "First Name", "Last Name", "Email");
	        System.out.println("---------------------------------------------------------------------------");
	        
	        userMap.values().forEach(entity -> System.out.printf("%-20s %-15s %-15s %-25s\n",
	                getValueOrDefault(entity.getUsername()),
	                getValueOrDefault(entity.getFirstName()),
	                getValueOrDefault(entity.getLastName()),
	                getValueOrDefault(entity.getEmail())
	        ));
	        
	        System.out.println();
        }
	}
	
	/**
     * Prompts the admin to select a user by username.
     */
	private void selecteAUser() {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        UserManagementPage.username = scanner.nextLine();
    }
	
	/**
	 * Checks and approves pending instructor applications.
	 */
	public static void checkAndApproveInstructors() {
		if(checkPendingApplications()) {
			approveInstructors();
			verifyAccountActivation();
		}
	}
	
	/**
	 * Approves pending instructor applications.
	 *
	 * @param pendingUserNames Array of usernames to approve (used if `skip` is false).
	 * @param skip             If true, prompts the user to input usernames.
	 * @return True if any instructors were approved; otherwise, false.
	 */
	public static boolean approveInstructors() {
	    Map<String, Instructor> pendingInstructors = getPendingInstructorsMap();
	    Map<String, Instructor> instructorsMap = getInstructorsMap();
	    
	    if (pendingInstructors == null || pendingInstructors.isEmpty()) {
	        System.out.println("No pending applications to approve.");
	        return false;
	    }
	    
	    String[] usernames = getUsernamesFromInput();
	    if (usernames == null || usernames.length == 0) {
	        System.out.println("No usernames provided for approval.");
	        return false;
	    }
	    
	    boolean anyApproved = processApprovals(usernames, pendingInstructors, instructorsMap);
	    if (!anyApproved) {
	        System.out.println("No instructors were approved.");
	        return false;
	    }
	    
	    System.out.println("Instructor approval process completed.");
	    return true;
	}
	
	/**
	 * Prompts the user to input usernames for approval.
	 *
	 * @return An array of usernames entered by the user.
	 */
	private static String[] getUsernamesFromInput() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the usernames of the instructors to approve (separate with commas): ");
	    String input = scanner.nextLine();
	    return input.trim().isEmpty() ? new String[0] : input.split(",");
	}
    
	/**
     * Returns the default value if the input value is null.
     * 
     * @param value The value to check.
     * @return The value or "N/A" if it's null.
     */
	private String getValueOrDefault(String value) {
	    return value == null ? "N/A" : value;
	}
	
	/**
     * Gets the string resolution for the user management actions.
     * 
     * @return The string resolution.
     */
    public String getStringResolution() {
    	return stringResolution;
    }
}