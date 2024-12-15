package com.Software.FitnessSystem.AdminPageNavigation;
import com.Software.FitnessSystem.InfrastructureForPages.Page;
import com.Software.FitnessSystem.LoginPage.AdminPagesController;
import java.util.Scanner;

public class NavigationControllerForAdmin {
    private Page currentPage;
    
    @SuppressWarnings("resource")
	public void navigateTo(Page page, AdminPagesController controller) {
        this.currentPage = page;
        while (true) {
            currentPage.display();
            System.out.print(">> Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            currentPage.executeOption(choice);
        }
    }
}