package com.Software.FitnessSystem.ClientPageNavigation;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;
import com.Software.FitnessSystem.ClientControllers.ProgressTrackingControls;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.ClientPageControllers;
/**
 *  the Progress Tracking page for clients
 * Allows clients to add and view milestones related to their fitness progress
 * 
 * @author Alaa Alawneh
 */
public class ProgressTrackingPage extends BasePage {
	private ClientPageControllers clientController;
	@SuppressWarnings("unused")
	private ProgressTrackingControls progressTrackingControls;
	private String type;
	private String value;
	private String date;
	private Client currentClient;
	private static  boolean isAddMilestonePage = false;
	private static boolean isShowProgressPage = false;
	/**
	 * Constructs a ProgressTrackingPage for the given client with the specified controller
	 * 
	 * @param clientController the controller managing client page navigation
	 * @param client the client whose progress is being tracked
	 */
	public ProgressTrackingPage(ClientPageControllers clientController, Client client) {
		this.clientController = clientController;
		this.progressTrackingControls = new ProgressTrackingControls();
        this.currentClient = client;
	}
	
    @Override
    public void display() {
        System.out.println("\nPrograss Tracking Menu:");
        System.out.println("1. Add a New Milestone.");
        System.out.println("2. Show all Milestones.");
        System.out.println("3. Go Back.");
    }
    
    @Override
    public boolean executeOption(int choice) {
    	boolean returnValue = true;
        switch (choice) {
            case 1:
            	isAddMilestonePage = true;
            	getMilestoneInfo();
                ProgressTrackingControls.addMilestone(type, value, date, currentClient);
                App.saveMilestoneChanges();
                isAddMilestonePage = false;
                break;
            case 2:
            	isShowProgressPage = true;
            	ProgressTrackingControls.showProgress();
            	isShowProgressPage = false;
                break;
            case 3:
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
     * asksthe user for milestone details and stores them
     */
    public void getMilestoneInfo() {
    	System.out.print("Enter milestone type (e.g., Weight, BMI, Attendance): ");
        type = scanner.nextLine();
        System.out.print("Enter milestone value: ");
        value = scanner.nextLine();
        System.out.print("Enter milestone date (Year-Month-Day): ");
        date = scanner.nextLine();
    }
    /**
     * Returns whether the Add Milestone page is active
     * 
     * @return true if the Add Milestone page is active else false
     */
    public static boolean isAddMilestonePage() {
        return isAddMilestonePage;
    }
    /**
     * Returns whether the Show Progress page is active
     * 
     * @return true if the Show Progress page is active else false
     */
    public static boolean isShowProgressPage() {
        return isShowProgressPage;
    }
}