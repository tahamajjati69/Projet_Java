package test;

import dao.LivreurDao;
import entities.Livreur;
import java.sql.SQLException;
import java.util.List;

public class TestLivreur {
    public static void main(String[] args) throws SQLException {
        LivreurDao dao = new LivreurDao();

            dao.create(new Livreur( "Taha", "Nord", "Camion"));
        dao.create(new Livreur("Sara", "Sud", "Moto"));

        System.out.println("Tous les livreurs :");
        List<Livreur> liste = dao.findAll();
        liste.forEach(System.out::println);

        if (!liste.isEmpty()) {
            Livreur l = liste.get(0); // prend le premier livreur
            l.setZone("Centre");
            l.setVehicule("Voiture");
            dao.update(l);
        }

        if (!liste.isEmpty()) {
            Livreur l = liste.get(1); // prend le deuxième livreur
            dao.delete(l.getId());
        }

        System.out.println("Après update et delete :");
        dao.findAll().forEach(System.out::println);
    }
}
