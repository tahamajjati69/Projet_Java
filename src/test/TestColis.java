package test;

import dao.ColisDao;
import entities.Colis;
import java.sql.SQLException;
import java.util.List;

public class TestColis {
    public static void main(String[] args) throws SQLException {

        ColisDao dao = new ColisDao();

        // 1. Ajouter des colis (sans référence, car AUTO_INCREMENT)
        dao.create(new Colis(2.5, "Casablanca"));
        dao.create(new Colis(4.0, "Rabat"));

        // 2. Afficher tous les colis
        System.out.println("Tous les colis :");
        List<Colis> liste = dao.findAll();
        for (Colis c : liste) {
            System.out.println(c.getReference() + " - " + c.getPoids() + " - " + c.getVilleDestination());
        }

        // 3. Modifier un colis (ex : modifier le premier)
        if (!liste.isEmpty()) {
            Colis c = liste.get(0);
            c.setPoids(3.0);
            c.setVilleDestination("Marrakech");
            dao.update(c);
            System.out.println("Colis modifié !");
        }

        // 4. Supprimer un colis (ex : supprimer le deuxième)
        if (liste.size() >= 2) {
            Colis c2 = liste.get(1);
            dao.delete(c2.getReference());
            System.out.println("Colis supprimé !");
        }

        // 5. Afficher après update et delete
        System.out.println("Après update et delete :");
        dao.findAll().forEach(c -> {
            System.out.println(
                c.getReference() + " - " + c.getPoids() + " - " + c.getVilleDestination()
            );
        });
    }
}
