package services;

import dao.LivraisonDao;
import entities.Livraison;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class LivraisonService {

    private final LivraisonDao livraisonDao;

    public LivraisonService() throws SQLException {
        livraisonDao = new LivraisonDao();
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

    public Map<Integer, Integer> getLivraisonsParMois() {
        return livraisonDao.getLivraisonsParMois();
    }
}
