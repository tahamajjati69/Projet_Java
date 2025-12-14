package dao;

import entities.Livreur;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreurDao implements IDao<Livreur> {

    private final Connection conn;

    public LivreurDao() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur connexion LivreurDao : " + e.getMessage());
        }
    }

    @Override
    public boolean create(Livreur l) {
        String sql = "INSERT INTO livreur(nom, zone, vehicule) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getNom());
            ps.setString(2, l.getZone());
            ps.setString(3, l.getVehicule());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(Livreur l) {
        String sql = "UPDATE livreur SET nom=?, zone=?, vehicule=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getNom());
            ps.setString(2, l.getZone());
            ps.setString(3, l.getVehicule());
            ps.setInt(4, l.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM livreur WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Livreur findById(int id) {
        String sql = "SELECT * FROM livreur WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Livreur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("zone"),
                    rs.getString("vehicule")
                );
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Livreur> findAll() {
        List<Livreur> liste = new ArrayList<>();
        String sql = "SELECT * FROM livreur";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                liste.add(new Livreur(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("zone"),
                    rs.getString("vehicule")
                ));
            }
        } catch (SQLException e) {
            return liste;
        }
        return liste;
    }
}
