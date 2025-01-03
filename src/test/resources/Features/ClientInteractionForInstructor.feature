@AmmarShafiiTests
Feature: Client Interaction
  As an instructor
  I want to interact with enrolled clients and provide feedback or progress reports

  @AmmarShafiiTests
  Scenario: Send a message to an enrolled client
    Given I am logged in as an instructor
    And I have an enrolled client named "Omar"
    When I send a message to "Omar" which says "Good Job"
    Then the client should receive the message

   @AmmarShafiiTests
   Scenario: Post a message on the dicussion forum
     Given I am logged in as an instructor
     And I am on the dicussion forum for the program "Cardio"
     When I post a message on the forum which says "It was a fun session"
     Then the message should be visible to all enrolled clients
   
   
   
   @AmmarShafiiTests
   Scenario: Provide a feedback report to a client
   Given I am logged in as an instructor
   And I have a client named "Fares"
   When I provide feedback to "Fares" with the content "Focus more on your form"
   Then the client should receive the feedback
   
   
  
      
    @AmmarShafiiTests
    Scenario Outline: Provide a progress report to a client
    Given I am logged in as an instructor
    And I have a client named '<ClientName>'
    When I provide a progress report to '<ClientName>' with the content '<ProgressReport>'
    Then the client should receive the progress report
    
    Examples:
      | ClientName     | Duration | ProgressReport                       |
      | Ibrahim        | 2 weeks  | "There's a noticable difference!"    |
      | Zaher          | 3 weeks  | "Your overall fitness has increased" |
      | Saeed          | 5 weeks  | "Great progress, we can do even more"|

