
package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;
import timsitu.enums.EnumJenisKelamin;

public class Apoteker extends User{
    private String kode;
    private String nip;

    public Apoteker(String kode, String nip, String nama, String tanggal_lahir, String no_hp, EnumJenisKelamin jenis_kelamin, String alamat, String username, String password) {
        super(nama, tanggal_lahir, no_hp, jenis_kelamin, alamat, username, password);
        this.nip = nip;
        this.kode = kode;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public static ArrayList<Apoteker> getAllData(){
        ArrayList<Apoteker> dataApoteker = new ArrayList();
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT * FROM user INNER JOIN apoteker ON user.id = apoteker.id_user";
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                Apoteker data = new Apoteker(
                    rs.getString("kode_apoteker"),
                    rs.getString("nip"),
                    rs.getString("nama"),
                    rs.getString("tanggal_lahir"), 
                    rs.getString("no_hp"), 
                    rs.getString("jenis_kelamin").equals("PRIA") ? EnumJenisKelamin.PRIA : EnumJenisKelamin.WANITA, 
                    rs.getString("alamat"),
                    rs.getString("username"),
                    rs.getString("password")
                );
                data.setId(rs.getInt(1));
                dataApoteker.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataApoteker;
    }
    
    public void simpanData()throws SQLException {
        int id;
        String sql;
        
        ConnectionDB db = new ConnectionDB();
        sql = "INSERT INTO user VALUES (" + null + ", '" + getNama() + "', '" + this.getTanggalLahir() + "', '" + getNoHp() + "', '" + getJenisKelamin() + "', '" + getAlamat() + "', '" + this.getUsername() + "', '" + this.getPassword() + "', '"+ User.EnumRole.DOKTER +"')";
        id = db.addQuery(sql);
        
        sql = "INSERT INTO apoteker VALUES (" + null + ", '" + kode + "', '" + nip + "', " + id + ")";
        db.query(sql); 
    }
    
    public void editData()throws SQLException {
        String sql;
        ConnectionDB db = new ConnectionDB();
        sql = "UPDATE user SET nama='" + this.getNama() + "', "
                + "tanggal_lahir='" + this.getTanggalLahir() + "', "
                + "no_hp='" + this.getNoHp() + "', "
                + "jenis_kelamin='" + this.getJenisKelamin() + "', "
                + "alamat='" + this.getAlamat() + "', "
                + "username='" + this.getUsername()+ "', "
                + "password='" + this.getPassword()+ "' "
                + "WHERE id=" + this.getId();
        db.query(sql);
        
        sql = "UPDATE apoteker SET nip='" + nip + "' "
                + "WHERE kode_apoteker='" + kode + "'";
        db.query(sql);
    }
    
    public void deleteData() throws SQLException {
        String sql = "DELETE FROM apoteker WHERE kode_apoteker='" + kode + "'";
        ConnectionDB db = new ConnectionDB();
        db.query(sql);
        
        sql = "DELETE FROM user WHERE id=" + this.getId();
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_apoteker = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_apoteker, 1)) AS kode FROM apoteker";
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
                
                kode_apoteker = "APT" + Nol + AN;
                
            } else {
                kode_apoteker = "APT001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_apoteker;
    } 
}
