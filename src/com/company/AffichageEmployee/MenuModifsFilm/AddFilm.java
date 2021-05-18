package com.company.AffichageEmployee.MenuModifsFilm;

import com.company.ElementDeBase.Film;

import javax.swing.*;
import java.awt.*;

import static com.company.ElementDeBase.Film.sauvegarderFilm;

public class AddFilm extends JFrame{
    protected AddFilm() {
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

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(e -> {
            dispose();
            new MenuModifFilm();
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(e -> {
            String titre=titreField.getText();
            String genre=genreField.getText();
            String releaseDate=dateField.getText();
            int duree=Integer.parseInt(dureeField.getText());
            String image=afficheField.getText();
            Film film=new Film(titre,releaseDate,duree,genre,image,0);
            sauvegarderFilm(film);
            dispose();
            new MenuModifFilm();
        });
        contentPane.add(annuler);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddFilm();
    }
}
