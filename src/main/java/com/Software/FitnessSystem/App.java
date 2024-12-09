package com.Software.FitnessSystem;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
    
	public String login(String userName, String password, String role) {
        switch (role) {
        case "Admin":
            //this.admin.add(new Admin(userName, password));
        	return "AdminLoggedIn";
        case "Instructor":
        	return "InstructorLoggedIn";
        case "Client":
        	return "ClientLoggedIn";
        default:
        	return "NoOneLoggedIn";
        }
	}
}