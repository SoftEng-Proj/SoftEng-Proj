package com.software.fitness_system;
import com.software.fitness_system.AdminControllers.SubscriptionPlan;

public class Instructor implements User{
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String password;
    
    private int logins = 0;
    private String lastLogin = "";
    private SubscriptionPlan subscriptionPlan;
    
    /**
     * Constructor to initialize a new instructor with first name, last name, email, username, and password.
     * @author Muath Hassoun
     * @param fName the first name of the instructor
     * @param lName the last name of the instructor
     * @param email the email address of the instructor
     * @param username the username of the instructor
     * @param password the password of the instructor
     */
    public Instructor(String fName, String lName, String email, String username, String password) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    /**
     * Default constructor for the Instructor object.
     * @author Muath Hassoun
     */
    public Instructor() {
    }
    
    /**
     * Returns the first name of the instructor.
     * @author Muath Hassoun
     * @return the first name of the instructor
     */
    @Override
    public String getFirstName() {
        return fName;
    }
    
    /**
     * Sets the first name of the instructor.
     * @author Muath Hassoun
     * @param fName the first name to set
     */
    @Override
    public void setFirstName(String fName) {
        this.fName = fName;
    }
    
    /**
     * Returns the last name of the instructor.
     * @author Muath Hassoun
     * @return the last name of the instructor
     */
    @Override
    public String getLastName() {
        return lName;
    }
    
    /**
     * Sets the last name of the instructor.
     * @author Muath Hassoun
     * @param lName the last name to set
     */
    @Override
    public void setLastName(String lName) {
        this.lName = lName;
    }
    
    /**
     * Returns the email address of the instructor.
     * @author Muath Hassoun
     * @return the email address of the instructor
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the email address of the instructor.
     * @author Muath Hassoun
     * @param email the email address to set
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Returns the username of the instructor.
     * @author Muath Hassoun
     * @return the username of the instructor
     */
    @Override
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username of the instructor.
     * @author Muath Hassoun
     * @param username the username to set
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Returns the password of the instructor.
     * @author Muath Hassoun
     * @return the password of the instructor
     */
    @Override
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the password of the instructor.
     * @author Muath Hassoun
     * @param password the password to set
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Returns the number of logins of the instructor.
     * @author Muath Hassoun
     * @return the number of logins of the instructor
     */
    @Override
    public int getLogins() {
        return logins;
    }
    
    /**
     * Sets the number of logins of the instructor.
     * @author Muath Hassoun
     * @param logins the number of logins to set
     */
    @Override
    public void setLogins(int logins) {
        this.logins = logins;
    }
    
    /**
     * Returns the last login timestamp of the instructor.
     * @author Muath Hassoun
     * @return the last login timestamp of the instructor
     */
    @Override
    public String getLastLogin() {
        return lastLogin;
    }
    
    /**
     * Sets the last login timestamp of the instructor.
     * @author Muath Hassoun
     * @param lastLogin the last login timestamp to set
     */
    @Override
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    /**
     * Returns the subscription plan of the instructor.
     * @author Muath Hassoun
     * @return the subscription plan of the instructor
     */
    @Override
    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }
    
    /**
     * Sets the subscription plan of the instructor.
     * @author Muath Hassoun
     * @param subscriptionPlan the subscription plan to set
     */
    @Override
    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
    
    /**
     * Returns a string representation of the Instructor object.
     * @author Muath Hassoun
     * @return a string representation of the instructor including first name, last name, email, username, and password
     */
    @Override
    public String toString() {
        return "Instructor {" +
               "First Name='" + fName + '\'' +
               ", Last Name='" + lName + '\'' +
               ", Email='" + email + '\'' +
               ", Username='" + username + '\'' +
               ", Password='" + password + '\'' +
               '}';
    }
}