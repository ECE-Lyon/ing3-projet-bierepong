package com.company.AffichageClients;

import com.company.Connexion.FenetreLoginGrid;
import com.company.ElementDeBase.Film;
import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reduction;
import com.company.ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static com.company.ElementDeBase.Film.libMaker;
import static com.company.ElementDeBase.Reservation.listResaMaker;

public class ChoixFilm extends JFrame {
    private Membre membre;

    public ChoixFilm(Membre membre) throws IOException {
        ArrayList<Film> lib = libMaker();
        ArrayList<Reservation> reservationArrayList = listResaMaker();
        int nbFilm = lib.size();

        int tailleFenetre = ((nbFilm - 1) / 5 + 2) * 2;

        setTitle("Sélection");
        GridLayout grid = new GridLayout(tailleFenetre, 5);

        grid.setHgap(10);
        setLayout(grid);

        //Cette boucle sert à afficher les films les uns après les autres
        for (int j = 0; j < (nbFilm - 1) / 5 + 1; j++) {
            if (nbFilm - (j * 5) < 5) { // if (il reste moins de 5 films à afficher sur une ligne)
                for (int i = 0; i < nbFilm % 5; i++) {
                    JLabel label = Film.LabelIconeFilmBis(lib.get(i + j * 5));
                    add(label);
                }
                for (int i = 0; i < 5 - nbFilm % 5; i++) {//Complete le reste de la ligne de case vide
                    JLabel blank = new JLabel("");
                    add(blank);
                }
                for (int i = 0; i < nbFilm % 5; i++) {
                    JTextArea txt = Film.TextAreaBis(lib.get(i + j * 5).title + "\n" + lib.get(i + j * 5).genre + "\n"
                            + lib.get(i + j * 5).releaseDate + "\n" + Integer.toString(lib.get(i + j * 5).runningTime)
                            + " min");
                    add(txt);
                }
                for (int i = 0; i < 5 - nbFilm % 5; i++) {//Complete le reste de la ligne de case vide
                    JLabel blank = new JLabel("");
                    add(blank);
                }
            } else {
                for (int i = 0; i < 5; i++) {
                    JLabel label = Film.LabelIconeFilmBis(lib.get(i));
                    add(label);
                }
                for (int i = 0; i < 5; i++) {
                    JTextArea txt = Film.TextAreaBis(lib.get(i).title + "\n" + lib.get(i).genre + "\n" +
                            lib.get(i).releaseDate + "\n" + Integer.toString(lib.get(i).runningTime) + " min");
                    add(txt);
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            JLabel blank = new JLabel("");
            add(blank);
        }


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JPanel panelFilm = new JPanel();
        panelFilm.setLayout(new GridLayout(1, 2));
        JLabel filmLabel = new JLabel("Film");
        JComboBox choixFilm = new JComboBox(lib.toArray());
        panelFilm.add(filmLabel);
        panelFilm.add(choixFilm);

        JPanel panelNbTicket = new JPanel();
        panelNbTicket.setLayout(new GridLayout(1, 2));
        JLabel labelNbTickets = new JLabel("Nombre de tickets");
        JTextField champ = new JTextField("");
        panelNbTicket.add(labelNbTickets);
        panelNbTicket.add(champ);

        panel.add(panelFilm);
        panel.add(panelNbTicket);
        add(panel);

        for (int i = 0; i < 4; i++) {
            JLabel blank = new JLabel("");
            add(blank);
        }

        JButton acheter = new JButton("Acheter");
        acheter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Film film=(Film) choixFilm.getSelectedItem();
                int nbTickets=Integer.parseInt(champ.getText());
                int numResa =reservationArrayList.get(0).getNumDeResa();
                for (int i = 0;i< reservationArrayList.size();i++) {
                    if (numResa < reservationArrayList.get(i).getNumDeResa()) {
                        numResa = reservationArrayList.get(i).getNumDeResa();
                    }
                }
                numResa++;

                Reservation resa=new Reservation(nbTickets,numResa,membre,film);
                dispose();
                try {
                    new Confirmation(resa);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        add(acheter);
        JLabel blank = new JLabel("");
        add(blank);
        JButton logOut = new JButton("Log out");
        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FenetreLoginGrid();
            }
        });
        add(logOut);

        setSize(new Dimension(1040, tailleFenetre * 150));
        setVisible(true);
    }


    public static void main(String[] args) throws IOException {
        Reduction reduction = new Reduction("student", 4);
        Membre membre = new Membre("a@g.com", "passw0rd", "Michou", "Michel",
                reduction);
        new ChoixFilm(membre);
    }
}