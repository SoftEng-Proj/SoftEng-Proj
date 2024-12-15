package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.UserManagementControls.*;
import com.Software.FitnessSystem.User;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;

import java.util.Map;
import java.util.Scanner;

public class UserManagementPage extends BasePage {
	private static AdminPagesController AdminPagesController;
	private static String fName;
	private static String lName;
	private static String email;
	private static String username;
	private static String password;
	private static String role;
	
	private String stringResolution = "";
	private boolean booleanResolution = false;
	
	public static void setUserValues(String fName, String lName, String email, String username, String password, String role) {
		UserManagementPage.fName = fName;
		UserManagementPage.lName = lName;
		UserManagementPage.email = email;
		UserManagementPage.username = username;
		UserManagementPage.password = password;
		UserManagementPage.role = role;
	}
	
	public static void setUsername(String username, String role) {
		UserManagementPage.username = username;
		UserManagementPage.role = role;
	}
	
	public static void setUserPassword(String password, String role) {
		UserManagementPage.password = password;
		UserManagementPage.role = role;
	}
	
	public static void setUserFirstName(String fName, String role) {
		UserManagementPage.fName = fName;
		UserManagementPage.role = role;
	}
	
	public static void setUserLastName(String lName, String role) {
		UserManagementPage.lName = lName;
		UserManagementPage.role = role;
	}
	
	public static void setUserEmail(String email, String role) {
		UserManagementPage.email = email;
		UserManagementPage.role = role;
	}
	
	public UserManagementPage(AdminPagesController AdminPagesController) {
		UserManagementPage.AdminPagesController = AdminPagesController;
	}
	
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
    
    @Override
    public void executeOption(int choice) {
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
            	booleanResolution = selectUser(username, role);
            	editUserDetails(username, role);
                break;
            case 4:
            	printUserDetails(getClientsMap());
            	selecteAUser();
            	UserManagementPage.role = "Client";
            	booleanResolution = selectUser(username, role);
            	editUserDetails(username, role);
                break;
            case 5:
            	printUserDetails(getInstructorsMap());
            	selecteAUser();
            	UserManagementPage.role = "Instructor";
            	booleanResolution = selectUser(username, role);
            	deactivateUser(username, role);
                break;
            case 6:
            	printUserDetails(getClientsMap());
            	selecteAUser();
            	UserManagementPage.role = "Client";
            	booleanResolution = selectUser(username, role);
            	deactivateUser(username, role);
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
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
        saveAccountChanges();
    }
    
    @SuppressWarnings("resource")
	private void promptUserForDetails() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter first name: ");
        String fName = scanner.nextLine();
        UserManagementPage.fName = fName;
        
        System.out.print("Enter last name: ");
        String lName = scanner.nextLine();
        UserManagementPage.lName = lName;
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        UserManagementPage.email = email;
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        UserManagementPage.username = username;
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        UserManagementPage.password = password;
    }
    
    private void printingAMessageOfSsuccess() {
    	System.out.println("\nA new user account has been established successfully!");
	    System.out.println("First Name: " + UserManagementPage.fName);
	    System.out.println("Last Name: " + UserManagementPage.lName);
	    System.out.println("Email: " + UserManagementPage.email);
	    System.out.println("\nUsername: " + UserManagementPage.username);
	    System.out.println("Password: " + UserManagementPage.password);
    }
    
	private <T extends User> boolean printUserDetails(Map<String, T> userMap) {
	    if (userMap == null || userMap.isEmpty()) {
	        return false;
	    } else {
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
	        return true;
	    }
	}
	
	@SuppressWarnings("resource")
	private void selecteAUser() {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        UserManagementPage.username = username;
    }
    
	private String getValueOrDefault(String value) {
	    return value == null ? "N/A" : value;
	}
	
    public String getStringResolution() {
    	return stringResolution;
    }
    
    public boolean getBooleanResolution() {
    	return booleanResolution;
    }
}