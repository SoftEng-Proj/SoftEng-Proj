package com.Software.FitnessSystem.AdminControllers;

public class SubscriptionPlan {
	public enum PlanType {
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
	
	private PlanType planType;
    
    public SubscriptionPlan() {
    }
    
    public SubscriptionPlan(PlanType planType) {
        this.planType = planType;
    }
    
    public PlanType getPlanType() {
        return planType;
    }
    public void setPlanType(PlanType planType) {
        this.planType = planType;
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