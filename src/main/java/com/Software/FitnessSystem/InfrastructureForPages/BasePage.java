package com.Software.FitnessSystem.InfrastructureForPages;
import java.util.Scanner;

/**
 * Represents a base class for pages in the fitness system.
 * This class implements the common functionality shared by all pages in the system.
 * It provides basic methods for navigation and user input handling.
 * <p>
 * This class implements the {@link Page} interface and can be extended by specific page classes 
 * to provide detailed page functionality.
 * 
 * @author Muath Hassoun
 */
public abstract class BasePage implements Page {
	/**
     * A {@link Scanner} object used for reading user input from the console.
     * This object is shared by all subclasses to handle input operations.
     */
    protected Scanner scanner = new Scanner(System.in);
    
    /**
     * Prints a message to the console indicating that the user is returning to the previous menu.
     * This method is intended to be used for navigation between pages in the application.
     */
    protected void goBack() {
        System.out.println("Returning to the previous menu...");
    }
}