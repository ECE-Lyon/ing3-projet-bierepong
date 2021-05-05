package ElementDeBase;

public class Reduction {
    public String nom;
    public int montant;

    public Reduction(String nom,int montant){
        this.nom=nom;
        this.montant=montant;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getMontant() { return montant; }
    public void setMontant(int montant) { this.montant = montant; }
}
