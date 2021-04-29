import javax.swing.*;
import java.awt.*;

public class ModifEmployee extends JFrame {
    protected void ModifFilm(Film film) {
        setTitle("Modification Film");
        GridLayout grid = new GridLayout(5, 2);
        grid.setVgap(3);
        setLayout(grid);

        JLabel titreLab = new JLabel("  Titre :");
        JTextField titreField = new JTextField(film.title);
        add(titreLab);add(titreField);

        JLabel genreLab = new JLabel("  Genre :");
        JTextField genreField = new JTextField(film.genre);
        add(genreLab);add(genreField);

        JLabel dateLab = new JLabel("  Date de sortie :");
        JTextField dateField = new JTextField(film.releaseDate);
        add(dateLab);add(dateField);

        JLabel dureeLab = new JLabel("  Durée :");
        JTextField dureeField = new JTextField(Integer.toString(film.runningTime));
        add(dureeLab);add(dureeField);

        JLabel afficheLab = new JLabel("  Affiche :");
        JTextField afficheField = new JTextField(film.image);
        add(afficheLab);add(afficheField);

        setSize(500,250);
        setVisible(true);
    }

    protected void ModifMembre(Membre membre) {
        setTitle("Modification Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(5, 2);
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
        setSize(500,250);
        setVisible(true);
    }

    protected void ModifResa(Reservation resa) {
        setTitle("Modification Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(5, 2);
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
        JTextField reducField = new JTextField(Integer.toString(resa.reduc));
        contentPane.add(reducLab);contentPane.add(reducField);

        setSize(500,250);
        setVisible(true);
    }

    protected void AddFilm() {
        setTitle("Modification Film");
        GridLayout grid = new GridLayout(5, 2);
        grid.setVgap(3);
        setLayout(grid);

        JLabel titreLab = new JLabel("  Titre :");
        JTextField titreField = new JTextField("");
        add(titreLab);add(titreField);

        JLabel genreLab = new JLabel("  Genre :");
        JTextField genreField = new JTextField("");
        add(genreLab);add(genreField);

        JLabel dateLab = new JLabel("  Date de sortie :");
        JTextField dateField = new JTextField("");
        add(dateLab);add(dateField);

        JLabel dureeLab = new JLabel("  Durée :");
        JTextField dureeField = new JTextField("");
        add(dureeLab);add(dureeField);

        JLabel afficheLab = new JLabel("  Affiche :");
        JTextField afficheField = new JTextField("");
        add(afficheLab);add(afficheField);

        setSize(500,250);
        setVisible(true);
    }

    protected void AddMembre() {
        setTitle("Modification Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(5, 2);
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
        setSize(500,250);
        setVisible(true);
    }

    protected void AddResa() {
        int numDeResa = 69;

        setTitle("Modification Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(5, 2);
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

        Membre membre = new Membre();
        membre.setAge(20);
        membre.setId("xX_L0rd_BG_Du_06_Xx");
        membre.setMDP("mdp");
        membre.setNom("Monot");
        membre.setPrenom("Romain");
        membre.setEtudiant(true);

        Reservation resa = new Reservation();
        resa.setNumDeResa(1);
        resa.setIdAcheteur(membre.id);
        resa.setNbTickets(2);
        resa.setReduc(25);
        resa.setTitreFilm(film_1.title);

        ModifEmployee modif = new ModifEmployee();
        modif.AddMembre();
    }
}
