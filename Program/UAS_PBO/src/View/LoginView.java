
package View;

import Controller.LoginCtrl;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginView extends javax.swing.JFrame {

    private LoginCtrl loginCtrl;
    
    
    public LoginView() {
        initComponents();
        
        loginCtrl = new LoginCtrl(this);
        
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JCheckBox getCheckboxPassword() {
        return checkboxPassword;
    }

    public JPasswordField getFieldPassword() {
        return fieldPassword;
    }

    public JTextField getFieldUsername() {
        return fieldUsername;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldUsername = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JPasswordField();
        checkboxPassword = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("E-Library Information System");
        setResizable(false);
        setSize(new java.awt.Dimension(1368, 770));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldUsername.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldUsername.setBorder(null);
        fieldUsername.setOpaque(false);
        getContentPane().add(fieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(843, 322, 242, 25));

        fieldPassword.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        fieldPassword.setBorder(null);
        fieldPassword.setOpaque(false);
        getContentPane().add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(843, 375, 242, 25));

        checkboxPassword.setBorder(null);
        checkboxPassword.setContentAreaFilled(false);
        checkboxPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkboxPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(checkboxPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 407, -1, -1));

        btnLogin.setBorder(null);
        btnLogin.setContentAreaFilled(false);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1014, 456, 72, 29));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1368, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        loginCtrl.login();
    }//GEN-LAST:event_btnLoginMouseClicked

    private void checkboxPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkboxPasswordMouseClicked
        loginCtrl.showPassword();
    }//GEN-LAST:event_checkboxPasswordMouseClicked

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox checkboxPassword;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
