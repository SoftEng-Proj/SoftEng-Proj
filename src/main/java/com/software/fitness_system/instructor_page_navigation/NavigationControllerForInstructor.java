package com.software.fitness_system.instructor_page_navigation;

import java.util.Scanner;

import com.software.fitness_system.infrastructure_for_pages.Page;
import com.software.fitness_system.login_page.InstructorPageControllers;


/**
 * Handles navigation for the instructor pages in the fitness system.
 * This class is responsible for controlling the flow between different instructor pages
 * by displaying the current page and executing the corresponding action based on the user's choice.
 * It uses the Page class to manage individual page displays and actions.
 * 
 * @author Ammar Shafii
 */
public class NavigationControllerForInstructor {
    private Page currentPage;
    
    
    
    /**
     * Navigates to a specific page and allows the instructor to interact with the page.
     * Continuously prompts the user to enter a choice and executes the selected option.
     * This method runs in an infinite loop, allowing the instructor to interact with the page
     * until they exit the program.
     * 
     * @param page The page to navigate to.
     * @param controller The controller responsible for managing admin page actions.
     */
    @SuppressWarnings("resource")
	public void navigateTo(Page page, InstructorPageControllers controller) {
        this.currentPage = page;
        boolean doLoop = true;
        
        while (doLoop) {
            currentPage.display();
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
            	choice = new Scanner(System.in).nextInt();
            } catch(ArithmeticException e) {
            	choice = 1;
            }
            
            doLoop = currentPage.executeOption(choice);
        }
    }
}