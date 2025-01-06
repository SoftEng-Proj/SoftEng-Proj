package com.software.fitness_system;

public class Admin {
    private String username;
    private String password;
    
    /**
     * Default constructor for the Admin object.
     */
    public Admin() {
    }
    
    /**
     * Returns the username of the admin.
     * @author Muath Hassoun
     * @return the username of the admin
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username of the admin.
     * @author DELL
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Returns the password of the admin.
     * @author Muath Hassoun
     * @return the password of the admin
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the password of the admin.
     * @author Muath Hassoun
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}