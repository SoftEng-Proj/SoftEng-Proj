@MuathHassounTests
Feature: Program Monitoring

  @MuathHassounTests
  Scenario: View all programs
    Given I select the option to view all programs
    Then I should see a list of all programs
    
  @MuathHassounTests
  Scenario: View statistics on the most popular programs by enrollment
    Given I view the enrollment statistics
    Then I should see the most popular programs
    
  @MuathHassounTests
  Scenario: Generate reports on revenue, attendance, and client progress
    Given I generate a reports
    Then I should see reports on revenue, attendance, and client progress
    When I generate a report for a specific program
    Then I should see report on revenue, attendance, and client progress
    
  @MuathHassounTests
  Scenario: Track active and completed programs
    Given I view the program status
    Then I should see a list of active and completed programs