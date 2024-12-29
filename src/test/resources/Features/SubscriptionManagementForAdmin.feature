@MuathHassounTests
Feature: Subscription Management
  @MuathHassounTests
  Scenario: Manage subscription plans for clients and instructors
    Given I edit a subscription plan
    Then the changes should be saved successfully

  @MuathHassounTests
  Scenario: Create or modify a subscription plan
    Given I add or update a plan (e.g., Basic or Premium)
    Then the plan should be available for clients and instructors.

  @MuathHassounTests
  Scenario: View subscription details
    Given I view subscription details
    Then I should see the details for clients and instructors