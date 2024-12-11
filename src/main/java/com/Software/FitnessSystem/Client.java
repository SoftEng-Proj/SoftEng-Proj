package com.Software.FitnessSystem;

public class Client implements User{
	private String fName;
	private String lName;
	private String email;
	private String username;
	private String password;
	
	private int logins = 0;
    private String lastLogin = "";
	
	public Client(String fName, String lName, String email, String username, String password) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public Client() {
    }
	
	@Override
	public String getFirstName() {
		return fName;
	}
	@Override
	public void setFirstName(String fName) {
		this.fName = fName;
	}
	
	@Override
	public String getLastName() {
		return lName;
	}
	@Override
	public void setLastName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int getLogins() {
        return logins;
    }
	@Override
    public void setLogins(int logins) {
        this.logins = logins;
    }
    
	@Override
    public String getLastLogin() {
        return lastLogin;
    }
	@Override
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    
	@Override
	public String toString() {
	    return "Client {" +
	           "First Name='" + fName + '\'' +
	           ", Last Name='" + lName + '\'' +
	           ", Email='" + email + '\'' +
	           ", Username='" + username + '\'' +
	           ", Password='" + password + '\'' +
	           '}';
	}
}