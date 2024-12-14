package com.Software.FitnessSystem.ClientControllers;

import com.Software.FitnessSystem.Client;

public class FitnessMilestone {
	    private String username;
	    private String type;
	    private String value;
	    private String date;

	    public FitnessMilestone(String type, String value, String date, Client client) {
	    	this.username = client.getUsername();
	        this.type = type;
	        this.value = value;
	        this.date = date;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getValue() {
	        return value;
	    }

	    public void setValue(String value) {
	        this.value = value;
	    }

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    public String getName() {
	        return username;
	    }

	    public void setName(String username) {
	        this.username = username;
	    }

	    @Override
	    public String toString() {
	        return "Milestone [Type=" + type + ", Value=" + value + ", Date=" + date + ", Name=" + username + "]";
	    }
}
