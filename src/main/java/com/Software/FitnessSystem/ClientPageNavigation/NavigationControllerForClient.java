package com.Software.FitnessSystem.ClientPageNavigation;

import java.util.Scanner;

import com.Software.FitnessSystem.InfrastructureForPages.Page;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;

public class NavigationControllerForClient {
    private Page currentPage;
    
    @SuppressWarnings("resource")
	public void navigateTo(Page page, ClientPageControllers controller) {
        this.currentPage = page;
        while (true) {
            currentPage.display();
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            
            if (choice == 7) {
                System.out.println("\nReturning to the main menu...");
               // controller.navigateToManagementPage();
                break;
            }
            currentPage.executeOption(choice);
        }
    }
}