package com.company.AffichageEmployee.MenuModifResa;

import com.company.ElementDeBase.Film;
import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Film.*;
import static com.company.ElementDeBase.Reservation.deleteResa;
import static com.company.ElementDeBase.Reservation.sauvegarderResa;

public class ModifResa extends JFrame{
    protected ModifResa(Reservation resa,Membre membre) {
        int index = 0;
        ArrayList<Film> films = libMaker();
        while(!resa.film.getTitle().equals(films.get(index).getTitle())){index++;}

        setTitle("Modification Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(5, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel numLab = new JLabel(Integer.toString(resa.numDeResa));
        contentPane.add(empty);contentPane.add(numLab);

        JLabel emptyBis = new JLabel("");
        JLabel idLab = new JLabel(resa.membre.getMail());
        contentPane.add(emptyBis);contentPane.add(idLab);

        JLabel filmLab = new JLabel("  Film :");
        JComboBox filmsComboBox=new JComboBox(films.toArray());
        filmsComboBox.setSelectedIndex(index);
        contentPane.add(filmLab);contentPane.add(filmsComboBox);

        JLabel nbLab = new JLabel("  Nombre de tickets :");
        JTextField nbField = new JTextField(Integer.toString(resa.nbTickets));
        contentPane.add(nbLab);contentPane.add(nbField);

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(e -> {
            dispose();
            new MenuModifResa();
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(e -> {
            Film film=(Film) filmsComboBox.getSelectedItem();
            int nbTickets=Integer.parseInt(nbField.getText());
            Reservation reservation=new Reservation(nbTickets,resa.numDeResa,membre,film);
            //Décremente le nombre de places vendues sur le film en fontion de l'ancienne reservation
            Film film1 = reservation.getFilm();
            film1.setNbDeVente(reservation.getFilm().getNbDeVente()-resa.getNbTickets());
            deleteFilm(reservation.getFilm());
            sauvegarderFilm(film1);

            deleteResa(resa);
            sauvegarderResa(reservation);
            dispose();
            new MenuModifResa();
        });
        contentPane.add(annuler);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }
}
