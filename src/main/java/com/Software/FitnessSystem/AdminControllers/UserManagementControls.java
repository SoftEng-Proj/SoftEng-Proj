package com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.Instructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManagementControls {
    private static Instructor newInstructor;
    private static Client newClient;
    
    private static Instructor returnedInstructor;
    private static Client returnedClient;
    
	public static String fillUserDetails(String fName, String lName, String email, String userName, String password, String role) {
		Map<String, String> newAccount = new HashMap<>();
		
		switch(role) {
		case "Instructor":
			newInstructor = new Instructor(fName, lName, email, userName, password);
			App.putNewInstructor(userName, newInstructor);
			
			newAccount.put(userName, password);
			App.putNewAccount(role, newAccount);
			return role + "_Added";
		case "Client":
			newClient = new Client(fName, lName, email, userName, password);
			App.putNewClient(userName, newClient);
			
			newAccount.put(userName, password);
			App.putNewAccount(role, newAccount);
			return role + "_Added";
		default:
			return "Fail";
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
	
	public boolean editUserDetails(String username, String role) {
		switch(role) {
		case "Instructor":
			try {
			    Instructor editInstructor = App.getInstructorsMap().get(username);
			    if (editInstructor == null) {
			        System.out.println("Instructor with username '" + username + "' not found.");
			        return true;
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
			        return true;
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
	private void editInstructorDetails(Instructor editInstructor) {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Current First Name: " + editInstructor.getFirstName());
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
	}
	
	@SuppressWarnings("resource")
	private void editClientDetails(Client editClient) {
	    Scanner scanner = new Scanner(System.in);
	    
	    System.out.println("Current First Name: " + editClient.getFirstName());
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
	}
	
	public boolean verifyUserUpdate(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deactivateUser(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyUserDeactivation(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkPendingApplications() {
		// TODO Auto-generated method stub
		return false;
	}

	public void approveApplication(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyNotification(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyAccountActivation(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void viewActivityReports() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean verifyActivityReports() {
		// TODO Auto-generated method stub
		return false;
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
	
	public void saveChanges() {
		
	}
}