package DAO ;

import Models.Patient;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3308/jee_gestion_reservation_project"; 
    private static final String JDBC_USER = "root"; 
    private static final String JDBC_PASSWORD = "root123"; 
    

    public Patient verifyPatient(String email, String password ) throws ClassNotFoundException {

        String query = "SELECT * FROM patient WHERE Email = ? AND Password = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            // Set parameters for the query
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            Patient patient = new Patient();
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
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
            e.printStackTrace(); 
            System.out.println("Database error in verifyPatient: " + e.getMessage());

        }
        return null ; 
    }

    public boolean registerPatient(Patient patient) throws ClassNotFoundException {
        String queryGetMaxId = "SELECT MAX(ID_patient) FROM patient"; // Query to get the max ID
        String queryInsertPatient = "INSERT INTO patient (ID_patient, Name, Telephone, Email, DateDeNaissance, Password) VALUES (?, ?, ?, ?, ?, ?)";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {
    
            // Get the max ID and increment it by 1
            ResultSet resultSet = statement.executeQuery(queryGetMaxId);
            int newId = 1; // Default to 1 if no records are present
            if (resultSet.next()) {
                newId = resultSet.getInt(1) + 1; // Increment the max ID by 1
            }
    
            // Prepare the insert query with the new ID
            try (PreparedStatement preparedStatement = connection.prepareStatement(queryInsertPatient)) {
                preparedStatement.setInt(1, newId); // Set the new ID
                preparedStatement.setString(2, patient.getName());
                preparedStatement.setString(3, patient.getTelephone());
                preparedStatement.setString(4, patient.getEmail());
                preparedStatement.setDate(5, new java.sql.Date(patient.getDateDeNaissance().getTime()));
                preparedStatement.setString(6, patient.getPassword());
    
                // Execute the insert query
                int rowsInserted = preparedStatement.executeUpdate();
                return rowsInserted > 0; // Return true if at least one row is inserted
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
}
