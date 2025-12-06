package services;

import dao.LivreurDao;
import entities.Livreur;
import java.util.List;

public class LivreurService {

    private final LivreurDao livreurDao;

    public LivreurService() {
        livreurDao = new LivreurDao();
    }

    public boolean ajouterLivreur(Livreur l) {
        return livreurDao.create(l);
    }

    public boolean modifierLivreur(Livreur l) {
        return livreurDao.update(l);
    }

    public boolean supprimerLivreur(int id) {
        return livreurDao.delete(id);
    }

    public Livreur getLivreur(int id) {
        return livreurDao.findById(id);
    }

    public List<Livreur> listeLivreurs() {
        return livreurDao.findAll();
    }

    public List<Livreur> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean update(Livreur l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
