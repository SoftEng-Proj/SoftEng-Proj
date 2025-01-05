package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;
import com.Software.FitnessSystem.User;
import com.Software.FitnessSystem.AdminControllers.UserManagementControls;

import java.util.Map;
import java.util.Scanner;

/**
 * Represents the Co-User Management page for the admin in the fitness system.
 * This page allows the admin to manage all aspects of user accounts efficiently,
 * focusing on instructors and clients. It provides comprehensive tools to
 * ensure smooth account management and user engagement tracking.
 * 
 * @author Muath Hassoun
 */
public class CoUserManagementPage {
	/**
	 * Edits the details of a user account.
	 *
	 * @param username The username of the account to edit.
	 * @param role     The role of the user ("Instructor" or "Client").
	 * @return True if the details were successfully updated; otherwise, false.
	 */
	public static boolean editUserDetails(String username, String role) {
	    switch (role) {
	        case "Instructor":
	            return processEdit(getInstructorsMap(), username, INSTRUCTOR_ACCOUNTS_FILENAME);
	        case "Client":
	            return processEdit(getClientsMap(), username, CLIENT_ACCOUNTS_FILENAME);
	        default:
	            System.out.println("Invalid role provided.");
	            return false;
	    }
	}
	
	/**
	 * Processes the editing of a user based on the provided map and file.
	 *
	 * @param userMap  The map containing the user accounts.
	 * @param username The username of the account to edit.
	 * @param filename The file where updated accounts will be saved.
	 * @return True if the details were successfully updated; otherwise, false.
	 */
	private static <T extends User> boolean processEdit(Map<String, T> userMap, String username, String filename) {
	    T user = userMap.get(username);
	    if (user == null) {
	        System.out.println("User with username '" + username + "' not found.");
	        return false;
	    }
	    
	    try {
	        editDetails(user);
	        printingAMessageOfSuccess(user);
	        return true;
	    } catch (Exception e) {
	        System.err.println("An error occurred while editing the user: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    }
	}
	
	/**
	 * Edits the details of the provided user.
	 *
	 * @param user The user to edit.
	 */
	private static <T extends User> void editDetails(T user) {
	    try (Scanner scanner = new Scanner(System.in)) {
	    	UserManagementControls.updatedInstructor.remove(user.getUsername());
	    	UserManagementControls.updatedInstructor.add(user.getUsername());
	        
	        String newFirstName = promptForUpdate(scanner, "First Name", user.getFirstName());
	        String newLastName = promptForUpdate(scanner, "Last Name", user.getLastName());
	        String newEmail = promptForUpdate(scanner, "Email", user.getEmail());
	        String newUsername = promptForUpdate(scanner, "Username", user.getUsername());
	        String newPassword = promptForUpdate(scanner, "Password", user.getPassword());
	        
	        UserManagementControls.checkNewData(user, newFirstName, newLastName, newEmail, newUsername, newPassword);
	    }
	}
	
	/**
	 * Prompts the user to update a field and returns the updated value.
	 *
	 * @param scanner The Scanner instance for input.
	 * @param field   The name of the field being updated.
	 * @param current The current value of the field.
	 * @return The updated value or the current value if left blank.
	 */
	private static String promptForUpdate(Scanner scanner, String field, String current) {
	    System.out.println("Current " + field + ": " + current);
	    System.out.print("Enter new " + field + " (leave blank to keep unchanged): ");
	    String input = scanner.nextLine().trim();
	    return input.isEmpty() ? current : input;
	}
	
	/**
	 * Prints a success message with the updated details of a user.
	 *
	 * @param <T>      The type of user, extending the `User` class.
	 * @param editUser The user object whose details have been updated.
	 */
	private static <T extends User> void printingAMessageOfSuccess(T editUser) {
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
        return switch (role) {
            case "Instructor" -> UserManagementControls.updatedInstructor.contains(username);
            case "Client" -> UserManagementControls.updatedClient.contains(username);
            default -> false;
        };
	}
}