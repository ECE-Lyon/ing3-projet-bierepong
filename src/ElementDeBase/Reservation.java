package ElementDeBase;

public class Reservation {
    public int nbTickets;
    public int numDeResa;
    public String idAcheteur;
    public String titreFilm;
    public String reduc;

    public int getNbTickets() { return nbTickets; }
    public void setNbTickets(int nbTickets) { this.nbTickets = nbTickets; }

    public String  getTitreFilm() { return titreFilm; }
    public void setTitreFilm(String film) { this.titreFilm = film; }

    public String  getIdAcheteur() { return idAcheteur; }
    public void setIdAcheteur(String acheteur) { this.idAcheteur = acheteur; }

    public int getNumDeResa() { return numDeResa; }
    public void setNumDeResa(int numDeResa) { this.numDeResa = numDeResa; }

    public String getReduc() { return reduc; }
    public void setReduc(String reduc) { this.reduc = reduc; }
}

