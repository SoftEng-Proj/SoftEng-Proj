

package com.Software.FitnessSystem.ClientControllers;

import java.util.Map;
import com.Software.FitnessSystem.App;
import com.Software.FitnessSystem.Client;
/**
 * This class provides methods to manage client account profiles
 * and the ability to create update and view profiles
 * and to set dietary preferences.
 * 
 * @author Alaa Alawneh
 */
public class AccountManagementControls {
	private static Map<String, Profile> profilesMap = App.getClientProfileMap();
	/**
     * Default constructor for AccountManagementControls
     * beacause the class uses static methods no need to make an instance
     */
    public AccountManagementControls() {
    	
    }
	
	 /**
     * Creates a new profile for a client if it does not exist
     *
     * @param username       The username of the client
     * @param client         The client object
     * @param age            The age of the client
     * @param fitnessGoals   The fitness goals of the client
     * @return A message of the result of the operation
     */
	public static String createProfile(String username, Client client, String age, String fitnessGoals) {
		if(!App.getClientsMap().containsKey(username)) {
			System.out.println("There isn't any client with Username: " + username);
			return "Empty";
		}
		
        Profile newProfile = new Profile(age, fitnessGoals);
        profilesMap.put(client.getUsername(), newProfile);
        System.out.println("Profile created successfully for " + client.getUsername() + "\n");
        return "Profile created successfully";
    }
	
	 /**
     * Updates the personal details of a client's profile
     *
     * @param client         The client object
     * @param newAge         The new age of the client
     * @param newFitnessGoals The new fitness goals of the client
     * @return A message of the result of the operation
     */
	public static String updatePersonalDetails(Client client, String newAge, String newFitnessGoals) {
        Profile profile = profilesMap.get(client.getUsername());
        if (profile == null) {
            System.out.println("No profile found for " + client.getUsername());
            return newFitnessGoals;
        }
        
        profile.setAge(newAge);
        profile.setFitnessGoals(newFitnessGoals);
        System.out.println("Profile updated successfully for " + client.getUsername() + "\n");
        return "Updated personal details successfully";
    }
	/**
     * Sets the dietary preferences and restrictions for the client profile
     *
     * @param client             The client object
     * @param dietaryPreference  The dietary preference of the client
     * @param restrictions       The dietary restrictions of the client
     * @return A message indicating the result of the operation
     */
	public static String setDietaryPreferences(Client client, String dietaryPreference, String restrictions) {
        Profile profile = profilesMap.get(client.getUsername());
        if (profile == null) {
            System.out.println("No profile found for " + client.getUsername());
            return restrictions;
        }
        
        profile.setDietaryPreference(dietaryPreference);
        profile.setDietaryRestrictions(restrictions);
        
        System.out.println("Dietary preferences updated for " + client.getUsername() + "\n");
        return "Updated successfully";
    }
	/**
     * Displays the profile details of a client
     *
     * @param client    The client object
     */
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