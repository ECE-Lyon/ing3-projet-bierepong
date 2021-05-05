package AffichageEmployee;

import ElementDeBase.Film;
import ElementDeBase.Membre;
import ElementDeBase.Reduction;
import ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;

public class ModifEmployee extends JFrame {
    protected void ModifFilm(Film film) {
        setTitle("Modification Film");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel titreLab = new JLabel("  Titre :");
        JTextField titreField = new JTextField(film.title);
        contentPane.add(titreLab);contentPane.add(titreField);

        JLabel genreLab = new JLabel("  Genre :");
        JTextField genreField = new JTextField(film.genre);
        contentPane.add(genreLab);contentPane.add(genreField);

        JLabel dateLab = new JLabel("  Date de sortie :");
        JTextField dateField = new JTextField(film.releaseDate);
        contentPane.add(dateLab);contentPane.add(dateField);

        JLabel dureeLab = new JLabel("  Durée :");
        JTextField dureeField = new JTextField(Integer.toString(film.runningTime));
        contentPane.add(dureeLab);contentPane.add(dureeField);

        JLabel afficheLab = new JLabel("  Affiche :");
        JTextField afficheField = new JTextField(film.image);
        contentPane.add(afficheLab);contentPane.add(afficheField);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    protected void ModifMembre(Membre membre) {
        setTitle("Modification Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel idLab = new JLabel(membre.id);
        contentPane.add(empty);contentPane.add(idLab);

        JLabel prenomLab = new JLabel("  Prénom :");
        JTextField prenomField = new JTextField(membre.prenom);
        contentPane.add(prenomLab);contentPane.add(prenomField);

        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField(membre.nom);
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel ageLab = new JLabel("  Age :");
        JTextField ageField = new JTextField(Integer.toString(membre.age));
        contentPane.add(ageLab);contentPane.add(ageField);

        JLabel etudiantLab = new JLabel("  Etudiant :");
        JPanel student = new JPanel();
        student.setLayout(new GridLayout(1,2));
        JRadioButton oui = new JRadioButton("Oui");
        JRadioButton non = new JRadioButton("Non");
        if (membre.etudiant) {
            oui.setSelected(true);
        }
        else {
            non.setSelected(true);
        }
        student.add(oui);
        student.add(non);
        contentPane.add(etudiantLab);contentPane.add(student);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    protected void ModifResa(Reservation resa) {
        setTitle("Modification Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel numLab = new JLabel(Integer.toString(resa.numDeResa));
        contentPane.add(empty);contentPane.add(numLab);

        JLabel emptyBis = new JLabel("");
        JLabel idLab = new JLabel(resa.idAcheteur);
        contentPane.add(emptyBis);contentPane.add(idLab);

        JLabel filmLab = new JLabel("  Film :");
        JTextField filmField = new JTextField(resa.titreFilm);
        contentPane.add(filmLab);contentPane.add(filmField);

        JLabel nbLab = new JLabel("  Nombre de tickets :");
        JTextField nbField = new JTextField(Integer.toString(resa.nbTickets));
        contentPane.add(nbLab);contentPane.add(nbField);

        JLabel reducLab = new JLabel("  Réduction :");
        JTextField reducField = new JTextField(resa.reduc);
        contentPane.add(reducLab);contentPane.add(reducField);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    protected void ModifReduc(Reduction reduc) {
        setTitle("Modification Réduction");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(3, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);


        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField(reduc.nom);
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel montantLab = new JLabel("  Montant :");
        JTextField montantField = new JTextField(Integer.toString(reduc.montant));
        contentPane.add(montantLab);contentPane.add(montantField);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    protected void AddFilm() {
        setTitle("Ajouter un Film");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel titreLab = new JLabel("  Titre :");
        JTextField titreField = new JTextField("");
        contentPane.add(titreLab);contentPane.add(titreField);

        JLabel genreLab = new JLabel("  Genre :");
        JTextField genreField = new JTextField("");
        contentPane.add(genreLab);contentPane.add(genreField);

        JLabel dateLab = new JLabel("  Date de sortie :");
        JTextField dateField = new JTextField("");
        contentPane.add(dateLab);contentPane.add(dateField);

        JLabel dureeLab = new JLabel("  Durée :");
        JTextField dureeField = new JTextField("");
        contentPane.add(dureeLab);contentPane.add(dureeField);

        JLabel afficheLab = new JLabel("  Affiche :");
        JTextField afficheField = new JTextField("");
        contentPane.add(afficheLab);contentPane.add(afficheField);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    protected void AddMembre() {
        setTitle("Ajouter un Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel idLab = new JLabel("  ID");
        JTextField idField = new JTextField("");
        contentPane.add(idLab);contentPane.add(idField);

        JLabel prenomLab = new JLabel("  Prénom :");
        JTextField prenomField = new JTextField("");
        contentPane.add(prenomLab);contentPane.add(prenomField);

        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField("");
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel ageLab = new JLabel("  Age :");
        JTextField ageField = new JTextField("");
        contentPane.add(ageLab);contentPane.add(ageField);

        JLabel etudiantLab = new JLabel("  Etudiant :");
        JPanel student = new JPanel();
        student.setLayout(new GridLayout(1,2));
        JRadioButton oui = new JRadioButton("Oui");
        JRadioButton non = new JRadioButton("Non",true);
        student.add(oui);
        student.add(non);
        contentPane.add(etudiantLab);contentPane.add(student);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    protected void AddResa() {
        int numDeResa = 69;

        setTitle("Ajouter une Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel numLab = new JLabel(Integer.toString(numDeResa));
        contentPane.add(empty);contentPane.add(numLab);

        JLabel idLab = new JLabel("  ID Acheteur");
        JTextField idField = new JTextField("");
        contentPane.add(idLab);contentPane.add(idField);

        JLabel filmLab = new JLabel("  Film :");
        JTextField filmField = new JTextField("");
        contentPane.add(filmLab);contentPane.add(filmField);

        JLabel nbLab = new JLabel("  Nombre de tickets :");
        JTextField nbField = new JTextField("");
        contentPane.add(nbLab);contentPane.add(nbField);

        JLabel reducLab = new JLabel("  Réduction :");
        JTextField reducField = new JTextField("");
        contentPane.add(reducLab);contentPane.add(reducField);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    protected void AddReduc() {
        setTitle("Modification Réduction");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(3, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);


        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField("");
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel montantLab = new JLabel("  Montant :");
        JTextField montantField = new JTextField("");
        contentPane.add(montantLab);contentPane.add(montantField);

        JButton annule = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        Film film_1 = new Film();
        film_1.setGenre("Commédie");
        film_1.setReleaseDate("15 Janvier 2004");
        film_1.setTitle("Shrek");
        film_1.setRunningTime(106);
        film_1.setImage("Images/ShrekPNG.png");

        Membre membre = new Membre("xX_L0rd_BG_Du_06_Xx","mdp","Monot","Romain",20,true);
        membre.setAge(20);
        membre.setId("xX_L0rd_BG_Du_06_Xx");
        membre.setMDP("mdp");
        membre.setNom("Monot");
        membre.setPrenom("Romain");
        membre.setEtudiant(true);

        Reservation resa = new Reservation(2,1,membre.id,film_1.title,"Etudiante");
        resa.setNumDeResa(1);
        resa.setIdAcheteur(membre.id);
        resa.setNbTickets(2);
        resa.setReduc("Etudiante");
        resa.setTitreFilm(film_1.title);

        ModifEmployee modif = new ModifEmployee();
        modif.AddFilm();
    }
}
