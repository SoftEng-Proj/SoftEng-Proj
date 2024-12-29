@MuathHassounTests
Feature: User Management
  @MuathHassounTests
  Scenario: Add a new instructor or client account
    Given I am logged in as an admin
    When I fill in the details for a new user
    Then the new user account should be created successfully

  @MuathHassounTests
  Scenario: Update an existing user account
    GivenI have selected an existing user
    When I edit the user details
    And I save the changed data
    Then the user account should be updated successfully

  @MuathHassounTests
  Scenario: Deactivate a user account
    Given I have selected an active user
    When I deactivate the user account
    Then the user should no longer be able to log in

  @MuathHassounTests
  Scenario: Approve a new instructor registration
    Given there are pending instructor applications
    When I approve an application
    Then the account should become active

  @MuathHassounTests
  Scenario: Monitor user activity and engagement statistics
    Given I view activity reports
    Then I should see detailed engagement statistics for all users