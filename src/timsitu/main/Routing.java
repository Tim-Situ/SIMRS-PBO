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
import timsitu.pages.reservasi.ReservasiByAdminPage;
import timsitu.pages.poliklinik.PoliklinikPage;
import timsitu.pages.transaksi.FormTransaksiPage;
import timsitu.pages.transaksi.TransaksiPage;

public class Routing {
    
    private MainPage mainPage;
    private DashboardPage dashboard;
    private ObatPage obatPage;
    private PasienPage pasienPage;
    private DokterPage dokterPage;
    private ApotekerPage apotekerPage;
    private ReservasiByAdminPage pendaftaranAdmin;
    private FormTransaksiPage formTransaksiPage;
    private PoliklinikPage poliklinikPage;

    public Routing(MainPage mainPage) {
        this.mainPage = mainPage;
        this.dashboard = new DashboardPage();
        this.obatPage = new ObatPage();
        this.pasienPage = new PasienPage();
        this.dokterPage = new DokterPage();
        this.apotekerPage = new ApotekerPage();
        this.pendaftaranAdmin = new ReservasiByAdminPage();
        this.formTransaksiPage = new FormTransaksiPage();
        this.poliklinikPage = new PoliklinikPage();
    }

    public void handleSelection(int index) {
        if (UserSessions.getRole() == User.EnumRole.ADMIN){
            switch (index) {
                case 0:
                    MainPage.setForm(new DashboardPage());
                    break;
                case 1:
                    MainPage.setForm(new ReservasiByAdminPage());
                    break;
                case 2:
                    MainPage.setForm(new TransaksiPage());
                    break;
                case 3:
                    MainPage.setForm(new JadwalPage());
                    break;
                case 7:
                    MainPage.setForm(new PasienPage());
                    break;
                case 8:
                    MainPage.setForm(new DokterPage());
                    break;
                case 9:
                    MainPage.setForm(new ApotekerPage());
                    break;
                case 10:
                    MainPage.setForm(new ObatPage());
                    break;
                case 11:
                    MainPage.setForm(new PoliklinikPage());
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
                    MainPage.setForm(new DashboardPage());
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
                    MainPage.setForm(new DashboardPage());
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
