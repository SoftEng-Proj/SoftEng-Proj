package com.Software.FitnessSystem.AdminControllers;
import com.Software.FitnessSystem.App;
import java.util.Map;

public class SubscriptionPlan {
	public enum PlanType {
		FREE(0.0, 7, "Access to free features only"),
        BASIC(29.99, 30, "Access to basic features only"),
        PREMIUM(99.99, 120, "Access to all features, priority support, and more");
		
        private final double price;
        private final int duration;
        private final String description;
        
        PlanType(double price, int duration, String description) {
            this.price = price;
            this.duration = duration;
            this.description = description;
        }
        
        public double getPrice() {
            return price;
        }
        
        public int getDuration() {
            return duration;
        }
        
        public String getDescription() {
            return description;
        }
    }
	
    private static Map<String, CustomPlan> dynamicPlans;
	private CustomPlan planType;
    
    public SubscriptionPlan() {
    }
    
    public SubscriptionPlan(CustomPlan planType) {
        this.planType = planType;
    }
    
    public CustomPlan getPlanType() {
        return planType;
    }
    public void setPlanType(CustomPlan planType) {
        this.planType = planType;
    }
    
    public static void convertFromPlanTypeToCustomPlan() {
    	dynamicPlans = App.getSubscriptionPlanMap();
        for (PlanType planType : PlanType.values()) {
        	if(!dynamicPlans.containsKey(planType.name())) {
        		addToSubscriptionPlanMap(planType);
    		}
        }
    }
    
    private static void addToSubscriptionPlanMap(PlanType planType) {
    	String name = planType.name();
        double price = planType.getPrice();
        int duration = planType.getDuration();
        String description = planType.getDescription();
        
        addDynamicPlan(name, price, duration, description);
    }
    
    public static void addDynamicPlan(String name, double price, int duration, String description) {
        dynamicPlans.put(name.toUpperCase(), new CustomPlan(name, price, duration, description) {});
    }
    public static CustomPlan getDynamicPlan(String name) {
        return dynamicPlans.get(name.toUpperCase());
    }
    
    @Override
    public String toString() {
        return "SubscriptionPlan: \n" +
        		"Level: '" + getPlanType().toString() + "'\n" +
                "Price: " + planType.getPrice() + "\n" +
                "Duration: '" + planType.getDuration() + "'\n" +
                "Description: '" + planType.getDescription() + "'\n" +
                "-----------------------------------------------------\n";
    }
}