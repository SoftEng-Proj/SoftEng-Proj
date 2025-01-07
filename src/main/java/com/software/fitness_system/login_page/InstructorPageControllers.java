package com.software.fitness_system.login_page;
import java.util.Scanner;

import com.software.fitness_system.instructor_page_navigation.InteractForInstructorPage;
import com.software.fitness_system.instructor_page_navigation.NavigationControllerForInstructor;
import com.software.fitness_system.instructor_page_navigation.NotificationsPage;
import com.software.fitness_system.instructor_page_navigation.ProgramManagementPage;
import com.software.fitness_system.instructor_page_navigation.ProgressTrackingInstructorPage;

/**
 * Controls the navigation between pages for instructors in the fitness system.
 * This class provides access to key pages such as Program Management, Client Interaction, 
 * Progress Tracking, and Notifications for instructors.
 * 
 * The class facilitates navigation through a menu system, allowing instructors to 
 * interact with the system efficiently.
 * 
 * @author Ammar Shafii
 */
public class InstructorPageControllers {
	private NavigationControllerForInstructor navigationController = new NavigationControllerForInstructor();
	private InteractForInstructorPage interactForInstructorPage;
	private NotificationsPage notificationsPage;
	private ProgramManagementPage programManagementPage;
	private ProgressTrackingInstructorPage progressTrackingInstructorPage;
	
	/**
     * Constructs an instance of {@code InstructorPageControllers} and initializes 
     * all the available pages for instructor navigation.
     */
	public InstructorPageControllers() {
    	interactForInstructorPage = new InteractForInstructorPage(this);
    	notificationsPage = new NotificationsPage(this);
    	programManagementPage = new ProgramManagementPage(this);
    	progressTrackingInstructorPage = new ProgressTrackingInstructorPage(this);
    }
	
	/**
     * Displays the main menu for the instructor and prompts the user to select an option.
     * The user's choice determines which page they will be navigated to.
     * 
     * @return {@code true} if navigation is successful.
     */
	@SuppressWarnings("resource")
	public boolean navigateToManagementPage() {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
        navigateToPage(choiceNumber);
        return true;
    }
	
	/**
     * Navigates to a specific page for the instructor based on the user's choice.
     * Each option corresponds to one of the pages available to the instructor.
     * 
     * @param page The number representing the user's choice.
     *             1 - Program Management
     *             2 - Client Interaction
     *             3 - Progress Tracking
     *             4 - Notifications and Updates
     *             5 - Logout (returns to the Login Page)
     *             6 - Exit (closes the program)
     * 
     * @return {@code true} if navigation is successful.
     */
	public boolean navigateToPage(int page) {
        switch (page) {
        case 1 -> navigationController.navigateTo(programManagementPage, this);
        case 2 -> navigationController.navigateTo(interactForInstructorPage, this);
        case 3 -> navigationController.navigateTo(progressTrackingInstructorPage, this);
        case 4 -> navigationController.navigateTo(notificationsPage, this);
        case 5 -> {
        	System.out.print("\n");
        	new LoginPageController();
        }
        case 6 -> {
            System.err.println("\n\nExiting program. Goodbye!");
            System.exit(0);
        }
        default -> System.out.println("Invalid selection. Please try again.");
        }
        
        return true;
    }
	
	/**
     * Displays the main menu options for the instructor.
     * The menu provides six options, allowing the instructor to choose a page to navigate to.
     */
	private void displayMainMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Program Management");
        System.out.println("2. Client Interaction.");
        System.out.println("3. Progress Tracking.");
        System.out.println("4. Notifications and Updates.");
        System.out.println("5. Log out and return to the login page.");
        System.out.println("6. Exit.");
        System.out.print("\nEnter your choice: ");
    }

}