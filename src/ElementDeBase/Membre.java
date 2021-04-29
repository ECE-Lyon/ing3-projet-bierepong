package ElementDeBase;

public class Membre {
    public String id;
    public String mdp;
    public String nom;
    public String prenom;
    public int age;
    public boolean etudiant;

    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }

    public void setEtudiant(boolean etudiant) { this.etudiant = etudiant; }
    public boolean isEtudiant() { return etudiant; }

    public void setId(String id) { this.id = id; }
    public String getId() { return id; }

    public void setMDP(String MDP) { this.mdp = MDP; }
    public String getMDP() { return mdp; }

    public void setNom(String nom) { this.nom = nom; }
    public String getNom() { return nom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getPrenom() { return prenom; }
}
