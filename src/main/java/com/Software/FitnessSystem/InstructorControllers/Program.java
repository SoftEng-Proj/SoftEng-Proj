package com.Software.FitnessSystem.InstructorControllers;


/**
 * It represents a program that can be created to be added into the list of 
 * Fitness programs. This Program has attributes for program name, duration, level,
 * goal,price, schedule type, links along with end time.
 * 
 * @author Ammar Shafii
 */

public class Program {
    private String name;
    private String duration;
    private String endAt;
    private String level;
    private String goal;
    private String links;
    private String price;
    private String schedule;
    
    /**
     * Default constructor.
     * Initializes a new instance of the Program class with default values.
     */
    public Program() {
    }
    
    /**
     * Parameterized constructor.
     * Initializes a new instance of the Program class with specified attributes.
     * 
     * @param name The name of the program.
     * @param duration The duration of the program
     * @param endAt the days for the program to end
     * @param level the difficulty level of program
     * @param goal the target goal of the program
     * @param links the links provided for the program
     * @param price the price of the program
     */
    public Program(String name, String duration, String endAt, String level, String goal, String links, String price) {
        this.name = name;
        this.duration = duration;
        this.endAt = endAt;
        this.level = level;
        this.goal = goal;
        this.links = links;
        this.price = price;
        this.schedule="Not set yet";
    }
    
    
    /**
     * Retrieves the name of the program.
     * 
     * @return Name of program
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the program
     * 
     * @param name The name to set for the program
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the duration of program
     * 
     * @return Duration of program
     */
    public String getDuration() {
        return duration;
    }
    
    /**
     * Sets the program duration
     * 
     * @param duration The duration to set for the program
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    /**
     * Retrieves the end day of program
     * 
     * @return End day of program
     */
    public String getEndAt() {
        return endAt;
    }
    
    /**
     * Sets the program end day
     * 
     * @param endAt Sets when program ends.
     */
    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }
    
    /**
     * Retrieves level of program
     * 
     * @return level of program
     */
    public String getLevel() {
        return level;
    }
    
    /**
     * Sets the program level
     * 
     * @param level the level of program
     */
    public void setLevel(String level) {
        this.level = level;
    }
    
    /**
     * Retrieves goal of program
     * 
     * @return the goal of the program
     */
    public String getGoal() {
        return goal;
    }
    
    
    /**
     * Sets the program goal
     * 
     * @param goal the goal to set for the program
     */
    public void setGoal(String goal) {
        this.goal = goal;
    }
    
    /**
     * Retrieves the links for program
     * 
     * @return the links for the program
     */
    public String getLinks() {
        return links;
    }
    
    /**
     * Sets the links for the program
     * 
     * @param links The links to associate with the program
     */
    public void setLinks(String links) {
        this.links = links;
    }
    
    /**
     * Retrieves the price of program
     * 
     * @return the price of the program
     */
    public String getPrice() {
        return price;
    }
    
    /**
     * Sets the price of the program
     * 
     * @param price The price to set for the program
     */
    public void setPrice(String price) {
        this.price = price;
    }
    
    /**
     * Retrieves the schedule type of the program
     * 
     * @return the schedule type of program
     */
    public String getSchedule() {
        return schedule;
    }
    
    /**
     * Sets the schedule type of the program
     * 
     * @param schedule The schedule type to set for the program
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}