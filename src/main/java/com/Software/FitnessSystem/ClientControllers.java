package com.Software.FitnessSystem;
import java.util.Scanner;

import com.Software.FitnessSystem.AdminPageNavigation.ManagementPage;
import com.Software.FitnessSystem.AdminPageNavigation.StatisticsPage;
import com.Software.FitnessSystem.ClientPageNavigation.NavigationControllerForClient;
import com.Software.FitnessSystem.ClientPageNavigation.ProgressTrackingPage;

public class ClientControllers {
    private NavigationControllerForClient navigationController = new NavigationControllerForClient();
    private ManagementPage managementPage = new ManagementPage();
    private ProgressTrackingPage progressTrackingPage;
    private StatisticsPage statisticsPage;
    private int mainListNumber = 0;
    
    public ClientControllers() {
    	progressTrackingPage = new ProgressTrackingPage(this);
    	statisticsPage = new StatisticsPage(new AdminControllers()); //this
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
            case 2 -> navigationController.navigateTo(progressTrackingPage, this);
            case 3 -> navigationController.navigateTo(statisticsPage, this);
            case 4 -> {
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
        System.out.println("2. Approve new instructor registrations.");
        System.out.println("3. Monitor user activity and engagement statistics.");
        System.out.println("4. Exit.");
        System.out.print("\nEnter your choice: ");
    }
    
    
}