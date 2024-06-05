package timsitu.models;

import java.sql.SQLException;
import timsitu.config.ConnectionDB;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import timsitu.enums.EnumJenisKelamin;

public class Reservasi {
    private String kode;
    private Pasien pasien;
    private Jadwal jadwal;
    private int noAntrian;
    private String tanggal;
    private String status;

    public Reservasi(String kode, Pasien pasien, Jadwal jadwal, int noAntrian, String tanggal) {
        this.kode = kode;
        this.pasien = pasien;
        this.jadwal = jadwal;
        this.noAntrian = noAntrian;
        this.tanggal = tanggal;
    }

    public String getKode() {
        return kode;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

    public int getNoAntrian() {
        return noAntrian;
    }

    public void setNoAntrian(int noAntrian) {
        this.noAntrian = noAntrian;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void simpanData()throws SQLException {  
        ConnectionDB db = new ConnectionDB();        
        String sql = "INSERT INTO reservasi VALUES (" + 
            null + ", '" + 
            kode + "', '" + 
            pasien.getKode() + "', '" + 
            jadwal.getKode() + "', " + 
            noAntrian + ", '" + 
            tanggal + "', '"+
            status +"')";
        
        db.query(sql); 
    }
    
    public void deleteData() throws SQLException {
        String sql = "DELETE FROM reservasi WHERE kode_reservasi='" + kode + "'";
        ConnectionDB db = new ConnectionDB();
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_reservasi = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_reservasi, 1)) AS kode FROM reservasi";
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
                
                kode_reservasi = "RSV" + Nol + AN;
                
            } else {
                kode_reservasi = "RSV001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_reservasi;
    }
    
    public static int generateNoAntrian(){
        int noAntrian = 1;
        
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = sdf.format(currentDate);
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(no_antrian) AS no_antrian FROM reservasi WHERE tanggal='" + tanggal + "'";
            ResultSet rs = db.getData(sql);
            
            if(rs.next()){
                noAntrian = rs.getInt("no_antrian") + 1;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return noAntrian;
    }
    
    public static ArrayList<Reservasi> getAllData(int idUser){
        ArrayList<Reservasi> dataReservasi = new ArrayList();
        Pasien pasien;
        Dokter dokter;
        Jadwal jadwal;
        
        try {
            ConnectionDB db = new ConnectionDB();
            
            String sql = "SELECT rsv.*, up.nama, up.jenis_kelamin, ud.id AS id_user_dokter FROM reservasi rsv "
                    + "INNER JOIN pasien psn ON psn.kode_pasien = rsv.kode_pasien "
                    + "INNER JOIN jadwal jdw ON rsv.kode_jadwal = jdw.kode_jadwal "
                    + "INNER JOIN user up ON up.id = psn.id_user "
                    + "INNER JOIN dokter dkt ON dkt.kode_dokter = jdw.kode_dokter "
                    + "INNER JOIN user ud ON ud.id = dkt.id_user WHERE ud.id = " + idUser;
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                
                pasien = new Pasien(rs.getString("kode_pasien"), rs.getString("nama"), null, null, rs.getString("jenis_kelamin").equals("PRIA") ? EnumJenisKelamin.PRIA : EnumJenisKelamin.WANITA, null);
                
                Reservasi data = new Reservasi(rs.getString("kode_reservasi"), pasien, null, rs.getInt("no_antrian"), rs.getString("tanggal"));
                data.setStatus(rs.getString("status"));
                dataReservasi.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataReservasi;
    }
}
