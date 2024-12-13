package com.Software.FitnessSystem.AdminPageNavigation;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.AdminControllers.ContentManagementControls;
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
            	ContentManagementControls.setApprovedTipsMap(App.getInstructorTipsMap());
            	ContentManagementControls.dealWithContentTypes(App.getPendingInstructorTipsMap(), false);
                App.saveInstructorTipsChanges();
                break;
            case 2:
            	ContentManagementControls.setApprovedTipsMap(App.getHealthTipsMap());
            	ContentManagementControls.dealWithContentTypes(App.getPendingHealthTipsMap(), false);
                App.saveHealthTipsChanges();
                break;
            case 3:
            	ContentManagementControls.setHandledFeedbackMap(App.getHandledFeedbackMap());
            	ContentManagementControls.dealWithContentTypes(App.getUserFeedbackMap(), true);
                App.saveUserFeedbackChanges();
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