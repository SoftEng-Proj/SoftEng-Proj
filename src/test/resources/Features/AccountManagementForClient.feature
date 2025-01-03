@AlaaAlawnehTestss
Feature: Account Management
  I want to create and customize profiles with personal details and dietary preferences.

  @AlaaAlawnehTestss
  Scenario Outline: Set dietary preferences or restrictions
    When I select "<dietary_preference>" as my dietary preference
    And I add "<restriction>" as a restriction
    And I save the changes
    Then my dietary preferences should be updated
    And I should see a message saying "<confirmation_message>"
    
    Examples:
      | dietary_preference | restriction | confirmation_message                       |
      | Vegetarian         | No nuts     | Dietary preferences updated successfully   |
      | Vegan              | No gluten   | Dietary preferences updated successfully   |
      
  @AlaaAlawnehTestss
  Scenario: Create a new user profile
    When I enter my personal details including age "25" and fitness goals "Build muscle"
    And I specify my dietary preferences or restrictions as "No dairy"
    And I submit the form
    Then my profile should be created
    And I should see a confirmation message "Profile created successfully"
    
  @AlaaAlawnehTestss
  Scenario: Update personal details in the profile
    When I update my age to "30"
    And I change my fitness goals to "Lose weight"
    And I save the changes
    Then my profile should be updated
    And I should see a message saying "Profile updated successfully"