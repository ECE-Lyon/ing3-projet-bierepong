package com.company.AffichageEmployee.MenuModifResa;

import com.company.ElementDeBase.Film;
import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Film.libMaker;
import static com.company.ElementDeBase.Membre.listMembreMaker;
import static com.company.ElementDeBase.Reservation.listResaMaker;
import static com.company.ElementDeBase.Reservation.sauvegarderResa;

public class AddResa extends JFrame {
    protected AddResa(){
        ArrayList<Reservation> resas = listResaMaker();
        ArrayList<Film> films = libMaker();
        ArrayList<Membre> membres = listMembreMaker();

        setTitle("Ajouter une Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(5, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel numLab = new JLabel(Integer.toString(resas.size()));
        contentPane.add(empty);contentPane.add(numLab);

        JLabel mailLab = new JLabel("  Adresse mail");
        JComboBox membreComboBox=new JComboBox(membres.toArray());
        contentPane.add(mailLab);contentPane.add(membreComboBox);

        JLabel filmLab = new JLabel("  Film :");
        JComboBox filmsComboBox=new JComboBox(films.toArray());
        contentPane.add(filmLab);contentPane.add(filmsComboBox);

        JLabel nbLab = new JLabel("  Nombre de tickets :");
        JTextField nbField = new JTextField("");
        contentPane.add(nbLab);contentPane.add(nbField);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(e -> {
            dispose();
            new MenuModifResa();
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(e -> {
            Membre membre=(Membre) membreComboBox.getSelectedItem();
            Film film=(Film) filmsComboBox.getSelectedItem();
            int nbTickets=Integer.parseInt(nbField.getText());
            int numResa =resas.get(0).getNumDeResa();
            for (Reservation resa : resas) {
                if (numResa < resa.getNumDeResa()) {
                    numResa = resa.getNumDeResa();
                }
            }
            numResa++;
            Reservation reservation=new Reservation(nbTickets,numResa,membre,film);
            sauvegarderResa(reservation);
            dispose();
            new MenuModifResa();
        });
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddResa();
    }
}
