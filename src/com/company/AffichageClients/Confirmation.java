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

import static com.company.ElementDeBase.Film.deleteFilm;
import static com.company.ElementDeBase.Film.sauvegarderFilm;
import static com.company.ElementDeBase.Reservation.sauvegarderResa;

public class Confirmation extends JFrame {
    private Reservation resa;
    public Confirmation(Reservation resa)throws IOException{
        Film film= resa.film;
        setTitle("Confirmation");
        Container contentPane=this.getContentPane();
        GridLayout grid=new GridLayout(3,1);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel label= Film.LabelIconeFilmBis(film);
        add(label);
        JTextArea textFilm=Film.TextAreaBis(film.title+"\n"+film.genre+"\n"+film.releaseDate+"\n"+
                Integer.toString(film.runningTime)+" minutes");
        add(textFilm);

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(2,1));

        int tarif=resa.nbTickets*(8-resa.membre.getReduction().montant);

        JTextArea textResa=Film.TextAreaBis("nombre de tickets : "+resa.nbTickets+"\n"+
                "tarif : "+tarif+"€ \n");
        panel.add(textResa);

        JPanel panelBis = new JPanel();
        panelBis.setLayout(new GridLayout(1,2));
        JButton payer=new JButton("Passer la commande");
        payer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                sauvegarderResa(resa);
                new Payment();
            }
        });
        JButton retour = new JButton("Retour");
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new ChoixFilm(resa.membre);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        panelBis.add(retour);
        panelBis.add(payer);

        panel.add(panelBis);
        add(panel);

        setSize(250,500);
        setVisible(true);
    }

    public static void main(String[] args)throws IOException{
        Film film = new Film("Shrek","15 Janvier 2004",106,
                "Commédie","Images/ShrekPNG.png",1);
        Reduction reduction=new Reduction("étudiante",4);
        Membre membre=new Membre("michel","michelineCla+b'L","Michelin", "Michel",
                reduction);
        Reservation reservation=new Reservation(2,1,membre,film);
        new Confirmation(reservation);
    }
}
