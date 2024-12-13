package com.Software.FitnessSystem.ClientControllers;

import java.util.HashMap;
import java.util.Map;

public class FeedbackReviewsControls {
	private static Map<String, Map<String, Integer>> programRatings = new HashMap<>();
    private static Map<String, Map<String, String>> programReviews = new HashMap<>();
    private static Map<String, Map<String, String>> programSuggestions = new HashMap<>();

    public void submitRating(String username, String programId, int rating) {
        if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating. Please Write a rating between 1 and 5.");
        } else {
            if (programRatings.containsKey(programId) == false) {
                programRatings.put(programId, new HashMap<>());
            }

            Map<String, Integer> ratings = programRatings.get(programId);
            ratings.put(username, rating);
            System.out.println("Your rating has been saved for program: " + programId);
        }
    }

    public void submitReview(String username, String programId, String review) {
        if (programReviews.containsKey(programId) == false) {
            programReviews.put(programId, new HashMap<>());
        }

        Map<String, String> reviews = programReviews.get(programId);
        reviews.put(username, review);
        System.out.println("Your review has been saved for program: " + programId);
    }

    public void submitSuggestion(String username, String programId, String suggestion) {
        if (programSuggestions.containsKey(programId) == false) {
            programSuggestions.put(programId, new HashMap<>());
        }

        Map<String, String> suggestions = programSuggestions.get(programId);
        suggestions.put(username, suggestion);
        System.out.println("Your suggestion has been sent to the instructor for program: " + programId);
    }

    public void viewFeedback(String username, String programId) {
        System.out.println("\nViewing feedback for Program: " + programId);

        System.out.println("\nRatings:");
        if (programRatings.containsKey(programId)) {
            Map<String, Integer> ratings = programRatings.get(programId);
            for (String user : ratings.keySet()) {
                int rating = ratings.get(user);
                System.out.println("User: " + user + ", Rating: " + rating + " stars");
            }
        } else {
            System.out.println("No ratings found for this program.");
        }

        System.out.println("\nReviews:");
        if (programReviews.containsKey(programId)) {
            Map<String, String> reviews = programReviews.get(programId);
            for (String user : reviews.keySet()) {
                String review = reviews.get(user);
                System.out.println("User: " + user + ", Review: " + review);
            }
        } else {
            System.out.println("No reviews found for this program.");
        }

        System.out.println("\nSuggestions:");
        if (programSuggestions.containsKey(programId)) {
            Map<String, String> suggestions = programSuggestions.get(programId);
            for (String user : suggestions.keySet()) {
                String suggestion = suggestions.get(user);
                System.out.println("User: " + user + ", Suggestion: " + suggestion);
            }
        } else {
            System.out.println("No suggestions found for this program.");
        }
    }
}
