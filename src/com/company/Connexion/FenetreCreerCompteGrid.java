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

        // Declaration des objets graphiques
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

        //Parametres du grid

        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        //Declarations des pannels (parametres par defaut)
        JPanel Top = new JPanel();
        //Top.setLayout(new GridLayout(1,1));

        JPanel Login = new JPanel();
        Login.setLayout(new GridLayout(6,2));

        JPanel Buttuns = new JPanel();
        //Login.setLayout(new GridLayout(3,2));

        JPanel CreerCompte = new JPanel();
        //CreerCompte.setLayout(new GridLayout(1,2));


        ButSubmit.addActionListener(e -> {
            String nom = valNom.getText();
            String prenom = valPrenom.getText();
            String Mail1 =ValMail.getText();
            String Password = valMDP.getText();
            String verifPassord = valValidMDP.getText();
            Reduction reduction = new Reduction("aucune",0);

            Membre membre = new Membre(Mail1,Password,nom,prenom,reduction);
            /*boolean etudiant;
            boolean senior;

            etudiant= valEtudiant.isSelected();
            senior= valSenior.isSelected();*/

            /*membre.setMail(Mail1);
            membre.setNom(nom);
            membre.setPrenom(prenom);
            membre.setAge(age);
            membre.setPassword(Password);
            membre.setEtudiant(etudiant);
            membre.setSenior(senior);*/

            //if(!Mail1.contains("@")){JOptionPane.showMessageDialog(Buttuns, "Adresse Mail invalide!");}

            if(Password.equals(verifPassord)){
                Sauvegarder(membre);
                dispose();
                try {
                    new ChoixFilm(membre);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            else{
                JOptionPane.showMessageDialog(Buttuns, "Vos mots de passe doivent être identiques!");
            }
            //System.out.println(Mail+Password);
            //int c=0;
            //for (int i=0;i<=ValMail.lenth;i++){
            //if(ValMail[i]=='@'){//}//}
            //sauvegarder dans base de donnée
            //Sauvegarder(Type,Mail,Password);

        });


        ButRetour.addActionListener(e -> {
            dispose();
            new FenetreLoginGrid();
        });

        /*valMDP.addActionListener(new java.awt.event.ActionListener() {
                                     public void actionPerformed(java.awt.event.ActionEvent e) {
                                         String Mail1 =ValMail.getText();
                                         if (!Mail1.contains("@")){
                                             JOptionPane.showMessageDialog(null,
                                                     "Adresse Mail invalide!", "Error Message",
                                                     JOptionPane.ERROR_MESSAGE);
                                         }
                                     }
                                 });*/


        Top.add(Titre);

        Login.add(Nom);Login.add(valNom);Login.add(Prenom);Login.add(valPrenom);
        Login.add(Mail); Login.add(ValMail);Login.add(MDP);Login.add(valMDP);Login.add(ValidMDP);Login.add(valValidMDP);

        Buttuns.add(ButRetour);Buttuns.add(ButSubmit);

        add(Top);add(Login);add(Buttuns);add(CreerCompte);

        setSize(new Dimension(500,500));
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
}
