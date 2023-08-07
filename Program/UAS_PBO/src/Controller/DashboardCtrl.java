package Controller;

import View.BukuView;
import View.DashboardView;
import View.MhsView;
import View.PeminjamView;
import View.SettingView;
import View.AboutView;
import javax.swing.JOptionPane;

public class DashboardCtrl {
    
    private BukuCtrl bukuCtrl;
    private BukuView bukuView;
        
    private MhsCtrl mhsCtrl;
    private MhsView mhsView;

    private PeminjamCtrl peminjamCtrl;
    private PeminjamView peminjamView;
    
    private SettingView settingView;
    private AboutView aboutView;

    public DashboardCtrl(BukuView bukuView) {
        this.bukuView = bukuView;
    }
    public DashboardCtrl(MhsView mhsView){
        this.mhsView = mhsView;
    }
    public DashboardCtrl(PeminjamView peminjamView){
        this.peminjamView = peminjamView;
        this.peminjamCtrl = new PeminjamCtrl(peminjamView);
    }
    
    public DashboardCtrl(BukuCtrl bukuCtrl, MhsCtrl mhsCtrl,PeminjamCtrl peminjamCtrl) {
        this.bukuCtrl = bukuCtrl;
        this.mhsCtrl = mhsCtrl;
        this.peminjamCtrl = peminjamCtrl;
    } 

    
    public void setBukuView(BukuView bukuView) {
        this.bukuView = bukuView;
    }

    public void setMhsView(MhsView mhsView) {
        this.mhsView = mhsView;
    }

    public void setPeminjamView(PeminjamView peminjamView) {
        this.peminjamView = peminjamView;
    }

    public void setSettingView(SettingView settingView) {
        this.settingView = settingView;
    }
    public void setAboutView(AboutView aboutView) {
        this.aboutView = aboutView;
    }

    
    public void tampilHalamanHome(DashboardView view) {
    view.getMainPanel().removeAll();
    view.getMainPanel().repaint();
    view.getMainPanel().revalidate();

   
}
    
    public void tampilHalamanAbout(DashboardView view) {
        view.getMainPanel().removeAll();
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();

        // Gunakan variabel instance bukuView yang telah diinisialisasi sebelumnya
        view.getMainPanel().add(aboutView.getMainPanel());
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();

    }

    public void tampilHalamanBuku(DashboardView view) {
        view.getMainPanel().removeAll();
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();

        // Gunakan variabel instance bukuView yang telah diinisialisasi sebelumnya
        view.getMainPanel().add(bukuView.getMainPanel());
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();

        // Access the text fields only if bukuView is not null
        if (bukuView != null) {
            bukuView.getFieldJudul().setText(null);
            bukuView.getFieldIsbn().setText(null);
            bukuView.getFieldPenerbit().setText(null);
            bukuView.getFieldPenulis().setText(null);
            bukuView.getFieldSearch().setText(null);
            bukuView.getDateTahunTerbit().setDate(null);
        }

        // Call tampilDataBuku method from bukuCtrl if it is not null
        if (bukuCtrl != null) {
            bukuCtrl.tampilDataBuku();
        }
    }

    public void tampilHalamanMhs(DashboardView view) {
        view.getMainPanel().removeAll();
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();

        view.getMainPanel().add(mhsView.getMainPanel());
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();
        
        if (mhsView != null){
            mhsView.getFieldJurusan().setText(null);
            mhsView.getFieldKelas().setText(null);
            mhsView.getFieldNama().setText(null);
            mhsView.getFieldNim().setText(null);
            mhsView.getFieldNomorTlp().setText(null);
            mhsView.getFieldSearch().setText(null);
            mhsView.getTextAlamat().setText(null);
            mhsView.getDateTanggalLahir().setDate(null);
        }
        
        if (mhsCtrl != null){
            mhsCtrl.tampilDataMhs();
        }
    }

    public void tampilHalamanPeminjam(DashboardView view) {
    view.getMainPanel().removeAll();
    view.getMainPanel().repaint();
    view.getMainPanel().revalidate();

    view.getMainPanel().add(peminjamView.getMainPanel());
    view.getMainPanel().repaint();
    view.getMainPanel().revalidate();

    if (peminjamView != null) {
        // Mengatur combo box nama ke index pertama
        peminjamView.getComboNama().setSelectedIndex(0);

        // Mengatur combo box buku ke index pertama
        peminjamView.getComboBuku().setSelectedIndex(0);

        // Mengatur tanggal pada JDateChooser menjadi null
        peminjamView.getDateTanggalPmb().setDate(null);
        peminjamView.getDateTanggalPmj().setDate(null);
        peminjamView.getFieldSearch().setText(null);
    }

    if (peminjamCtrl != null) {
        peminjamCtrl.tampilDataPeminjam();
        peminjamCtrl.tampilComboBoxNama(peminjamView.getComboNama()); // Panggil method tampilComboBoxNama dengan parameter
        peminjamCtrl.tampilComboBoxBuku(peminjamView.getComboBuku());
    }
}

    public void tampilHalamanSetting(DashboardView view) {
        view.getMainPanel().removeAll();
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();

        view.getMainPanel().add(settingView.getMainPanel());
        view.getMainPanel().repaint();
        view.getMainPanel().revalidate();
        settingView.getFieldUser().setText(null);
        settingView.getFieldPasswordLama().setText(null);
        settingView.getFieldPasswordBaru().setText(null);
        settingView.getFieldKonfirmasi().setText(null);
        settingView.getCheckBoxPassword().setSelected(false);
    }

    public void logout(DashboardView view) {
        int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar dari aplikasi?", "Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Jika user memilih OK, keluar dari aplikasi
            System.exit(0);
        } else {
            // Jika user memilih Cancel, tidak melakukan apa-apa
        }
    }

}
