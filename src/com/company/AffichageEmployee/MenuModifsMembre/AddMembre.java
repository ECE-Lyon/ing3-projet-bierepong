package com.company.AffichageEmployee.MenuModifsMembre;

import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.ElementDeBase.Membre.sauvegarderMembre;
import static com.company.ElementDeBase.Reduction.listReducMaker;

public class AddMembre extends JFrame{
    protected AddMembre() {
        ArrayList<Reduction> reductions = listReducMaker();

        setTitle("Ajouter un Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel mailLab = new JLabel("  mail");
        JTextField mailField = new JTextField("");
        contentPane.add(mailLab);contentPane.add(mailField);

        JLabel prenomLab = new JLabel("  Prénom :");
        JTextField prenomField = new JTextField("");
        contentPane.add(prenomLab);contentPane.add(prenomField);

        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField("");
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel mdpLab = new JLabel("  Mot de passe :");
        JTextField mdpField = new JTextField("");
        contentPane.add(mdpLab);contentPane.add(mdpField);

        JLabel reducLab = new JLabel("  Réduction :");
        JComboBox reducComboBox=new JComboBox(reductions.toArray());
        contentPane.add(reducLab);contentPane.add(reducComboBox);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifMembre();
            }
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mail=mailField.getText();
                String prenom=prenomField.getText();
                String nom=nomField.getText();
                String password=mdpField.getText();
                Reduction reduction=(Reduction) reducComboBox.getSelectedItem();
                Membre membre=new Membre(mail,password,prenom,nom,reduction);
                sauvegarderMembre(membre);
                dispose();
                new MenuModifMembre();
            }
        });
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddMembre();
    }
}
