package com.software.fitness_system.client_page_navigation;
import com.software.fitness_system.App;
import com.software.fitness_system.basics.Client;
import com.software.fitness_system.client_controllers.AccountManagementControls;
import com.software.fitness_system.client_controllers.Profile;
import com.software.fitness_system.infrastructure_for_pages.BasePage;
import com.software.fitness_system.login_page.ClientPageControllers;
/**
 * The AccountManagementPage class represents a user interface for managing
 * client accounts including creating profiles and updating details and setting the
 * dietary preferences
 * This class also extend BasePage
 * 
 * @author Alaa Alawneh
 */
public class AccountManagementPage extends BasePage {
	private ClientPageControllers clientController;
    private static boolean onDietaryRestrictionsPage = false;
    private static boolean onCreateProfilePage = false;
    private static boolean onUpdatePersonalDetailsPage = false;
    /**
     * Constructs an AccountManagementPage with the specified client controller
     *
     * @param clientController the controller for managing client navigation
     */
    public AccountManagementPage(ClientPageControllers clientController) {
        this.clientController = clientController;
    }
    /**
     * Display the account management menu option to chosee from
     */
    @Override
    public void display() {
        System.out.println("\nAccount Management Menu:");
        System.out.println("1. Create Profile.");
        System.out.println("2. Update Personal Details.");
        System.out.println("3. Set Dietary Preferences.");
        System.out.println("4. View Profile.");
        System.out.println("5. Go Back.");
    }
    /**
     * Executes the menu option you pick
     *
     * @param choice   the option selected by the client
     */
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        System.out.print("Enter your Username: ");
        String username = scanner.nextLine();
        Client client = App.getClientsMap().get(username);

        switch (choice) {
            case 1:
            	onCreateProfilePage = true;
                System.out.print("Enter Age: ");
                String age = scanner.nextLine();
                System.out.print("Enter Fitness Goals: ");
                String fitnessGoals = scanner.nextLine();
                AccountManagementControls.createProfile(username, client, age, fitnessGoals);
                App.saveClientProfileChanges();
                break;
            case 2:
            	onUpdatePersonalDetailsPage = true;
                System.out.print("Enter New Age: ");
                String newAge = scanner.nextLine();
                System.out.print("Enter New Fitness Goals: ");
                String newFitnessGoals = scanner.nextLine();
                String returnVal = AccountManagementControls.updatePersonalDetails(client, newAge, newFitnessGoals);
                if(returnVal.equals(newFitnessGoals)) {
                    System.out.println("No profile found for " + client.getUsername());
                }
                
                App.saveClientProfileChanges();
                break;
            case 3:
            	onDietaryRestrictionsPage = true;
                System.out.print("Enter Dietary Preference: ");
                String dietaryPreference = scanner.nextLine();
                System.out.print("Enter Dietary Restrictions (comma-separated): ");
                String restrictions = scanner.nextLine();
                String returned = AccountManagementControls.setDietaryPreferences(client, dietaryPreference, restrictions);
                if(returned.equals(restrictions)) {
                    System.out.println("No profile found for " + client.getUsername());
                }
                
                App.saveClientProfileChanges();
                break;
            case 4:
                viewProfile(client);
                break;
            case 5:
                System.out.println("\nReturning to the main menu...");
                clientController.navigateToManagementPage();
                returnValue = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return returnValue;
    }
    
    /**
     * Check if the user is on the dietary restrictions page
     *
     * @return true if on the dietary restrictions page else false
     */
    public static boolean isOnDietaryRestrictionsPage() {
        return onDietaryRestrictionsPage;
    }

    /**
     * Checks if the user is on the create profile page
     *
     * @return true if on the create profile page esle false
     */
    public static boolean isOnCreateProfilePage() {
        return onCreateProfilePage;
    }

    /**
     * Check if the user is on the update personal details page
     *
     * @return true if on the update personal details page else false
     */
    public static boolean isOnUpdatePersonalDetailsPage() {
        return onUpdatePersonalDetailsPage;
    }
    
	/**
     * Displays the profile details of a client
     *
     * @param client  The client object
     */
	public void viewProfile(Client client) {
        Profile profile = AccountManagementControls.profilesMap.get(client.getUsername());
        if (profile == null) {
            System.out.println("No profile found for " + client.getUsername());
            return;
        }
        
        System.out.println("\nProfile Details for " + client.getUsername() + ":");
        System.out.println("Age: " + profile.getAge());
        System.out.println("Fitness Goals: " + profile.getFitnessGoals());
        System.out.println("Dietary Preferences: " + profile.getDietaryPreference());
        System.out.println("Dietary Restrictions: " + profile.getDietaryRestrictions());
    }
}