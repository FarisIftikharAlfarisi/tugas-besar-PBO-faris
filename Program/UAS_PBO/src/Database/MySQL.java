
package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    // Ganti dengan informasi koneksi MySQL Anda
    private static final String URL = "jdbc:mysql://localhost:3306/uas_pbo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Metode untuk mendapatkan koneksi ke database MySQL
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Load driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Buat koneksi
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil!");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC tidak ditemukan!");
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal!");
            e.printStackTrace();
        }
        return connection;
    }
}
