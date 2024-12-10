package com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.AdminPageNavigation.ContentManagementPage;
import com.Software.FitnessSystem.AdminPageNavigation.UserManagementPage;
import com.Software.FitnessSystem.AdminPageNavigation.NavigationControllerForAdmin;
import com.Software.FitnessSystem.AdminPageNavigation.ProgramMonitoringPage;
import com.Software.FitnessSystem.AdminPageNavigation.SubscriptionManagementPage;

import java.util.Scanner;

public class AdminPagesController {
    public NavigationControllerForAdmin navigationController = new NavigationControllerForAdmin();
    public UserManagementPage managementPage = new UserManagementPage();
    public ContentManagementPage contentPage;
    public ProgramMonitoringPage monitoringPage;
    public SubscriptionManagementPage subscriptionPage;
    
    @SuppressWarnings("unused")
	private int mainListNumber = 0;
    
    public AdminPagesController() {
    	contentPage = new ContentManagementPage(this);
    	monitoringPage = new ProgramMonitoringPage(this);
    	subscriptionPage = new SubscriptionManagementPage(this);
    }
    
    @SuppressWarnings("resource")
	public boolean navigateToManagementPage() {
        displayMainMenu();
        Scanner input = new Scanner(System.in);
        int choiceNumber = input.nextInt();
        mainListNumber = choiceNumber;
        navigateToPage(choiceNumber);
        return true;
    }
    
    public boolean navigateToPage(int page) {
        switch (page) {
            case 1 -> navigationController.navigateTo(managementPage, this);
            case 2 -> navigationController.navigateTo(contentPage, this);
            case 3 -> navigationController.navigateTo(monitoringPage, this);
            case 4 -> navigationController.navigateTo(subscriptionPage, this);
            case 5 -> {
                System.out.println("\n\nExiting program. Goodbye!");
                System.exit(0);
            }
            default -> System.out.println("Invalid selection. Please try again.");
        }
        return true;
    }
    
    private void displayMainMenu() {
        System.out.println("Select an option from the list below:");
        System.out.println("1. Manage accounts for instructors and clients.");
        System.out.println("2. Approve or reject content submissions.");
        System.out.println("3. Monitor user activity and engagement statistics.");
        System.out.println("4. Manage subscription plans.");
        System.out.println("5. Exit.");
        System.out.print(">> Enter your choice: ");
    }
}