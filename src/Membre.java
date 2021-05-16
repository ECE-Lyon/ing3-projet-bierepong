package Models;

public class Membre {

        private String Mail;
        private String Nom;
        private String Prenom;
        private String Password;
        private int age;
        private String Etudiant;
        private String Senior;

    public String getSenior() {
        return Senior;
    }

    public void setSenior(String senior) {
        Senior = senior;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEtudiant() {
        return Etudiant;
    }

    public void setEtudiant(String etudiant) {
        Etudiant = etudiant;
    }

    @Override
        public String toString() {
            return "Album{" +
                    ", Mail='" + Mail + '\'' +
                    ", MotDePasse='" +Password + '\'' +
                    ", Nom='" +Nom + '\'' +
                    ", Prenom=" + Prenom + '\''+
                    ", Age='" +age + '\'' +
                    ", Etudiant='" +Etudiant +
                    '}';
        }
    }

