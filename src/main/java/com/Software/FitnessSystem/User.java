package com.Software.FitnessSystem;

public interface User {
    String getFirstName();
    void setFirstName(String fName);
    
    String getLastName();
    void setLastName(String lName);
    
    String getEmail();
    void setEmail(String email);
    
    String getUsername();
    void setUsername(String username);
    
    String getPassword();
    void setPassword(String password);
    
    int getLogins();
    void setLogins(int logins);
    
    String getLastLogin();
    void setLastLogin(String lastLogin);
}