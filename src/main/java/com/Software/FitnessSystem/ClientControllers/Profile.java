package com.Software.FitnessSystem.ClientControllers;

public class Profile {
	private String age;
    private String fitnessGoals;
    private String dietaryPreference;
    private String dietaryRestrictions;
    
    public Profile(String age, String fitnessGoals) {
        this.age = age;
        this.fitnessGoals = fitnessGoals;
        this.dietaryPreference = "";
        this.dietaryRestrictions = "";
    }
    
    public Profile() {
    }
    
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    
    public String getFitnessGoals() {
        return fitnessGoals;
    }
    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }
    
    public String getDietaryPreference() {
        return dietaryPreference;
    }
    public void setDietaryPreference(String dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
    }
    
    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }
    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
    
    @Override
    public String toString() {
        return "Profile [Age=" + age + ", Fitness Goals=" + fitnessGoals 
               + ", Dietary Preference=" + dietaryPreference 
               + ", Dietary Restrictions=" + dietaryRestrictions + "]";
    }
}
