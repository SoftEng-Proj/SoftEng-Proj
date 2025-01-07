package com.software.fitness_system;
import com.software.fitness_system.admin_controllers.SubscriptionPlan;

/**
 * Represents a general user in the Fitness Management System.
 * Provides methods to get and set user attributes such as name, email,
 * username, password, login statistics, and subscription plan.
 * This interface is intended to be implemented by specific user roles like Admin, Instructor, and Client.
 * 
 * @author Muath Hassoun
 */
public interface User {
    /**
     * Retrieves the user's first name.
     * @return The first name of the user.
     */
    String getFirstName();
    
    /**
     * Sets the user's first name.
     * @param fName The first name to set for the user.
     */
    void setFirstName(String fName);
    
    /**
     * Retrieves the user's last name.
     * @return The last name of the user.
     */
    String getLastName();
    
    /**
     * Sets the user's last name.
     * @param lName The last name to set for the user.
     */
    void setLastName(String lName);
    
    /**
     * Retrieves the user's email address.
     * @return The email address of the user.
     */
    String getEmail();
    
    /**
     * Sets the user's email address.
     * @param email The email address to set for the user.
     */
    void setEmail(String email);
    
    /**
     * Retrieves the username of the user.
     * @return The username of the user.
     */
    String getUsername();
    
    /**
     * Sets the username of the user.
     * @param username The username to set for the user.
     */
    void setUsername(String username);
    
    /**
     * Retrieves the user's password.
     * @return The password of the user.
     */
    String getPassword();
    
    /**
     * Sets the user's password.
     * @param password The password to set for the user.
     */
    void setPassword(String password);
    
    /**
     * Retrieves the number of logins the user has made.
     * @return The total number of logins for the user.
     */
    int getLogins();
    
    /**
     * Sets the number of logins for the user.
     * @param logins The number of logins to set for the user.
     */
    void setLogins(int logins);
    
    /**
     * Retrieves the timestamp of the user's last login.
     * @return The timestamp of the last login in a string format.
     */
    String getLastLogin();
    
    /**
     * Sets the timestamp of the user's last login.
     * @param lastLogin The timestamp of the last login to set for the user.
     */
    void setLastLogin(String lastLogin);
    
    /**
     * Retrieves the user's subscription plan.
     * @return The subscription plan associated with the user.
     */
    SubscriptionPlan getSubscriptionPlan();
    
    /**
     * Sets the user's subscription plan.
     * @param subscriptionPlan The subscription plan to associate with the user.
     */
    void setSubscriptionPlan(SubscriptionPlan subscriptionPlan);
}