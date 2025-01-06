package com.software.fitness_system.LoginPage;
import static com.software.fitness_system.App.*;

import java.util.Scanner;

import com.software.fitness_system.Client;
import com.software.fitness_system.Instructor;

/**
 * Controls the login process for admin, instructor, and client users.
 * This class provides a login menu and handles user authentication 
 * for different user roles. Upon successful login, the user is redirected 
 * to the appropriate page controller (Admin, Instructor, or Client).
 * 
 * The controller supports navigation between login, admin, instructor, and 
 * client pages. It also verifies user credentials using stored user data.
 * 
 * @author Muath Hassoun
 */
public class LoginPageController {
    public AdminPagesController adminPagesController = new AdminPagesController();
    public InstructorPageControllers instructorPagesController = new InstructorPageControllers();
    public ClientPageControllers clientPagesController = new ClientPageControllers(new Client());
    
    @SuppressWarnings("unused")
	private int mainListNumber = 0;
    
    /**
     * Constructs an instance of the {@code LoginPageController} and immediately navigates 
     * the user to the login menu.
     */
    public LoginPageController() {
    	navigateToLoginPage();
    }
    
    /**
     * Displays the login menu and prompts the user to select one of the available options.
     * Options include logging in as Admin, Instructor, Client, or exiting the program.
     */
    private void displayLoginMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Login as Admin.");
        System.out.println("2. Login as Instructor.");
        System.out.println("3. Login as Client.");
        System.out.println("4. Exit.");
        System.out.print(">> Enter your choice: ");
    }
    
    /**
     * Navigates to the login page, displays the menu, and waits for the user's selection.
     * Based on the user's input, it calls {@link #navigateToPage(int)}.
     * 
     * @return {@code true} if navigation is successful.
     */
    @SuppressWarnings("resource")
	public boolean navigateToLoginPage() {
    	displayLoginMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
        mainListNumber = choiceNumber;
        navigateToPage(choiceNumber);
        return true;
    }
    
    /**
     * Navigates to a specific page based on the user's choice from the login menu.
     * 
     * @param page The number representing the user's choice.
     *             1 - Admin login
     *             2 - Instructor login
     *             3 - Client login
     *             4 - Exit the program
     * 
     * @return {@code true} if navigation is successful.
     */
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
    
    /**
     * Handles login attempts for Admin, Instructor, or Client.
     * Determines which type of user is logging in and calls {@link #interData(int)}.
     * 
     * @param from The type of user attempting to log in:
     *             1 - Admin
     *             2 - Instructor
     *             3 - Client
     * 
     * @return {@code true} if login is successful, otherwise {@code false}.
     */
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
    
    /**
     * Prompts the user to enter login credentials (username and password) and verifies them.
     * 
     * @param from The type of user attempting to log in:
     *             1 - Admin
     *             2 - Instructor
     *             3 - Client
     * 
     * @return {@code true} if the login credentials are valid, otherwise {@code false}.
     */
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
    
    /**
     * Verifies the user's credentials (username and password) for the given user type.
     * 
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @param from The type of user attempting to log in:
     *             1 - Admin
     *             2 - Instructor
     *             3 - Client
     * 
     * @return {@code true} if the credentials are valid, otherwise {@code false}.
     */
    private static boolean verifyCredentials(String username, String password, int userType) {
        return switch (userType) {
            case 1 -> verifyAdmin(username, password);
            case 2 -> verifyInstructor(username, password);
            case 3 -> verifyClient(username, password);
            default -> false; // invalid user type
        };
    }

    /**
     * Verifies the admin credentials.
     * 
     * @param username The username entered by the admin.
     * @param password The password entered by the admin.
     * 
     * @return {@code true} if the admin credentials are valid, otherwise {@code false}.
     */
    private static boolean verifyAdmin(String username, String password) {
        // Verify if the username exists and the password matches
        return getAdminsMap().containsKey(username) && getAdminsMap().get(username).getPassword().equals(password);
    }

    /**
     * Verifies the instructor credentials.
     * 
     * @param username The username entered by the instructor.
     * @param password The password entered by the instructor.
     * 
     * @return {@code true} if the instructor credentials are valid and the login limit is not exceeded, otherwise {@code false}.
     */
    private static boolean verifyInstructor(String username, String password) {
        if (getInstructorsMap().containsKey(username) && getInstructorsMap().get(username).getPassword().equals(password)) {
            Instructor instructor = getInstructorsMap().get(username);
            if (getSubscriptionPlanMap().get(username).getDuration() >= instructor.getLogins()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifies the client credentials.
     * 
     * @param username The username entered by the client.
     * @param password The password entered by the client.
     * 
     * @return {@code true} if the client credentials are valid, otherwise {@code false}.
     */
    private static boolean verifyClient(String username, String password) {
    	if (getClientsMap().containsKey(username) && getClientsMap().get(username).getPassword().equals(password)) {
            Client client = getClientsMap().get(username);
            if (getSubscriptionPlanMap().get(username).getDuration() >= client.getLogins()) {
                return true;
            }
        }
        return false;
    }
}