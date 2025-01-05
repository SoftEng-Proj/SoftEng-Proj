@MuathHassounTests
Feature: User Management

  @MuathHassounTests
  Scenario Outline: Add a new user account
    Given I am logged in as an admin
    When I fill in the details for a new <user_type>
    Then the new <user_type> account should be created successfully

    Examples:
      | user_type    |
      | client       |
      | instructor   |

  @MuathHassounTests
  Scenario Outline: Update an existing user account
    Given I have selected an existing <user_type>
    When I edit the <user_type> details
    And I save the changed data
    Then the <user_type> account should be updated successfully

    Examples:
      | user_type    |
      | client       |
      | instructor   |

  @MuathHassounTests
  Scenario Outline: Deactivate a user account
    Given I have selected an active <user_type>
    When I deactivate the <user_type> account
    Then the <user_type> should no longer be able to log in

    Examples:
      | user_type    |
      | client       |
      | instructor   |

  @MuathHassounTests
  Scenario: Approve a new instructor registration
    Given there are pending instructor applications
    When I approve a instructor application
    Then the instructor account should become active
    
  @MuathHassounTests
  Scenario: Monitor user activity and engagement statistics
    Given I view activity reports
    Then I should see detailed engagement statistics for all users
    