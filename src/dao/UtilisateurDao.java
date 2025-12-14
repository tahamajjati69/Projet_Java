package dao;

import utils.DBConnection;
import java.sql.*;
import java.util.Random;

public class UtilisateurDao {

    private Connection conn;

    public UtilisateurDao() {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String email, String password) {
        String sql = "SELECT id FROM utilisateur WHERE email=? AND password=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean emailExiste(String email) {
        String sql = "SELECT id FROM utilisateur WHERE email=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public String genererCode() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    public void sauvegarderCode(String email, String code) {
        String sql = "UPDATE utilisateur SET code_verification=?, code_expiration=DATE_ADD(NOW(), INTERVAL 10 MINUTE) WHERE email=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, code);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifierCode(String email, String code) {
        String sql = "SELECT id FROM utilisateur WHERE email=? AND code_verification=? AND code_expiration > NOW()";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, code);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public void clearCode(String email) {
        String sql = "UPDATE utilisateur SET code_verification=NULL, code_expiration=NULL WHERE email=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
