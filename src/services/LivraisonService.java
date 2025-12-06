package services;

import dao.GraphLivraisonDao;
import dao.LivraisonDao;
import entities.Livraison;

import java.util.List;
import java.util.Map;

public class LivraisonService {

    private final LivraisonDao livraisonDao;
    private final GraphLivraisonDao graphDao;

    public LivraisonService() {
        
        livraisonDao = new LivraisonDao();
        graphDao = new GraphLivraisonDao();
        // DAO pour les statistiques
    }

    public boolean ajouterLivraison(Livraison l) {
        return livraisonDao.create(l);
    }

    public boolean modifierLivraison(Livraison l) {
        return livraisonDao.update(l);
    }

    public boolean supprimerLivraison(int id) {
        return livraisonDao.delete(id);
    }

    public Livraison getLivraison(int id) {
        return livraisonDao.findById(id);
    }

    public List<Livraison> listeLivraisons() {
        return livraisonDao.findAll();
    }
    public List<Livraison> getLivraisonsParStatut(String statut) {
    return livraisonDao.findByStatut(statut);
}

    
    // Récupère le nombre de livraisons par mois
    public Map<Integer, Integer> getLivraisonsParMois() {
        return graphDao.getLivraisonsParMois();
    }
}
