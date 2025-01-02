@AlaaAlawnehTests
@progress_tracking
Feature: Progress Tracking  
  I want to track my fitness milestones and view achievements for completing programs.

  @track_fitness_milestones
  Scenario Outline: Track personal fitness milestones  
    Given I am logged into my account  
    And I am on the progress tracking page  
    When I update my milestone with "<milestone_type>" as "<milestone_value>"  
    Then my milestone should be recorded  
    And I should see a confirmation message saying "Milestone updated successfully"

  @view_achievements
  Scenario: View achievements or badges  
    Given I am logged into my account  
    And I have completed the program "Full-Body Transformation"  
    When I go to the "Achievements" section  
    Then I should see the badge "Program Completed"  
    And I should see a message saying "Congratulations on completing Full-Body Transformation!"

  Examples:
      | milestone_type | milestone_value |
      | Weight         | 70kg            |
      | BMI            | 23.5            |
      | Attendance     | 30 sessions     |
      | Lifted Weight  | 100kg           |