
package Controller;

import Database.MySQL;
import Model.BukuModel;
import View.BukuView;

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


public class BukuCtrl {
    
    private final BukuView bukuView;
    private final BukuModel bukuModel;
    
    public BukuCtrl(BukuView bukuView){
        this.bukuView = bukuView;
        this.bukuModel = new BukuModel();
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

    public void tampilDataBuku() {
    // Menghapus semua data dari JTable sebelum menambahkan data baru
    DefaultTableModel model = (DefaultTableModel) bukuView.getTableBuku().getModel();
    model.setRowCount(0);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = Database.MySQL.getConnection();

    // Query untuk mengambil data buku dari tabel Buku
    String query = "SELECT buku_id, penulis, penerbit, isbn, judul, tahunterbit FROM Buku";

    try {
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        // Variabel untuk menyimpan nomor urut
        int no = 1;

        // Loop untuk membaca data dari hasil query dan menambahkannya ke JTable
        while (resultSet.next()) {
            int bukuId = resultSet.getInt("buku_id");
            String penulis = resultSet.getString("penulis");
            String penerbit = resultSet.getString("penerbit");
            String isbn = resultSet.getString("isbn");
            String judul = resultSet.getString("judul");
            String tahunterbit = resultSet.getString("tahunterbit");

            // Ubah format tanggal dari yyyy-MM-dd menjadi dd/MM/yyyy (jika tidak null)
            if (tahunterbit != null) {
                SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat displayDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dbDateFormat.parse(tahunterbit);
                tahunterbit = displayDateFormat.format(date);
            }

            // Menambahkan data ke dalam JTable
            model.addRow(new Object[]{no, bukuId, penulis, penerbit, isbn, judul, tahunterbit});

            // Increment nomor urut
            no++;
        }

        // Menutup koneksi dan statement
        resultSet.close();
        statement.close();

    } catch (SQLException | ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengambil data buku dari database!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Mengatur kolom ID agar tersembunyi
    TableColumn idColumn = bukuView.getTableBuku().getColumnModel().getColumn(1);
    idColumn.setMinWidth(0);
    idColumn.setMaxWidth(0);
    idColumn.setWidth(0);
    idColumn.setPreferredWidth(0);

    // Mengatur semua kolom agar data berada di tengah
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    for (int i = 0; i < bukuView.getTableBuku().getColumnCount(); i++) {
        bukuView.getTableBuku().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Mengatur header kolom agar berada di tengah
    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) bukuView.getTableBuku().getTableHeader().getDefaultRenderer();
    headerRenderer.setHorizontalAlignment(JLabel.CENTER);

    // Menampilkan garis-garis pada tabel
    bukuView.getTableBuku().setShowGrid(true);
    bukuView.getTableBuku().setShowHorizontalLines(true);
    bukuView.getTableBuku().setGridColor(Color.BLACK);
    setColumnWidthToContent(bukuView.getTableBuku());
}

    public void tampilkanDataBukuKeForm() {
    int selectedRowIndex = bukuView.getTableBuku().getSelectedRow();

    if (selectedRowIndex >= 0) {
        // Ambil data dari JTable sesuai dengan baris yang dipilih
        DefaultTableModel tableModel = (DefaultTableModel) bukuView.getTableBuku().getModel();
        String penulis = tableModel.getValueAt(selectedRowIndex, 2).toString();
        String penerbit = tableModel.getValueAt(selectedRowIndex, 3).toString();
        String isbn = tableModel.getValueAt(selectedRowIndex, 4).toString();
        String judul = tableModel.getValueAt(selectedRowIndex, 5).toString();
        String tahunterbit = tableModel.getValueAt(selectedRowIndex, 6).toString();

        // Set data ke input fields pada form
        bukuView.getFieldPenulis().setText(penulis);
        bukuView.getFieldPenerbit().setText(penerbit);
        bukuView.getFieldIsbn().setText(isbn);
        bukuView.getFieldJudul().setText(judul);

        // Konversi tahunterbit dari string ke tanggal (format "dd/MM/yyyy")
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            java.util.Date date = dateFormat.parse(tahunterbit);
            bukuView.getDateTahunTerbit().setDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
            // Atur bagaimana menangani exception jika terjadi kesalahan dalam parsing tanggal
        }
    }
}

    private void ambilData() {
    String penulis = bukuView.getFieldPenulis().getText();
    String penerbit = bukuView.getFieldPenerbit().getText();
    String isbn = bukuView.getFieldIsbn().getText();
    String judul = bukuView.getFieldJudul().getText();

    // Set data ke dalam model
    bukuModel.setPenulis(penulis);
    bukuModel.setPenerbit(penerbit);
    bukuModel.setIsbn(isbn);
    bukuModel.setJudul(judul);

    // Konversi tanggal dari java.util.Date ke java.sql.Date
    java.util.Date utilTahunTerbit = bukuView.getDateTahunTerbit().getDate();
    if (utilTahunTerbit == null) {
        bukuModel.setTahunterbit(null);
    } else {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strTahunTerbit = dateFormat.format(utilTahunTerbit);
        bukuModel.setTahunterbit(strTahunTerbit);
    }
}

    public void tambahData() {
    // Ambil data dari view dan lakukan validasi cek field kosong
    ambilData();

    // Validasi cek field kosong
    String penulis = bukuModel.getPenulis();
    String penerbit = bukuModel.getPenerbit();
    String isbn = bukuModel.getIsbn();
    String judul = bukuModel.getJudul();
    String tahunterbit = bukuModel.getTahunterbit();

    if (penulis.isEmpty() || penerbit.isEmpty() || isbn.isEmpty() || judul.isEmpty() || tahunterbit == null) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        return;
    }

    try {
        Connection connection = MySQL.getConnection();

        // Lakukan proses cek data ISBN dengan query SELECT
        String queryCekIsbn = "SELECT COUNT(*) AS total FROM buku WHERE isbn = ?";
        PreparedStatement statementCekIsbn = connection.prepareStatement(queryCekIsbn);
        statementCekIsbn.setString(1, isbn);

        ResultSet resultSetCekIsbn = statementCekIsbn.executeQuery();
        if (resultSetCekIsbn.next()) {
            int total = resultSetCekIsbn.getInt("total");
            if (total > 0) {
                JOptionPane.showMessageDialog(bukuView, "Data dengan ISBN tersebut sudah ada!");
                resultSetCekIsbn.close();
                statementCekIsbn.close();
                connection.close();
                return;
            }
        }

        resultSetCekIsbn.close();
        statementCekIsbn.close();

        // Jika semua validasi berhasil, lakukan proses tambah data ke database
        String queryTambah = "INSERT INTO buku (penulis, penerbit, isbn, judul, tahunterbit) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statementTambah = connection.prepareStatement(queryTambah);
        statementTambah.setString(1, penulis);
        statementTambah.setString(2, penerbit);
        statementTambah.setString(3, isbn);
        statementTambah.setString(4, judul);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilTahunTerbit = dateFormat.parse(tahunterbit);
        statementTambah.setDate(5, new java.sql.Date(utilTahunTerbit.getTime()));

        int rowsInserted = statementTambah.executeUpdate();
        statementTambah.close();
        connection.close();

        // Jika ada baris yang berhasil diinsert, berarti proses tambah data berhasil
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(bukuView, "Data buku berhasil ditambahkan!");
        } else {
            JOptionPane.showMessageDialog(bukuView, "Gagal menambahkan data buku. Terjadi kesalahan pada database.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(bukuView, "Gagal menambahkan data buku. Terjadi kesalahan pada database.");
    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Format tanggal tidak valid. Harap masukkan tanggal dengan format yang benar (dd/MM/yyyy)!");
    }
    
    tampilDataBuku();
    clearForm();
}
    
    public void updateDataBuku() {
    // Mendapatkan baris terpilih dari JTable
    int selectedRow = bukuView.getTableBuku().getSelectedRow();

    // Periksa apakah ada baris yang dipilih di JTable
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data buku yang akan diupdate!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan proses update karena tidak ada baris yang dipilih
    }

    // Mengambil ID buku dari JTable yang dipilih
    int id = (int) bukuView.getTableBuku().getValueAt(selectedRow, 1);

    // Ambil data dari view dan lakukan validasi cek field kosong
    ambilData();

    // Validasi cek field kosong setelah ambil data dari view
    String penulis = bukuModel.getPenulis();
    String penerbit = bukuModel.getPenerbit();
    String isbn = bukuModel.getIsbn();
    String judul = bukuModel.getJudul();
    String tahunterbit = bukuModel.getTahunterbit();

    if (penulis.isEmpty() || penerbit.isEmpty() || isbn.isEmpty() || judul.isEmpty() || tahunterbit.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Data tidak valid, hentikan proses update
    }

    // Tampilkan option dialog untuk konfirmasi update data
    UIManager.put("OptionPane.okButtonText", "OK");
    UIManager.put("OptionPane.cancelButtonText", "Cancel");
    int option = JOptionPane.showOptionDialog(
            null,
            "Anda yakin ingin melakukan update data buku?",
            "Konfirmasi Update Data",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new Object[]{"OK", "Cancel"},
            "OK"
    );

    // Jika user memilih "OK", lanjutkan proses update data buku
    if (option == JOptionPane.OK_OPTION) {
        try {
            Connection connection = MySQL.getConnection();

            // Query untuk memeriksa apakah data dengan ISBN yang sama sudah ada di database
            String checkQuery = "SELECT COUNT(*) FROM Buku WHERE ISBN = ? AND buku_id <> ?";

            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, isbn);
            checkStatement.setInt(2, id);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Data dengan ISBN yang sama sudah ada di database.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    // Data dengan ISBN yang sama sudah ada, hentikan proses update
                    return;
                }
            }

            // Jika data dengan ISBN yang sama belum ada, lanjutkan proses update
            checkStatement.close();

            // Query untuk update data buku berdasarkan ID
            String updateQuery = "UPDATE Buku SET ISBN=?, penulis=?, penerbit=?, judul=?, tahunterbit=? WHERE buku_id=?";
            PreparedStatement updateStatement = null;

            try {
                updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, isbn);
                updateStatement.setString(2, penulis);
                updateStatement.setString(3, penerbit);
                updateStatement.setString(4, judul);

                // Konversi tanggal dari format "dd/MM/yyyy" menjadi java.sql.Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date utilTahunTerbit = dateFormat.parse(tahunterbit);
                updateStatement.setDate(5, new java.sql.Date(utilTahunTerbit.getTime()));

                updateStatement.setInt(6, id);

                // Eksekusi query untuk update data
                int rowsUpdated = updateStatement.executeUpdate();

                // Menampilkan pesan sukses jika data berhasil diupdate
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Data buku berhasil diupdate.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal melakukan update data buku.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException | ParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal melakukan update data buku!", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // Menutup statement
                if (updateStatement != null) {
                    updateStatement.close();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal melakukan update data buku!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Refresh tampilan JTable untuk menampilkan data terbaru
        tampilDataBuku();
        clearForm();
    }
    // Jika user memilih "Cancel", tidak ada tindakan yang diambil
}
    
    public void hapusDataBuku() {
    // Mendapatkan baris terpilih dari JTable
    int selectedRow = bukuView.getTableBuku().getSelectedRow();

    // Periksa apakah ada baris yang dipilih di JTable
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data buku yang akan dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan proses update karena tidak ada baris yang dipilih
    }

    // Mengambil ID buku dari JTable yang dipilih
    int id = (int) bukuView.getTableBuku().getValueAt(selectedRow, 1);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = Database.MySQL.getConnection();

    try {
        // Periksa apakah ada data di tabel Peminjam yang terelasi dengan buku yang akan dihapus
        String queryCheckRelation = "SELECT COUNT(*) as total FROM Peminjam WHERE buku_id=?";
        PreparedStatement statementCheckRelation = connection.prepareStatement(queryCheckRelation);
        statementCheckRelation.setInt(1, id);
        ResultSet resultSet = statementCheckRelation.executeQuery();
        resultSet.next();
        int totalRelation = resultSet.getInt("total");

        if (totalRelation > 0) {
            JOptionPane.showMessageDialog(null, "Data buku tidak dapat dihapus karena sudah terelasi dengan data peminjam.", "Warning", JOptionPane.WARNING_MESSAGE);
            return; // Hentikan proses karena data buku terelasi dengan data peminjam
        }

        // Tampilkan option dialog
        UIManager.put("OptionPane.okButtonText", "OK");
        UIManager.put("OptionPane.cancelButtonText", "Cancel");
        int option = JOptionPane.showOptionDialog(
                null,
                "Anda yakin ingin menghapus data buku?",
                "Konfirmasi Hapus Data",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"OK", "Cancel"},
                "OK"
        );

        // Jika user memilih "OK", hapus data dari database
        if (option == JOptionPane.OK_OPTION) {
            // Query untuk menghapus data buku berdasarkan ID
            String query = "DELETE FROM Buku WHERE buku_id=?";

            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);

                // Eksekusi query untuk hapus data
                int rowsDeleted = statement.executeUpdate();

                // Menampilkan pesan sukses jika data berhasil dihapus
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data buku berhasil dihapus.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data buku.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                // Menutup koneksi dan statement
                statement.close();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal menghapus data buku!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Refresh tampilan JTable untuk menampilkan data terbaru
            tampilDataBuku();
            clearForm();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal menghapus data buku!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void clearForm(){
        bukuView.getFieldPenulis().setText("");
        bukuView.getFieldPenerbit().setText("");
        bukuView.getFieldIsbn().setText("");
        bukuView.getFieldJudul().setText("");
        bukuView.getDateTahunTerbit().setDate(null);
        bukuView.getFieldSearch().setText("");
        
        tampilDataBuku();
    }
    
    public void searchDataBuku() {
    // Mendapatkan kata kunci pencarian dari field di Form
    String kataKunci = bukuView.getFieldSearch().getText();

    // Menghapus semua data dari JTable sebelum melakukan pencarian
    DefaultTableModel model = (DefaultTableModel) bukuView.getTableBuku().getModel();
    model.setRowCount(0);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = Database.MySQL.getConnection();

    // Query untuk melakukan pencarian data buku berdasarkan kata kunci (NamaBuku, Penulis, Penerbit, ISBN, atau Judul)
    String query = "SELECT buku_id, penulis, penerbit, isbn, judul, tahunterbit FROM Buku WHERE penulis LIKE ? OR penerbit LIKE ? OR isbn LIKE ? OR judul LIKE ? OR tahunterbit LIKE ?";

    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam Penulis
        statement.setString(2, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam Penerbit
        statement.setString(3, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam ISBN
        statement.setString(4, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam Judul
        statement.setString(5, "%" + kataKunci + "%"); // Tambahkan wildcard % untuk mencari kata kunci di manapun dalam TahunTerbit

        ResultSet resultSet = statement.executeQuery();

        // Variabel untuk menyimpan nomor urut
        int no = 1;

        // Loop untuk membaca data dari hasil query dan menambahkannya ke JTable
        while (resultSet.next()) {
            int bukuId = resultSet.getInt("buku_id");
            String penulis = resultSet.getString("penulis");
            String penerbit = resultSet.getString("penerbit");
            String isbn = resultSet.getString("isbn");
            String judul = resultSet.getString("judul");
            String tahunterbit = resultSet.getString("tahunterbit");

            // Menambahkan data ke dalam JTable
            model.addRow(new Object[]{no, bukuId, penulis, penerbit, isbn, judul, tahunterbit});

            // Increment nomor urut
            no++;
        }

        // Menutup koneksi dan statement
        resultSet.close();
        statement.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal melakukan pencarian data buku!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
}
