package com.Software.FitnessSystem;

public class FitnessPrograms {
	private String programName;
	private int enrollments;
	private String status;
	
	public FitnessPrograms(String programName, int enrollments, String status) {
		this.programName = programName;
		this.enrollments = enrollments;
		this.status = status;
	}
	
	public FitnessPrograms() {
	}
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public int getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(int enrollments) {
		this.enrollments = enrollments;
	}
	
	public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}