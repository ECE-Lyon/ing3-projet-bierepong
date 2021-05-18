package com.company.AffichageEmployee.MenuModifsReduc;

import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;

import static com.company.ElementDeBase.Reduction.deleteReduc;
import static com.company.ElementDeBase.Reduction.sauvegarderReduc;

public class ModifReduc extends JFrame{
    protected ModifReduc(Reduction reduc) {
        setTitle("Modification Réduction");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(3, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);


        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField(reduc.nom);
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel montantLab = new JLabel("  Montant :");
        JTextField montantField = new JTextField(Integer.toString(reduc.montant));
        contentPane.add(montantLab);contentPane.add(montantField);

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(e -> {
            dispose();
            new MenuModifReduc();
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(e -> {
            dispose();
            String nom=nomField.getText();
            int montant=Integer.parseInt(montantField.getText());
            Reduction reduction=new Reduction(nom,montant);
            deleteReduc(reduc);
            sauvegarderReduc(reduction);
            dispose();
            new MenuModifReduc();
        });
        contentPane.add(annuler);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }
}
