
package View;

import Controller.MhsCtrl;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MhsView extends javax.swing.JFrame {

    private final MhsCtrl mhsCtrl;
    
    public MhsView() {
        initComponents();
        
        mhsCtrl = new MhsCtrl(this);
        mhsCtrl.tampilDataMhs();
        
        
    }
    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JButton getBtnHapus() {
        return btnHapus;
    }

    public JButton getBtnTambah() {
        return btnTambah;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JDateChooser getDateTanggalLahir() {
        return dateTanggalLahir;
    }

    public JTextField getFieldJurusan() {
        return fieldJurusan;
    }

    public JTextField getFieldKelas() {
        return fieldKelas;
    }

    public JTextField getFieldNama() {
        return fieldNama;
    }

    public JTextField getFieldNim() {
        return fieldNim;
    }

    public JTextField getFieldNomorTlp() {
        return fieldNomorTlp;
    }

    public JTextField getFieldSearch() {
        return fieldSearch;
    }

    public JTable getTableMhs() {
        return tableMhs;
    }

    public JTextArea getTextAlamat() {
        return textAlamat;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        fieldNomorTlp = new javax.swing.JTextField();
        fieldNim = new javax.swing.JTextField();
        fieldNama = new javax.swing.JTextField();
        fieldKelas = new javax.swing.JTextField();
        fieldJurusan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();
        dateTanggalLahir = new com.toedter.calendar.JDateChooser();
        fieldSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMhs = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1154, 703));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldNomorTlp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldNomorTlp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldNomorTlp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 353, 300, 32));

        fieldNim.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldNim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldNim, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 144, 300, 32));

        fieldNama.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldNama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 198, 300, 32));

        fieldKelas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldKelas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 300, 32));

        fieldJurusan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldJurusan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldJurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 300, 32));

        textAlamat.setColumns(20);
        textAlamat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        textAlamat.setRows(2);
        jScrollPane1.setViewportView(textAlamat);

        MainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 300, 80));

        dateTanggalLahir.setOpaque(false);
        MainPanel.add(dateTanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 502, 300, 32));

        fieldSearch.setBorder(null);
        fieldSearch.setOpaque(false);
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldSearchKeyPressed(evt);
            }
        });
        MainPanel.add(fieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 145, 279, 25));

        tableMhs.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "ID", "NIM", "NAMA", "JURUSAN", "KELAS", "NO.HP", "ALAMAT", "TGL.LAHIR"
            }
        ));
        tableMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMhsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMhs);

        MainPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 670, 510));

        btnClear.setBorder(null);
        btnClear.setContentAreaFilled(false);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        MainPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 575, 74, 29));

        btnTambah.setBorder(null);
        btnTambah.setContentAreaFilled(false);
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        MainPanel.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 575, 71, 29));

        btnHapus.setBorder(null);
        btnHapus.setContentAreaFilled(false);
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        MainPanel.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(929, 144, 84, 29));

        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        MainPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 144, 74, 29));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DataMahasiswa.png"))); // NOI18N
        MainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        mhsCtrl.clearForm();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        mhsCtrl.tambahDataMhs();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        mhsCtrl.hapusDataMhs();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        mhsCtrl.updateDataMhs();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void fieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyPressed
        mhsCtrl.searchDataMhs();
    }//GEN-LAST:event_fieldSearchKeyPressed

    private void tableMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMhsMouseClicked
        mhsCtrl.tampilkanDataMhsKeForm();
    }//GEN-LAST:event_tableMhsMouseClicked

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
            java.util.logging.Logger.getLogger(MhsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MhsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MhsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MhsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MhsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dateTanggalLahir;
    private javax.swing.JTextField fieldJurusan;
    private javax.swing.JTextField fieldKelas;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNim;
    private javax.swing.JTextField fieldNomorTlp;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableMhs;
    private javax.swing.JTextArea textAlamat;
    // End of variables declaration//GEN-END:variables
}
