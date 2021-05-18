package com.company.AffichageEmployee.MenuModifsReduc;

import com.company.AffichageEmployee.MenuEmployee;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Reduction.deleteReduc;
import static com.company.ElementDeBase.Reduction.listReducMaker;

public class MenuModifReduc extends JFrame{
    public MenuModifReduc(){
        ArrayList<Reduction> reductions = listReducMaker();
        setTitle("Menu Réduction");
        int len = reductions.size();
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(Reduction reduction:reductions){
            JLabel label = new JLabel("  " + reduction.nom);
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("modifier");
            modifier.addActionListener(e -> {
                dispose();
                new ModifReduc(reduction);
            });
            panelBis.add(modifier);

            JButton supprimer=new JButton("Supprimer");
            supprimer.addActionListener(e -> {
                dispose();
                deleteReduc(reduction);
                new MenuModifReduc();
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

        JButton add=new JButton("Ajouter une Réduction");
        add.addActionListener(e -> {
            dispose();
            new AddReduc();
        });
        add(add);
        setSize(500,40*(len+1));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuModifReduc();
    }
}
