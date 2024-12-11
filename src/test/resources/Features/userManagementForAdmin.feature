Feature: User Management
  Scenario: Add a new instructor or client account
    Given I am logged in as an admin
    When I navigate to the "User Management" page
    And I fill in the details for a new user
    Then the new user account should be created successfully
    
  Scenario: Update an existing user account
    Given I am on the "User Management" page
    And I have selected an existing user
    When I edit the user details
    And I save the changes
    Then the user account should be updated successfully
    
  Scenario: Deactivate a user account
    Given I am on the "User Management" page
    And I have selected an active user
    When I deactivate the user account
    Then the user should no longer be able to log in
    
  Scenario: Approve a new instructor registration
    Given I am on the "User Management" page
    And there are pending instructor applications
    When I approve an application
    Then the account should become active
    
  Scenario: Monitor user activity and engagement statistics
    Given I am on the "User Management" page
    When I view activity reports
    Then I should see detailed engagement statistics for all users