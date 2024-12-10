package com.Software.FitnessSystem.ClientControllers;

public class FitnessMilestone {
	 private String type;
	    private String value;
	    private String date;

	    public FitnessMilestone(String type, String value, String date) {
	        this.type = type;
	        this.value = value;
	        this.date = date;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getValue() {
	        return value;
	    }

	    public void setValue(String value) {
	        this.value = value;
	    }

	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    @Override
	    public String toString() {
	        return "Milestone [Type=" + type + ", Value=" + value + ", Date=" + date + "]";
	    }
}
