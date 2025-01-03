@AlaaAlawnehTests
Feature: Program Exploration and Enrollment
  I want to browse fitness programs using filters and enroll in programs to view schedules.
  
  @AlaaAlawnehTests
  Scenario Outline: Browse programs using filters
    Given I filter programs by difficulty level "<difficulty_level>"
    When I filter programs by focus area "<focus_area>"
    Then I should see a list of programs that match my filters
    
      Examples:
      | difficulty_level | focus_area         |
      | Beginner         | Weight loss        |
      | Intermediate     | Muscle building    |
      | Advanced         | Flexibility        |
      
  @AlaaAlawnehTests
  Scenario: Enroll in a program
    Given I have selected a program named "Strength Training for Beginners"
    When I click on the Enroll button
    Then I should be enrolled in the program
    And I should see the program's schedule displayed
    
  @AlaaAlawnehTests
  Scenario: View the schedule of an enrolled program
    Given I am enrolled in the program "Yoga for Flexibility"
    When I go to the "My Programs" section
    And I select the program "Yoga for Flexibility"
    Then I should see the schedule for the program
    And the schedule should include session dates and times