package com.company.AffichageEmployee.MenuModifResa;

import com.company.AffichageEmployee.MenuEmployee;
import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.ElementDeBase.Reservation.deleteResa;
import static com.company.ElementDeBase.Reservation.listResaMaker;

public class MenuModifResa extends JFrame{
    public MenuModifResa(){
        ArrayList<Reservation> reservations = listResaMaker();

        setTitle("Menu Réservation");
        int len = reservations.size();
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(Reservation reservation:reservations){
            JLabel label = new JLabel("  " + reservation.numDeResa);
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("modifier");
            modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Membre membre= reservation.membre;
                    dispose();
                    new ModifResa(reservation,membre);
                }
            });
            panelBis.add(modifier);

            JButton supprimer=new JButton("supprimer");
            supprimer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    deleteResa(reservation);
                    new MenuModifResa();
                }
            });
            panelBis.add(supprimer);

            add(label);
            add(panelBis);
        }
        JButton retour=new JButton("Retour");
        retour.addActionListener(e -> {
            dispose();
            new MenuEmployee();
        });
        add(retour);

        JButton add=new JButton("Ajouter une Réservation");
        add.addActionListener(e -> {
            dispose();
            new AddResa();
        });
        add(add);

        setSize(500,40*(len+1));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuModifResa();
    }
}
