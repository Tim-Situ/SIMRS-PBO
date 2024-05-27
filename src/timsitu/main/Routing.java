package timsitu.main;

import timsitu.models.User;
import timsitu.models.UserSessions;
import timsitu.pages.DashboardPage;
import timsitu.pages.LoginPage;
import timsitu.pages.MainPage;
import timsitu.pages.apoteker.ApotekerPage;
import timsitu.pages.dokter.DokterPage;
import timsitu.pages.jadwal.JadwalPage;
import timsitu.pages.obat.ObatPage;
import timsitu.pages.obat.PengambilanObatPage;
import timsitu.pages.pasien.PasienPage;
import timsitu.pages.pemeriksaan.PemeriksaanPage;
import timsitu.pages.pendaftaran.PendaftaranAdminPage;
import timsitu.pages.poliklinik.PoliklinikPage;
import timsitu.pages.transaksi.FormTransaksiPage;

public class Routing {
    
    private MainPage mainPage;
    private DashboardPage dashboard;
    private ObatPage obatPage;
    private PasienPage pasienPage;
    private DokterPage dokterPage;
    private ApotekerPage apotekerPage;
    private PendaftaranAdminPage pendaftaranAdmin;
    private FormTransaksiPage formTransaksiPage;
    private PoliklinikPage poliklinikPage;

    public Routing(MainPage mainPage) {
        this.mainPage = mainPage;
        this.dashboard = new DashboardPage();
        this.obatPage = new ObatPage();
        this.pasienPage = new PasienPage();
        this.dokterPage = new DokterPage();
        this.apotekerPage = new ApotekerPage();
        this.pendaftaranAdmin = new PendaftaranAdminPage();
        this.formTransaksiPage = new FormTransaksiPage();
        this.poliklinikPage = new PoliklinikPage();
    }

    public void handleSelection(int index) {
        if (UserSessions.getRole() == User.EnumRole.ADMIN){
            switch (index) {
                case 0:
                    MainPage.setForm(dashboard);
                    break;
                case 1:
                    MainPage.setForm(pendaftaranAdmin);
                    break;
                case 2:
                    MainPage.setForm(formTransaksiPage);
                    break;
                case 3:
                    MainPage.setForm(new JadwalPage());
                    break;
                case 7:
                    MainPage.setForm(pasienPage);
                    break;
                case 8:
                    MainPage.setForm(dokterPage);
                    break;
                case 9:
                    MainPage.setForm(apotekerPage);
                    break;
                case 10:
                    MainPage.setForm(obatPage);
                    break;
                case 11:
                    MainPage.setForm(poliklinikPage);
                    break;
                case 15:
                    LoginPage loginPage = new LoginPage();
                    UserSessions.setName(null);
                    UserSessions.setRole(null);
                    loginPage.setVisible(true);
                    mainPage.dispose();
                    break;
                default:
                    break;
            }
            
        } else if (UserSessions.getRole() == User.EnumRole.DOKTER) {
            switch (index) {
                case 0:
                    MainPage.setForm(dashboard);
                    break;
                case 1:
                    MainPage.setForm(new PemeriksaanPage());
                    break;
                case 5:
                    LoginPage loginPage = new LoginPage();
                    UserSessions.setName(null);
                    UserSessions.setRole(null);
                    loginPage.setVisible(true);
                    mainPage.dispose();
                    break;
                default:
                    break;
            }

        }else if (UserSessions.getRole() == User.EnumRole.APOTEKER) {
            switch (index) {
                case 0:
                    MainPage.setForm(dashboard);
                    break;
                case 1:
                    MainPage.setForm(new ObatPage());
                    break;
                case 2:
                    MainPage.setForm(new PengambilanObatPage());
                    break;
                case 6:
                    LoginPage loginPage = new LoginPage();
                    UserSessions.setName(null);
                    UserSessions.setRole(null);
                    loginPage.setVisible(true);
                    mainPage.dispose();
                    break;
                default:
                    break;
            }

        }
    }
}
