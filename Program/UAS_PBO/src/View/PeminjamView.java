
package View;

import Controller.PeminjamCtrl;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PeminjamView extends javax.swing.JFrame {


    private final PeminjamCtrl peminjamCtrl;
    
    public PeminjamView() {
        initComponents();
        
        peminjamCtrl = new PeminjamCtrl(this);
        peminjamCtrl.tampilComboBoxNama(comboNama);
        peminjamCtrl.tampilComboBoxBuku(comboBuku);
        peminjamCtrl.tampilDataPeminjam();
        
        
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JButton getBtnKonfirmasi() {
        return btnKonfirmasi;
    }

    public JButton getBtnPerpanjang() {
        return btnPerpanjang;
    }

    public JButton getBtnPrint() {
        return btnPrint;
    }

    public JButton getBtnTambah() {
        return btnTambah;
    }

    public JComboBox<String> getComboBuku() {
        return comboBuku;
    }

    public JComboBox<String> getComboNama() {
        return comboNama;
    }

    public JDateChooser getDateTanggalPmb() {
        return dateTanggalPmb;
    }

    public JDateChooser getDateTanggalPmj() {
        return dateTanggalPmj;
    }

    public JTextField getFieldSearch() {
        return fieldSearch;
    }

    public JTable getTablePeminjam() {
        return tablePeminjam;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        comboNama = new javax.swing.JComboBox<>();
        comboBuku = new javax.swing.JComboBox<>();
        dateTanggalPmj = new com.toedter.calendar.JDateChooser();
        dateTanggalPmb = new com.toedter.calendar.JDateChooser();
        btnClear = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePeminjam = new javax.swing.JTable();
        fieldSearch = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnKonfirmasi = new javax.swing.JButton();
        btnPerpanjang = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1154, 703));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboNama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNama.setBorder(null);
        comboNama.setOpaque(false);
        MainPanel.add(comboNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 145, 300, 32));

        comboBuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBuku.setBorder(null);
        comboBuku.setOpaque(false);
        MainPanel.add(comboBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 198, 300, 32));

        dateTanggalPmj.setOpaque(false);
        MainPanel.add(dateTanggalPmj, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 251, 300, 32));

        dateTanggalPmb.setOpaque(false);
        MainPanel.add(dateTanggalPmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 304, 300, 32));

        btnClear.setBorder(null);
        btnClear.setContentAreaFilled(false);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        MainPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 376, 73, 27));

        btnTambah.setBorder(null);
        btnTambah.setContentAreaFilled(false);
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        MainPanel.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 375, 72, 28));

        tablePeminjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "ID", "NIM", "NAMA", "BUKU", "PENERBIT", "TGL.DIPINJAM", "TGL.PENGEMBALIAN", "STATUS"
            }
        ));
        tablePeminjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePeminjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePeminjam);

        MainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 660, 510));

        fieldSearch.setBorder(null);
        fieldSearch.setOpaque(false);
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldSearchKeyPressed(evt);
            }
        });
        MainPanel.add(fieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 145, 285, 24));

        btnPrint.setBorder(null);
        btnPrint.setContentAreaFilled(false);
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
        });
        MainPanel.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 145, 76, 28));

        btnKonfirmasi.setBorder(null);
        btnKonfirmasi.setContentAreaFilled(false);
        btnKonfirmasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKonfirmasiMouseClicked(evt);
            }
        });
        MainPanel.add(btnKonfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(909, 145, 98, 28));

        btnPerpanjang.setBorder(null);
        btnPerpanjang.setContentAreaFilled(false);
        btnPerpanjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerpanjangMouseClicked(evt);
            }
        });
        MainPanel.add(btnPerpanjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1018, 145, 103, 28));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Peminjaman.png"))); // NOI18N
        MainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        peminjamCtrl.clearForm();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        peminjamCtrl.tambahDataPeminjam();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        peminjamCtrl.printData();
    }//GEN-LAST:event_btnPrintMouseClicked

    private void btnKonfirmasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKonfirmasiMouseClicked
        peminjamCtrl.konfirmasi();
    }//GEN-LAST:event_btnKonfirmasiMouseClicked

    private void btnPerpanjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerpanjangMouseClicked
        peminjamCtrl.PerpanjangPinjaman();
    }//GEN-LAST:event_btnPerpanjangMouseClicked

    private void tablePeminjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePeminjamMouseClicked
        peminjamCtrl.generateHTMLTableFromJTable(tablePeminjam);
    }//GEN-LAST:event_tablePeminjamMouseClicked

    private void fieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyPressed
        peminjamCtrl.searchDataPeminjam();
    }//GEN-LAST:event_fieldSearchKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PeminjamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeminjamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeminjamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeminjamView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeminjamView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JButton btnPerpanjang;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> comboBuku;
    private javax.swing.JComboBox<String> comboNama;
    private com.toedter.calendar.JDateChooser dateTanggalPmb;
    private com.toedter.calendar.JDateChooser dateTanggalPmj;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePeminjam;
    // End of variables declaration//GEN-END:variables
}
