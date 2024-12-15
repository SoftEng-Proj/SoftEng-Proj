package com.Software.FitnessSystem.InfrastructureForPages;

/**
 * Represents a blueprint for pages in the fitness system.
 * This interface defines the essential methods that all pages must implement 
 * to support displaying content and handling user interactions.
 * 
 * Any class that implements this interface must provide concrete implementations 
 * for the display logic and the execution of user-selected options.
 * 
 * This interface is a core part of the system's page navigation structure.
 * 
 * @author Muath Hassoun
 */
public interface Page {
	/**
     * Displays the content of the page.
     * This method should provide the necessary logic to present 
     * information to the user when the page is loaded.
     */
    void display();
    
    /**
     * Executes a specific action based on the user's choice.
     * This method is responsible for handling user input and performing 
     * the corresponding action associated with the selected option.
     * 
     * @param choice The user's input, typically representing a menu option or command.
     */
    void executeOption(int choice);
}