package test;

import dao.LivreurDao;
import entities.Livreur;
import java.sql.SQLException;
import java.util.List;

public class TestLivreur {
    public static void main(String[] args) throws SQLException {
        LivreurDao dao = new LivreurDao();

        // 1. Ajouter des livreurs
            dao.create(new Livreur(0, "Taha", "Nord", "Camion"));
        dao.create(new Livreur(0, "Sara", "Sud", "Moto"));

        // 2. Afficher tous les livreurs
        System.out.println("Tous les livreurs :");
        List<Livreur> liste = dao.findAll();
        liste.forEach(System.out::println);

        // 3. Modifier un livreur
        if (!liste.isEmpty()) {
            Livreur l = liste.get(0); // prend le premier livreur
            l.setZone("Centre");
            l.setVehicule("Voiture");
            dao.update(l);
        }

        // 4. Supprimer un livreur
        if (!liste.isEmpty()) {
            Livreur l = liste.get(1); // prend le deuxième livreur
            dao.delete(l.getId());
        }

        // 5. Afficher après update et delete
        System.out.println("Après update et delete :");
        dao.findAll().forEach(System.out::println);
    }
}
