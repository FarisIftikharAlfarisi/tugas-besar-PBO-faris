package View;

import Controller.BukuCtrl;
import Controller.MhsCtrl;
import Controller.DashboardCtrl;
import Controller.PeminjamCtrl;
import java.awt.Color;
import javax.swing.JPanel;

public class DashboardView extends javax.swing.JFrame {

    DashboardCtrl dashboardCtrl;
    
   public DashboardView() {
        initComponents();

        BukuView bukuView = new BukuView();
        BukuCtrl bukuCtrl = new BukuCtrl(bukuView);

        MhsView mhsView = new MhsView();
        MhsCtrl mhsCtrl = new MhsCtrl(mhsView);
        
        PeminjamView peminjamView = new PeminjamView();
        PeminjamCtrl peminjamCtrl = new PeminjamCtrl(peminjamView);
       

        // Create a single instance of DashboardCtrl with both BukuCtrl and MhsCtrl
        dashboardCtrl = new DashboardCtrl(bukuCtrl, mhsCtrl, peminjamCtrl);

        dashboardCtrl.setBukuView(bukuView);
        dashboardCtrl.setMhsView(mhsView);
        dashboardCtrl.setPeminjamView(peminjamView);

        dashboardCtrl.setSettingView(new SettingView());
        dashboardCtrl.setAboutView(new AboutView());
        
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavbarPanel = new javax.swing.JPanel();
        MenuBuku = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        menuPmj = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MenuMhs = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        menuSetting = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        menuAbout = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        menuLogout = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        HeaderPanel = new javax.swing.JPanel();
        menuHome = new javax.swing.JPanel();
        MainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("E-Library Information System");
        setMinimumSize(new java.awt.Dimension(1368, 770));
        setResizable(false);
        setSize(new java.awt.Dimension(1368, 770));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavbarPanel.setOpaque(false);
        NavbarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuBuku.setBackground(new java.awt.Color(118, 154, 222));
        MenuBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuBukuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuBukuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuBukuMouseExited(evt);
            }
        });
        MenuBuku.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data Buku");
        MenuBuku.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 13, -1, -1));

        NavbarPanel.add(MenuBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 193, 50));

        menuPmj.setBackground(new java.awt.Color(118, 154, 222));
        menuPmj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPmjMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPmjMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPmjMouseExited(evt);
            }
        });
        menuPmj.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Peminjaman");
        menuPmj.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 13, -1, -1));

        NavbarPanel.add(menuPmj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, 193, 50));

        MenuMhs.setBackground(new java.awt.Color(118, 154, 222));
        MenuMhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMhsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuMhsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuMhsMouseExited(evt);
            }
        });
        MenuMhs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data Mahasiswa");
        MenuMhs.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, -1, -1));

        NavbarPanel.add(MenuMhs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 193, 50));

        menuSetting.setBackground(new java.awt.Color(118, 154, 222));
        menuSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSettingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuSettingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuSettingMouseExited(evt);
            }
        });
        menuSetting.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Setelan");
        menuSetting.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 13, -1, -1));

        NavbarPanel.add(menuSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 225, 193, 50));

        menuAbout.setBackground(new java.awt.Color(118, 154, 222));
        menuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAboutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuAboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuAboutMouseExited(evt);
            }
        });
        menuAbout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("About");
        menuAbout.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 13, -1, -1));

        NavbarPanel.add(menuAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 193, 50));

        menuLogout.setBackground(new java.awt.Color(118, 154, 222));
        menuLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuLogoutMouseExited(evt);
            }
        });
        menuLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Logout");
        menuLogout.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 13, -1, -1));

        NavbarPanel.add(menuLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 355, 193, 50));

        getContentPane().add(NavbarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 211, 634));

        HeaderPanel.setOpaque(false);
        HeaderPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuHome.setOpaque(false);
        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuHomeLayout = new javax.swing.GroupLayout(menuHome);
        menuHome.setLayout(menuHomeLayout);
        menuHomeLayout.setHorizontalGroup(
            menuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        menuHomeLayout.setVerticalGroup(
            menuHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        HeaderPanel.add(menuHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, 120, 45));

        getContentPane().add(HeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1365, 65));

        MainPanel.setOpaque(false);
        MainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 65, 1154, 703));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Dashboard.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1368, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBukuMouseClicked
        dashboardCtrl.tampilHalamanBuku(this);
    }//GEN-LAST:event_MenuBukuMouseClicked

    private void menuPmjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPmjMouseClicked
        dashboardCtrl.tampilHalamanPeminjam(this);
    }//GEN-LAST:event_menuPmjMouseClicked

    private void MenuMhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMhsMouseClicked
        dashboardCtrl.tampilHalamanMhs(this);
    }//GEN-LAST:event_MenuMhsMouseClicked

    private void menuSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSettingMouseClicked
        dashboardCtrl.tampilHalamanSetting(this);
    }//GEN-LAST:event_menuSettingMouseClicked

    private void menuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAboutMouseClicked
        dashboardCtrl.tampilHalamanAbout(this);
    }//GEN-LAST:event_menuAboutMouseClicked

    private void menuLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseClicked
        dashboardCtrl.logout(this);
    }//GEN-LAST:event_menuLogoutMouseClicked

    private void MenuBukuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBukuMouseEntered
        MenuBuku.setBackground(new java.awt.Color(30, 144, 255));
    }//GEN-LAST:event_MenuBukuMouseEntered

    private void MenuBukuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuBukuMouseExited
        MenuBuku.setBackground(new java.awt.Color(118, 154, 222));
    }//GEN-LAST:event_MenuBukuMouseExited

    private void menuPmjMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPmjMouseEntered
        menuPmj.setBackground(new java.awt.Color(30, 144, 255));
    }//GEN-LAST:event_menuPmjMouseEntered

    private void menuPmjMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPmjMouseExited
        menuPmj.setBackground(new java.awt.Color(118, 154, 222));
    }//GEN-LAST:event_menuPmjMouseExited

    private void MenuMhsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMhsMouseEntered
        MenuMhs.setBackground(new java.awt.Color(30, 144, 255));
    }//GEN-LAST:event_MenuMhsMouseEntered

    private void MenuMhsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMhsMouseExited
        MenuMhs.setBackground(new java.awt.Color(118, 154, 222));
    }//GEN-LAST:event_MenuMhsMouseExited

    private void menuSettingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSettingMouseEntered
        menuSetting.setBackground(new java.awt.Color(30, 144, 255));
    }//GEN-LAST:event_menuSettingMouseEntered

    private void menuSettingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSettingMouseExited
        menuSetting.setBackground(new java.awt.Color(118, 154, 222));
    }//GEN-LAST:event_menuSettingMouseExited

    private void menuAboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAboutMouseEntered
        menuAbout.setBackground(new java.awt.Color(30, 144, 255));
    }//GEN-LAST:event_menuAboutMouseEntered

    private void menuAboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAboutMouseExited
        menuAbout.setBackground(new java.awt.Color(118, 154, 222));
    }//GEN-LAST:event_menuAboutMouseExited

    private void menuLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseEntered
        menuLogout.setBackground(new java.awt.Color(30, 144, 255));
    }//GEN-LAST:event_menuLogoutMouseEntered

    private void menuLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogoutMouseExited
        menuLogout.setBackground(new java.awt.Color(118, 154, 222));
    }//GEN-LAST:event_menuLogoutMouseExited

    private void menuHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHomeMouseClicked
        dashboardCtrl.tampilHalamanHome(this);
    }//GEN-LAST:event_menuHomeMouseClicked

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
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MenuBuku;
    private javax.swing.JPanel MenuMhs;
    private javax.swing.JPanel NavbarPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel menuAbout;
    private javax.swing.JPanel menuHome;
    private javax.swing.JPanel menuLogout;
    private javax.swing.JPanel menuPmj;
    private javax.swing.JPanel menuSetting;
    // End of variables declaration//GEN-END:variables
}
