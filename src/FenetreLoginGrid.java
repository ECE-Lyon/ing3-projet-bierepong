package com.company;
import Models.Membre;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class FenetreLoginGrid extends JFrame {
    public FenetreLoginGrid() {

        setTitle("Identification");

        JLabel Titre,Mail,MDP,creercompte;//Empty;
        JTextField ValMail,valMDP;
        JButton ButSubmit, ButCreercompte, ButSubmitEmploye,ButGuest;

        Titre=new JLabel("Robert Pathé");
        Mail=new JLabel("Mail:");
        MDP=new JLabel("MdP:");
        creercompte=new JLabel("Pas de compte?");

        ValMail=new JTextField("");
        valMDP=new JPasswordField("");

        ButSubmit=new JButton("Connexion");
        ButSubmitEmploye=new JButton("Connexion staff");
        ButGuest=new JButton("Se connecter sans compte");

        ButCreercompte=new JButton("Créer un compte");

        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        JPanel Top = new JPanel();
        Top.setBackground(Color.YELLOW);
        //Top.setLayout(new GridLayout(1,1));

        JPanel Login = new JPanel();
        Login.setLayout(new GridLayout(3,2));

        JPanel Buttuns = new JPanel();

        JPanel CreerCompte = new JPanel();

        ButSubmit.addActionListener(e -> {
        int n=0;
            try (Connection con = DriverManager.getConnection("jdbc:h2:./default"); PreparedStatement statement = con.prepareStatement("select MAIL,PASSWORD from members")) {
                //statement.setString(1, "mail");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while(resultSet.next()) {
                        String mail = resultSet.getString("mail");
                        String password = resultSet.getString("password");
                        if (ValMail.getText().equals(mail) && valMDP.getText().equals(password)) {
                            dispose();
                            new FenetrePrincipale();
                            n=1;
                        }
                    }
                    if(n==0){JOptionPane.showMessageDialog(Buttuns, "Identifiants incorrectssssss");}

                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });

        ButSubmitEmploye.addActionListener(e -> {

            try (Connection con = DriverManager.getConnection("jdbc:h2:./default"); PreparedStatement statement = con.prepareStatement("select MAIL,PASSWORD from members")) { //ATT EMPLOYES!!!
                try (ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()) {
                        String mail = resultSet.getString("mail");
                        String password = resultSet.getString("password");
                        if (ValMail.getText().equals(mail) && valMDP.getText().equals(password)) {
                            dispose();
                            new FenetrePrincipale();
                        }
                        else{
                            JOptionPane.showMessageDialog(Buttuns, "Identifiants incorrects");
                        }
                    }
                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });

        ButCreercompte.addActionListener(e -> {
            dispose();
            new FenetreCreerCompteGrid();
        });


        ButGuest.addActionListener(e -> {
            dispose();
            try {
                new FenetrePrincipale();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        Top.add(Titre);Login.add(Mail); Login.add(ValMail);Login.add(MDP);Login.add(valMDP);
        Buttuns.add(ButSubmit);Buttuns.add(ButGuest);Buttuns.add(ButSubmitEmploye);CreerCompte.add(creercompte);CreerCompte.add(ButCreercompte);

        add(Top);add(Login);add(Buttuns);add(CreerCompte);

        setSize(new Dimension(500,500));
        setVisible(true);



    }
}
