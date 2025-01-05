@MuathHassounTests
Feature: Subscription Management

  @MuathHassounTests
  Scenario: Manage subscription plans for clients and instructors (edit)
    Given I edit a subscription plan
    Then the changes should be saved successfully
    
  @MuathHassounTests
  Scenario: Add a new subscription plan
    Given I add a new subscription plan (e.g., Basic or Premium)
    Then the new plan should be available for clients and instructors.

  @MuathHassounTests
  Scenario Outline: Modify an existing subscription plan
    Given I update an existing subscription plan with "<type>" as "<value>"
    When the plan is updated
    Then the updated plan should be available for clients and instructors with "<type>" set to "<value>"
    
    Examples:
        | type        | value                              |
        | price       | 49.99                              |
        | duration    | 12                                 |
        | description | 'Premium plan with extra features' |
        
  @MuathHassounTests
  Scenario: Delete a subscription plan
    Given I delete a subscription plan
    Then the plan should no longer be available for clients and instructors.
    
  @MuathHassounTests
  Scenario: View subscription details
    Given I view subscription details
    Then I should see the details for clients and instructors