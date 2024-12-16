@subscription_management
Feature: Subscription Management
  @manage_subscription_plans_for_clients_and_instructors
  Scenario: Manage subscription plans for clients and instructors
    Given I am on the "Subscription Management" page
    When I edit a subscription plan
    Then the changes should be saved successfully
    
  @create_or_modify_a_subscription_plan
  Scenario: Create or modify a subscription plan
    Given I am on the "Subscription Management" page
    When I add or update a plan (e.g., Basic or Premium)
    Then the plan should be available for clients and instructors.
    
  @view_subscription_details
  Scenario: View subscription details
    Given I am on the "Subscription Management" page
    When I view subscription details
    Then I should see the details for clients and instructors