package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {
    private static final String URL = "jdbc:mysql://localhost:3306/jee_gestion_reservation_project";  
    private static final String USER = "root";  
    private static final String PASSWORD = ""; 


   public static Connection getConnexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}





