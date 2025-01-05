package com.Software.FitnessSystem.ClientPageNavigation;

import java.util.Scanner;

import com.Software.FitnessSystem.InfrastructureForPages.Page;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;
/**
 * The NavigationControllerForClient class is for managing the navigation
 * of the client in the different pages of the app
 * It also handles user input and allows moving between pages
 * 
 * @author Alaa Alawneh
 */
public class NavigationControllerForClient {
    private Page currentPage;
    /**
     * Navigate to the wanted page and handle input to perform actions based on the available options
     * This method loops continuously until the user returns to the main menu
     *
     * @param page the page to navigate to
     * @param controller the controller for managing client page navigation
     */
    @SuppressWarnings("resource")
	public void navigateTo(Page page, ClientPageControllers controller) {
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