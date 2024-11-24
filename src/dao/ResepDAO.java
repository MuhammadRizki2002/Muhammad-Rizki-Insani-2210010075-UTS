package dao;

import model.Resep; // Mengimpor model Resep.
import java.sql.Connection; // Koneksi ke database.
import java.sql.PreparedStatement; // Untuk pernyataan SQL dengan parameter.
import java.sql.Statement; // Untuk pernyataan SQL sederhana.
import java.sql.ResultSet; // Untuk membaca hasil query dari database.
import java.sql.SQLException; // Untuk menangani SQLException.
import java.util.ArrayList; // Untuk membuat ArrayList.
import java.util.List; // Untuk menggunakan tipe List.

public class ResepDAO {

    private Connection conn;

    // Constructor
    public ResepDAO(Connection conn) {
        this.conn = conn;
    }

    // CREATE
    public void tambahResep(Resep resep) throws SQLException {
        String sql = "INSERT INTO resep (judul, bahan, langkah) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, resep.getJudul());
            stmt.setString(2, resep.getBahan());
            stmt.setString(3, resep.getLangkah());
            stmt.executeUpdate();
        }
    }

    // READ
    public List<Resep> getSemuaResep() throws SQLException {
        String sql = "SELECT * FROM resep";
        List<Resep> resepList = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                resepList.add(new Resep(
                        rs.getInt("id"),
                        rs.getString("judul"),
                        rs.getString("bahan"),
                        rs.getString("langkah")
                ));
            }
        }
        return resepList;
    }

    // UPDATE
    public void updateResep(Resep resep) throws SQLException {
        String sql = "UPDATE resep SET judul = ?, bahan = ?, langkah = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, resep.getJudul());
            stmt.setString(2, resep.getBahan());
            stmt.setString(3, resep.getLangkah());
            stmt.setInt(4, resep.getId());
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void hapusResep(int id) throws SQLException {
        String sql = "DELETE FROM resep WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Resep> cariResep(String keyword) throws SQLException {
        String sql = "SELECT * FROM resep WHERE judul LIKE ?";
        List<Resep> resepList = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + keyword + "%"); // Gunakan wildcard untuk pencarian
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    resepList.add(new Resep(
                            rs.getInt("id"),
                            rs.getString("judul"),
                            rs.getString("bahan"),
                            rs.getString("langkah")
                    ));
                }
            }
        }
        return resepList;
    }

}
