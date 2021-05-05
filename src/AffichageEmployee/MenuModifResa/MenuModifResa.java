package AffichageEmployee.MenuModifResa;

import AffichageEmployee.MenuEmployee;
import AffichageEmployee.MenuModifResa.ModifResa;
import ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuModifResa extends JFrame{
    public MenuModifResa(){
        Reservation[] Lib=getResa();
        setTitle("Menu Réservation");
        int len = Lib.length;
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(int i=0;i<len;i++){
            Reservation reservation=Lib[i];
            JLabel label = new JLabel("  " + Integer.toString(reservation.numDeResa));
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("modifier");
            modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ModifResa(reservation);
                }
            });
            panelBis.add(modifier);

            panelBis.add(new JButton("Supprimer"));

            add(label);
            add(panelBis);
        }
        JButton retour=new JButton("Retour");
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuEmployee();
            }
        });
        add(retour);

        JButton add=new JButton("Ajouter une Réservation");
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddResa();
            }
        });
        add(add);

        setSize(500,40*(len+1));
        setVisible(true);
    }
    public Reservation[] getResa(){
        Reservation resa = new Reservation(2,1,"michel","Schreck",
                "Etudiante");
        Reservation[] reservations={resa};
        return reservations;
    }

    public static void main(String[] args) {
        new MenuModifResa();
    }
}
