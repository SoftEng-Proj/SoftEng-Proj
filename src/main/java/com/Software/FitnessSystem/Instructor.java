package com.Software.FitnessSystem;

public class Instructor {
	private String fName;
	private String lName;
	private String email;
	private String username;
	private String password;
	
	private int logins = 0;
    private String lastLogin = "";
	
	public Instructor(String fName, String lName, String email, String username, String password) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public Instructor() {
    }
	
	public String getFirstName() {
		return fName;
	}
	public void setFirstName(String fName) {
		this.fName = fName;
	}
	
	public String getLastName() {
		return lName;
	}
	public void setLastName(String lName) {
		this.lName = lName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getLogins() {
        return logins;
    }
    public void setLogins(int logins) {
        this.logins = logins;
    }
    
    public String getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
	
	@Override
	public String toString() {
	    return "Instructor {" +
	           "First Name='" + fName + '\'' +
	           ", Last Name='" + lName + '\'' +
	           ", Email='" + email + '\'' +
	           ", Username='" + username + '\'' +
	           ", Password='" + password + '\'' +
	           '}';
	}
}