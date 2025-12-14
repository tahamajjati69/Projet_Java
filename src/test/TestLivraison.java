package test;

import entities.Livraison;
import services.LivraisonService;

import java.sql.Date;

public class TestLivraison {
    public static void main(String[] args) {
        try {
            LivraisonService service = new LivraisonService();

            Livraison l1 = new Livraison(0, "En cours", new Date(System.currentTimeMillis()), 1, 1);
            service.ajouterLivraison(l1);

            l1.setStatut("Livré");
            service.modifierLivraison(l1);

            Livraison l2 = service.getLivraison(l1.getId());
            System.out.println("Livraison récupérée : " + l2);

            for (Livraison l : service.listeLivraisons()) {
                System.out.println(l);
            }

            for (Livraison l : service.getLivraisonsParStatut("Livré")) {
                System.out.println("Livraison livrée : " + l);
            }

            service.supprimerLivraison(l1.getId());

            System.out.println("Stats livraisons par mois : " + service.getLivraisonsParMois());

        } catch (Exception e) {
            System.err.println("Erreur TestLivraison : " + e.getMessage());
        }
    }
}
