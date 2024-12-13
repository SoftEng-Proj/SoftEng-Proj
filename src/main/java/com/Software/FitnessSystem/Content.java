package com.Software.FitnessSystem;

public class Content {
	private String ID;
    private String type;
    private String description;
    
    public Content() {
    }
    
    public Content(String ID, String type, String description) {
    	this.ID = ID;
        this.type = type;
        this.description = description;
    }
    
    public String getContentID() {
    	return ID;
    }
    public void setContentID(String ID) {
    	this.ID = ID;
    }
    
    public String getContentType() {
    	return type;
    }
    public void setContentType(String type) {
    	this.type = type;
    }
    
    public String getContentDescription() {
    	return description;
    }
    public void setContentDescription(String description) {
    	this.description = description;
    }
    
    @Override
    public String toString() {
        return "Type: " + type + "\nDescription: " + description;
    }
}