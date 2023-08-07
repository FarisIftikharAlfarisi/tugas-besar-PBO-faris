
package Controller;

import View.LoginView;
import Model.LoginModel;
import Database.MySQL;
import View.DashboardView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginCtrl {
    private final LoginView loginView;
    private final LoginModel loginModel;
    private final DashboardView dashboardView; // Tambahkan atribut untuk referensi ke DashboardView

    public LoginCtrl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModel();
        this.dashboardView = new DashboardView();
        this.dashboardView.setVisible(false); // Sembunyikan DashboardView saat aplikasi dibuka
    }

    private void ambilData() {
        String username = loginView.getFieldUsername().getText();
        char[] passwordChars = loginView.getFieldPassword().getPassword();
        String password = new String(passwordChars);

        loginModel.setUsername(username);
        loginModel.setPassword(password);
    }

    private void showDashboardView() {
        dashboardView.setVisible(true); // Tampilkan DashboardView setelah berhasil login
        loginView.setVisible(false); // Sembunyikan panel login
    }
    
    
    public void login() {
        ambilData(); // Ambil data dari view
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();

        if (username.isEmpty() || password.isEmpty()) {
            // Tampilkan pesan kesalahan jika field kosong
            JOptionPane.showMessageDialog(null, "Username dan password harus diisi!");
        } else {
            try {
                // Mendapatkan koneksi ke database
                Connection connection = MySQL.getConnection();

                // Query untuk mencari data anggota berdasarkan username dan password
                String query = "SELECT * FROM anggota WHERE user = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);

                // Eksekusi query
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Jika ada data yang sesuai, tampilkan pesan berhasil login
                    JOptionPane.showMessageDialog(null, "User berhasil login!");
                    showDashboardView(); // Panggil method untuk menampilkan dashboard view
                } else {
                    // Jika tidak ada data yang sesuai, tampilkan pesan kesalahan
                    JOptionPane.showMessageDialog(null, "Username atau password salah!");
                }

                // Tutup koneksi dan statement
                resultSet.close();
                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal login. Terjadi kesalahan pada database.");
            }
        }
    }

    public void showPassword() {
        if (loginView.getCheckboxPassword().isSelected()) {
            // Jika checkbox tercentang, tampilkan password sebagai plain text
            loginView.getFieldPassword().setEchoChar((char) 0); // Menghilangkan karakter tersembunyi
        } else {
            // Jika checkbox tidak tercentang, tampilkan password sebagai bintang-bintang
            loginView.getFieldPassword().setEchoChar('*'); // Mengatur karakter tersembunyi kembali ke *
        }
    
    }
}