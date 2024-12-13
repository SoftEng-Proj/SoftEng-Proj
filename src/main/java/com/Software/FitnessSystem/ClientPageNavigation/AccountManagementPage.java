package com.Software.FitnessSystem.ClientPageNavigation;
import com.Software.FitnessSystem.ClientControllers.AccountManagementControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;

public class AccountManagementPage extends BasePage {
	private ClientPageControllers clientController;
    private AccountManagementControls accountManagementControls;

    public AccountManagementPage(ClientPageControllers clientController) {
        this.clientController = clientController;
        this.accountManagementControls = new AccountManagementControls();
    }

    @Override
    public void display() {
        System.out.println("\nAccount Management Menu:");
        System.out.println("1. Create Profile.");
        System.out.println("2. Update Personal Details.");
        System.out.println("3. Set Dietary Preferences.");
        System.out.println("4. View Profile.");
        System.out.println("5. Go Back.");
    }

    @Override
    public void executeOption(int choice) {
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        Client client = App.getClientsMap().get(username);

        switch (choice) {
            case 1:
                System.out.print("Enter Age: ");
                String age = scanner.nextLine();
                System.out.print("Enter Fitness Goals: ");
                String fitnessGoals = scanner.nextLine();
                accountManagementControls.createProfile(client, age, fitnessGoals);
                break;

            case 2:
                System.out.print("Enter New Age: ");
                String newAge = scanner.nextLine();
                System.out.print("Enter New Fitness Goals: ");
                String newFitnessGoals = scanner.nextLine();
                accountManagementControls.updatePersonalDetails(client, newAge, newFitnessGoals);
                break;

            case 3:
                System.out.print("Enter Dietary Preference: ");
                String dietaryPreference = scanner.nextLine();
                System.out.print("Enter Dietary Restrictions (comma-separated): ");
                String restrictions = scanner.nextLine();
                accountManagementControls.setDietaryPreferences(client, dietaryPreference, restrictions);
                break;

            case 4:
                accountManagementControls.viewProfile(client);
                break;

            case 5:
                System.out.println("\nReturning to the main menu...");
                clientController.navigateToManagementPage();
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
