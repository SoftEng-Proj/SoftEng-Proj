package com.Software.FitnessSystem.AdminControllers;

import java.util.Objects;

/**
 * Represents a customizable subscription plan in the Fitness Management System.
 * Provides attributes for plan name, price, duration, and description, 
 * along with methods to access and modify these attributes.
 * This class can be used to define personalized subscription plans for clients.
 * 
 * @author Muath Hassoun
 */
public class CustomPlan {
    private String name;
    private double price;
    private int duration;
    private String description;
    
    /**
     * Default constructor.
     * Initializes a new instance of the CustomPlan class with default values.
     */
    public CustomPlan() {
    }
    
    /**
     * Parameterized constructor.
     * Initializes a new instance of the CustomPlan class with specified attributes.
     * 
     * @param name The name of the subscription plan.
     * @param price The price of the subscription plan.
     * @param duration The duration of the subscription plan in days.
     * @param description A description of the subscription plan.
     */
    public CustomPlan(String name, double price, int duration, String description) {
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.description = description;
    }
    
    /**
     * Retrieves the name of the subscription plan.
     * 
     * @return The name of the plan.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the subscription plan.
     * 
     * @param name The name to set for the plan.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the price of the subscription plan.
     * 
     * @return The price of the plan.
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Sets the price of the subscription plan.
     * 
     * @param price The price to set for the plan.
     */
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }
    
    /**
     * Retrieves the duration of the subscription plan in days.
     * 
     * @return The duration of the plan.
     */
    public int getDuration() {
        return duration;
    }
    
    /**
     * Sets the duration of the subscription plan in days.
     * 
     * @param duration The duration to set for the plan.
     */
    public void setDuration(int duration) {
        if (duration > 0) {
            this.duration = duration;
        } else {
            throw new IllegalArgumentException("Duration must be greater than 0.");
        }
    }
    
    /**
     * Retrieves the description of the subscription plan.
     * 
     * @return The description of the plan.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the description of the subscription plan.
     * 
     * @param description The description to set for the plan.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Returns a string representation of the CustomPlan object.
     * 
     * @return A string that describes the CustomPlan object.
     */
    @Override
    public String toString() {
        return String.format("CustomPlan[name=%s, price=%.2f, duration=%d days, description=%s]",
                             name, price, duration, description);
    }
    
    /**
     * Checks if two CustomPlan objects are equal based on their attributes.
     * 
     * @param obj The object to compare.
     * @return {@code true} if the objects are equal, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CustomPlan that = (CustomPlan) obj;
        return Double.compare(that.price, price) == 0 &&
               duration == that.duration &&
               name.equals(that.name) &&
               description.equals(that.description);
    }
    
    /**
     * Returns a hash code for the CustomPlan object based on its attributes.
     * 
     * @return The hash code for the CustomPlan object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price, duration, description);
    }
}