package com.Software.FitnessSystem.AdminPageNavigation;
import java.util.Scanner;

import com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.InfrastructureForPages.Page;

public class NavigationControllerForAdmin {
    private Page currentPage;
    
    @SuppressWarnings("resource")
	public void navigateTo(Page page, AdminControllers controller) {
        this.currentPage = page;
        while (true) {
            currentPage.display();
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            
            if (choice == 7) {
                System.out.println("\nReturning to the main menu...");
                controller.navigateToManagementPage();
                break;
            }
            currentPage.executeOption(choice);
        }
    }
}