package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;
import timsitu.enums.EnumHari;
import timsitu.enums.EnumJenisKelamin;

public class Jadwal {
    
    private String kode;
    private EnumHari hari;
    private Dokter dokter;
    private String jam_mulai;
    private String jam_selesai;
    private String ruangan;

    public Jadwal(String kode, EnumHari hari, Dokter dokter, String jam_mulai, String jam_selesai, String ruangan) {
        this.kode = kode;
        this.hari = hari;
        this.dokter = dokter;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
        this.ruangan = ruangan;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public EnumHari getHari() {
        return hari;
    }

    public void setHari(EnumHari hari) {
        this.hari = hari;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public String getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(String jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public String getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(String jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }
    
    public static ArrayList<Jadwal> getAllData(){
        ArrayList<Jadwal> dataJadwal = new ArrayList();
        Jadwal jadwal;
        Dokter dokter;
        Poliklinik poli;
        
        EnumHari hari;
        EnumJenisKelamin jenisKelaminDokter;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT jadwal.*, dokter.kode_poli, dokter.nip, user.nama, user.jenis_kelamin, poliklinik.nama_poli FROM jadwal "
                    + "INNER JOIN dokter ON dokter.kode_dokter = jadwal.kode_dokter "
                    + "INNER JOIN user ON user.id = dokter.id_user "
                    + "INNER JOIN poliklinik ON poliklinik.kode_poliklinik = dokter.kode_poli";
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
               
                hari = EnumHari.valueOf(rs.getString("hari"));
                jenisKelaminDokter = EnumJenisKelamin.valueOf(rs.getString("jenis_kelamin"));
                
                poli = new Poliklinik(rs.getString("kode_poli"), rs.getString("nama_poli"), null);
                dokter = new Dokter(rs.getString("kode_dokter"), rs.getString("nip"), rs.getString("nama"), poli, null, null, jenisKelaminDokter, null, null, null);
                
                jadwal = new Jadwal(rs.getString("kode_jadwal"), hari, dokter, rs.getString("jam_mulai"), rs.getString("jam_selesai"), rs.getString("ruangan"));
                dataJadwal.add(jadwal);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataJadwal;
    }
    
    public void simpanData()throws SQLException {  
        ConnectionDB db = new ConnectionDB();        
        String sql = "INSERT INTO jadwal VALUES (" + 
            null + ", '" + 
            kode + "', '" + 
            hari + "', '" + 
            dokter.getKode() + "', '" + 
            jam_mulai + "', '" + 
            jam_selesai +"', '" + 
            ruangan + 
        "')";
        
        db.query(sql); 
    }
    
    public void editData()throws SQLException {
        String sql;
        ConnectionDB db = new ConnectionDB();
        sql = "UPDATE jadwal SET hari='" + hari + "', "
                + "kode_dokter='" + dokter.getKode() + "', "
                + "jam_mulai='" + jam_mulai + "', "
                + "jam_selesai='" + jam_selesai + "', "
                + "ruangan='" + ruangan + "' "
                + "WHERE kode_jadwal='" + kode + "'";
        db.query(sql);
    }
    
    public void deleteData() throws SQLException {
        String sql = "DELETE FROM jadwal WHERE kode_jadwal='" + kode + "'";
        ConnectionDB db = new ConnectionDB();
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_jadwal = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_jadwal, 1)) AS kode FROM jadwal";
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
                
                kode_jadwal = "JDW" + Nol + AN;
                
            } else {
                kode_jadwal = "JDW001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_jadwal;
    }
}
