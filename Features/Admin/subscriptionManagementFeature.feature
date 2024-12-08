Feature: Subscription Management
  Scenario: Manage subscription plans for clients and instructors
    Given I am on the "Subscription Management" page
    When I edit a subscription plan
    Then the changes should be saved successfully
    
  Scenario: Create or modify a subscription plan  
    Given I am on the "Subscription Management" page  
    When I add or update a plan (e.g., Basic or Premium)  
    Then the plan should be available for clients and instructors.
    
  Scenario: View subscription details
    Given I am on the "Subscription Management" page
    When I view subscription details
    Then I should see the details for clients and instructors