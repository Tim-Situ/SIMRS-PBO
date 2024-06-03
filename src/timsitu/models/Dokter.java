package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;
import timsitu.enums.EnumJenisKelamin;

public class Dokter extends User{

    private String kode;
    private String nip;
    private Poliklinik poli;
    
    public Dokter(String kode, String nip, String nama, Poliklinik poli, String tanggal_lahir, String no_hp, EnumJenisKelamin jenis_kelamin, String alamat, String username, String password) {
        super(nama, tanggal_lahir, no_hp, jenis_kelamin, alamat, username, password);
        this.kode = kode;
        this.nip = nip;
        this.poli = poli;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Poliklinik getPoli() {
        return poli;
    }

    public void setPoli(Poliklinik poli) {
        this.poli = poli;
    }
    
    public static ArrayList<Dokter> getAllData(){
        ArrayList<Dokter> dataDokter = new ArrayList();
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT * FROM user "
                    + "INNER JOIN dokter ON user.id = dokter.id_user "
                    + "INNER JOIN poliklinik ON poliklinik.kode_poliklinik = dokter.kode_poli";
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                Dokter data = new Dokter(
                    rs.getString("kode_dokter"),
                    rs.getString("nip"),
                    rs.getString("nama"),
                    new Poliklinik(rs.getString("kode_poliklinik"), rs.getString("nama_poli"), rs.getString("keterangan")),
                    rs.getString("tanggal_lahir"), 
                    rs.getString("no_hp"), 
                    rs.getString("jenis_kelamin").equals("PRIA") ? EnumJenisKelamin.PRIA : EnumJenisKelamin.WANITA, 
                    rs.getString("alamat"),
                    rs.getString("username"),
                    rs.getString("password")
                );
                data.setIdUser(rs.getInt(1));
                dataDokter.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataDokter;
    }
    
    public void simpanData()throws SQLException {
        int id;
        String sql;
        
        ConnectionDB db = new ConnectionDB();
        sql = "INSERT INTO user VALUES (" + null + ", '" + getNama() + "', '" + this.getTanggalLahir() + "', '" + getNoHp() + "', '" + getJenisKelamin() + "', '" + getAlamat() + "', '" + this.getUsername() + "', '" + this.getPassword() + "', '"+ EnumRole.DOKTER +"')";
        id = db.addQuery(sql);
        
        sql = "INSERT INTO dokter VALUES (" + null + ", '" + kode + "', '" + nip + "', '" + poli.getKode() + "', " + id + ")";
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
        
        sql = "UPDATE dokter SET nip='" + nip + "', "
                + "kode_poli='" + poli.getKode() + "' "
                + "WHERE kode_dokter='" + kode + "'";
        db.query(sql);
    }
    
    public void deleteData() throws SQLException {
        String sql = "DELETE FROM dokter WHERE kode_dokter='" + kode + "'";
        ConnectionDB db = new ConnectionDB();
        db.query(sql);
        
        sql = "DELETE FROM user WHERE id=" + this.getId();
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_dokter = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_dokter, 1)) AS kode FROM dokter";
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
                
                kode_dokter = "DKT" + Nol + AN;
                
            } else {
                kode_dokter = "DKT001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_dokter;
    }
    
}
