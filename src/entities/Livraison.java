package entities;

import java.util.Date;

public class Livraison {
    private int id;
    private String statut;
    private Date dateLivraison;
    private int colisRef;
    private int livreurId;

    public Livraison() {}

    public Livraison(String statut, Date dateLivraison, int colisRef, int livreurId) {
        this.statut = statut;
        this.dateLivraison = dateLivraison;
        this.colisRef = colisRef;
        this.livreurId = livreurId;
    }

    public Livraison(int id, String statut, Date dateLivraison, int colisRef, int livreurId) {
        this.id = id;
        this.statut = statut;
        this.dateLivraison = dateLivraison;
        this.colisRef = colisRef;
        this.livreurId = livreurId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Date getDateLivraison() { return dateLivraison; }
    public void setDateLivraison(Date dateLivraison) { this.dateLivraison = dateLivraison; }

    public int getColisRef() { return colisRef; }
    public void setColisRef(int colisRef) { this.colisRef = colisRef; }

    public int getLivreurId() { return livreurId; }
    public void setLivreurId(int livreurId) { this.livreurId = livreurId; }

    @Override
    public String toString() {
        return "Livraison{" +
                "id=" + id +
                ", statut='" + statut + '\'' +
                ", dateLivraison=" + dateLivraison +
                ", colisRef=" + colisRef +
                ", livreurId=" + livreurId +
                '}';
    }
}
