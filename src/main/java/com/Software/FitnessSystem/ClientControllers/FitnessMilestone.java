package com.Software.FitnessSystem.ClientControllers;

import com.Software.FitnessSystem.Client;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * Represents a fitness milestone achieved by the client
 * Each milestone has a type, value, date, and the username of the client
 * 
 * @author Alaa Alawneh
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FitnessMilestone {
    private String username;
    private String type;
    private String value;
    private String date;
    /**
     * Constructs a new FitnessMilestone with the type, value, date, and client information
     *
     * @param type   the type of the milestone
     * @param value  the value of the milestone
     * @param date   the date the milestone was achieved
     * @param client  the client associated with this milestone
     */
    public FitnessMilestone(String type, String value, String date, Client client) {
    	this.username = client.getUsername();
        this.type = type;
        this.value = value;
        this.date = date;
    }
    /**
     * Default constructor for FitnessMilestone.
     */
    public FitnessMilestone() {
    }
    /**
     * Get the type of the milestone
     *
     * @return the type of the milestone
     */
    /**
     * Sets the type of the milestone
     *
     * @param type the new type of the milestone
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the value of the milestone
     *
     * @return the value of the milestone
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the milestone
     *
     * @param value the new value of the milestone
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the date of the milestone
     *
     * @return the date of the milestone
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the milestone
     *
     * @param date the new date of the milestone
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets the username of the client associated with this milestone
     *
     * @return the username of the client
     */
    public String getName() {
        return username;
    }

    /**
     * Sets the username of the client associated with this milestone
     *
     * @param username the new username of the client
     */
    public void setName(String username) {
        this.username = username;
    }

    /**
     * Returns a string representation of the milestone
     *
     * @return a string containing the milestone's type, value, date, and client username
     */
    @Override
    public String toString() {
        return "Milestone [Type=" + type + ", Value=" + value + ", Date=" + date + ", Name=" + username + "]";
    }
}