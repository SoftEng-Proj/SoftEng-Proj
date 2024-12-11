Feature: Notifications and Updates
As an instructor
I want to notify clients about changes to schedules and announce new programs or special offers

Scenario Outline: Notify clients about changes to program schedules
  Given I am logged in as an instructor
  And there is a program titled '<ProgramName>'
  And '<ClientName>' is enrolled in the '<ProgramName>' program
  When I update the schedule of '<ProgramName>' to '<NewSchedule>'
  Then '<ClientName>' should receive a notification about the updated schedule

Examples:
  | ProgramName          | ClientName | NewSchedule       |
  | Increase Mobility    | Omar       | Mondays 10 AM     |
  | Building Muscles     | Samer      | Tuesdays 5 PM     |
  | Cardio               | Ahmad      | Wednesdays 7 AM   |

  
  
Scenario Outline: Announce new programs or special offers
  Given I am logged in as an instructor
  When I announce '<AnnouncementType>' with details '<AnnouncementDetails>'
  Then all clients should receive the announcement

Examples:
  | AnnouncementType         | AnnouncementDetails             |
  | New Program Launch       | "Advanced Yoga Program starts soon!" |
  | Special Offer            | "20% discount on all programs this month!" |
  | New Program Launch       | "Strength Training Program for Beginners" |