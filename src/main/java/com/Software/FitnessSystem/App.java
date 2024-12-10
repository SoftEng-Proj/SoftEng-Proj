package com.Software.FitnessSystem;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static Map<String, Map<String, String>> AccountsMap = new HashMap<>();
    public static Map<String, Admin> AdminsMap = new HashMap<>();
    public static Map<String, Instructor> InstructorsMap = new HashMap<>();
    public static Map<String, Client> ClientsMap = new HashMap<>();
    
    public static Admin Admin;
    public static Instructor Instructor;
    public static Client Client;
    
    public static void main(String[] args) {
        System.out.println("Welcome to FitX");
    }
    
	public String login(String userName, String password, String role) {
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
}