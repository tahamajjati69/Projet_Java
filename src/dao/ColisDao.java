package dao;

import entities.Colis;
import utils.DBConnection;  

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColisDao {

    private final Connection conn;

    public ColisDao() {
        try {
            conn = DBConnection.getConnection(); 
        } catch (SQLException e) {
            throw new RuntimeException("Erreur connexion ColisDao : " + e.getMessage());
        }
    }

    public boolean create(Colis c) {
        String sql = "INSERT INTO colis (poids, villeDestination) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, c.getPoids());
            ps.setString(2, c.getVilleDestination());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erreur CREATE Colis : " + e.getMessage());
            return false;
        }
    }

    public boolean update(Colis c) {
        String sql = "UPDATE colis SET poids=?, villeDestination=? WHERE reference=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, c.getPoids());
            ps.setString(2, c.getVilleDestination());
            ps.setInt(3, c.getReference());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erreur UPDATE Colis : " + e.getMessage());
            return false;
        }
    }

    public boolean delete(int reference) {
        String sql = "DELETE FROM colis WHERE reference=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reference);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erreur DELETE Colis : " + e.getMessage());
            return false;
        }
    }

    public Colis findById(int reference) {
        String sql = "SELECT * FROM colis WHERE reference=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reference);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Colis(
                    rs.getInt("reference"),
                    rs.getDouble("poids"),
                    rs.getString("villeDestination")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur FIND Colis : " + e.getMessage());
        }
        return null;
    }

    public List<Colis> findAll() {
        List<Colis> liste = new ArrayList<>();
        String sql = "SELECT * FROM colis";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                liste.add(new Colis(
                    rs.getInt("reference"),
                    rs.getDouble("poids"),
                    rs.getString("villeDestination")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur FIND ALL Colis : " + e.getMessage());
        }
        return liste;
    }
}
