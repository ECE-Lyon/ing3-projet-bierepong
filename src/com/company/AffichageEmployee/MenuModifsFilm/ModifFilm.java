package com.company.AffichageEmployee.MenuModifsFilm;

import com.company.ElementDeBase.Film;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.ElementDeBase.Film.deleteFilm;
import static com.company.ElementDeBase.Film.sauvegarderFilm;

public class ModifFilm extends JFrame{
    protected ModifFilm(Film film) {
        setTitle("Modification Film");

        Container contentPane = this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel titreLab = new JLabel("  Titre :");
        JTextField titreField = new JTextField(film.title);
        contentPane.add(titreLab);
        contentPane.add(titreField);

        JLabel genreLab = new JLabel("  Genre :");
        JTextField genreField = new JTextField(film.genre);
        contentPane.add(genreLab);
        contentPane.add(genreField);

        JLabel dateLab = new JLabel("  Date de sortie :");
        JTextField dateField = new JTextField(film.releaseDate);
        contentPane.add(dateLab);
        contentPane.add(dateField);

        JLabel dureeLab = new JLabel("  Durée :");
        JTextField dureeField = new JTextField(Integer.toString(film.runningTime));
        contentPane.add(dureeLab);
        contentPane.add(dureeField);

        JLabel afficheLab = new JLabel("  Affiche :");
        JTextField afficheField = new JTextField(film.image);
        contentPane.add(afficheLab);
        contentPane.add(afficheField);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifFilm();
            }
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titre=titreField.getText();
                String genre=genreField.getText();
                String releaseDate=dateField.getText();
                int duree=Integer.parseInt(dureeField.getText());
                String image=afficheField.getText();
                Film film1=new Film(titre,releaseDate,duree,genre,image, film.nbDeVente);
                deleteFilm(film);
                sauvegarderFilm(film1);
                dispose();
                new MenuModifFilm();
            }
        });
        contentPane.add(annule);
        contentPane.add(valider);

        setSize(500, 250);
        setVisible(true);
    }
}
