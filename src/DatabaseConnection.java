import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/hostel_manager";
        String username = "root";
        String password = "Your password here";

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}