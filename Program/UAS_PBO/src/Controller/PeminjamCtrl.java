
package Controller;

import Database.MySQL;
import Model.PeminjamModel;
import View.PeminjamView;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class PeminjamCtrl {
    
    private final PeminjamView peminjamView;
    private final PeminjamModel peminjamModel;
    
    
    public PeminjamCtrl(PeminjamView peminjamView){
        this.peminjamView = peminjamView;
        this.peminjamModel = new PeminjamModel();
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
    
    public void tampilDataPeminjam() {
    // Menghapus semua data dari JTable sebelum menambahkan data baru
    DefaultTableModel model = (DefaultTableModel) peminjamView.getTablePeminjam().getModel();
    model.setRowCount(0);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = MySQL.getConnection();

    // Query untuk mengambil data peminjaman dari tabel Peminjam
    String query = "SELECT peminjam_id, m.nim, m.nama, b.judul, b.penerbit, p.tanggalpeminjam, p.tanggalpengembalian, p.status "
            + "FROM Peminjam p "
            + "JOIN Mahasiswa m ON p.mahasiswa_id = m.mahasiswa_id "
            + "JOIN Buku b ON p.buku_id = b.buku_id";

    try {
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        // Variabel untuk menyimpan nomor urut
        int no = 1;

        // Loop untuk membaca data dari hasil query
        while (resultSet.next()) {
            int peminjamId = resultSet.getInt("peminjam_id");
            String nim = resultSet.getString("nim");
            String nama = resultSet.getString("nama");
            String judulBuku = resultSet.getString("judul");
            String penerbitBuku = resultSet.getString("penerbit");
            String tanggalPeminjaman = resultSet.getString("tanggalpeminjam");
            String tanggalPengembalian = resultSet.getString("tanggalpengembalian");
            boolean status = resultSet.getBoolean("status");

            // Mengubah format tanggal peminjaman dan tanggal pengembalian menjadi dd-MM-yyyy
            SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat displayDateFormat = new SimpleDateFormat("dd-MM-yyyy");

            Date datePeminjaman = dbDateFormat.parse(tanggalPeminjaman);
            tanggalPeminjaman = displayDateFormat.format(datePeminjaman);

            if (tanggalPengembalian != null) {
                Date datePengembalian = dbDateFormat.parse(tanggalPengembalian);
                tanggalPengembalian = displayDateFormat.format(datePengembalian);
            }

            // Menambahkan data ke dalam JTable
            model.addRow(new Object[]{no, peminjamId, nim, nama, judulBuku, penerbitBuku, tanggalPeminjaman, tanggalPengembalian, status});

            // Increment nomor urut
            no++;
        }

        // Menutup koneksi dan statement
        resultSet.close();
        statement.close();

        // Loop untuk menentukan status peminjaman
        for (int i = 0; i < model.getRowCount(); i++) {
            boolean status = (boolean) model.getValueAt(i, 8);

            if (status) {
                model.setValueAt("Sudah Selesai", i, 8);
            } else {
                SimpleDateFormat dbDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String tanggalPengembalian = (String) model.getValueAt(i, 7);

                try {
                    Date currentDate = new Date();
                    Date datePengembalian = dbDateFormat.parse(tanggalPengembalian);

                    if (datePengembalian != null && datePengembalian.before(currentDate)) {
                        model.setValueAt("Overdue", i, 8);
                    } else {
                        model.setValueAt("Ongoing", i, 8);
                    }
                } catch (ParseException e) {
                    // Tangani kesalahan parsing jika diperlukan
                    e.printStackTrace();
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengambil data peminjam dari database!", "Error", JOptionPane.ERROR_MESSAGE);
    }   catch (ParseException ex) {
            Logger.getLogger(PeminjamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    // Mengatur kolom ID agar tersembunyi
    TableColumn idColumn = peminjamView.getTablePeminjam().getColumnModel().getColumn(1);
    idColumn.setMinWidth(0);
    idColumn.setMaxWidth(0);
    idColumn.setWidth(0);
    idColumn.setPreferredWidth(0);

    // Mengatur semua kolom agar data berada di tengah
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    for (int i = 0; i < peminjamView.getTablePeminjam().getColumnCount(); i++) {
        peminjamView.getTablePeminjam().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Mengatur header kolom agar berada di tengah
    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) peminjamView.getTablePeminjam().getTableHeader().getDefaultRenderer();
    headerRenderer.setHorizontalAlignment(JLabel.CENTER);

    // Menampilkan garis-garis pada tabel
    peminjamView.getTablePeminjam().setShowGrid(true);
    peminjamView.getTablePeminjam().setShowHorizontalLines(true);
    peminjamView.getTablePeminjam().setGridColor(Color.BLACK);
    setColumnWidthToContent(peminjamView.getTablePeminjam());
}
    
    private void ambilDataPeminjam() {
    // Ambil data dari view
    String namaMahasiswaNim = peminjamView.getComboNama().getSelectedItem().toString();
    String namaBukuISBN = peminjamView.getComboBuku().getSelectedItem().toString();

    // Split data namaMahasiswaNim menjadi Nama dan Nim
    String[] namaMahasiswaNimArray = namaMahasiswaNim.split(" - ");
    String namaMahasiswa = namaMahasiswaNimArray[0];
    String nimMahasiswa = namaMahasiswaNimArray[1];

    // Split data namaBukuISBN menjadi Judul Buku dan ISBN
    String[] namaBukuISBNArray = namaBukuISBN.split(" - ");
    String judulBuku = namaBukuISBNArray[0];
    String isbnBuku = namaBukuISBNArray[1];

    // Konversi tanggal peminjaman dari java.util.Date ke format "dd/MM/yyyy"
    java.util.Date utilTanggalPeminjaman = peminjamView.getDateTanggalPmj().getDate();
    String strTanggalPeminjaman = null;
    if (utilTanggalPeminjaman != null) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        strTanggalPeminjaman = dateFormat.format(utilTanggalPeminjaman);
    }

    // Konversi tanggal pengembalian dari java.util.Date ke format "dd/MM/yyyy"
    java.util.Date utilTanggalPengembalian = peminjamView.getDateTanggalPmb().getDate();
    String strTanggalPengembalian = null;
    if (utilTanggalPengembalian != null) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        strTanggalPengembalian = dateFormat.format(utilTanggalPengembalian);
    }

    // Set data ke dalam model
    peminjamModel.setNama(namaMahasiswa);
    peminjamModel.setBuku(judulBuku);
    peminjamModel.setNim(nimMahasiswa);
    peminjamModel.setIsbn(isbnBuku);
    peminjamModel.setTanggalPeminjaman(strTanggalPeminjaman);
    peminjamModel.setTanggalPengembalian(strTanggalPengembalian);
}
    
    public void tambahDataPeminjam() {
    // Ambil data dari view dan lakukan validasi cek field kosong
    ambilDataPeminjam();

    // Validasi cek field kosong
    String namaMahasiswa = peminjamModel.getNama();
    String nimMahasiswa = peminjamModel.getNim();
    String judulBuku = peminjamModel.getBuku();
    String isbnBuku = peminjamModel.getIsbn();
    String tanggalPeminjaman = peminjamModel.getTanggalPeminjaman();
    String tanggalPengembalian = peminjamModel.getTanggalPengembalian();

    if (namaMahasiswa.isEmpty() || nimMahasiswa.isEmpty() || judulBuku.isEmpty() || isbnBuku.isEmpty() || tanggalPeminjaman == null || tanggalPengembalian == null) {
        JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
        return;
    }

    // Lakukan konfirmasi untuk menambahkan data
    int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menambahkan data peminjam?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        try {
            Connection connection = MySQL.getConnection();

            // Lakukan proses tambah data ke database
            String queryTambah = "INSERT INTO Peminjam (mahasiswa_id, buku_id, tanggalpeminjam, tanggalpengembalian, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementTambah = connection.prepareStatement(queryTambah);
            statementTambah.setInt(1, getIdMahasiswaFromDatabase(nimMahasiswa));
            statementTambah.setInt(2, getIdBukuFromDatabase(judulBuku, isbnBuku));

            // Ubah format tanggal ke 'yyyy-MM-dd' sebelum di-insert ke database
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilTanggalPeminjaman = dateFormat.parse(tanggalPeminjaman);
            java.util.Date utilTanggalPengembalian = dateFormat.parse(tanggalPengembalian);

            statementTambah.setDate(3, new java.sql.Date(utilTanggalPeminjaman.getTime()));
            statementTambah.setDate(4, new java.sql.Date(utilTanggalPengembalian.getTime()));

            statementTambah.setInt(5, 0); // Set status false (0), karena baru ditambahkan

            int rowsInserted = statementTambah.executeUpdate();
            statementTambah.close();
            connection.close();

            // Jika ada baris yang berhasil diinsert, berarti proses tambah data berhasil
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data peminjam berhasil ditambahkan!");
                // Refresh tampilan ComboBox setelah penambahan data
                tampilComboBoxNama(peminjamView.getComboNama());
                tampilComboBoxBuku(peminjamView.getComboBuku());
            } else {
                JOptionPane.showMessageDialog(null, "Gagal menambahkan data peminjam. Terjadi kesalahan pada database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data peminjam. Terjadi kesalahan pada database.");
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Format tanggal tidak valid. Harap masukkan tanggal dengan format yang benar (dd/MM/yyyy)!");
        }
    }

    // Refresh tampilan data peminjam
    tampilDataPeminjam();
    clearForm();
    
    
}

    public void PerpanjangPinjaman() {
    // Mendapatkan baris terpilih dari JTable
    int selectedRow = peminjamView.getTablePeminjam().getSelectedRow();

    // Periksa apakah ada baris yang dipilih di JTable
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data mahasiswa yang akan diupdate!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan proses update karena tidak ada baris yang dipilih
    }

    // Ambil data dari JTable
    DefaultTableModel model = (DefaultTableModel) peminjamView.getTablePeminjam().getModel();
    int peminjamId = Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
    String nimMahasiswa = model.getValueAt(selectedRow, 2).toString();
    String judulBuku = model.getValueAt(selectedRow, 4).toString();
    String isbnBuku = model.getValueAt(selectedRow, 5).toString();

    // Tampilkan dialog untuk memilih tanggal pengembalian baru
    JDateChooser dateChooser = new JDateChooser();
    dateChooser.setDateFormatString("dd/MM/yyyy");
    int dateChooserResult = JOptionPane.showOptionDialog(null, dateChooser, "Pilih Tanggal Pengembalian Baru", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    if (dateChooserResult != JOptionPane.OK_OPTION) {
        return; // Batal perpanjangan pinjaman jika tombol Cancel diklik pada dateChooser
    }

    // Ambil tanggal pengembalian baru dari dateChooser
    Date tanggalPengembalianBaru = dateChooser.getDate();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Format tanggal yang sesuai dengan format di database
    String strTanggalPengembalianBaru = dateFormat.format(tanggalPengembalianBaru);

    try {
        Connection connection = MySQL.getConnection();

        // Update data tanggal pengembalian pada database
        String queryUpdate = "UPDATE Peminjam SET tanggalpengembalian = ? WHERE peminjam_id = ?";
        PreparedStatement statementUpdate = connection.prepareStatement(queryUpdate);
        statementUpdate.setString(1, strTanggalPengembalianBaru);
        statementUpdate.setInt(2, peminjamId);

        int rowsUpdated = statementUpdate.executeUpdate();
        statementUpdate.close();
        connection.close();

        // Tampilkan pesan berhasil atau gagal
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Perpanjangan pinjaman berhasil dilakukan untuk buku " + judulBuku + " (ISBN: " + isbnBuku + ") dengan tanggal pengembalian baru: " + dateFormat.format(tanggalPengembalianBaru));
        } else {
            JOptionPane.showMessageDialog(null, "Gagal melakukan perpanjangan pinjaman. Terjadi kesalahan pada database.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal melakukan perpanjangan pinjaman. Terjadi kesalahan pada database.");
    }

    // Refresh tampilan data peminjam
    tampilDataPeminjam();
}

    public void konfirmasi() {
    // Mendapatkan baris terpilih dari JTable
    int selectedRow = peminjamView.getTablePeminjam().getSelectedRow();

    // Periksa apakah ada baris yang dipilih di JTable
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Pilih data mahasiswa yang akan diupdate!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan proses update karena tidak ada baris yang dipilih
    }

    // Mendapatkan ID peminjam dari baris terpilih
    int peminjamId = (int) peminjamView.getTablePeminjam().getValueAt(selectedRow, 1);

    // Tampilkan konfirmasi
    int result = JOptionPane.showConfirmDialog(null, "Apakah buku ini sudah dikembalikan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        // Lakukan update status peminjaman menjadi true
        try {
            Connection connection = MySQL.getConnection();

            // Lakukan proses update status peminjaman ke database
            String queryUpdate = "UPDATE Peminjam SET status = ? WHERE peminjam_id = ?";
            PreparedStatement statementUpdate = connection.prepareStatement(queryUpdate);
            statementUpdate.setBoolean(1, true); // Set status true
            statementUpdate.setInt(2, peminjamId);

            int rowsUpdated = statementUpdate.executeUpdate();
            statementUpdate.close();
            connection.close();

            // Jika ada baris yang berhasil diupdate, tampilkan pesan sukses
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Status peminjaman berhasil di-update!");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal update status peminjaman. Terjadi kesalahan pada database.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal update status peminjaman. Terjadi kesalahan pada database.");
        }

        // Refresh tampilan data peminjam
        tampilDataPeminjam();
        
        // Refresh combo box buku dan combo box mahasiswa
        tampilComboBoxBuku(peminjamView.getComboBuku());
        tampilComboBoxNama(peminjamView.getComboNama());
        
    }
}
    
    public void clearForm() {
        // Memindahkan pilihan combo box buku ke index 0
        JComboBox<String> bukuComboBox = peminjamView.getComboBuku();
        DefaultComboBoxModel<String> bukuComboBoxModel = (DefaultComboBoxModel<String>) bukuComboBox.getModel();
        if (bukuComboBoxModel.getSize() > 0) {
            bukuComboBox.setSelectedIndex(0);
        }

        // Memindahkan pilihan combo box nama ke index 0
        JComboBox<String> namaComboBox = peminjamView.getComboNama();
        DefaultComboBoxModel<String> namaComboBoxModel = (DefaultComboBoxModel<String>) namaComboBox.getModel();
        if (namaComboBoxModel.getSize() > 0) {
            namaComboBox.setSelectedIndex(0);
        }

        // Mengosongkan field tanggal peminjaman dan tanggal pengembalian
        JDateChooser dateTanggalPmj = peminjamView.getDateTanggalPmj();
        JDateChooser dateTanggalPmb = peminjamView.getDateTanggalPmb();
        dateTanggalPmj.setDate(null);
        dateTanggalPmb.setDate(null);
        
        tampilDataPeminjam();
    }
    
    public void searchDataPeminjam() {
    // Mendapatkan kata kunci pencarian dari field di Form
    String kataKunci = peminjamView.getFieldSearch().getText();

    // Menghapus semua data dari JTable sebelum melakukan pencarian
    DefaultTableModel model = (DefaultTableModel) peminjamView.getTablePeminjam().getModel();
    model.setRowCount(0);

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = MySQL.getConnection();

    // Query untuk melakukan pencarian data peminjam berdasarkan kata kunci (NIM, Nama Mahasiswa, Judul Buku, Penerbit Buku, Tanggal Peminjaman, Tanggal Pengembalian, atau Status)
    String query = "SELECT peminjam_id, m.nim, m.nama, b.judul, b.penerbit, p.tanggalpeminjam, p.tanggalpengembalian, p.status "
            + "FROM Peminjam p "
            + "JOIN Mahasiswa m ON p.mahasiswa_id = m.mahasiswa_id "
            + "JOIN Buku b ON p.buku_id = b.buku_id "
            + "WHERE m.nim LIKE ? OR m.nama LIKE ? OR b.judul LIKE ? OR b.penerbit LIKE ? OR p.tanggalpeminjam LIKE ? OR p.tanggalpengembalian LIKE ? OR (CASE WHEN p.status = 1 THEN 'Sudah Selesai' ELSE (CASE WHEN (p.tanggalpengembalian IS NOT NULL AND p.tanggalpengembalian < CURDATE()) THEN 'Overdue' ELSE 'Ongoing' END) END) LIKE ?";

    try {
        PreparedStatement statement = connection.prepareStatement(query);
        for (int i = 1; i <= 7; i++) {
            statement.setString(i, "%" + kataKunci + "%");
        }

        ResultSet resultSet = statement.executeQuery();

        // Variabel untuk menyimpan nomor urut
        int no = 1;

        // Loop untuk membaca data dari hasil query dan menambahkannya ke JTable
        while (resultSet.next()) {
            int peminjamId = resultSet.getInt("peminjam_id");
            String nim = resultSet.getString("nim");
            String nama = resultSet.getString("nama");
            String judulBuku = resultSet.getString("judul");
            String penerbitBuku = resultSet.getString("penerbit");
            String tanggalPeminjaman = resultSet.getString("tanggalpeminjam");
            String tanggalPengembalian = resultSet.getString("tanggalpengembalian");
            boolean status = resultSet.getBoolean("status");

            // Menentukan status peminjaman sesuai dengan yang diinginkan
            String statusPeminjaman;
            if (status) {
                statusPeminjaman = "Sudah Selesai";
            } else {
                SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                Date datePengembalian = dbDateFormat.parse(tanggalPengembalian);

                if (datePengembalian != null && datePengembalian.before(currentDate)) {
                    statusPeminjaman = "Overdue";
                } else {
                    statusPeminjaman = "Ongoing";
                }
            }

            // Menambahkan data ke dalam JTable
            model.addRow(new Object[]{no, peminjamId, nim, nama, judulBuku, penerbitBuku, tanggalPeminjaman, tanggalPengembalian, statusPeminjaman});

            // Increment nomor urut
            no++;
        }

        // Menutup koneksi dan statement
        resultSet.close();
        statement.close();

    } catch (SQLException | ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal melakukan pencarian data peminjam!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Mengatur kolom ID agar tersembunyi
    TableColumn idColumn = peminjamView.getTablePeminjam().getColumnModel().getColumn(1);
    idColumn.setMinWidth(0);
    idColumn.setMaxWidth(0);
    idColumn.setWidth(0);
    idColumn.setPreferredWidth(0);

    // Mengatur semua kolom agar data berada di tengah
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
    for (int i = 0; i < peminjamView.getTablePeminjam().getColumnCount(); i++) {
        peminjamView.getTablePeminjam().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
    }

    // Mengatur header kolom agar berada di tengah
    DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) peminjamView.getTablePeminjam().getTableHeader().getDefaultRenderer();
    headerRenderer.setHorizontalAlignment(JLabel.CENTER);

    // Menampilkan garis-garis pada tabel
    peminjamView.getTablePeminjam().setShowGrid(true);
    peminjamView.getTablePeminjam().setShowHorizontalLines(true);
    peminjamView.getTablePeminjam().setGridColor(Color.BLACK);
}

    public void tampilComboBoxNama(JComboBox<String> comboBoxNama) {
        comboBoxNama.removeAllItems(); // Menghapus semua item dari JComboBox sebelum menambahkan data baru

        // Mengambil koneksi database dari kelas MySQL
        Connection connection = MySQL.getConnection();

        // Query untuk mengambil data Nama dan Nim dari tabel Mahasiswa
        String query = "SELECT nama, nim FROM Mahasiswa";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Loop untuk membaca data dari hasil query dan menambahkannya ke JComboBox
            while (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String nim = resultSet.getString("nim");

                // Format data Nama dan Nim menjadi "Nama - Nim"
                String namaNimFormatted = nama + " - " + nim;

                // Tambahkan data ke dalam JComboBox
                comboBoxNama.addItem(namaNimFormatted);
            }

            // Menutup koneksi dan statement
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengambil data mahasiswa dari database!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void tampilComboBoxBuku(JComboBox<String> comboBoxBuku) {
    comboBoxBuku.removeAllItems(); // Menghapus semua item dari JComboBox sebelum menambahkan data baru

    // Mengambil koneksi database dari kelas MySQL
    Connection connection = MySQL.getConnection();

    // Query untuk mengambil semua data buku dari tabel Buku
    String queryBuku = "SELECT buku_id, judul, isbn FROM Buku";

    // Query untuk mengambil data buku yang sedang dipinjam dari tabel Peminjam
    String queryPeminjam = "SELECT DISTINCT buku_id FROM Peminjam WHERE status = false";

    try {
        // Mengambil data semua buku dari tabel Buku
        PreparedStatement statementBuku = connection.prepareStatement(queryBuku);
        ResultSet resultSetBuku = statementBuku.executeQuery();

        // Menghapus data buku yang sedang dipinjam dari data buku utama
        while (resultSetBuku.next()) {
            int bukuId = resultSetBuku.getInt("buku_id");

            // Cek apakah buku dengan bukuId sedang dipinjam
            PreparedStatement statementPeminjam = connection.prepareStatement(queryPeminjam);
            ResultSet resultSetPeminjam = statementPeminjam.executeQuery();

            boolean isDipinjam = false;
            while (resultSetPeminjam.next()) {
                int peminjamBukuId = resultSetPeminjam.getInt("buku_id");
                if (bukuId == peminjamBukuId) {
                    isDipinjam = true;
                    break;
                }
            }

            // Jika buku tidak sedang dipinjam, tambahkan ke dalam JComboBox
            if (!isDipinjam) {
                String judulBuku = resultSetBuku.getString("judul");
                String isbn = resultSetBuku.getString("isbn");
                // Format data Judul Buku dan ISBN menjadi "Judul Buku - ISBN"
                String judulBukuISBNFormatted = judulBuku + " - " + isbn;
                // Tambahkan data ke dalam JComboBox
                comboBoxBuku.addItem(judulBukuISBNFormatted);
            }
        }

        // Menutup koneksi dan statement
        resultSetBuku.close();
        statementBuku.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengambil data buku dari database!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // Method untuk mendapatkan ID mahasiswa berdasarkan NIM
    private int getIdMahasiswaFromDatabase(String nim) {
    int mahasiswaId = -1; // Default ID -1 menandakan tidak ditemukan

    try {
        Connection connection = MySQL.getConnection();

        // Query untuk mendapatkan ID mahasiswa berdasarkan NIM
        String query = "SELECT mahasiswa_id FROM Mahasiswa WHERE nim = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nim);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            mahasiswaId = resultSet.getInt("mahasiswa_id");
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan data mahasiswa dari database!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return mahasiswaId;
}

    // Method untuk mendapatkan ID buku berdasarkan judul dan ISBN
    private int getIdBukuFromDatabase(String judul, String isbn) {
    int bukuId = -1; // Default ID -1 menandakan tidak ditemukan

    try {
        Connection connection = MySQL.getConnection();

        // Query untuk mendapatkan ID buku berdasarkan judul dan ISBN
        String query = "SELECT buku_id FROM Buku WHERE judul = ? AND isbn = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, judul);
        statement.setString(2, isbn);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            bukuId = resultSet.getInt("buku_id");
        }

        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mendapatkan data buku dari database!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return bukuId;
}

    // Method untuk melakukan print data dari JTable ke printer atau tampilan preview
    public void printData() {
        JTable table = peminjamView.getTablePeminjam();
        String htmlTable = generateHTMLTableFromJTable(table);

        // Tampilkan tampilan preview dalam JDialog
        JDialog previewDialog = new JDialog(peminjamView, "Preview Tabel", true);
        previewDialog.setLayout(new BorderLayout());

        JTextPane previewPane = new JTextPane();
        previewPane.setContentType("text/html");
        previewPane.setText(htmlTable);
        previewPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(previewPane);
        previewDialog.add(scrollPane, BorderLayout.CENTER);

        JButton printButton = new JButton("Print");
        printButton.addActionListener(e -> {
            // Lakukan print data
            try {
                boolean complete = previewPane.print();
                if (complete) {
                    JOptionPane.showMessageDialog(null, "Print berhasil.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Print dibatalkan atau gagal.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error while printing.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            previewDialog.dispose(); // Tutup preview setelah mencetak
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(printButton);
        previewDialog.add(buttonPanel, BorderLayout.SOUTH);

        previewDialog.pack();
        previewDialog.setLocationRelativeTo(peminjamView);
        previewDialog.setVisible(true);
    }

    // Method untuk menghasilkan tampilan HTML dari JTable dengan judul "Table Peminjam" dan gaya CSS
    public String generateHTMLTableFromJTable(JTable table) {
    int numRows = table.getRowCount();
    int numCols = table.getColumnCount();

    StringBuilder sb = new StringBuilder();
    sb.append("<html><head><style>");
    sb.append("table {");
    sb.append("  border-collapse: collapse;");
    sb.append("  width: 100%;");
    sb.append("}");
    sb.append("th, td {");
    sb.append("  border: 1px solid black;");
    sb.append("  padding: 8px;");
    sb.append("}");
    sb.append("th {");
    sb.append("  background-color: #f2f2f2;");
    sb.append("}");
    sb.append(".table-title {"); // CSS untuk judul tabel
    sb.append("  font-size: 20px;");
    sb.append("  font-weight: bold;");
    sb.append("  text-align: center;");
    sb.append("  margin-bottom: 20px;");
    sb.append("}");
    sb.append("</style></head><body>");

    // Menambahkan judul tabel
    sb.append("<div class='table-title'>Table Peminjam</div>");

    // Membuat tabel
    sb.append("<table>");

    // Menambahkan header kolom
    sb.append("<tr>");
    for (int col = 0; col < numCols; col++) {
        sb.append("<th>").append(table.getColumnName(col)).append("</th>");
    }
    sb.append("</tr>");

    // Menambahkan data baris
    for (int row = 0; row < numRows; row++) {
        sb.append("<tr>");
        for (int col = 0; col < numCols; col++) {
            sb.append("<td>").append(table.getValueAt(row, col)).append("</td>");
        }
        sb.append("</tr>");
    }

    sb.append("</table></body></html>");
    return sb.toString();
}

}
