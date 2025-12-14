package dao;

import entities.Livraison;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LivraisonDao implements IDao<Livraison> {

    private final Connection conn;

    public LivraisonDao() throws SQLException {
        conn = DBConnection.getConnection();
    }

    public boolean create(Livraison l) {
        String sql = "INSERT INTO Livraison (statut, dateLivraison, colisRef, livreurId) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getStatut());
            ps.setDate(2, new java.sql.Date(l.getDateLivraison().getTime()));
            ps.setInt(3, l.getColisRef());
            ps.setInt(4, l.getLivreurId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean update(Livraison l) {
        String sql = "UPDATE Livraison SET statut=?, dateLivraison=?, colisRef=?, livreurId=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, l.getStatut());
            ps.setDate(2, new java.sql.Date(l.getDateLivraison().getTime()));
            ps.setInt(3, l.getColisRef());
            ps.setInt(4, l.getLivreurId());
            ps.setInt(5, l.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM Livraison WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public Livraison findById(int id) {
        String sql = "SELECT * FROM Livraison WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Livraison(
                    rs.getInt("id"),
                    rs.getString("statut"),
                    rs.getDate("dateLivraison"),
                    rs.getInt("colis_id"),
                    rs.getInt("livreur_id")
                );
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Livraison> findAll() {
        List<Livraison> list = new ArrayList<>();
        String sql = "SELECT * FROM Livraison";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Livraison(
                    rs.getInt("id"),
                    rs.getString("statut"),
                    rs.getDate("dateLivraison"),
                    rs.getInt("colisRef"),
                    rs.getInt("livreurId")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : "+e.getMessage());
        }
        return list;
    }

    public List<Livraison> findByStatut(String statut) {
        List<Livraison> list = new ArrayList<>();
        String sql = "SELECT * FROM Livraison WHERE statut=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, statut);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Livraison(
                    rs.getInt("id"),
                    rs.getString("statut"),
                    rs.getDate("dateLivraison"),
                    rs.getInt("colisRef"),
                    rs.getInt("livreurId")
                ));
            }
        } catch (SQLException e) {
            return list;
        }
        return list;
    }

    public Map<Integer, Integer> getLivraisonsParMois() {
        Map<Integer, Integer> stats = new HashMap<>();
        String sql = "SELECT MONTH(dateLivraison) AS mois, COUNT(*) AS total FROM Livraison GROUP BY MONTH(dateLivraison)";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                stats.put(rs.getInt("mois"), rs.getInt("total"));
            }
        } catch (SQLException e) {
            return stats;
        }
        return stats;
    }
}
