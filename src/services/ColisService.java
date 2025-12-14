package services;

import dao.ColisDao;
import entities.Colis;

import java.util.List;

public class ColisService {

    private final ColisDao colisDao;

    public ColisService() {
        colisDao = new ColisDao(); 
    }

    public boolean ajouterColis(Colis c) {
        return colisDao.create(c);
    }

    public boolean modifierColis(Colis c) {
        return colisDao.update(c);
    }

    public boolean supprimerColis(int reference) {
        return colisDao.delete(reference);
    }

    public Colis getColis(int reference) {
        return colisDao.findById(reference);
    }

    public List<Colis> listeColis() {
        return colisDao.findAll();
    }
}
