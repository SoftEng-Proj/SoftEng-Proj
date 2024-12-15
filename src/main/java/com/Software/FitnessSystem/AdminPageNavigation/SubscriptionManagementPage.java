package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.SubscriptionManagementControls.*;
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
        System.out.println("1. Create, modify, or remove a subscription plan.");
        System.out.println("2. Manage subscription plans for clients and instructors.");
        System.out.println("3. View subscription details.");
        System.out.println("4. Go Back.");
    }
    
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
            	dealWithSubscriptionPlan();
            	saveCustomSubscriptionPlanChanges();
                break;
            case 2:
            	dealWithUsersSubscriptionPlan();
            	saveAccountChanges();
                break;
            case 3:
            	printSubscriptionPlan();
                break;
            case 4:
                System.out.println("\nReturning to the main menu...");
                adminController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}