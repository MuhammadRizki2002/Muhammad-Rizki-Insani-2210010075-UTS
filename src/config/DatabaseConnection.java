package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/db_resep";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    // Method untuk mendapatkan koneksi
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi ke database berhasil!");
            } catch (SQLException e) {
                System.err.println("Koneksi ke database gagal!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
