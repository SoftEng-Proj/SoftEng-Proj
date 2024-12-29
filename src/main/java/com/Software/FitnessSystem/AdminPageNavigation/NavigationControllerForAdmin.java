package com.Software.FitnessSystem.AdminPageNavigation;
import com.Software.FitnessSystem.InfrastructureForPages.Page;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;
import java.util.Scanner;

/**
 * Handles navigation for the admin pages in the fitness system.
 * This class is responsible for controlling the flow between different admin pages
 * by displaying the current page and executing the corresponding action based on the user's choice.
 * It uses the Page class to manage individual page displays and actions.
 * 
 * @author Muath Hassoun
 */
public class NavigationControllerForAdmin {
    /**
     * Navigates to a specific page and allows the admin to interact with the page.
     * Continuously prompts the user to enter a choice and executes the selected option.
     * This method runs in an infinite loop, allowing the admin to interact with the page
     * until they exit the program.
     * 
     * @param page The page to navigate to.
     * @param controller The controller responsible for managing admin page actions.
     */
	public void navigateTo(Page page, AdminPagesController controller) {
        while (true) {
            page.display();
            System.out.print(">> Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            page.executeOption(choice);
        }
    }
}