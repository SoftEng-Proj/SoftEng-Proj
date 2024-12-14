 Feature: Program Management
  As an instructor
  I want to create, update, and delete fitness programs
 Scenario Outline: Create a new fitness program
    Given I am logged in as an instructor
    When I create a new program with Title '<Title>', Duration '<Duration>', Difficulty '<Difficulty>',Goals '<Goals>', Price '<Price>' 
    And I add a video tutorial and images
    And I schedule group sessions for '<Session>'
    Then the program should be created with the provided details
    
    Examples:
    | Title                | Duration | Difficulty   | Goals               | Price | SessionType | 
    | Increase Mobility    | 4 weeks  | Beginner     | Flexibility         | $50   | Online      | 
    | Building Muscles     | 7 weeks  | Intermediate | Mass increase       | $60   | In-person   | 
    | Cardio               | 5 weeks  | Advanced     |Stamina improvement  | $90   | Online      |
    
    
    Scenario Outline: Update an already existing fitness program
    Given I am logged in as an instructor
    And I have a program titled '<ProgramTitle>'
    When I update the program to change the duration to '<NewDuration>', set the difficulty to '<NewDifficulty>',set the Price to '<NewPrice>' and set the Session to '<NewSessionType>'
    Then the program should be updated with the new details
    
    Examples:
  | ProgramTitle      | NewDuration | NewDifficulty | NewPrice |NewSessionType |
  | Building Muscles  | 9 weeks     | Advanced      | $80      |Online         |
  | Increase Mobility | 6 weeks     | Intermediate  | $70      |In-Person      |
  | Cardio            | 2 weeks     | Beginner      | $ 40     |In-Person      |
  
  
  Scenario: Delete an exsting fitness program
  Given I am logged in as an instructor 
  And I have a program titled 'Increase Mobility'
  When I delete the program 
  Then the program should no longer appear in the list of programs
  
  Scenario: Delete an exsting fitness program
  Given I am logged in as an instructor 
  And I have a program titled 'Building Muscles'
  When I delete the program 
  Then the program should no longer appear in the list of programs
  
  Scenario: Delete an exsting fitness program
  Given I am logged in as an instructor 
  And I have a program titled 'Cardio'
  When I delete the program 
  Then the program should no longer appear in the list of programs
  
  
  
  
    
    
    
    
    
    