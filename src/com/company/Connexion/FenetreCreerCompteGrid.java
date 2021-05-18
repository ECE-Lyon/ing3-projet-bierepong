package com.company.Connexion;

import com.company.AffichageClients.ChoixFilm;
import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FenetreCreerCompteGrid extends JFrame {

    public FenetreCreerCompteGrid() {

        setTitle("Création de compte");

        // Déclaration des objets graphiques
        JLabel Titre,Mail,MDP,ValidMDP,Nom,Prenom;
        JTextField ValMail,valMDP,valValidMDP,valNom,valPrenom;
        JButton ButSubmit, ButRetour;

        Titre=new JLabel("Robert Pathé, création de compte");
        Nom=new JLabel("Nom:");
        Prenom=new JLabel("Prenom:");
        Mail=new JLabel("Mail:");
        MDP=new JLabel("MDP:");
        ValidMDP=new JLabel("Vérifier le mdp:");

        valNom=new JTextField("");
        valPrenom=new JTextField("");
        ValMail=new JTextField("");
        valMDP=new JPasswordField("");
        valValidMDP=new JPasswordField("");

        ButSubmit=new JButton("Valider");
        ButRetour=new JButton("Retour");

        //Paramètres du grid
        GridLayout grid = new GridLayout(3, 3);
        grid.setHgap(10);
        setLayout(grid);

        //Déclarations des panels (paramètres par defaut)
        JPanel Top = new JPanel();

        JPanel Login = new JPanel();
        Login.setLayout(new GridLayout(6,2));

        JPanel Buttons = new JPanel();


        ButSubmit.addActionListener(e -> {
            String nom = valNom.getText();
            String prenom = valPrenom.getText();
            String mail =ValMail.getText();
            String password = valMDP.getText();
            String verifPassword = valValidMDP.getText();
            Reduction reduction = new Reduction("Aucune",0);

            Membre membre = new Membre(mail,password,nom,prenom,reduction);

            if(password.equals(verifPassword)){
                Sauvegarder(membre);
                dispose();
                try {
                    new ChoixFilm(membre);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else{
                JOptionPane.showMessageDialog(Buttons, "Vos mots de passe doivent être identiques!");
            }
        });


        ButRetour.addActionListener(e -> {
            dispose();
            new FenetreLoginGrid();
        });

        Top.add(Titre);

        Login.add(Nom);Login.add(valNom);Login.add(Prenom);Login.add(valPrenom);Login.add(Mail);
        Login.add(ValMail);Login.add(MDP);Login.add(valMDP);Login.add(ValidMDP);Login.add(valValidMDP);

        Buttons.add(ButRetour);Buttons.add(ButSubmit);

        add(Top);add(Login);add(Buttons);

        setSize(new Dimension(500,300));
        setVisible(true);
    }

    void Sauvegarder(Membre membre) {

        try{
            Connection con = DriverManager.getConnection("jdbc:h2:./default");

            try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO MEMBERS (Mail, Password, nom,prenom, reduction) VALUES (?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, membre.getMail());
                preparedStatement.setString(2, membre.getPassword());
                preparedStatement.setString(3, membre.getNom());
                preparedStatement.setString(4, membre.getPrenom());
                String red = membre.getReduction().nom;
                preparedStatement.setString(5,red);
                preparedStatement.execute();
            }
            con.close();
        }catch(
                SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FenetreCreerCompteGrid();
    }
}
