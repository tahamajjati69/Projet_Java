package entities;

public class Livreur {
    private int id;
    private String nom;
    private String zone;
    private String vehicule;

    public Livreur() {}

    public Livreur(String nom, String zone, String vehicule) {
        this.nom = nom;
        this.zone = zone;
        this.vehicule = vehicule;
    }

    public Livreur(int id, String nom, String zone, String vehicule) {
        this.id = id;
        this.nom = nom;
        this.zone = zone;
        this.vehicule = vehicule;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public String getVehicule() { return vehicule; }
    public void setVehicule(String vehicule) { this.vehicule = vehicule; }

    @Override
    public String toString() {
        return nom + " (" + zone + ", " + vehicule + ")";
    }
}
