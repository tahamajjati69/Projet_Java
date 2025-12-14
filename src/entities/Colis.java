package entities;

public class Colis {
    private int reference;          
    private double poids;
    private String villeDestination;

    public Colis(int reference, double poids, String villeDestination) {
        this.reference = reference;
        this.poids = poids;
        this.villeDestination = villeDestination;
    }

    public Colis(double poids, String villeDestination) {
        this.poids = poids;
        this.villeDestination = villeDestination;
    }

    // Getters & Setters
    public int getReference() { return reference; }
    public void setReference(int reference) { this.reference = reference; }

    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }

    public String getVilleDestination() { return villeDestination; }
    public void setVilleDestination(String villeDestination) { this.villeDestination = villeDestination; }

    @Override
    public String toString() {
        return "Colis{" +
                "reference=" + reference +
                ", poids=" + poids +
                ", villeDestination='" + villeDestination + '\'' +
                '}';
    }
}
