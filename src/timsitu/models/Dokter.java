package timsitu.models;

import java.util.Date;

public class Dokter extends User{

    private String kode;
    private String nip;
    private Poliklinik poli;
    
    public Dokter(String kode, String nip, String nama, Poliklinik poli, Date tanggal_lahir, String no_hp, EnumJenisKelamin jenis_kelamin, String alamat, String username, String password) {
        super(nama, tanggal_lahir, no_hp, jenis_kelamin, alamat, username, password);
        this.kode = kode;
        this.nip = nip;
        this.poli = poli;
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
    
}
