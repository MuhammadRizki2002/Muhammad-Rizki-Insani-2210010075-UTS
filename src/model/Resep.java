package model;

public class Resep {

    private int id;
    private String judul;
    private String bahan;
    private String langkah;

    // Constructor
    public Resep(int id, String judul, String bahan, String langkah) {
        this.id = id;
        this.judul = judul;
        this.bahan = bahan;
        this.langkah = langkah;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getLangkah() {
        return langkah;
    }

    public void setLangkah(String langkah) {
        this.langkah = langkah;
    }
}
