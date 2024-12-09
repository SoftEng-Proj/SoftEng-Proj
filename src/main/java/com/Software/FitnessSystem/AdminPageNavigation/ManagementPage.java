package com.Software.FitnessSystem.AdminPageNavigation;

import com.Software.FitnessSystem.InfrastructureForPages.BasePage;

public class ManagementPage extends BasePage {
    @Override
    public void display() {
        System.out.println("\nManagement Menu:");
        System.out.println("1. Add new instructor account.");
        System.out.println("2. Add new client account.");
        System.out.println("3. Update instructor account.");
        System.out.println("4. Update client account.");
        System.out.println("5. Deactivate instructor account.");
        System.out.println("6. Deactivate client account.");
        System.out.println("7. Go Back.");
    }

    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Adding new instructor account...");
                break;
            case 2:
                System.out.println("Adding new client account...");
                break;
            case 3:
                System.out.println("Updating instructor account...");
                break;
            case 4:
                System.out.println("Updating client account...");
                break;
            case 5:
                System.out.println("Deactivating instructor account...");
                break;
            case 6:
                System.out.println("Deactivating client account...");
                break;
            case 7:
                goBack();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}