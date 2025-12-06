package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Objet Connection unique (singleton)
    private static Connection connection;

    // Méthode pour récupérer la connexion
    public static Connection getConnection() throws SQLException {
        // Si la connexion n'existe pas ou est fermée, on la crée
        if (connection == null || connection.isClosed()) {
            // Connexion à la base MySQL
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/logistique", // Nom de la base
                "root",                                   // Utilisateur MySQL
                ""                                        // Mot de passe
            );
            System.out.println("Connexion à la base réussie !");
        }
        return connection;
    }
}
