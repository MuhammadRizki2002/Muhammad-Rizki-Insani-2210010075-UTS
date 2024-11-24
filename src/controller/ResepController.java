package controller;

import dao.ResepDAO;
import model.Resep;
import config.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList; // Untuk membuat ArrayList.
import java.util.List; // Untuk menggunakan tipe List.

public class ResepController {

    private ResepDAO resepDAO;

    public ResepController() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            resepDAO = new ResepDAO(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tambahResep(Resep resep) {
        try {
            resepDAO.tambahResep(resep);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Resep> getSemuaResep() {
        try {
            return resepDAO.getSemuaResep();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateResep(Resep resep) {
        try {
            resepDAO.updateResep(resep);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void hapusResep(int id) {
        try {
            resepDAO.hapusResep(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Resep> cariResep(String keyword) {
        try {
            return resepDAO.cariResep(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
