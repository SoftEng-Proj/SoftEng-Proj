package com.Software.FitnessSystem.AdminPageNavigation;
import static com.Software.FitnessSystem.App.*;
import static com.Software.FitnessSystem.AdminControllers.ContentManagementControls.*;

import com.Software.FitnessSystem.InfrastructureForPages.BasePage;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;

public class ContentManagementPage extends BasePage {
    private AdminPagesController adminController;
    
    public ContentManagementPage(AdminPagesController adminController) {
        this.adminController = adminController;
    }
    
    @Override
    public void display() {
        System.out.println("\nContent Management Menu:");
        System.out.println("1. Approve or reject wellness articles, tips, or recipes shared by instructors.");
        System.out.println("2. Approve or reject articles or tips shared on health and wellness.");
        System.out.println("3. Handle user feedback and complaints.");
        System.out.println("4. Go Back.");
    }


    @Override
    public void executeOption(int choice) {
        switch (choice) {
            case 1:
            	setApprovedTipsMap(getInstructorTipsMap());
            	dealWithContentTypes(getPendingInstructorTipsMap(), false);
                saveInstructorTipsChanges();
                break;
            case 2:
            	setApprovedTipsMap(getHealthTipsMap());
            	dealWithContentTypes(getPendingHealthTipsMap(), false);
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
}