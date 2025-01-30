package src.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static void main(String[] args) {
        // ✅ Updated connection URL with allowPublicKeyRetrieval=true
        String url = "jdbc:mysql://shawa.com.tr:3306/shawacom_SMS?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "shawacom_heso";
        String password = "Hes0@981";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println(" Connection successful to the database @159.146.26.117");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
