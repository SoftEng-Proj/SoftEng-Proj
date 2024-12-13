Feature: Program Monitoring
  Scenario: View all programs
    Given I am on the "Program Monitoring" page
    When I select the option to view all programs
    Then I should see a list of all programs
    
  Scenario: View statistics on the most popular programs by enrollment
    Given I am on the "Program Monitoring" page
    When I view the enrollment statistics
    Then I should see the most popular programs
    
  Scenario: Generate reports on revenue, attendance, and client progress
    Given I am on the "Program Monitoring" page
    When I generate a reports
    Then I should see reports on revenue, attendance, and client progress
    When I generate a report for a specific program
    Then I should see report on revenue, attendance, and client progress
    
  Scenario: Track active and completed programs
    Given I am on the "Program Monitoring" page
    When I view the program status
    Then I should see a list of active and completed programs