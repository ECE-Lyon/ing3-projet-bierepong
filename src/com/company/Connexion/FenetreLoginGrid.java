package com.company.Connexion;

import com.company.AffichageClients.ChoixFilm;
import com.company.AffichageEmployee.MenuEmployee;
import com.company.ElementDeBase.Membre;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Reduction.listReducMaker;

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
        ButGuest=new JButton("Réserver sans compte");

        ButCreercompte=new JButton("Créer un compte");

        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        JPanel Top = new JPanel();
        Top.setBackground(Color.YELLOW);

        JPanel Login = new JPanel();
        Login.setLayout(new GridLayout(3,2));

        JPanel Buttons = new JPanel();

        JPanel CreerCompte = new JPanel();

        ArrayList<Reduction> reductionArrayList = listReducMaker();

        ButSubmit.addActionListener(e -> {
        int n=0;
            try (Connection con = DriverManager.getConnection("jdbc:h2:./default");
                 PreparedStatement statement = con.prepareStatement("select * from members")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while(resultSet.next()) {
                        String mail = resultSet.getString("mail");
                        String password = resultSet.getString("password");
                        String nom = resultSet.getString("nom");
                        String prenom = resultSet.getString("prenom");
                        String nomreduction = resultSet.getString("reduction");
                        int montantreduction =0;
                        for (Reduction reduction:reductionArrayList){
                            if(reduction.nom.equals(nomreduction)){
                                montantreduction = reduction.montant;
                            }
                        }
                        Reduction RED = new Reduction(nomreduction,montantreduction);

                        if (ValMail.getText().equals(mail) && valMDP.getText().equals(password)) {
                            dispose();
                            Membre membre=new Membre(mail,password,nom,prenom,RED);
                            new ChoixFilm(membre);
                            n=1;
                        }
                    }
                    if(n==0){JOptionPane.showMessageDialog(Buttons, "Identifiants incorrects!");}

                }
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });

        ButSubmitEmploye.addActionListener(e -> {

            try (Connection con = DriverManager.getConnection("jdbc:h2:./default");
                 PreparedStatement statement = con.prepareStatement("select MAIL,PASSWORD from employee")) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while(resultSet.next()) {
                        String mail = resultSet.getString("mail");
                        String password = resultSet.getString("password");
                        if (ValMail.getText().equals(mail) && valMDP.getText().equals(password)) {
                            dispose();
                            new MenuEmployee();
                        }
                        else{
                            JOptionPane.showMessageDialog(Buttons, "Identifiants incorrects");
                        }
                    }
                }
            } catch (SQLException throwables) {
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
                Reduction reductionguest = new Reduction("Aucune",0);
                Membre guest = new Membre("guest",null,null,null, reductionguest);
                new ChoixFilm(guest);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        Top.add(Titre);Login.add(Mail); Login.add(ValMail);Login.add(MDP);Login.add(valMDP);
        Buttons.add(ButSubmit);Buttons.add(ButGuest);Buttons.add(ButSubmitEmploye);
        CreerCompte.add(creercompte);CreerCompte.add(ButCreercompte);

        add(Top);add(Login);add(Buttons);add(CreerCompte);

        setSize(new Dimension(500,500));
        setVisible(true);
    }

    public static void main(String[] args) {
        new FenetreLoginGrid();
    }
}
