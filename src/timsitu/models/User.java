/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package timsitu.models;

import java.util.Date;

/**
 *
 * @author fauzeinmulyawarman
 */
public class User {
    public enum EnumJenisKelamin {PRIA, WANITA}
    public enum EnumRole {NULL, ADMIN, DOKTER, APOTEKER}
    
    private String nama;
    private Date tanggal_lahir;
    private String no_hp;
    private EnumJenisKelamin jenis_kelamin;
    private String alamat;
    private String username;
    private String password;

    public User(String nama, Date tanggal_lahir, String no_hp, EnumJenisKelamin jenis_kelamin, String alamat, String username, String password) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.no_hp = no_hp;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.username = username;
        this.password = password;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public EnumJenisKelamin getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(EnumJenisKelamin jenis_kelamin) {
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
