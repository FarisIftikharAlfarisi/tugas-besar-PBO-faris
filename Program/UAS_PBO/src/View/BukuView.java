
package View;

import Controller.BukuCtrl;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class BukuView extends javax.swing.JFrame {

    private final BukuCtrl bukuCtrl;
    
    public BukuView() {
        initComponents();
        
        bukuCtrl = new BukuCtrl(this);
        bukuCtrl.tampilDataBuku();
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

    public JDateChooser getDateTahunTerbit() {
        return dateTahunTerbit;
    }

    public JTextField getFieldIsbn() {
        return fieldIsbn;
    }

    public JTextField getFieldJudul() {
        return fieldJudul;
    }

    public JTextField getFieldPenerbit() {
        return fieldPenerbit;
    }

    public JTextField getFieldPenulis() {
        return fieldPenulis;
    }

    public JTextField getFieldSearch() {
        return fieldSearch;
    }

    public JTable getTableBuku() {
        return tableBuku;
    }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        fieldJudul = new javax.swing.JTextField();
        fieldPenerbit = new javax.swing.JTextField();
        fieldPenulis = new javax.swing.JTextField();
        fieldIsbn = new javax.swing.JTextField();
        fieldSearch = new javax.swing.JTextField();
        dateTahunTerbit = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1154, 703));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldJudul.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldJudul.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 137, 300, 32));

        fieldPenerbit.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldPenerbit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldPenerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 188, 300, 32));

        fieldPenulis.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldPenulis.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldPenulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 238, 300, 32));

        fieldIsbn.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldIsbn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 289, 300, 32));

        fieldSearch.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldSearch.setBorder(null);
        fieldSearch.setOpaque(false);
        fieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldSearchKeyPressed(evt);
            }
        });
        MainPanel.add(fieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(521, 137, 277, 24));

        dateTahunTerbit.setOpaque(false);
        MainPanel.add(dateTahunTerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 338, 300, 32));

        tableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "ID", "PENULIS", "PENERBIT", "ISBN", "JUDUL", "THN.TERBIT"
            }
        ));
        tableBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBuku);

        MainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 660, 510));

        btnClear.setBorder(null);
        btnClear.setContentAreaFilled(false);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        MainPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 391, 74, 29));

        btnTambah.setBorder(null);
        btnTambah.setContentAreaFilled(false);
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        MainPanel.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 391, 72, 29));

        btnHapus.setBorder(null);
        btnHapus.setContentAreaFilled(false);
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        MainPanel.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 135, 84, 29));

        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        MainPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1018, 135, 73, 29));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DataBuku.png"))); // NOI18N
        MainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        bukuCtrl.clearForm();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        bukuCtrl.tambahData();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        bukuCtrl.hapusDataBuku();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        bukuCtrl.updateDataBuku();
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void tableBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBukuMouseClicked
        bukuCtrl.tampilkanDataBukuKeForm();
    }//GEN-LAST:event_tableBukuMouseClicked

    private void fieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldSearchKeyPressed
        bukuCtrl.searchDataBuku();
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
            java.util.logging.Logger.getLogger(BukuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BukuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BukuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BukuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BukuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser dateTahunTerbit;
    private javax.swing.JTextField fieldIsbn;
    private javax.swing.JTextField fieldJudul;
    private javax.swing.JTextField fieldPenerbit;
    private javax.swing.JTextField fieldPenulis;
    private javax.swing.JTextField fieldSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBuku;
    // End of variables declaration//GEN-END:variables
}
