@AlaaAlawnehTests
Feature: Feedback and Reviews  
  I want to rate and review completed programs and suggest improvements to instructors.

  @AlaaAlawnehTests
  Scenario Outline: Rate a completed program  
    Given I am logged into my account  
    And I have completed the program "<program_name>"
    When I rate the program "<rating>" out of 5 stars  
    And I submit my rating  
    Then my rating should be saved  
    
  @AlaaAlawnehTests
  Scenario Outline: Submit a review for a completed program  
    Given I am logged into my account  
    And I have completed the program "<program_name>"  
    When I write a review "<review_text>"  
    And I submit my review  
    Then my review should be saved  
    
  @AlaaAlawnehTests
  Scenario: Submit an improvement suggestion to instructors  
    Given I am logged into my account  
    And I have completed the program "Cardio Blast"  
    When I navigate to the "Suggestions" section  
    And I submit a suggestion "Add more HIIT exercises"  
    Then my suggestion should be sent to the instructor  

  Examples:  
      | program_name         | rating | review_text                                              |
      | Yoga for Beginners   | 4      | "Great program, but could use more breathing exercises." |
      | Strength Training 101| 5      | "Excellent program for beginners."                       |
      | Cardio Blast         | 3      | "Good, but needs more variety."                          |
      
      