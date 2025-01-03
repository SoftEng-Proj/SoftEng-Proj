@AlaaAlawnehTests
Feature: Progress Tracking  
  I want to track my fitness milestones and view achievements for completing programs.

  @AlaaAlawnehTests
  Scenario Outline: Track personal fitness milestones  
    Given I am logged into my account  
    When I update my milestone with "<milestone_type>" as "<milestone_value>"  
    Then my milestone should be recorded  
    And I should see a confirmation message saying "Milestone updated successfully"

  @AlaaAlawnehTests
  Scenario: View achievements or badges  
    Given I am logged into my account  
    And I have completed the program "Full-Body Transformation"  
    Then I should see the badge "Program Completed"  
    And I should see a message saying "Congratulations on completing Full-Body Transformation!"

  Examples:
      | milestone_type | milestone_value |
      | Weight         | 70kg            |
      | BMI            | 23.5            |
      | Attendance     | 30 sessions     |
      | Lifted Weight  | 100kg           |