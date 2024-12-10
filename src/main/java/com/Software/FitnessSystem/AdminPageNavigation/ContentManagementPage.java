package com.Software.FitnessSystem.AdminPageNavigation;

import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

public class ContentManagementPage extends BasePage {
    private AdminPagesController adminController;

    public ContentManagementPage(AdminPagesController adminController) {
        this.adminController = adminController;
    }

    @Override
    public void display() {
        System.out.println("\nContent Management Menu:");
        System.out.println("1. Approve new instructor application.");
        System.out.println("2. Reject new instructor application.");
        System.out.println("3. Review wellness articles, tips, or recipes.");
        System.out.println("4. Handle user feedback and complaints.");
        System.out.println("5. Go Back.");
    }

    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Approving new instructor application...");
                break;
            case 2:
                System.out.println("Rejecting new instructor application...");
                break;
            case 3:
                System.out.println("Reviewing wellness articles, tips, or recipes...");
                break;
            case 4:
                System.out.println("Handling user feedback and complaints...");
                break;
            case 5:
                System.out.println("\nReturning to the main menu...");
                adminController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}