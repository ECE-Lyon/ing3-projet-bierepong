package com.company.AffichageEmployee.MenuModifsReduc;

import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.ElementDeBase.Reduction.sauvegarderReduc;

public class AddReduc extends JFrame{
    protected AddReduc() {
        setTitle("Ajouter une Réduction");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(3, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);


        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField("");
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel montantLab = new JLabel("  Montant :");
        JTextField montantField = new JTextField("");
        contentPane.add(montantLab);contentPane.add(montantField);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifReduc();
            }
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom=nomField.getText();
                int montant=Integer.parseInt(montantField.getText());
                Reduction reduction=new Reduction(nom,montant);
                sauvegarderReduc(reduction);
                dispose();
                new MenuModifReduc();
            }
        });
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddReduc();
    }
}
