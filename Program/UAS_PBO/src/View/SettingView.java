
package View;

import Controller.SettingCtrl;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class SettingView extends javax.swing.JFrame {


    private final SettingCtrl settingCtrl;
    
    public SettingView() {
        initComponents();
        
        settingCtrl = new SettingCtrl(this);
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JCheckBox getCheckBoxPassword() {
        return checkBoxPassword;
    }

    public JPasswordField getFieldKonfirmasi() {
        return fieldKonfirmasi;
    }

    public JPasswordField getFieldPasswordBaru() {
        return fieldPasswordBaru;
    }

    public JPasswordField getFieldPasswordLama() {
        return fieldPasswordLama;
    }

    

    public JTextField getFieldUser() {
        return fieldUser;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        fieldUser = new javax.swing.JTextField();
        fieldPasswordLama = new javax.swing.JPasswordField();
        fieldPasswordBaru = new javax.swing.JPasswordField();
        fieldKonfirmasi = new javax.swing.JPasswordField();
        checkBoxPassword = new javax.swing.JCheckBox();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1154, 703));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 145, 300, 32));

        fieldPasswordLama.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldPasswordLama.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldPasswordLama, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 202, 300, 32));

        fieldPasswordBaru.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldPasswordBaru.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldPasswordBaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 258, 300, 32));

        fieldKonfirmasi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldKonfirmasi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MainPanel.add(fieldKonfirmasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 314, 300, 32));

        checkBoxPassword.setBorder(null);
        checkBoxPassword.setContentAreaFilled(false);
        checkBoxPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxPasswordMouseClicked(evt);
            }
        });
        MainPanel.add(checkBoxPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 364, -1, -1));

        btnClear.setBorder(null);
        btnClear.setContentAreaFilled(false);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });
        MainPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 415, 74, 29));

        btnUpdate.setBorder(null);
        btnUpdate.setContentAreaFilled(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        MainPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 415, 70, 28));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Setting.png"))); // NOI18N
        MainPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1154, 703));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxPasswordMouseClicked
        settingCtrl.showPassword();
    }//GEN-LAST:event_checkBoxPasswordMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        settingCtrl.ClearForm();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        settingCtrl.updatePassword();
    }//GEN-LAST:event_btnUpdateMouseClicked

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
            java.util.logging.Logger.getLogger(SettingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox checkBoxPassword;
    private javax.swing.JPasswordField fieldKonfirmasi;
    private javax.swing.JPasswordField fieldPasswordBaru;
    private javax.swing.JPasswordField fieldPasswordLama;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
