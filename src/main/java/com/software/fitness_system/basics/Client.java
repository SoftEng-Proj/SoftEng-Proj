/**
 * Client class implements the User interface and represents a client in the system.
 * It contains personal details, login information, subscription plan, and enrolled program.
 * @author Muath Hassoun
 */
package com.software.fitness_system.basics;
import com.software.fitness_system.admin_controllers.SubscriptionPlan;
import com.software.fitness_system.instructor_controllers.Program;

public class Client implements User {
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String password;
    private Program enrolledProgram;
    
    private int logins = 0;
    private String lastLogin = "";
    private SubscriptionPlan subscriptionPlan;
    
    /**
     * Constructor to initialize a new client with first name, last name, email, username, and password.
     * @author Muath Hassoun
     * @param fName the first name of the client
     * @param lName the last name of the client
     * @param email the email address of the client
     * @param username the username of the client
     * @param password the password of the client
     */
    public Client(String fName, String lName, String email, String username, String password) {
        super();
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    /**
     * Default constructor for the Client class.
     * @author Muath Hassoun
     */
    public Client() {
    }
    
    /**
     * Returns the first name of the client.
     * @author Muath Hassoun
     * @return the first name of the client
     */
    @Override
    public String getFirstName() {
        return fName;
    }
    
    /**
     * Sets the first name of the client.
     * @author Muath Hassoun
     * @param fName the first name to set
     */
    @Override
    public void setFirstName(String fName) {
        this.fName = fName;
    }
    
    /**
     * Returns the last name of the client.
     * @author Muath Hassoun
     * @return the last name of the client
     */
    @Override
    public String getLastName() {
        return lName;
    }
    
    /**
     * Sets the last name of the client.
     * @author Muath Hassoun
     * @param lName the last name to set
     */
    @Override
    public void setLastName(String lName) {
        this.lName = lName;
    }
    
    /**
     * Returns the email of the client.
     * @author Muath Hassoun
     * @return the email of the client
     */
    @Override
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the email of the client.
     * @author Muath Hassoun
     * @param email the email to set
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Returns the username of the client.
     * @author Muath Hassoun
     * @return the username of the client
     */
    @Override
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username of the client.
     * @author Muath Hassoun
     * @param username the username to set
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Returns the password of the client.
     * @author Muath Hassoun
     * @return the password of the client
     */
    @Override
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the password of the client.
     * @author Muath Hassoun
     * @param password the password to set
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Returns the number of logins for the client.
     * @author Muath Hassoun
     * @return the number of logins
     */
    @Override
    public int getLogins() {
        return logins;
    }
    
    /**
     * Sets the number of logins for the client.
     * @author Muath Hassoun
     * @param logins the number of logins to set
     */
    @Override
    public void setLogins(int logins) {
        this.logins = logins;
    }
    
    /**
     * Returns the last login timestamp of the client.
     * @author Muath Hassoun
     * @return the last login timestamp
     */
    @Override
    public String getLastLogin() {
        return lastLogin;
    }
    
    /**
     * Sets the last login timestamp of the client.
     * @author Muath Hassoun
     * @param lastLogin the last login timestamp to set
     */
    @Override
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    /**
     * Returns the subscription plan of the client.
     * @author Muath Hassoun
     * @return the subscription plan
     */
    @Override
    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }
    
    /**
     * Sets the subscription plan of the client.
     * @author Muath Hassoun
     * @param subscriptionPlan the subscription plan to set
     */
    @Override
    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
    
    /**
     * Returns the enrolled program for the client.
     * @author Muath Hassoun
     * @return the enrolled program
     */
    public Program getEnrolledProgram() {
        return enrolledProgram;
    }
    
    /**
     * Sets the enrolled program for the client.
     * @author Muath Hassoun
     * @param enrolledProgram the program to set
     */
    public void setEnrolledProgram(Program enrolledProgram) {
        this.enrolledProgram = enrolledProgram;
    }
    
    /**
     * Returns a string representation of the client, including their first name, last name, email, username, and password.
     * @author Muath Hassoun
     * @return a string representation of the client
     */
    @Override
    public String toString() {
        return "Client {" +
               "First Name='" + fName + '\'' +
               ", Last Name='" + lName + '\'' +
               ", Email='" + email + '\'' +
               ", Username='" + username + '\'' +
               ", Password='" + password + '\'' +
               '}';
    }
}
