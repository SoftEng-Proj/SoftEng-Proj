package com.Software.FitnessSystem.ClientControllers;

import java.util.HashMap;
import java.util.Map;

import com.Software.FitnessSystem.Client;

public class AccountManagementControls {
	private static Map<String, Profile> profilesMap = new HashMap<>();
    
	public void createProfile(Client client, String age, String fitnessGoals) {
        Profile newProfile = new Profile(age, fitnessGoals);
        
        profilesMap.put(client.getUsername(), newProfile);
        
        System.out.println("Profile created successfully for " + client.getUsername() + "\n");
    }

	public void updatePersonalDetails(Client client, String newAge, String newFitnessGoals) {
        Profile profile = profilesMap.get(client.getUsername());
        profile.setAge(newAge);
        profile.setFitnessGoals(newFitnessGoals);
        
        System.out.println("Profile updated successfully for " + client.getUsername() + "\n");
    }

	public void setDietaryPreferences(Client client, String dietaryPreference, String restrictions) {
        Profile profile = profilesMap.get(client.getUsername());
        profile.setDietaryPreference(dietaryPreference);
        profile.setDietaryRestrictions(restrictions);
        
        System.out.println("Dietary preferences updated for " + client.getUsername() + "\n");
    }

	public void viewProfile(Client client) {
        Profile profile = profilesMap.get(client.getUsername());
        
        System.out.println("\nProfile Details for " + client.getUsername() + ":");
        System.out.println("Age: " + profile.getAge());
        System.out.println("Fitness Goals: " + profile.getFitnessGoals());
        System.out.println("Dietary Preferences: " + profile.getDietaryPreference());
        System.out.println("Dietary Restrictions: " + profile.getDietaryRestrictions());
    }
}
