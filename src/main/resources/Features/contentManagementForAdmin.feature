Feature: Content Management
  Scenario: Approve or reject wellness articles, tips, or recipes shared by instructors
    Given I am on the "Content Management" page
    When I review a wellness article, tip, or recipe
    Then I can approve or reject the submission
    
  Scenario: Handle user feedback and complaints
    Given I am on the "Content Management" page
    When I review user feedback and complaints
    Then I should be able to handle them appropriately