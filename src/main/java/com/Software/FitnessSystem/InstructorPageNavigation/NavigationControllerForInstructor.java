package com.Software.FitnessSystem.InstructorPageNavigation;

import java.util.Scanner;

import com.Software.FitnessSystem.InfrastructureForPages.Page;
import com.Software.FitnessSystem.LoginPage.InstructorPageControllers;

public class NavigationControllerForInstructor {
    private Page currentPage;
    
    @SuppressWarnings("resource")
	public void navigateTo(Page page, InstructorPageControllers controller) {
        this.currentPage = page;
        while (true) {
            currentPage.display();
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            
            currentPage.executeOption(choice);
        }
    }
}