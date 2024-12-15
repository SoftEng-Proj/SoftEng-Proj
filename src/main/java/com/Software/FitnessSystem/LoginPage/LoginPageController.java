package com.Software.FitnessSystem.LoginPage;
import java.util.Scanner;

import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;

public class LoginPageController {
    public AdminPagesController adminPagesController = new AdminPagesController();
    public InstructorPageControllers instructorPagesController = new InstructorPageControllers();
    public ClientPageControllers clientPagesController = new ClientPageControllers(new Client());
    
    @SuppressWarnings("unused")
	private int mainListNumber = 0;
    
    public LoginPageController() {
    	navigateToLoginPage();
    }
    
    private void displayLoginMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Login as Admin.");
        System.out.println("2. Login as Instructor.");
        System.out.println("3. Login as Client.");
        System.out.println("4. Exit.");
        System.out.print(">> Enter your choice: ");
    }
    
    @SuppressWarnings("resource")
	public boolean navigateToLoginPage() {
    	displayLoginMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
        mainListNumber = choiceNumber;
        navigateToPage(choiceNumber);
        return true;
    }
    
    public boolean navigateToPage(int page) {
        switch (page) {
            case 1 -> {
            	if(loginData(1)) {
                	adminPagesController.navigateToManagementPage();
            	} else {
            		navigateToLoginPage();
            		return false;
            	}
            }
            case 2 ->  {
            	if(loginData(2)) {
            		instructorPagesController.navigateToManagementPage();
            	} else {
            		navigateToLoginPage();
            		return false;
            	}
            }
            case 3 -> {
	        	if(loginData(3)) {
	        		clientPagesController.navigateToManagementPage();
	        	} else {
	        		navigateToLoginPage();
	        		return false;
	        	}
	        }
            
            case 4 -> {
                System.err.println("\n\nExiting program. Goodbye!");
                System.exit(0);
            }
            default -> {
            	System.out.println("Invalid selection. Please try again.");
            }
        }
        return true;
    }
    
    private boolean loginData(int from) {
    	switch(from) {
    	case 1:
    		return interData(1);
    	case 2:
    		return interData(2);
    	case 3:
    		return interData(3);
    	default:
    		return false;
    	}
    }
    
    @SuppressWarnings("resource")
	private boolean interData(int from) {
    	Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        
        while (!isLoggedIn) {
            System.out.println("\nPlease, Enter your data to log in your account:");
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            
            if (verifyCredentials(username, password, from)) {
                System.out.println("\nLogin successful!");
                isLoggedIn = true;
                return true;
            } else {
                System.out.println("\nInvalid username or password. Please try again.");
                return false;
            }
        }
        
        return false;
    }
    
    private static boolean verifyCredentials(String username, String password, int from) {
    	switch(from) {
    	case 1:
        	if(App.getAdminsMap().containsKey(username) && 
        			App.getAdminsMap().get(username).getPassword().equals(password)) {
        		return true;
        	}
    		return false;
    	case 2:
        	if(App.getInstructorsMap().containsKey(username) && 
        			App.getInstructorsMap().get(username).getPassword().equals(password)) {
        		return true;
        	}
    		return false;
    	case 3:
        	if(App.getClientsMap().containsKey(username) && 
        			App.getClientsMap().get(username).getPassword().equals(password)) {
        		return true;
        	}
    		return false;
    	default:
    		return false;
    	}
    }
}