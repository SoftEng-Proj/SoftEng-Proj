package com.Software.FitnessSystem;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadAndSaveEntities {
    public static void saveAdminsToFile(Map<String, Admin> adminsMap, String AdminAccountsFile) {
        File file = new File(AdminAccountsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, adminsMap);
        } catch (IOException e) {
            System.err.println("Error saving Admins data: " + e.getMessage());
        }
    }
    
    public static void loadAdminsFromFile(Map<String, Admin> adminsMap, String AdminAccountsFile) {
        File file = new File(AdminAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Admin> loadedAdmins = objectMapper.readValue(file, new TypeReference<Map<String, Admin>>() {});
            adminsMap.putAll(loadedAdmins);
        } catch (IOException e) {
            System.err.println("Error loading Admins data: " + e.getMessage());
        }
    }
    
    public static void saveInstructorsToFile(Map<String, Instructor> instructorsMap, String InstructorsAccountsFile) {
        File file = new File(InstructorsAccountsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, instructorsMap);
        } catch (IOException e) {
            System.err.println("Error saving Instructors data: " + e.getMessage());
        }
    }
    
    public static void loadInstructorsFromFile(Map<String, Instructor> instructorsMap, String InstructorsAccountsFile) {
        File file = new File(InstructorsAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Instructor> loadedInstructors = objectMapper.readValue(file, new TypeReference<Map<String, Instructor>>() {});
            instructorsMap.putAll(loadedInstructors);
        } catch (IOException e) {
            System.err.println("Error loading Instructors data: " + e.getMessage());
        }
    }
    
    public static void savePendingInstructorsToFile(Map<String, Instructor> pendingInstructorsMap, String pendingInstructorsAccountsFile) {
        File file = new File(pendingInstructorsAccountsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, pendingInstructorsMap);
        } catch (IOException e) {
            System.err.println("Error saving Instructors data: " + e.getMessage());
        }
    }
    
    public static void loadPendingInstructorsFromFile(Map<String, Instructor> pendingInstructorsMap, String pendingInstructorsAccountsFile) {
        File file = new File(pendingInstructorsAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Instructor> loadedInstructors = objectMapper.readValue(file, new TypeReference<Map<String, Instructor>>() {});
            pendingInstructorsMap.putAll(loadedInstructors);
        } catch (IOException e) {
            System.err.println("Error loading Instructors data: " + e.getMessage());
        }
    }
    
    public static void saveClientsToFile(Map<String, Client> clientsMap, String clientsAccountsFile) {
        File file = new File(clientsAccountsFile);
        if (!file.exists()) {
            System.err.println("The file does not exist. A new file will be created.");
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, clientsMap);
        } catch (IOException e) {
            System.err.println("Error saving Clients data: " + e.getMessage());
        }
    }
    
    public static void loadClientsFromFile(Map<String, Client> clientsMap, String clientsAccountsFile) {
        File file = new File(clientsAccountsFile);
        if (!file.exists()) {
            System.err.println("File does not exist. Cannot load data.");
            return;
        }
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Client> loadedClients = objectMapper.readValue(file, new TypeReference<Map<String, Client>>() {});
            clientsMap.putAll(loadedClients);
        } catch (IOException e) {
            System.err.println("Error loading Clients data: " + e.getMessage());
        }
    }
}