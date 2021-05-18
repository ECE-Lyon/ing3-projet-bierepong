package com.company.AffichageEmployee.MenuModifsMembre;

import com.company.AffichageEmployee.MenuEmployee;
import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.ElementDeBase.Membre.deleteMembre;
import static com.company.ElementDeBase.Membre.listMembreMaker;
import static com.company.ElementDeBase.Reduction.listReducMaker;

public class MenuModifMembre extends JFrame{
    public MenuModifMembre(){
        ArrayList<Membre> membres = listMembreMaker();

        setTitle("Menu Membre");
        int len = membres.size();
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(int i=0;i<len;i++){
            Membre membre=membres.get(i);
            JLabel id = new JLabel("  " + membre.getMail());
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("Modifier");
            modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ModifMembre(membre);
                }
            });
            panelBis.add(modifier);

            JButton supprimer=new JButton("Supprimer");
            supprimer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    deleteMembre(membre);
                    new MenuModifMembre();
                }
            });
            panelBis.add(supprimer);

            add(id);
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

        JButton add=new JButton("Ajouter un Membre");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddMembre();
            }
        });
        add(add);
        setSize(500,60*(len+1));
        setVisible(true);
    }


    public static void main(String[] args) {
        new MenuModifMembre();
    }
}
