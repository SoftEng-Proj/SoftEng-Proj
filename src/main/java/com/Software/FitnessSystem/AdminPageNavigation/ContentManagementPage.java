package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;

import java.util.Map;

import static com.Software.FitnessSystem.AdminControllers.ContentManagementControls.*;

import com.Software.FitnessSystem.Content;
import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

/**
 * Represents the Content Management page for the admin in the fitness system.
 * This page allows the admin to manage and approve content shared by instructors or users,
 * such as wellness articles, tips, recipes, and user feedback.
 * The page also includes options for handling user complaints and navigating back to the main menu.
 * 
 * @author Muath Hassoun
 */
public class ContentManagementPage extends BasePage {
    private AdminPagesController adminController;
    
    /**
     * Constructor to initialize the ContentManagementPage with the provided AdminPagesController.
     * 
     * @param adminController The controller responsible for managing admin page navigation and actions.
     */
    public ContentManagementPage(AdminPagesController adminController) {
        this.adminController = adminController;
    }
    
    /**
     * Displays the Content Management menu with available options for the admin.
     * The menu includes options for approving or rejecting wellness articles, tips, or recipes,
     * handling user feedback and complaints, and returning to the main menu.
     */
    @Override
    public void display() {
        System.out.println("\nContent Management Menu:");
        System.out.println("1. Approve or reject wellness articles, tips, or recipes shared by instructors.");
        System.out.println("2. Approve or reject articles or tips shared on health and wellness.");
        System.out.println("3. Handle user feedback and complaints.");
        System.out.println("4. Go Back.");
    }
    
    /**
     * Executes the selected option based on the user's choice.
     * The method handles approval/rejection of content, user feedback, and navigation back to the management page.
     * 
     * @param choice The option selected by the admin.
     */
    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
            	handleContentApproval(getPendingInstructorTipsMap(), getInstructorTipsMap(), false);
                saveInstructorTipsChanges();
                break;
            case 2:
            	handleContentApproval(getPendingHealthTipsMap(), getHealthTipsMap(), false);
                saveHealthTipsChanges();
                break;
            case 3:
            	setHandledFeedbackMap(getHandledFeedbackMap());
            	dealWithContentTypes(getUserFeedbackMap(), true);
                saveUserFeedbackChanges();
                break;
            case 4:
                System.out.println("\nReturning to the main menu...");
                adminController.navigateToManagementPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    
    /**
     * Handles the approval or rejection of content by updating the appropriate maps.
     * This method updates the approved content map based on the pending content map and the approval status.
     *
     * @param pendingContentMap the map of pending content items.
     * @param approvedContentMap the map to store approved content items.
     * @param isFeedback indicates if the content type is user feedback (not used in this case).
     */
    private void handleContentApproval(Map<String, Content> pendingContentMap, Map<String, Content> approvedContentMap, boolean isFeedback) {
        setApprovedTipsMap(approvedContentMap);
        dealWithContentTypes(pendingContentMap, isFeedback);
    }
}