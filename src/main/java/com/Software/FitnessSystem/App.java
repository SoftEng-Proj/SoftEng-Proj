package com.Software.FitnessSystem;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static Map<String, Map<String, String>> AccountsMap = new HashMap<>();
    private static Map<String, Admin> AdminsMap = new HashMap<>();
    private static Map<String, Instructor> InstructorsMap = new HashMap<>();
    private static Map<String, Client> ClientsMap = new HashMap<>();
    
    private static Admin Admin;
    private static Instructor Instructor;
    private static Client Client;
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
	public static String login(String userName, String password, String role) {
        switch (role) {
        case "Admin":
        	Admin = AdminsMap.get(userName);
        	return "AdminLoggedIn";
        case "Instructor":
        	Instructor = InstructorsMap.get(userName);
        	return "InstructorLoggedIn";
        case "Client":
        	Client = ClientsMap.get(userName);
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