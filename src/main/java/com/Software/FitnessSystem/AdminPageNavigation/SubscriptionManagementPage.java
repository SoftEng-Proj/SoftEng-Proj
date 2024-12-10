package com.Software.FitnessSystem.AdminPageNavigation;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

public class SubscriptionManagementPage extends BasePage {
    private AdminPagesController adminController;
    
    public SubscriptionManagementPage(AdminPagesController adminController) {
        this.adminController = adminController;
    }
    
    @Override
    public void display() {
        System.out.println("\nSubscription Management Menu:");
        System.out.println("1. Manage subscription plans (edit, create, or modify).");
        System.out.println("2. View subscription details.");
        System.out.println("3. Go Back.");
    }
    
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Managing subscription plans...");
                break;
            case 2:
                System.out.println("Viewing subscription details...");
                break;
            case 3:
                System.out.println("\nReturning to the main menu...");
                adminController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}