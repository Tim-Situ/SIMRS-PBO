package timsitu.models;

import java.util.Date;
import timsitu.enums.EnumJenisKelamin;

public abstract class User {
    public enum EnumRole {NULL, ADMIN, DOKTER, APOTEKER}
    
    private int id;
    private String nama;
    private String tanggal_lahir;
    private String no_hp;
    private EnumJenisKelamin jenis_kelamin;
    private String alamat;
    private String username;
    private String password;

    public User(String nama, String tanggal_lahir, String no_hp, EnumJenisKelamin jenis_kelamin, String alamat, String username, String password) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.no_hp = no_hp;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
    }
    
    public User(String nama, String tanggal_lahir, String no_hp, EnumJenisKelamin jenis_kelamin, String alamat) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.no_hp = no_hp;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalLahir() {
        return tanggal_lahir;
    }

    public void setTanggalLahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNoHp() {
        return no_hp;
    }

    public void setNoHp(String no_hp) {
        this.no_hp = no_hp;
    }

    public EnumJenisKelamin getJenisKelamin() {
        return jenis_kelamin;
    }

    public void setJenisKelamin(EnumJenisKelamin jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
}
