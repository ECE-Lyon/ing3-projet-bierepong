package com.company.AffichageClients;

import com.company.ElementDeBase.Film;
import com.company.ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.company.ElementDeBase.Reservation.sauvegarderResa;

public class Confirmation extends JFrame {
    public Confirmation(Reservation resa)throws IOException{
        Film film= resa.film;
        setTitle("Confirmation");
        Container contentPane=this.getContentPane();
        GridLayout grid=new GridLayout(3,1);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel label= Film.LabelIconeFilmBis(film);
        add(label);

        JPanel panel1=new JPanel();
        panel1.setLayout(new GridLayout(1,3));

        JLabel blank=new JLabel("");
        panel1.add(blank);
        //le tarif de base est de 8€, si le client a une réduction on y soustrait le montant
        int tarif=resa.nbTickets*(8-resa.membre.getReduction().montant);
        JTextArea text=Film.TextAreaBis(film.title+"\n"+film.genre+"\n"+film.releaseDate+"\n"+
                film.runningTime+" minutes\n\nnombre de tickets : "+resa.nbTickets+"\n"+"tarif : "+
                tarif+"€ \n");
        panel1.add(text);

        blank=new JLabel("");
        panel1.add(blank);
        add(panel1);

        JPanel panel2=new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        JButton retour = new JButton("Retour");
        retour.addActionListener(e -> {
            dispose();
            try {
                new ChoixFilm(resa.membre);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        panel2.add(retour);

        JButton payer=new JButton("Passer la commande");
        payer.addActionListener(e -> {
            dispose();
            sauvegarderResa(resa);
            new Payment();
        });
        panel2.add(payer);

        add(panel2);

        setSize(370,500);
        setVisible(true);
    }
}
