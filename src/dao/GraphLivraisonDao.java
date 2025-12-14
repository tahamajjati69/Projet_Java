package dao;

import utils.DBConnection;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GraphLivraisonDao {

    private final Connection conn;

    public GraphLivraisonDao() throws SQLException {
        conn = DBConnection.getConnection();
    }

    
    public Map<Integer, Integer> getLivraisonsParMois() {
        Map<Integer, Integer> stats = new HashMap<>();

        String sql = "SELECT MONTH(date_livraison) AS mois, COUNT(*) AS total " +
                     "FROM Livraison " +
                     "GROUP BY MONTH(date_livraison) " +
                     "ORDER BY mois";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int mois = rs.getInt("mois");
                int total = rs.getInt("total");
                stats.put(mois, total);
            }

        } catch (SQLException e) {
            System.err.println("Erreur getLivraisonsParMois(): " + e.getMessage());
        }

        return stats;
    }
}
