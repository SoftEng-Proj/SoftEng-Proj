package com.Software.FitnessSystem.AdminControllers;

class Report {
    private String programName;
    private double revenue;
    private int attendance;
    private String clientProgress;
    
    public Report(String programName, double revenue, int attendance, String clientProgress) {
        this.programName = programName;
        this.revenue = revenue;
        this.attendance = attendance;
        this.clientProgress = clientProgress;
    }
    
    public void displayReport() {
        System.out.println("Program: " + programName);
        System.out.println("Revenue: $" + revenue);
        System.out.println("Attendance: " + attendance);
        System.out.println("Client Progress: " + clientProgress);
        System.out.println("--------------------------------------------");
    }
}