package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;

public class Obat {
    
    public static enum EnumJenisObat {PIL, SIRUP, TABLET} 
    
    private String kode;
    private String nama;
    private int harga;
    private int stok;
    EnumJenisObat jenis;

    public Obat(String kode, String nama, int harga, int stok, EnumJenisObat jenis) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.jenis = jenis;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public EnumJenisObat getJenis() {
        return jenis;
    }

    public void setJenis(EnumJenisObat jenis) {
        this.jenis = jenis;
    }
    
    public static ArrayList<Obat> getAllData(){
        ArrayList<Obat> dataObat = new ArrayList();
        EnumJenisObat jenis;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT * FROM obat";
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                
                if(rs.getString("jenis").equals("PIL")){
                    jenis = EnumJenisObat.PIL;
                }else if(rs.getString("jenis").equals("SIRUP")){
                    jenis = EnumJenisObat.SIRUP;
                }else{
                    jenis = EnumJenisObat.TABLET;
                }
                
                Obat data = new Obat(rs.getString("kode_obat"), rs.getString("nama_obat"), rs.getInt("harga"), rs.getInt("stok"), jenis);
                dataObat.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataObat;
    }
    
    public static ArrayList<Obat> getResepObat(String kodePemeriksaan){
        ArrayList<Obat> dataObat = new ArrayList();
        EnumJenisObat jenis;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT resep_obat.kode_obat, resep_obat.jumlah, obat.harga, obat.nama_obat, obat.jenis FROM resep_obat "
                    + "INNER JOIN obat ON obat.kode_obat = resep_obat.kode_obat "
                    + "WHERE resep_obat.kode_pemeriksaan = '"+ kodePemeriksaan +"'";
            
            ResultSet rs = db.getData(sql);
            
            while(rs.next()){
                jenis = EnumJenisObat.valueOf(rs.getString("jenis"));
                Obat data = new Obat(rs.getString("kode_obat"), rs.getString("nama_obat"), rs.getInt("harga"), rs.getInt("jumlah"), jenis);
                dataObat.add(data);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return dataObat;
    }
    
    public void simpanData()throws SQLException {  
        ConnectionDB db = new ConnectionDB();        
        String sql = "INSERT INTO obat VALUES (" + null + ", '" + kode + "', '" + nama + "', " + harga + ", " + stok + ", '" + jenis +"')";
        db.query(sql); 
    }
    
    public void editData()throws SQLException {
        String sql;
        ConnectionDB db = new ConnectionDB();
        sql = "UPDATE obat SET nama_obat='" + nama + "', "
                + "harga=" + harga + ", "
                + "stok=" + stok + ", "
                + "jenis='" + jenis + "' "
                + "WHERE kode_obat='" + kode + "'";
        db.query(sql);
    }
    
    public void deleteData() throws SQLException {
        String sql = "DELETE FROM obat WHERE kode_obat='" + kode + "'";
        ConnectionDB db = new ConnectionDB();
        db.query(sql);
    }
    
    public void kurangiStok(int total)throws SQLException {
        stok -= total;
        
        ConnectionDB db = new ConnectionDB();
        String sql = "UPDATE obat SET stok=" + stok + " "
                + "WHERE kode_obat='" + kode + "'";
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_obat = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_obat, 1)) AS kode FROM obat";
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
                
                kode_obat = "OBT" + Nol + AN;
                
            } else {
                kode_obat = "OBT001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_obat;
    }
}
