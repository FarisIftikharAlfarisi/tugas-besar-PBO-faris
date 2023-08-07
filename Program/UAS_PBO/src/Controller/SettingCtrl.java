
package Controller;

import Database.MySQL;
import Model.SettingModel;
import View.SettingView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SettingCtrl {
    private final SettingView settingView;
    private final SettingModel settingModel;

    public SettingCtrl(SettingView settingView) {
        this.settingView = settingView;
        this.settingModel = new SettingModel();
    }

    private void ambilData() {
        String namaPengguna = settingView.getFieldUser().getText(); // Ambil data pengguna dari fieldUser
        char[] passwordLamaChars = settingView.getFieldPasswordLama().getPassword();
        char[] passwordBaruChars = settingView.getFieldPasswordBaru().getPassword();
        char[] passwordKonfirmasiChars = settingView.getFieldKonfirmasi().getPassword();

        String passwordLama = new String(passwordLamaChars);
        String passwordBaru = new String(passwordBaruChars);
        String passwordKonfirmasi = new String(passwordKonfirmasiChars);

        settingModel.setUser(namaPengguna); // Simpan data pengguna di model
        settingModel.setPasswordLama(passwordLama);
        settingModel.setPasswordBaru(passwordBaru);
        settingModel.setPasswordKonfirmasi(passwordKonfirmasi);
    }

    public void updatePassword() {
    ambilData(); // Ambil data dari view dan simpan di model

    String namaPengguna = settingModel.getUser(); // Ambil nama pengguna dari model
    String passwordLama = settingModel.getPasswordLama();
    String passwordBaru = settingModel.getPasswordBaru();
    String passwordKonfirmasi = settingModel.getPasswordKonfirmasi();

    // Validasi apakah semua field password sudah diisi
    if (namaPengguna.isEmpty() || passwordLama.isEmpty() || passwordBaru.isEmpty() || passwordKonfirmasi.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        return;
    }

    String passwordFromDB = null;
    try {
        Connection connection = MySQL.getConnection();

        // Lakukan proses mencari nama pengguna di database
        String queryUser = "SELECT user FROM anggota WHERE user = ?";
        PreparedStatement statementUser = connection.prepareStatement(queryUser);
        statementUser.setString(1, namaPengguna);

        ResultSet resultSetUser = statementUser.executeQuery();
        if (!resultSetUser.next()) {
            // Jika nama pengguna tidak ditemukan di database, berarti pengguna salah
            JOptionPane.showMessageDialog(null, "Nama pengguna tidak ditemukan di database.");
            resultSetUser.close();
            statementUser.close();
            connection.close();
            return;
        }

        resultSetUser.close();
        statementUser.close();

        // Lakukan proses mengambil password lama dari database dengan query SELECT
        String queryPassword = "SELECT password FROM anggota WHERE user = ?";
        PreparedStatement statementPassword = connection.prepareStatement(queryPassword);
        statementPassword.setString(1, namaPengguna);

        ResultSet resultSetPassword = statementPassword.executeQuery();
        if (resultSetPassword.next()) {
            passwordFromDB = resultSetPassword.getString("password");
        }

        resultSetPassword.close();
        statementPassword.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengambil password lama dari database.");
        return;
    }

    // Lakukan validasi password lama dengan data yang ada di database
    if (!passwordLama.equals(passwordFromDB)) {
        JOptionPane.showMessageDialog(null, "Password lama tidak cocok!");
        return;
    }

    // Validasi apakah password baru sama dengan konfirmasi password
    if (!passwordBaru.equals(passwordKonfirmasi)) {
        JOptionPane.showMessageDialog(null, "Password baru dan konfirmasi password tidak cocok!");
        return;
    }

    // Jika semua validasi berhasil, tampilkan konfirmasi untuk update password
    int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin update password?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION) {
        try {
            Connection connection = MySQL.getConnection();

            // Lakukan proses update password ke database dengan query UPDATE
            String queryUpdatePassword = "UPDATE anggota SET password = ? WHERE user = ?";
            PreparedStatement statementUpdatePassword = connection.prepareStatement(queryUpdatePassword);
            statementUpdatePassword.setString(1, passwordBaru);
            statementUpdatePassword.setString(2, namaPengguna);

            int rowsUpdated = statementUpdatePassword.executeUpdate();
            statementUpdatePassword.close();
            connection.close();

            // Jika ada baris yang diupdate, berarti update berhasil
            if (rowsUpdated > 0) {
                // Tampilkan pesan sukses setelah proses update berhasil
                JOptionPane.showMessageDialog(null, "Password berhasil diupdate!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengupdate password. Terjadi kesalahan pada database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengupdate password. Terjadi kesalahan pada database.");
        }
    } else {
        // Jika user membatalkan konfirmasi, tampilkan pesan batal
        JOptionPane.showMessageDialog(null, "Update password dibatalkan.");
    }
}
    
    public void showPassword() {
    if (settingView.getCheckBoxPassword().isSelected()) {
        // Jika checkbox tercentang, tampilkan password sebagai plain text
        settingView.getFieldPasswordLama().setEchoChar((char) 0); // Menghilangkan karakter tersembunyi
        settingView.getFieldPasswordBaru().setEchoChar((char) 0);
        settingView.getFieldKonfirmasi().setEchoChar((char) 0);
    } else {
        // Jika checkbox tidak tercentang, tampilkan password sebagai bintang-bintang
        settingView.getFieldPasswordLama().setEchoChar('*'); // Mengatur karakter tersembunyi kembali ke *
        settingView.getFieldPasswordBaru().setEchoChar('*');
        settingView.getFieldKonfirmasi().setEchoChar('*');
    }
}
    
    public void ClearForm(){
        settingView.getFieldUser().setText(null);
        settingView.getFieldPasswordLama().setText(null);
        settingView.getFieldPasswordBaru().setText(null);
        settingView.getFieldKonfirmasi().setText(null);
    }

}

