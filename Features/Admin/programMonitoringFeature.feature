Feature: Program Monitoring
  Scenario: View statistics on the most popular programs by enrollment
    Given I am on the "Program Monitoring" page
    When I view the enrollment statistics
    Then I should see the most popular programs
    
  Scenario: Generate reports on revenue, attendance, and client progress
    Given I am on the "Program Monitoring" page
    When I generate a report
    Then I should see reports on revenue, attendance, and client progress
    
  Scenario: Track active and completed programs
    Given I am on the "Program Monitoring" page
    When I view the program status
    Then I should see a list of active and completed programs