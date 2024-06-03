package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;

public class Poliklinik {
    private String kode;
    private String nama_poli;
    private String keterangan;

    public Poliklinik(String kode, String nama_poli, String keterangan) {
        this.kode = kode;
        this.nama_poli = nama_poli;
        this.keterangan = keterangan;
    }
    
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama_poli() {
        return nama_poli;
    }

    public void setNama_poli(String nama_poli) {
        this.nama_poli = nama_poli;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    public static ArrayList<Poliklinik> getAllData(){
        ArrayList<Poliklinik> dataPoliklinik = new ArrayList();
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT * FROM poliklinik";
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                Poliklinik data = new Poliklinik(
                    rs.getString("kode_poliklinik"),
                    rs.getString("nama_poli"),
                    rs.getString("keterangan")
                );
                dataPoliklinik.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataPoliklinik;
    }
    
    public void simpanData()throws SQLException {  
        ConnectionDB db = new ConnectionDB();        
        String sql = "INSERT INTO poliklinik VALUES (" + null + ", '" + kode + "', '" + nama_poli + "', '" + keterangan + "')";
        db.query(sql); 
    }
    
    public void editData()throws SQLException {
        String sql;
        ConnectionDB db = new ConnectionDB();
        sql = "UPDATE poliklinik SET nama_poli='" + nama_poli + "', "
                + "keterangan='" + keterangan + "' "
                + "WHERE kode_poliklinik='" + kode + "'";
        db.query(sql);
    }
    
    public void deleteData() throws SQLException {
        String sql = "DELETE FROM poliklinik WHERE kode_poliklinik='" + kode + "'";
        ConnectionDB db = new ConnectionDB();
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_poli = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_poliklinik, 1)) AS kode FROM poliklinik";
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
                
                kode_poli = "PLI" + Nol + AN;
                
            } else {
                kode_poli = "PLI001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_poli;
    }
    
}
