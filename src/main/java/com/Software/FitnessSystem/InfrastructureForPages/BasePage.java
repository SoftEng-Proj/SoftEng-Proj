package com.Software.FitnessSystem.InfrastructureForPages;
import java.util.Scanner;

public abstract class BasePage implements Page {
    protected Scanner scanner = new Scanner(System.in);
    
    protected void goBack() {
        System.out.println("Returning to the previous menu...");
    }
}