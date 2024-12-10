package com.Software.FitnessSystem.AdminPageNavigation;

import com.Software.FitnessSystem.AdminControllers.UserManagementControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;

public class UserManagementPage extends BasePage {
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
            	stringResolution = UserManagementControls.fillUserDetails(fName, lName, email, username, password, role);
                break;
            case 2:
            	stringResolution = UserManagementControls.fillUserDetails(fName, lName, email, username, password, role);
                break;
            case 3:
            	booleanResolution = UserManagementControls.selectUser(username, role);
            	UserManagementControls.editUserDetails(username, role);
                break;
            case 4:
            	booleanResolution = UserManagementControls.selectUser(username, role);
            	UserManagementControls.editUserDetails(username, role);
                break;
            case 5:
            	booleanResolution = UserManagementControls.selectUser(username, role);
            	UserManagementControls.deactivateUser(username, role);
                break;
            case 6:
            	booleanResolution = UserManagementControls.selectUser(username, role);
            	UserManagementControls.deactivateUser(username, role);
                break;
            case 7:
            	UserManagementControls.checkAndApproveInstructors();
                break;
            case 8:
            	UserManagementControls.viewAndVerifyReportsActivity();
                break;
            case 9:
                goBack();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
        UserManagementControls.saveChanges();
    }
    
    public String getStringResolution() {
    	return stringResolution;
    }
    
    public boolean getBooleanResolution() {
    	return booleanResolution;
    }
}