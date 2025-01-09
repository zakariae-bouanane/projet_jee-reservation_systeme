package DAO ;

import Models.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/jee_gestion_reservation_project"; 
    private static final String JDBC_USER = "root"; 
    private static final String JDBC_PASSWORD = "root123"; 

    public static Patient verifyPatient(String email, String password) {
        String query = "SELECT * FROM patient WHERE Email = ? AND Password = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            // Set parameters for the query
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Create and populate the Patient object
                    Patient patient = new Patient();
                    patient.setIdPatient(resultSet.getInt("ID_Patient"));
                    patient.setName(resultSet.getString("Name"));
                    patient.setTelephone(resultSet.getString("Telephone"));
                    patient.setEmail(resultSet.getString("Email"));
                    patient.setDateDeNaissance(resultSet.getDate("DateDeNaissance"));
                    patient.setPassword(resultSet.getString("Password"));
                    return patient;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log exception for debugging
        }
        return null; // Return null if no patient is found or an exception occurs
    }

    public static boolean registerPatient(Patient patient) {
        String query = "INSERT INTO patient (Name, Telephone, Email, DateDeNaissance, Password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            // Set parameters
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getTelephone());
            preparedStatement.setString(3, patient.getEmail());
            preparedStatement.setDate(4, new java.sql.Date(patient.getDateDeNaissance().getTime()));
            preparedStatement.setString(5, patient.getPassword());
    
            // Execute update
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // Return true if at least one row is inserted
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
