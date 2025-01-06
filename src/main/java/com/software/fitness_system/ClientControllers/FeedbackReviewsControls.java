package com.software.fitness_system.ClientControllers;

import java.util.HashMap;
import java.util.Map;

import com.software.fitness_system.App;
/**
 * The FeedbackReviewsControls class handles user feedback including ratings and reviews
 * and suggestions for the fitness programs.
 * 
 * @author Alaa Alawneh
 */
public class FeedbackReviewsControls {
	private static Map<String, Map<String, Integer>> programRatings = App.getProgramRatings();
    private static Map<String, Map<String, String>> programReviews = App.getProgramReviews();
    private static Map<String, Map<String, String>> programSuggestions = App.getProgramSuggestions();
    
    /**
     * Default constructor for AccountManagementControls
     * because the class uses static methods no need to make an instance
     */
    public FeedbackReviewsControls() {
    	
    }
    /**
     * Submits a rating for a specified fitness program
     * 
     * @param username  the name of the user submitting the rating
     * @param programId the ID of the program being rated
     * @param rating    the client rating and must be between 1 and 5
     * @return a confirmation message indicating the status of the submission
     */
    public static String submitRating(String username, String programId, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please write a rating between 1 and 5.");
        } else {
            programRatings.computeIfAbsent(programId, k -> new HashMap<>())
                          .put(username, rating);

            System.out.println("Your rating has been saved for program: " + programId);
            return "Rating Submitted successfully";
        }
        return "Invalid rating submission.";
    }
    
    /**
     * Submits a review for a fitness program
     * 
     * @param username  the name of the user submitting the review
     * @param programId the ID of the program being reviewed
     * @param review    the review text
     * @return a confirmation message indicating the status of the submission
     */
    public static String submitReview(String username, String programId, String review) {
        if (programReviews.containsKey(programId) == false) {
            programReviews.put(programId, new HashMap<>());
        }

        Map<String, String> reviews = programReviews.get(programId);
        reviews.put(username, review);
        System.out.println("Your review has been saved for program: " + programId);
        return "Review Submited succsesfully";
    }
    /**
     * Submits a suggestion for a fitness program
     * 
     * @param username    the name of the user submitting the suggestion
     * @param programId   the ID of the program for which the suggestion is being made
     * @param suggestion  the suggestion text
     * @return a confirmation message indicating the status of the submission
     */
    public static String submitSuggestion(String username, String programId, String suggestion) {
        if (programSuggestions.containsKey(programId) == false) {
            programSuggestions.put(programId, new HashMap<>());
        }

        Map<String, String> suggestions = programSuggestions.get(programId);
        suggestions.put(username, suggestion);
        System.out.println("Your suggestion has been sent to the instructor for program: " + programId);
        return "Suggestion Submited succsesfully";
    }

}
