package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;

public class Transaksi {
    private String kode;
    private String kodePemeriksaan;
    private String tanggal;
    private String pasien;
    private String dokter;
    private int totalBiaya;
    private int uangBayar;

    public Transaksi(String kode, String kodePemeriksaan, int totalBiaya, int uangBayar) {
        this.kode = kode;
        this.kodePemeriksaan = kodePemeriksaan;
        this.totalBiaya = totalBiaya;
        this.uangBayar = uangBayar;
    }

    public Transaksi(String kode, String kodePemeriksaan, String tanggal, String pasien, String dokter, int totalBiaya, int uangBayar) {
        this.kode = kode;
        this.kodePemeriksaan = kodePemeriksaan;
        this.tanggal = tanggal;
        this.pasien = pasien;
        this.dokter = dokter;
        this.totalBiaya = totalBiaya;
        this.uangBayar = uangBayar;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKodePemeriksaan() {
        return kodePemeriksaan;
    }

    public void setKodePemeriksaan(String kodePemeriksaan) {
        this.kodePemeriksaan = kodePemeriksaan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getPasien() {
        return pasien;
    }

    public void setPasien(String pasien) {
        this.pasien = pasien;
    }

    public String getDokter() {
        return dokter;
    }

    public void setDokter(String dokter) {
        this.dokter = dokter;
    }

    public int getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(int totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public int getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(int uangBayar) {
        this.uangBayar = uangBayar;
    }

    public static ArrayList<Transaksi> getAllData(){
        ArrayList<Transaksi> dataTransaksi = new ArrayList();
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT "
                    + "trs.kode_transaksi, prs.kode_pemeriksaan, rsv.tanggal AS tanggal_reservasi, up.nama AS nama_pasien, ud.nama AS nama_dokter, trs.total_biaya, trs.uang_bayar "
                    + "FROM transaksi trs "
                    + "INNER JOIN pemeriksaan prs ON prs.kode_pemeriksaan = trs.kode_pemeriksaan "
                    + "INNER JOIN reservasi rsv ON rsv.kode_reservasi = prs.kode_reservasi "
                    + "INNER JOIN pasien psn ON rsv.kode_pasien = psn.kode_pasien "
                    + "INNER JOIN user up ON up.id = psn.id_user "
                    + "INNER JOIN jadwal jdwl ON jdwl.kode_jadwal = rsv.kode_jadwal "
                    + "INNER JOIN dokter dkt ON dkt.kode_dokter = jdwl.kode_dokter "
                    + "INNER JOIN user ud ON ud.id = dkt.id_user";
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                
                Transaksi data = new Transaksi(rs.getString("kode_transaksi"), rs.getString("kode_pemeriksaan"), rs.getString("tanggal_reservasi"), rs.getString("nama_pasien"), rs.getString("nama_dokter"), rs.getInt("total_biaya"), rs.getInt("uang_bayar"));
                dataTransaksi.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataTransaksi;
    }
    
    public void simpanData()throws SQLException {  
        ConnectionDB db = new ConnectionDB();        
        String sql = "INSERT INTO transaksi VALUES (" + null + ", '" + kode + "', '" + kodePemeriksaan + "', " + totalBiaya + ", " + uangBayar + ")";
        db.query(sql); 
    }
    
    public static String generateKode(){
        
        String kode_transaksi = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_transaksi, 1)) AS kode FROM transaksi";
            ResultSet rs = db.getData(sql);
            
            if(rs.next()){
                int angka_kode = rs.getInt("kode");
                String AN = "" + (angka_kode + 1);
                String Nol = "";
                
                if(AN.length() == 1){
                    Nol = "00";
                }else if(AN.length() == 2){
                    Nol = "0";
                }else if(AN.length() == 3){
                    Nol = "";
                }
                
                kode_transaksi = "TRS" + Nol + AN;
                
            } else {
                kode_transaksi = "TRS001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_transaksi;
    }
}
