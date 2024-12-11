Feature: Progress Tracking
As an instructor
I want to monitor client progress and send reminders so that I can help clients achieve their goals


Scenario Outline: Monitor a client progress
Given I am logged in as an instructor
And I have an enrolled client named '<ClientName>'
When I view the progress of '<ClientName>'
Then I should see '<ClientName>' progress details with a completion rate of '<CompletionRate>' and attendance of '<Attendance>'
Examples:
  | ClientName | CompletionRate | Attendance |
  | Omar       | 75%            | 9/12       |
  | Samer      | 60%            | 12/20      |
  | Ahmad      | 100%           | 15/15      |
  
  Scenario Outline: Send a motivational reminder to a client
  Given I am logged in as an instructor
  And I have an enrolled client named '<ClientName>' with a completion rate of '<CompletionRate>'
  When I send a motivational reminder to '<ClientName>' which says '<Reminder>'
  Then the client should receive a reminder message

Examples:
  | ClientName | CompletionRate | Reminder                  |
  | Omar       | 75%            |"You've almost done it"    |
  | Samer      | 60%            |"Success Needs Hard work"  |
  | Ahmad      | 100%           |"You're Fantastic"         |
  
  
  Scenario Outline: Send recommendations to a client
  Given I am logged in as an instructor
  And I have an enrolled client named '<ClientName>' with a completion rate of '<CompletionRate>'
  When I send a recommendation to '<ClientName>' which says '<Recommondation>'
  Then the client should receive a reminder message

Examples:
  | ClientName | CompletionRate | Recommendation                     |
  | Omar       | 75%            |"You should keep going!"            |
  | Samer      | 60%            |"Keep fighting hard!"               |
  | Ahmad      | 100%           |"A small rest is well recommended!" |


