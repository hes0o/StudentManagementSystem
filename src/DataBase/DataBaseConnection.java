package src.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://www.shawa.com.tr:3306/shawacom_SMS";
        String user = "shawacom_heso";
        String password = "Hes0@981";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
