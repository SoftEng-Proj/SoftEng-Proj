@uaer_management
Feature: User Management
  @add_a_new_instructor_or_client_account
  Scenario: Add a new instructor or client account
    Given I am logged in as an admin
    When I navigate to the "User Management" page
    And I fill in the details for a new user
    Then the new user account should be created successfully
    
  @update_an_existing_user_account
  Scenario: Update an existing user account
    Given I am on the "User Management" page
    And I have selected an existing user
    When I edit the user details
    And I save the changes
    Then the user account should be updated successfully
    
  @deactivate_a_user_account
  Scenario: Deactivate a user account
    Given I am on the "User Management" page
    And I have selected an active user
    When I deactivate the user account
    Then the user should no longer be able to log in
    
  @approve_a_new_instructor_registration
  Scenario: Approve a new instructor registration
    Given I am on the "User Management" page
    And there are pending instructor applications
    When I approve an application
    Then the account should become active
    
  @monitor_user_activity_and_engagement_statistics
  Scenario: Monitor user activity and engagement statistics
    Given I am on the "User Management" page
    When I view activity reports
    Then I should see detailed engagement statistics for all users