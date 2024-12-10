package com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.Instructor;
import com.Software.FitnessSystem.LoadAndSaveEntities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
    
	public static String fillUserDetails(String fName, String lName, String email, String userName, String password, String role) {
		Map<String, String> newAccount = new HashMap<>();
		LocalDateTime currentDateTime = LocalDateTime.now();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        
		switch(role) {
		case "Instructor":
			newInstructor = new Instructor(fName, lName, email, userName, password);
	        newInstructor.setLastLogin(formattedDateTime);
	        newInstructor.setLogins(1);
	        
			App.putNewInstructor(userName, newInstructor);
			
			newAccount.put(userName, password);
			App.putNewAccount(role, newAccount);
			return role + "_Added";
		case "Client":
			newClient = new Client(fName, lName, email, userName, password);
			newClient.setLastLogin(formattedDateTime);
			newClient.setLogins(1);
	        
			App.putNewClient(userName, newClient);
			
			newAccount.put(userName, password);
			App.putNewAccount(role, newAccount);
			return role + "_Added";
		default:
			return "Fail";
		}
	}
	
	public static boolean verifyUserCreation(String userName, String role) {
		switch(role) {
		case "Instructor":
			App.putNewInstructor(userName, newInstructor);
			boolean isInstructorCreated = App.getInstructorsMap().containsKey(userName) ? true : false;
			return isInstructorCreated;
		case "Client":
			App.putNewClient(userName, newClient);
			boolean isClientCreated = App.getClientsMap().containsKey(userName) ? true : false;
			return isClientCreated;
		default:
			return false;
		}
	}
	
	public static boolean selectUser(String username, String role) {
		switch(role) {
		case "Instructor":
			returnedInstructor = App.getInstructorsMap().get(username);
			return true;
		case "Client":
			returnedClient = App.getClientsMap().get(username);
			return true;
		default:
			return false;
		}
	}
	
	public static Instructor getReturnedInstructor() {
		return returnedInstructor;
	}
	
	public static Client getReturnedClient() {
		return returnedClient;
	}
	
	public static boolean editUserDetails(String username, String role) {
		switch(role) {
		case "Instructor":
			try {
			    Instructor editInstructor = App.getInstructorsMap().get(username);
			    if (editInstructor == null) {
			        System.out.println("Instructor with username '" + username + "' not found.");
			        return false;
			    }
			    
			    editInstructorDetails(editInstructor);
			    return true;
			} catch (Exception e) {
			    System.err.println("An error occurred while editing the instructor: " + e.getMessage());
			    e.printStackTrace();
			    return false;
			}
		case "Client":
			try {
				Client editClient = App.getClientsMap().get(username);
			    if (editClient == null) {
			        System.out.println("Client with username '" + username + "' not found.");
			        return false;
			    }
			    
			    editClientDetails(editClient);
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
	    
	    System.out.println("\nUser details updated successfully!");
	    System.out.println("First Name: " + editInstructor.getFirstName());
	    System.out.println("Last Name: " + editInstructor.getLastName());
	    System.out.println("Email: " + editInstructor.getEmail());
	    System.out.println("Username: " + editInstructor.getUsername());
	    System.out.println("Password: " + editInstructor.getPassword());
	    LoadAndSaveEntities.saveInstructorsToFile(App.getInstructorsMap(), App.INSTRUCTOR_ACCOUNTS_FILENAME);
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
	    
	    System.out.println("\nUser details updated successfully!");
	    System.out.println("First Name: " + editClient.getFirstName());
	    System.out.println("Last Name: " + editClient.getLastName());
	    System.out.println("Email: " + editClient.getEmail());
	    System.out.println("Username: " + editClient.getUsername());
	    System.out.println("Password: " + editClient.getPassword());
		LoadAndSaveEntities.saveClientsToFile(App.getClientsMap(), App.CLIENT_ACCOUNTS_FILENAME);
	}
	
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
	
	public static boolean deactivateUser(String username, String role) {
		switch(role) {
		case "Instructor":
			App.getInstructorsMap().remove(username);
			deactivateInstructor.remove(username);
			deactivateInstructor.add(username);
			return !App.getInstructorsMap().containsKey(username);
		case "Client":
			App.getClientsMap().remove(username);
			deactivateClient.remove(username);
			deactivateClient.add(username);
			return !App.getClientsMap().containsKey(username);
		default:
			return false;
		}
	}

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
	
	public static boolean checkAndApproveInstructors() {
		if(!checkPendingApplications()) {
			return false;
		} else {
			approveInstructors();
			return verifyAccountActivation();
		}
	}
	
	public static boolean checkPendingApplications() {
	    Map<String, Instructor> pendingInstructors = App.getPendingInstructorsMap();
	    
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
	
	@SuppressWarnings("resource")
	public static boolean approveInstructors() {
	    Map<String, Instructor> pendingInstructors = App.getPendingInstructorsMap();
	    Map<String, Instructor> instructorsMap = App.getInstructorsMap();
	    
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
	
	public static boolean verifyAccountActivation() {
	    if (ApprovedInstructorsMap.isEmpty()) {
	        System.out.println("No approved instructor accounts found.");
	        return false;
	    }
	    
	    System.out.println("Approved Instructors:");
	    System.out.printf("%-15s %-15s %-25s %-20s\n", "First Name", "Last Name", "Email", "Username");
	    System.out.println("-----------------------------------------------------------------------------");
	    
	    for (Instructor inst : ApprovedInstructorsMap.values()) {
	    	if(App.getInstructorsMap().containsKey(inst.getUsername())) {
		        System.out.printf("%-15s %-15s %-25s %-20s\n",
                        inst.getFirstName(),
                        inst.getLastName(),
                        inst.getEmail(),
                        inst.getUsername());
	    	}
	    }
	    return true;
	}
	
	public static boolean viewAndVerifyReportsActivity() {
		if(!viewActivityReports()) {
			return false;
		} else {
			return verifyActivityReports();
		}
	}
	
	public static boolean viewActivityReports() {
		if (App.getClientsMap().isEmpty() && App.getInstructorsMap().isEmpty()) {
            System.out.println("No activity reports available.");
            return false;
        }
		
        System.out.println("\nActivity Reports:");
        System.out.printf("%-20s %-15s %-20s\n", "Username", "Logins", "Last Login");
        System.out.println("---------------------------------------------------------");
        
        if(!App.getClientsMap().isEmpty()) {
            for (Client entry : App.getClientsMap().values()) {
            	String username = entry.getFirstName() + " " + entry.getLastName();
                int logins = entry.getLogins();
                String lastLogin = entry.getLastLogin();
                
                System.out.printf("%-20s %-15d %-20s\n", username, logins, lastLogin);
            }
            
            thereAreActivations = true;
        }
        
        if(!App.getInstructorsMap().isEmpty()) {
        	for (Instructor entry : App.getInstructorsMap().values()) {
        		String username = entry.getFirstName() + " " + entry.getLastName();
                int logins = entry.getLogins();
                String lastLogin = entry.getLastLogin();
                
                System.out.printf("%-20s %-15d %-20s\n", username, logins, lastLogin);
            }
            
            thereAreActivations = true;
        }
        return true;
	}
	
	public static boolean verifyActivityReports() {
	    return thereAreActivations;
	}
	
	public static boolean saveChanges() {
		LoadAndSaveEntities.saveAdminsToFile(App.getAdminsMap(), App.ADMIN_ACCOUNTS_FILENAME);
		LoadAndSaveEntities.saveInstructorsToFile(App.getInstructorsMap(), App.INSTRUCTOR_ACCOUNTS_FILENAME);
		LoadAndSaveEntities.savePendingInstructorsToFile(App.getPendingInstructorsMap(), App.PENDING_INSTRUCTOR_ACCOUNTS_FILENAME);
		LoadAndSaveEntities.saveClientsToFile(App.getClientsMap(), App.CLIENT_ACCOUNTS_FILENAME);
		
		return true;
	}
}