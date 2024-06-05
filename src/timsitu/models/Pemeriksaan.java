package timsitu.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;

public class Pemeriksaan {
    private String kode;
    private float tinggiBadan;
    private float beratBadan;
    private String tekananDarah;
    private String keluhan;
    private String diagnosa;
    private int biaya;
    private ArrayList<Obat> resepObat;

    public Pemeriksaan(String kode, float tinggiBadan, float beratBadan, String tekananDarah, String keluhan, String diagnosa, int biaya, ArrayList<Obat> resepObat) {
        this.kode = kode;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.tekananDarah = tekananDarah;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.biaya = biaya;
        this.resepObat = resepObat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public float getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(float tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public float getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(float beratBadan) {
        this.beratBadan = beratBadan;
    }

    public String getTekananDarah() {
        return tekananDarah;
    }

    public void setTekananDarah(String tekananDarah) {
        this.tekananDarah = tekananDarah;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public ArrayList<Obat> getResepObat() {
        return resepObat;
    }

    public void setResepObat(ArrayList<Obat> resepObat) {
        this.resepObat = resepObat;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }
    
    public static Pemeriksaan getData(String kodeReservasi){
        Pemeriksaan data = null;
        String sql;
        ConnectionDB db;
        ResultSet rs;
        ArrayList<Obat> dataResep = new ArrayList<>();
        
        try {
            db = new ConnectionDB();
            
            sql = "SELECT obat.*, resep_obat.jumlah FROM resep_obat "
                    + "INNER JOIN obat ON obat.kode_obat = resep_obat.kode_obat "
                    + "INNER JOIN pemeriksaan ON pemeriksaan.kode_pemeriksaan = resep_obat.kode_pemeriksaan "
                    + "INNER JOIN reservasi ON reservasi.kode_reservasi = pemeriksaan.kode_reservasi "
                    + "WHERE reservasi.kode_reservasi = '"+ kodeReservasi +"'";
            
            rs = db.getData(sql);
            
            while (rs.next()) {                
                Obat obat = new Obat(rs.getString("kode_obat"), rs.getString("nama_obat"), rs.getInt("harga"), rs.getInt("stok"), Obat.EnumJenisObat.valueOf(rs.getString("jenis")));
                dataResep.add(obat);
            }
            
            sql = "SELECT * FROM pemeriksaan WHERE kode_reservasi='"+ kodeReservasi +"'";
            
            rs = db.getData(sql);
            
            if(rs.next()){
                data = new Pemeriksaan(
                        rs.getString("kode_pemeriksaan"),
                        rs.getFloat("tinggi_badan"),
                        rs.getFloat("berat_badan"),
                        rs.getString("tekanan_darah"),
                        rs.getString("keluhan"),
                        rs.getString("diagnosa"),
                        rs.getInt("biaya"),
                        dataResep    
                );
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return data;
    }
    
    public void simpanData(String kodeReservasi)throws SQLException {  
        ConnectionDB db = new ConnectionDB();        
        String sql = "INSERT INTO pemeriksaan VALUES (" + null + ", '" + kode + "', '" + kodeReservasi + "', "+ tinggiBadan +", "+ beratBadan +", '"+ tekananDarah +"', '"+ keluhan +"', '"+ diagnosa +"', "+ biaya +")";
        db.query(sql);
        
        for (Obat obat : resepObat) {
            sql = "INSERT INTO resep_obat VALUES("+null+", '"+ kode +"', '"+ obat.getKode() +"', " + obat.getStok() + ")";
            db.query(sql);
        }
        
        sql = "UPDATE reservasi SET status='Selesai' "
                + "WHERE kode_reservasi='" + kodeReservasi + "'";
        db.query(sql);
    }
    
    public static String generateKode(){
        
        String kode_pemeriksaan = null;
        
        try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT MAX(right(kode_pemeriksaan, 1)) AS kode FROM pemeriksaan";
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
                
                kode_pemeriksaan = "PRS" + Nol + AN;
                
            } else {
                kode_pemeriksaan = "PRS001";
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
        }
        
        return kode_pemeriksaan;
    }
}
