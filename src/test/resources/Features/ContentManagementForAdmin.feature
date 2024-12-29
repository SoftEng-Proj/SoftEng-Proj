@MuathHassounTests
Feature: Content Management
  @MuathHassounTests
  Scenario: Approve or reject wellness articles, tips, or recipes shared by instructors
    Given I am logged in as an Admin
    When I review a wellness article, tip, or recipe
    Then I can approve or reject the submission

  @MuathHassounTests
  Scenario: Approve articles or tips shared on health and wellness
    Given I am logged in as an admin
    When I review an article or tip on health and wellness
    Then I can approve or reject the submission

  @MuathHassounTests
  Scenario: Handle user feedback and complaints
    Given I am logged in as an admin
    When I review user feedback or complaints
    Then I should be able to handle them appropriately