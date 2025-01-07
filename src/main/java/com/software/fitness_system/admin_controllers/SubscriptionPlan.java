package com.software.fitness_system.admin_controllers;
import java.util.Map;

import com.software.fitness_system.App;

/**
 * Represents a subscription plan in the fitness system.
 * It includes predefined plan types and support for dynamic custom plans.
 * 
 * @author Muath Hassoun
 */
public class SubscriptionPlan {
	/**
     * Enum representing predefined subscription plans.
     */
	public enum PlanType {
		FREE(0.0, 7, "Access to free features only"),
        BASIC(29.99, 30, "Access to basic features only"),
        PREMIUM(99.99, 120, "Access to all features, priority support, and more");
		
        private final double price;
        private final int duration;
        private final String description;
        
        /**
         * Constructor for PlanType.
         *
         * @param price       the price of the plan.
         * @param duration    the duration of the plan in days.
         * @param description a brief description of the plan.
         */
        PlanType(double price, int duration, String description) {
            this.price = price;
            this.duration = duration;
            this.description = description;
        }
        
        /**
         * Retrieves the price of the plan.
         *
         * @return the price of the plan.
         */
        public double getPrice() {
            return price;
        }
        
        /**
         * Retrieves the duration of the plan in days.
         *
         * @return the duration of the plan.
         */
        public int getDuration() {
            return duration;
        }
        
        /**
         * Retrieves the description of the plan.
         *
         * @return the description of the plan.
         */
        public String getDescription() {
            return description;
        }
    }
	
    private static Map<String, CustomPlan> dynamicPlans;
	private CustomPlan planType;
    
	/**
     * Default constructor for SubscriptionPlan.
     */
    public SubscriptionPlan() {
    }
    
    /**
     * Constructor for SubscriptionPlan with a custom plan.
     *
     * @param planType the custom plan associated with this subscription.
     */
    public SubscriptionPlan(CustomPlan planType) {
        this.planType = planType;
    }
    
    /**
     * Retrieves the custom plan associated with this subscription.
     *
     * @return the custom plan.
     */
    public CustomPlan getPlanType() {
        return planType;
    }
    
    /**
     * Sets the custom plan for this subscription.
     *
     * @param planType the custom plan to be set.
     */
    public void setPlanType(CustomPlan planType) {
        this.planType = planType;
    }
    
    /**
     * Converts predefined PlanType values into CustomPlan instances and adds them to the dynamic plans map.
     * If a predefined plan is not already in the dynamic plans map, it will be added.
     */
    public static void convertFromPlanTypeToCustomPlan() {
    	dynamicPlans = App.getSubscriptionPlanMap();
        for (PlanType planType : PlanType.values()) {
        	if(!dynamicPlans.containsKey(planType.name())) {
        		addToSubscriptionPlanMap(planType);
    		}
        }
    }
    
    /**
     * Adds a predefined PlanType to the dynamic plans map as a CustomPlan.
     *
     * @param planType the predefined plan type to be added.
     */
    public static void addToSubscriptionPlanMap(PlanType planType) {
    	String name = planType.name();
        double price = planType.getPrice();
        int duration = planType.getDuration();
        String description = planType.getDescription();
        
        addDynamicPlan(name, price, duration, description);
    }
    
    /**
     * Adds a dynamic plan to the subscription plans map.
     *
     * @param name        the name of the plan.
     * @param price       the price of the plan.
     * @param duration    the duration of the plan in days.
     * @param description the description of the plan.
     */
    public static void addDynamicPlan(String name, double price, int duration, String description) {
        dynamicPlans.put(name.toUpperCase(), new CustomPlan(name, price, duration, description) {});
    }
}