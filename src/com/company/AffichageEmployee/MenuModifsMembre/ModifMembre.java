package com.company.AffichageEmployee.MenuModifsMembre;

import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Membre.deleteMembre;
import static com.company.ElementDeBase.Membre.sauvegarderMembre;
import static com.company.ElementDeBase.Reduction.listReducMaker;

public class ModifMembre extends JFrame{
    protected ModifMembre(Membre membre) {
        int index = 0;
        ArrayList<Reduction> reductions = listReducMaker();
        while(!reductions.get(index).getNom().equals(membre.getReduction().getNom())){index++;}


        setTitle("Modification Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel mailLab = new JLabel(membre.getMail());
        contentPane.add(empty);contentPane.add(mailLab);

        JLabel prenomLab = new JLabel("  Prénom :");
        JTextField prenomField = new JTextField(membre.getPrenom());
        contentPane.add(prenomLab);contentPane.add(prenomField);

        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField(membre.getNom());
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel passwordLab = new JLabel("  Mot de passe :");
        JTextField passwordField = new JTextField(membre.getPassword());
        contentPane.add(passwordLab);contentPane.add(passwordField);

        JLabel reducLab = new JLabel("  Réductions :");
        JComboBox reducsComboBox=new JComboBox(reductions.toArray());
        reducsComboBox.setSelectedIndex(index);
        contentPane.add(reducLab);contentPane.add(reducsComboBox);

        JButton annuler = new JButton("Annuler");
        annuler.addActionListener(e -> {
            dispose();
            new MenuModifMembre();
        });
        JButton valider = new JButton("Valider");
        valider.addActionListener(e -> {
            dispose();
            String prenom=prenomField.getText();
            String nom=nomField.getText();
            String password=passwordField.getText();
            Reduction reduction=(Reduction) reducsComboBox.getSelectedItem();
            Membre membre1=new Membre(membre.getMail(),password,nom,prenom,reduction);
            deleteMembre(membre);
            sauvegarderMembre(membre1);
            new MenuModifMembre();
        });
        contentPane.add(annuler);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }
}
