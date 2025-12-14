package test;

import entities.Colis;
import services.ColisService;

public class TestColis {
    public static void main(String[] args) {
        ColisService service = new ColisService();

        Colis c1 = new Colis(0, 15.0, "Marrakech");
        service.ajouterColis(c1);

        c1.setVilleDestination("Casablanca");
        service.modifierColis(c1);

        Colis c2 = service.getColis(c1.getReference());
        System.out.println("Colis récupéré : " + c2);

        for (Colis c : service.listeColis()) {
            System.out.println(c);
        }

        service.supprimerColis(c1.getReference());
    }
}
