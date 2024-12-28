@content_management
Feature: Content Management
  @approve_or_reject_wellness_articles_tips_or_recipes_shared_by_instructors
  Scenario: Approve or reject wellness articles, tips, or recipes shared by instructors
    Given I am logged in as an Admin
    When I navigate to the "Content Management" page
    And I review a wellness article, tip, or recipe
    Then I can approve or reject the submission
    
  @approve_articles_or_tips_shared_on_health_and_wellness
  Scenario: Approve articles or tips shared on health and wellness
    Given I am logged in as an admin
    When I navigate to the "Content Management" page
    And I review an article or tip on health and wellness
    Then I can approve or reject the submission
    
  @handle_user_feedback_and_complaints
  Scenario: Handle user feedback and complaints
    Given I am logged in as an admin
    When I navigate to the "Feedback" page
    And I review user feedback or complaints
    Then I should be able to handle them appropriately