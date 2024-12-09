package com.Software.FitnessSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.Software.FitnessSystem.AdminPageNavigation.ApprovalsPage;
import com.Software.FitnessSystem.AdminPageNavigation.ManagementPage;
import com.Software.FitnessSystem.AdminPageNavigation.NavigationControllerForAdmin;
import com.Software.FitnessSystem.AdminPageNavigation.StatisticsPage;

public class AdminControllers {
    private NavigationControllerForAdmin navigationController = new NavigationControllerForAdmin();
    private ManagementPage managementPage = new ManagementPage();
    private ApprovalsPage approvalsPage;
    private StatisticsPage statisticsPage;
    
    private Instructor newInstructor;
    private Client newClient;
    private int mainListNumber = 0;
    
    public AdminControllers() {
    	approvalsPage = new ApprovalsPage(this);
    	statisticsPage = new StatisticsPage(this);
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
            case 2 -> navigationController.navigateTo(approvalsPage, this);
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
	
	public void fillUserDetails(String fName, String lName, String email, String userName, String password, String role) {
		Map<String, String> newAccount = new HashMap<>();
		
		switch(role) {
		case "Instructor":
			newInstructor = new Instructor(fName, lName, email, userName, password);
			App.InstructorsMap.put(userName, newInstructor);
			break;
		case "Client":
			newClient = new Client(fName, lName, email, userName, password);
			App.ClientsMap.put(userName, newClient);
			break;
		}
		
		newAccount.put(userName, password);
		App.AccountsMap.put(role, newAccount);
	}
	
	public void selectUser(String string) {
		
	}
	
	public void editUserDetails(String string, String string2, String string3) {
		
	}
	
	public boolean verifyUserUpdate(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deactivateUser(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyUserDeactivation(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean checkPendingApplications() {
		// TODO Auto-generated method stub
		return false;
	}

	public void approveApplication(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyNotification(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyAccountActivation(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void viewActivityReports() {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyActivityReports() {
		// TODO Auto-generated method stub
		return false;
	}

	public void submitForm() {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyUserCreation(String string) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void saveChanges() {
		
	}
}