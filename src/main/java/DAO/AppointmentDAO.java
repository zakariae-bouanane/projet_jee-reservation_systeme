package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Models.Appointment;

public class AppointmentDAO{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jee_gestion_reservation_project";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";


    public static void save(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointments (name, email, phone, department, doctor, date, message) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, appointment.getName());
                statement.setString(2, appointment.getEmail());
                statement.setString(3, appointment.getPhone());
                statement.setString(4, appointment.getDepartment());
                statement.setString(5, appointment.getDoctor());
                statement.setString(6, appointment.getDate());
                statement.setString(7, appointment.getMessage());
                statement.executeUpdate();
        }
    }

    public static ArrayList<Appointment> getAll() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Appointment appointment = new Appointment();
                appointment.setName(rs.getString("name"));
                appointment.setEmail(rs.getString("email"));
                appointment.setPhone(rs.getString("phone"));
                appointment.setDepartment(rs.getString("department"));
                appointment.setDoctor(rs.getString("doctor"));
                appointment.setDate(rs.getString("date"));
                appointment.setMessage(rs.getString("message"));
                appointments.add(appointment);
                System.out.println(appointment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }

    public boolean confirmerRendezVous(String appointmentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deleteAppointment(int appointmentId) {
        String query = "DELETE FROM appointments WHERE id = ?";
    
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    
            preparedStatement.setInt(1, appointmentId);
            int rowsAffected = preparedStatement.executeUpdate();
    
            return rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
}
     public boolean confirmerrendezVous(String appointmentId) throws SQLException {
      String sql = "UPDATE appointments SET is_confirmed = true WHERE id = ?";
       try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
       PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, appointmentId);
        return stmt.executeUpdate() > 0;
    }
}

}
