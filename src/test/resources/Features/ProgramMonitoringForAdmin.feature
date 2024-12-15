@Program_Monitoring
Feature: Program Monitoring

  @View_all_programs
  Scenario: View all programs
    Given I am on the "Program Monitoring" page
    When I select the option to view all programs
    Then I should see a list of all programs
    
  @View_statistics_on_the_most_popular_programs_by_enrollment
  Scenario: View statistics on the most popular programs by enrollment
    Given I am on the "Program Monitoring" page
    When I view the enrollment statistics
    Then I should see the most popular programs
    
  @Generate_reports_on_revenue_attendance_and_client_progress
  Scenario: Generate reports on revenue, attendance, and client progress
    Given I am on the "Program Monitoring" page
    When I generate a reports
    Then I should see reports on revenue, attendance, and client progress
    When I generate a report for a specific program
    Then I should see report on revenue, attendance, and client progress
    
  @Track_active_and_completed_programs
  Scenario: Track active and completed programs
    Given I am on the "Program Monitoring" page
    When I view the program status
    Then I should see a list of active and completed programs