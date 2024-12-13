package com.Software.FitnessSystem.AdminControllers;

import com.Software.FitnessSystem.User;

public class SubscriptionManagementControls {
	
	public static <T extends User> void updateUserSubscriptionPlan(SubscriptionPlan subscriptionPlan, T user,
			boolean justRenew, boolean renewAndReverseSubscription) {
        if (subscriptionPlan != null) {
            switch (subscriptionPlan.getPlanType()) {
                case PREMIUM:
                	if(renewAndReverseSubscription && !justRenew) {
                    	subscriptionPlan.setPlanType(SubscriptionPlan.PlanType.BASIC);
                    	user.setSubscriptionPlan(subscriptionPlan);
                    	user.setLogins(0);
                	} else if(justRenew && !renewAndReverseSubscription) {
                		user.setLogins(0);
                	}
                    break;
                case BASIC:
                	if(renewAndReverseSubscription && !justRenew) {
                		subscriptionPlan.setPlanType(SubscriptionPlan.PlanType.PREMIUM);
                    	user.setSubscriptionPlan(subscriptionPlan);
                    	user.setLogins(0);
                	} else if(justRenew && !renewAndReverseSubscription) {
                		user.setLogins(0);
                	}
                    break;
                default:
                    break;
            }
        }
	}
	
	public static <T extends User> void giveTheUserNewSubscriptionOpportunity(SubscriptionPlan subscriptionPlan, T user) {
    	int login = user.getLogins();
        if (subscriptionPlan != null) {
            switch (subscriptionPlan.getPlanType()) {
                case PREMIUM:
                	login -= 21;
                	user.setLogins(login);
                    break;
                case BASIC:
                	login -= 7;
                	user.setLogins(login);
                    break;
                default:
                    break;
            }
        }
    }
}