package com.Software.FitnessSystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.Software.FitnessSystem.LoginPage.LoginPageController;

public class App {
	public static final String ADMIN_ACCOUNTS_FILENAME = "Files/Admins_File.json";
	public static final String INSTRUCTOR_ACCOUNTS_FILENAME = "Files/Instructors_File.json";
	public static final String PENDING_INSTRUCTOR_ACCOUNTS_FILENAME = "Files/PendingInstructors.json";
	public static final String CLIENT_ACCOUNTS_FILENAME = "Files/Clients_File.json";
	
    private static Map<String, Map<String, String>> AccountsMap = new HashMap<>();
    private static Map<String, Admin> AdminsMap = new HashMap<>();
    private static Map<String, Instructor> InstructorsMap = new HashMap<>();
    private static Map<String, Instructor> PendingInstructorsMap = new HashMap<>();
    private static Map<String, Client> ClientsMap = new HashMap<>();
    
    private static Admin Admin;
    private static Instructor Instructor;
    private static Client Client;
    
    public static void main(String[] args) {
        new App();
        
    	System.out.println("==============================================");
        System.out.println("     Welcome to Fitness Management System     ");
        System.out.println("==============================================\n");
        new LoginPageController();
    }
    
    public App() {
    	LoadAndSaveEntities.loadAdminsFromFile(AdminsMap, ADMIN_ACCOUNTS_FILENAME);
    	LoadAndSaveEntities.loadInstructorsFromFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
    	LoadAndSaveEntities.loadPendingInstructorsFromFile(PendingInstructorsMap, PENDING_INSTRUCTOR_ACCOUNTS_FILENAME);
    	LoadAndSaveEntities.loadClientsFromFile(ClientsMap, CLIENT_ACCOUNTS_FILENAME);
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
        	Instructor.setLastLogin(formattedDateTime);
        	Instructor.setLogins(Instructor.getLogins() + 1);
        	LoadAndSaveEntities.saveInstructorsToFile(InstructorsMap, INSTRUCTOR_ACCOUNTS_FILENAME);
        	
        	return "InstructorLoggedIn";
        case "Client":
        	Client = ClientsMap.get(userName);
        	Client.setLastLogin(formattedDateTime);
        	Client.setLogins(Client.getLogins() + 1);
        	LoadAndSaveEntities.saveClientsToFile(ClientsMap, ADMIN_ACCOUNTS_FILENAME);
        	
        	return "ClientLoggedIn";
        default:
        	return "NoOneLoggedIn";
        }
	}
	
	public static void putNewAccount(String role, Map<String, String> user) {
		AccountsMap.put(role, user);
	}
	public static Map<String, Map<String, String>> getAccountsMap() {
		return AccountsMap;
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
	
	public static Admin getAdminAccount() {
		return Admin;
	}
	
	public static Instructor getInstructorAccount() {
		return Instructor;
	}
	
	public static Client getClientAccount() {
		return Client;
	}
}