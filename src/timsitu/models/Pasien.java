package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;
import timsitu.enums.EnumJenisKelamin;

public class Pasien extends User{
    private String kode;

    public Pasien(String kode, String nama, String tanggal_lahir, String no_hp, EnumJenisKelamin jenis_kelamin, String alamat) {
        super(nama, tanggal_lahir, no_hp, jenis_kelamin, alamat);
        this.kode = kode;
    }

    public void setIdUser(int id){
        this.setId(id);
    }
    
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
    
    public static ArrayList<Pasien> getAllData(){
        ArrayList<Pasien> dataPasien = new ArrayList();
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT * FROM user INNER JOIN pasien ON user.id = pasien.id_user";
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                Pasien data = new Pasien(
                    rs.getString("kode_pasien"), 
                    rs.getString("nama"), 
                    rs.getString("tanggal_lahir"), 
                    rs.getString("no_hp"), 
                    rs.getString("jenis_kelamin").equals("PRIA") ? EnumJenisKelamin.PRIA : EnumJenisKelamin.WANITA, 
                    rs.getString("alamat")
                );
                data.setIdUser(rs.getInt(1));
                dataPasien.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataPasien;
    }
    
    public static Pasien cariData(String kode){
        Pasien pasien = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT * FROM user INNER JOIN pasien ON user.id = pasien.id_user WHERE pasien.kode_pasien='"+ kode +"'";
            ResultSet rs = db.getData(sql);
            
            if(rs.next()){
                pasien = new Pasien(
                    rs.getString("kode_pasien"), 
                    rs.getString("nama"), 
                    rs.getString("tanggal_lahir"), 
                    rs.getString("no_hp"), 
                    rs.getString("jenis_kelamin").equals("PRIA") ? EnumJenisKelamin.PRIA : EnumJenisKelamin.WANITA, 
                    rs.getString("alamat")
                );
                pasien.setIdUser(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return pasien;
    }
    
    public void simpanData()throws SQLException {
        int id;
        String sql;
        
        ConnectionDB db = new ConnectionDB();
        sql = "INSERT INTO user VALUES (" + null + ", '" + getNama() + "', '" + getTanggalLahir() + "', '" + getNoHp() + "', '" + getJenisKelamin() + "', '" + getAlamat() + "', " + null + ", " + null + ", "+null+")";
        id = db.addQuery(sql);
        
        sql = "INSERT INTO pasien VALUES (" + null + ", '" + kode + "', " + id + ")";
        db.query(sql); 
    }
    
    public void editData()throws SQLException {
        String sql;
        ConnectionDB db = new ConnectionDB();
        sql = "UPDATE user SET nama='" + this.getNama() + "', tanggal_lahir='" + this.getTanggalLahir() + "', no_hp='" + this.getNoHp() + "', jenis_kelamin='" + this.getJenisKelamin() + "', alamat='" + this.getAlamat() + "' WHERE id=" + this.getId();
        db.query(sql);
    }
    
    public void deleteData() throws SQLException {
        System.out.println(kode);
        String sql = "DELETE FROM pasien WHERE kode_pasien='" + kode + "'";
        ConnectionDB db = new ConnectionDB();
        db.query(sql);
        
        sql = "DELETE FROM user WHERE id=" + this.getId();
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_pasien = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_pasien, 1)) AS kode FROM pasien";
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
                
                kode_pasien = "PSN" + Nol + AN;
                
            } else {
                kode_pasien = "PSN001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_pasien;
    }
}
