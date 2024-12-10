package com.Software.FitnessSystem.AdminPageNavigation;
import java.util.Scanner;

import com.Software.FitnessSystem.InfrastructureForPages.Page;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

public class NavigationControllerForAdmin {
    private Page currentPage;
    
    @SuppressWarnings("resource")
	public void navigateTo(Page page, AdminPagesController controller) {
        this.currentPage = page;
        while (true) {
            currentPage.display();
            System.out.print(">> Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            
            if (choice == 9) {
                System.out.println("\nReturning to the main menu...");
                controller.navigateToManagementPage();
                break;
            }
            currentPage.executeOption(choice);
        }
    }
}