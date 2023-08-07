
package Controller;

import Database.MySQL;
import Model.MhsModel;
import View.MhsView;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class MhsCtrl {
    
    private final MhsView mhsView;
    private final MhsModel mhsModel;
    
    public MhsCtrl(MhsView mhsView){
        this.mhsView = mhsView;
        this.mhsModel = new MhsModel();
    }
    
    private void setColumnWidthToContent(JTable table) {
    for (int column = 0; column < table.getColumnCount(); column++) {
        TableColumn tableColumn = table.getColumnModel().getColumn(column);

        int preferredWidth = 0;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
            Component c = table.prepareRenderer(cellRenderer, row, column);
            int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
            preferredWidth = Math.max(preferredWidth, width);
        }

        tableColumn.setPreferredWidth(preferredWidth);
    }
}

    
    public void tampilDataMhs() {
    // Menghapus semua data dari JTable sebelum menambahkan data baru
    DefaultTableModel model = (DefaultTableModel) mhsView.getTableMhs().getModel();
    model.setRowCount(0);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = Database.MySQL.getConnection();

    // Query untuk mengambil data mahasiswa dari tabel Mahasiswa
    String query = "SELECT mahasiswa_id, nim, nama, jurusan, kelas, nomortelepon, alamat, tanggallahir FROM Mahasiswa";

    try {
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        // Variabel untuk menyimpan nomor urut
        int no = 1;

        // Loop untuk membaca data dari hasil query dan menambahkannya ke JTable
        while (resultSet.next()) {
            int mahasiswaId = resultSet.getInt("mahasiswa_id");
            String nim = resultSet.getString("nim");
            String nama = resultSet.getString("nama");
            String jurusan = resultSet.getString("jurusan");
            String kelas = resultSet.getString("kelas");
            String nomorTelepon = resultSet.getString("nomortelepon");
            String alamat = resultSet.getString("alamat");
            String tanggalLahir = resultSet.getString("tanggallahir");

            // Ubah format tanggal dari yyyy-MM-dd menjadi dd/MM/yyyy (jika tidak null)
            if (tanggalLahir != null) {
                SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat displayDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dbDateFormat.parse(tanggalLahir);
                tanggalLahir = displayDateFormat.format(date);
            }

            // Menambahkan data ke dalam JTable
            model.addRow(new Object[]{no, mahasiswaId, nim, nama, jurusan, kelas, nomorTelepon, alamat, tanggalLahir});

            // Increment nomor urut
            no++;
        }

        // Menutup koneksi dan statement
        resultSet.close();
        statement.close();

    } catch (SQLException | ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengambil data mahasiswa dari database!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Mengatur kolom ID agar tersembunyi
    TableColumn idColumn = mhsView.getTableMhs().getColumnModel().getColumn(1);
    idColumn.setMinWidth(0);
    idColumn.setMaxWidth(0);
    idColumn.setWidth(0);
    idColumn.setPreferredWidth(0);

    // Mengatur semua kolom agar data berada di tengah
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    for (int i = 0; i < mhsView.getTableMhs().getColumnCount(); i++) {
        mhsView.getTableMhs().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Mengatur header kolom agar berada di tengah
    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) mhsView.getTableMhs().getTableHeader().getDefaultRenderer();
    headerRenderer.setHorizontalAlignment(JLabel.CENTER);

    // Menampilkan garis-garis pada tabel
    mhsView.getTableMhs().setShowGrid(true);
    mhsView.getTableMhs().setShowHorizontalLines(true);
    mhsView.getTableMhs().setGridColor(Color.BLACK);
    setColumnWidthToContent(mhsView.getTableMhs());
}

    public void tampilkanDataMhsKeForm() {
    int selectedRowIndex = mhsView.getTableMhs().getSelectedRow();

    if (selectedRowIndex >= 0) {
        // Ambil data dari JTable sesuai dengan baris yang dipilih
        DefaultTableModel tableModel = (DefaultTableModel) mhsView.getTableMhs().getModel();
        String nim = tableModel.getValueAt(selectedRowIndex, 2).toString();
        String nama = tableModel.getValueAt(selectedRowIndex, 3).toString();
        String jurusan = tableModel.getValueAt(selectedRowIndex, 4).toString();
        String kelas = tableModel.getValueAt(selectedRowIndex, 5).toString();
        String nomorTelepon = tableModel.getValueAt(selectedRowIndex, 6).toString();
        String alamat = tableModel.getValueAt(selectedRowIndex, 7).toString();
        String tanggalLahir = tableModel.getValueAt(selectedRowIndex, 8).toString();

        // Set data ke input fields pada form
        mhsView.getFieldNim().setText(nim);
        mhsView.getFieldNama().setText(nama);
        mhsView.getFieldJurusan().setText(jurusan);
        mhsView.getFieldKelas().setText(kelas);
        mhsView.getFieldNomorTlp().setText(nomorTelepon);
        mhsView.getTextAlamat().setText(alamat);

        // Konversi tanggalLahir dari string ke tanggal (format "dd/MM/yyyy")
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date date = dateFormat.parse(tanggalLahir);
            mhsView.getDateTanggalLahir().setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
            // Atur bagaimana menangani exception jika terjadi kesalahan dalam parsing tanggal
        }
    }
}

    private void ambilDataMhs() {
    String nim = mhsView.getFieldNim().getText();
    String nama = mhsView.getFieldNama().getText();
    String jurusan = mhsView.getFieldJurusan().getText();
    String kelas = mhsView.getFieldKelas().getText();
    String nomorTelepon = mhsView.getFieldNomorTlp().getText();
    String alamat = mhsView.getTextAlamat().getText();

    // Set data ke dalam model
    mhsModel.setNim(nim);
    mhsModel.setNama(nama);
    mhsModel.setJurusan(jurusan);
    mhsModel.setKelas(kelas);
    mhsModel.setNomortelepon(nomorTelepon);
    mhsModel.setAlamat(alamat);

    // Konversi tanggalLahir dari java.util.Date ke format "dd/MM/yyyy"
    java.util.Date utilTanggalLahir = mhsView.getDateTanggalLahir().getDate();
    if (utilTanggalLahir == null) {
        mhsModel.setTanggallahir(null);
    } else {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strTanggalLahir = dateFormat.format(utilTanggalLahir);
        mhsModel.setTanggallahir(strTanggalLahir);
    }
}

    public void tambahDataMhs() {
    // Ambil data dari view dan lakukan validasi cek field kosong
    ambilDataMhs();

    // Validasi cek field kosong
    String nim = mhsModel.getNim();
    String nama = mhsModel.getNama();
    String jurusan = mhsModel.getJurusan();
    String kelas = mhsModel.getKelas();
    String nomorTelepon = mhsModel.getNomortelepon();
    String alamat = mhsModel.getAlamat();
    String tanggalLahir = mhsModel.getTanggallahir();

    if (nim.isEmpty() || nama.isEmpty() || jurusan.isEmpty() || kelas.isEmpty() || nomorTelepon.isEmpty() || alamat.isEmpty() || tanggalLahir == null) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        return;
    }

    // Validasi cek NIM hanya mengandung angka
    if (!nim.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "NIM hanya boleh berisi angka!");
        return;
    }

    // Validasi cek Nomor Telepon hanya mengandung angka
    if (!nomorTelepon.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Nomor Telepon hanya boleh berisi angka!");
        return;
    }

    try {
        Connection connection = MySQL.getConnection();

        // Lakukan proses cek data NIM dengan query SELECT
        String queryCekNim = "SELECT COUNT(*) AS total FROM mahasiswa WHERE nim = ?";
        PreparedStatement statementCekNim = connection.prepareStatement(queryCekNim);
        statementCekNim.setString(1, nim);

        ResultSet resultSetCekNim = statementCekNim.executeQuery();
        if (resultSetCekNim.next()) {
            int total = resultSetCekNim.getInt("total");
            if (total > 0) {
                JOptionPane.showMessageDialog(mhsView, "Data dengan NIM tersebut sudah ada!");
                resultSetCekNim.close();
                statementCekNim.close();
                connection.close();
                return;
            }
        }

        resultSetCekNim.close();
        statementCekNim.close();

        // Jika semua validasi berhasil, lakukan proses tambah data ke database
        String queryTambah = "INSERT INTO mahasiswa (nim, nama, jurusan, kelas, nomortelepon, alamat, tanggallahir) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statementTambah = connection.prepareStatement(queryTambah);
        statementTambah.setString(1, nim);
        statementTambah.setString(2, nama);
        statementTambah.setString(3, jurusan);
        statementTambah.setString(4, kelas);
        statementTambah.setString(5, nomorTelepon);
        statementTambah.setString(6, alamat);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilTglLahir = dateFormat.parse(tanggalLahir);
        statementTambah.setDate(7, new java.sql.Date(utilTglLahir.getTime()));

        int rowsInserted = statementTambah.executeUpdate();
        statementTambah.close();
        connection.close();

        // Jika ada baris yang berhasil diinsert, berarti proses tambah data berhasil
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(mhsView, "Data mahasiswa berhasil ditambahkan!");
        } else {
            JOptionPane.showMessageDialog(mhsView, "Gagal menambahkan data mahasiswa. Terjadi kesalahan pada database.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(mhsView, "Gagal menambahkan data mahasiswa. Terjadi kesalahan pada database.");
    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Format tanggal tidak valid. Harap masukkan tanggal dengan format yang benar (dd/MM/yyyy)!");
    }

    tampilDataMhs();
    clearForm();
}

    public void updateDataMhs() {
    // Mendapatkan baris terpilih dari JTable
    int selectedRow = mhsView.getTableMhs().getSelectedRow();

    // Periksa apakah ada baris yang dipilih di JTable
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data mahasiswa yang akan diupdate!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan proses update karena tidak ada baris yang dipilih
    }

    // Mengambil ID mahasiswa dari JTable yang dipilih
    int id = (int) mhsView.getTableMhs().getValueAt(selectedRow, 1);

    // Ambil data dari view dan lakukan validasi cek field kosong
    ambilDataMhs();

    // Validasi cek field kosong setelah ambil data dari view
    String nim = mhsModel.getNim();
    String nama = mhsModel.getNama();
    String jurusan = mhsModel.getJurusan();
    String kelas = mhsModel.getKelas();
    String nomorTelepon = mhsModel.getNomortelepon();
    String alamat = mhsModel.getAlamat();
    String tanggalLahir = mhsModel.getTanggallahir();

    if (nim.isEmpty() || nama.isEmpty() || jurusan.isEmpty() || kelas.isEmpty() || nomorTelepon.isEmpty() || alamat.isEmpty() || tanggalLahir == null) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Data tidak valid, hentikan proses update
    }

    // Validasi cek NIM hanya mengandung angka
    if (!nim.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "NIM hanya boleh berisi angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validasi cek Nomor Telepon hanya mengandung angka
    if (!nomorTelepon.matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Nomor Telepon hanya boleh berisi angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Tampilkan option dialog untuk konfirmasi update data
    UIManager.put("OptionPane.okButtonText", "OK");
    UIManager.put("OptionPane.cancelButtonText", "Cancel");
    int option = JOptionPane.showOptionDialog(
            null,
            "Anda yakin ingin melakukan update data mahasiswa?",
            "Konfirmasi Update Data",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"OK", "Cancel"},
            "OK"
    );

    // Jika user memilih "OK", lanjutkan proses update data mahasiswa
    if (option == JOptionPane.OK_OPTION) {
        try {
            Connection connection = MySQL.getConnection();

            // Query untuk memeriksa apakah data dengan NIM yang sama sudah ada di database
            String checkQuery = "SELECT COUNT(*) FROM mahasiswa WHERE nim = ? AND mahasiswa_id <> ?";

            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, nim);
            checkStatement.setInt(2, id);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Data dengan NIM yang sama sudah ada di database.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    // Data dengan NIM yang sama sudah ada, hentikan proses update
                    return;
                }
            }

            // Jika data dengan NIM yang sama belum ada, lanjutkan proses update
            checkStatement.close();

            // Query untuk update data mahasiswa berdasarkan ID
            String updateQuery = "UPDATE mahasiswa SET nim=?, nama=?, jurusan=?, kelas=?, nomortelepon=?, alamat=?, tanggallahir=? WHERE mahasiswa_id=?";
            PreparedStatement updateStatement = null;

            try {
                updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, nim);
                updateStatement.setString(2, nama);
                updateStatement.setString(3, jurusan);
                updateStatement.setString(4, kelas);
                updateStatement.setString(5, nomorTelepon);
                updateStatement.setString(6, alamat);

                // Konversi tanggal dari format "dd/MM/yyyy" menjadi java.sql.Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilTglLahir = dateFormat.parse(tanggalLahir);
                updateStatement.setDate(7, new java.sql.Date(utilTglLahir.getTime()));

                updateStatement.setInt(8, id);

                // Eksekusi query untuk update data
                int rowsUpdated = updateStatement.executeUpdate();

                // Menampilkan pesan sukses jika data berhasil diupdate
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil diupdate.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal melakukan update data mahasiswa.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal melakukan update data mahasiswa!", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // Menutup statement
                if (updateStatement != null) {
                    updateStatement.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal melakukan update data mahasiswa!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Refresh tampilan JTable untuk menampilkan data terbaru
        tampilDataMhs();
        clearForm();
    }
    // Jika user memilih "Cancel", tidak ada tindakan yang diambil
}
    
    public void hapusDataMhs() {
    // Mendapatkan baris terpilih dari JTable
    int selectedRow = mhsView.getTableMhs().getSelectedRow();

    // Periksa apakah ada baris yang dipilih di JTable
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data mahasiswa yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan proses hapus karena tidak ada baris yang dipilih
    }

    // Mengambil ID mahasiswa dari JTable yang dipilih
    int id = (int) mhsView.getTableMhs().getValueAt(selectedRow, 1);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = Database.MySQL.getConnection();

    try {
        // Periksa apakah ada data di tabel Peminjam yang terelasi dengan mahasiswa yang akan dihapus
        String queryCheckRelation = "SELECT COUNT(*) as total FROM Peminjam WHERE mahasiswa_id=?";
        PreparedStatement statementCheckRelation = connection.prepareStatement(queryCheckRelation);
        statementCheckRelation.setInt(1, id);
        ResultSet resultSet = statementCheckRelation.executeQuery();
        resultSet.next();
        int totalRelation = resultSet.getInt("total");

        if (totalRelation > 0) {
            JOptionPane.showMessageDialog(null, "Data mahasiswa tidak dapat dihapus karena sudah terelasi dengan data peminjam.", "Warning", JOptionPane.WARNING_MESSAGE);
            return; // Hentikan proses karena data mahasiswa terelasi dengan data peminjam
        }

        // Tampilkan option dialog
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        int option = JOptionPane.showOptionDialog(
                null,
                "Anda yakin ingin menghapus data mahasiswa?",
                "Konfirmasi Hapus Data",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"OK", "Cancel"},
                "OK"
        );

        // Jika user memilih "OK", hapus data dari database
        if (option == JOptionPane.OK_OPTION) {
            // Query untuk menghapus data mahasiswa berdasarkan ID
            String query = "DELETE FROM mahasiswa WHERE mahasiswa_id=?";

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);

                // Eksekusi query untuk hapus data
                int rowsDeleted = statement.executeUpdate();

                // Menampilkan pesan sukses jika data berhasil dihapus
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data mahasiswa.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Menutup koneksi dan statement
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal menghapus data mahasiswa!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Refresh tampilan JTable untuk menampilkan data terbaru
            tampilDataMhs();
            clearForm();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal menghapus data mahasiswa!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void clearForm() {
    mhsView.getFieldNama().setText("");
    mhsView.getFieldNim().setText("");
    mhsView.getFieldJurusan().setText("");
    mhsView.getFieldKelas().setText("");
    mhsView.getFieldNomorTlp().setText("");
    mhsView.getTextAlamat().setText("");
    mhsView.getDateTanggalLahir().setDate(null);
    mhsView.getFieldSearch().setText("");

    tampilDataMhs();
}

    public void searchDataMhs() {
    // Mendapatkan kata kunci pencarian dari field di Form
    String kataKunci = mhsView.getFieldSearch().getText();

    // Menghapus semua data dari JTable sebelum melakukan pencarian
    DefaultTableModel model = (DefaultTableModel) mhsView.getTableMhs().getModel();
    model.setRowCount(0);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = Database.MySQL.getConnection();

    // Query untuk melakukan pencarian data mahasiswa berdasarkan kata kunci (NIM, Nama, Jurusan, Kelas, NomorTelepon, Alamat, atau TanggalLahir)
    String query = "SELECT mahasiswa_id, nim, nama, jurusan, kelas, nomortelepon, alamat, tanggallahir FROM Mahasiswa WHERE nim LIKE ? OR nama LIKE ? OR jurusan LIKE ? OR kelas LIKE ? OR nomortelepon LIKE ? OR alamat LIKE ? OR tanggallahir LIKE ?";

    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam NIM
        statement.setString(2, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam Nama
        statement.setString(3, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam Jurusan
        statement.setString(4, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam Kelas
        statement.setString(5, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam NomorTelepon
        statement.setString(6, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam Alamat
        statement.setString(7, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam TanggalLahir

        ResultSet resultSet = statement.executeQuery();

        // Variabel untuk menyimpan nomor urut
        int no = 1;

        // Loop untuk membaca data dari hasil query dan menambahkannya ke JTable
        while (resultSet.next()) {
            int mahasiswaId = resultSet.getInt("mahasiswa_id");
            String nim = resultSet.getString("nim");
            String nama = resultSet.getString("nama");
            String jurusan = resultSet.getString("jurusan");
            String kelas = resultSet.getString("kelas");
            String nomortelepon = resultSet.getString("nomortelepon");
            String alamat = resultSet.getString("alamat");
            String tanggallahir = resultSet.getString("tanggallahir");

            // Menambahkan data ke dalam JTable
            model.addRow(new Object[]{no, mahasiswaId, nim, nama, jurusan, kelas, nomortelepon, alamat, tanggallahir});

            // Increment nomor urut
            no++;
        }

        // Menutup koneksi dan statement
        resultSet.close();
        statement.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal melakukan pencarian data mahasiswa!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    
}
