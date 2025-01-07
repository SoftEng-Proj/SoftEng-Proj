package com.software.fitness_system.basics;

public class Content {
    private String ID;
    private String type;
    private String description;
    
    /**
     * Default constructor for the Content object.
     * @author Muath Hassoun
     */
    public Content() {
    }
    
    /**
     * Returns the ID of the content.
     * @author Muath Hassoun
     * @return the ID of the content
     */
    public String getContentID() {
        return ID;
    }
    
    /**
     * Sets the ID of the content.
     * @author Muath Hassoun
     * @param ID the ID to set
     */
    public void setContentID(String ID) {
        this.ID = ID;
    }
    
    /**
     * Returns the type of the content.
     * @author Muath Hassoun
     * @return the type of the content
     */
    public String getContentType() {
        return type;
    }
    
    /**
     * Sets the type of the content.
     * @author Muath Hassoun
     * @param type the type to set
     */
    public void setContentType(String type) {
        this.type = type;
    }
    
    /**
     * Returns the description of the content.
     * @author Muath Hassoun
     * @return the description of the content
     */
    public String getContentDescription() {
        return description;
    }
    
    /**
     * Sets the description of the content.
     * @author Muath Hassoun
     * @param description the description to set
     */
    public void setContentDescription(String description) {
        this.description = description;
    }
}