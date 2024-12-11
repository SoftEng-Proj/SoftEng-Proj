Feature: Client Interaction
  As an instructor
  I want to interact with enrolled clients and provide feedback or progress reports

  Scenario: Send a message to an enrolled client
  Given I am logged in as an instructor 
  And I have an enrolled client named '<ClientName>'
  When I send a message to '<ClientName>' which says '<Message>'
  Then the client should receive the message 
  
  Examples:
   | ClientName     | Message   
   | Omar           | "Good Job"
   | Samer          | "Noticable Difference"
   | Ahmad          | "Not bad"
   
   
   Scenario Outline: Post a message on the dicussion forum
   Given I am logged in as an instructor  
   And I am on the dicussion forum for the program '<ProgramTitle>'
   When I post a message on the forum which says '<ForumMessage>'
   Then the message should be visible to all enrolled clients
   
   Examples:
      | ProgramTitle      | ForumMessage                            |
      | Building Muscles  | "Remeber to post your before and after" |
      | Increase Mobility | "How do you feel after the session?"    |
      | Cardio            | "It was a fun session"                  |
   
   
   Scenario Outline: Provide a feedback report to a client
   Given I am logged in as an instructor
   And I have a client named '<ClientName>'
   And I have reviewed the client progress
   When I provide feedback to '<ClientName>' with the content '<Feedback>'
   Then the client should receive the feedback
   
   
   Examples:
      | ClientName     | Feedback                       |
      | Mohammad       | "Try increasing your reps."    |
      | Fares          | "Focus more on your form"      |
      | Nidal          | "You need to push a bit harder"|
      
      
    Scenario Outline: Provide a progress report to a client
    Given I am logged in as an instructor
    And I have a client named '<ClientName>'
    And I have reviewed the client progress for the last '<Duration>'
    When I provide a progress report to '<ClientName>' with the content '<ProgressReport>'
    Then the client should receive the progress report
    
    Examples:
      | ClientName     | Duration | ProgressReport                       |
      | Ibrahim        | 2 weeks  | "There's a noticable difference!"    |
      | Zaher          | 3 weeks  | "Your overall fitness has increased" |
      | Saeed          | 5 weeks  | "Great progress, we can do even more"|
    
    
      
  

 
