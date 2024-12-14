package com.Software.FitnessSystem.ClientControllers;

import java.util.Map;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;

public class AccountManagementControls {
	private static Map<String, Profile> profilesMap = App.getClientProfileMap();
    
	public static String createProfile(Client client, String age, String fitnessGoals) {
		if (profilesMap.containsKey(client.getUsername())) {
            System.out.println("Profile already exists for " + client.getUsername());
            return fitnessGoals;
        }
		
        Profile newProfile = new Profile(age, fitnessGoals);
        profilesMap.put(client.getUsername(), newProfile);
        System.out.println("Profile created successfully for " + client.getUsername() + "\n");
        return "Profile Created Successfully.";
    }

	public static String updatePersonalDetails(Client client, String newAge, String newFitnessGoals) {
        Profile profile = profilesMap.get(client.getUsername());
        if (profile == null) {
            System.out.println("No profile found for " + client.getUsername());
            return newFitnessGoals;
        }
        profile.setAge(newAge);
        profile.setFitnessGoals(newFitnessGoals);
        
        System.out.println("Profile updated successfully for " + client.getUsername() + "\n");
        return "Updated Personal Details successfully.";
    }

	public static String setDietaryPreferences(Client client, String dietaryPreference, String restrictions) {
        Profile profile = profilesMap.get(client.getUsername());
        if (profile == null) {
            System.out.println("No profile found for " + client.getUsername());
            return restrictions;
        }
        profile.setDietaryPreference(dietaryPreference);
        profile.setDietaryRestrictions(restrictions);
        
        System.out.println("Dietary preferences updated for " + client.getUsername() + "\n");
        return "Dietary Preferences Updated";
    }

	public void viewProfile(Client client) {
        Profile profile = profilesMap.get(client.getUsername());
        if (profile == null) {
            System.out.println("No profile found for " + client.getUsername());
            return;
        }
        
        System.out.println("\nProfile Details for " + client.getUsername() + ":");
        System.out.println("Age: " + profile.getAge());
        System.out.println("Fitness Goals: " + profile.getFitnessGoals());
        System.out.println("Dietary Preferences: " + profile.getDietaryPreference());
        System.out.println("Dietary Restrictions: " + profile.getDietaryRestrictions());
    }
}
