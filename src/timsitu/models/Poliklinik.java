package timsitu.models;

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
    
}
