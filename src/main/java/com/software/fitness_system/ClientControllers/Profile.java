package com.software.fitness_system.ClientControllers;
/**
 * Represents a fitness profile for a client
 * The profile has age, fitness goals, dietary preferences, and dietary restrictions
 * 
 * @author Alaa Alawneh
 */
public class Profile {
	private String name;
    private String age;
    private String fitnessGoals;
    private String dietaryPreference;
    private String dietaryRestrictions;
    
    /**
     * Constructs a new Profile with the specified age and fitness goals
     * @param name         the first name of the client
     * @param age          the age of the client
     * @param fitnessGoals the fitness goals of the client
     */
    public Profile(String name, String age, String fitnessGoals) {
    	this.name = name;
        this.age = age;
        this.fitnessGoals = fitnessGoals;
        this.dietaryPreference = "";
        this.dietaryRestrictions = "";
    }

    /**
     * Constructs a default Profile with no initial values
     */
    public Profile() {
    }
    
    /**
     * Gets the name of the client
     *
     * @return the name of the client
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the client
     *
     * @param name the new name of the client
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the age of the client
     *
     * @return the age of the client
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets the age of the client
     *
     * @param age the new age of the client
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Gets the fitness goals of the client
     *
     * @return the fitness goals of the client
     */
    public String getFitnessGoals() {
        return fitnessGoals;
    }

    /**
     * Sets the fitness goals of the client
     *
     * @param fitnessGoals the new fitness goals of the client
     */
    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    /**
     * Gets the dietary preference of the client
     *
     * @return the dietary preference of the client
     */
    public String getDietaryPreference() {
        return dietaryPreference;
    }
    
    /**
     * Sets the dietary preference of the client
     *
     * @param dietaryPreference the new dietary preference of the client
     */
    public void setDietaryPreference(String dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
    }

    /**
     * Gets the dietary restrictions of the client
     *
     * @return the dietary restrictions of the client
     */
    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    /**
     * Sets the dietary restrictions of the client
     *
     * @param dietaryRestrictions the new dietary restrictions of the client
     */
    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}
