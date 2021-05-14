package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FenetreLoginGrid extends JFrame {
    public FenetreLoginGrid() {

        setTitle("Identification");

        JLabel Titre,Mail,MDP,creercompte;//Empty;
        JTextField ValMail,valMDP;
        JButton ButSubmit, ButCreercompte, ButSubmitEmploye;

        Titre=new JLabel("Robert Pathé");
        Mail=new JLabel("Mail:");
        //Empty=new JLabel("\n\n");
        MDP=new JLabel("MdP:");
        creercompte=new JLabel("Pas de compte?");

        ValMail=new JTextField("");
        valMDP=new JPasswordField("");

        ButSubmit=new JButton("Connexion");
        ButSubmitEmploye=new JButton("Connexion staff");

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
        //Login.setLayout(new GridLayout(3,2));

        JPanel CreerCompte = new JPanel();
        //CreerCompte.setLayout(new GridLayout(1,2));


        ButSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(ValMail.getText().equals("admin") && valMDP.getText().equals("password")){
                    dispose();
                    try {
                        new FenetrePrincipale();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                else{
                    JOptionPane.showMessageDialog(Buttuns, "Identifiants incorrects");
                }
            }
        });

        ButSubmitEmploye.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(ValMail.getText().equals("admin") && valMDP.getText().equals("password")){
                    dispose();
                    try {
                        new FenetrePrincipaleEmploye();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                else{
                    JOptionPane.showMessageDialog(Buttuns, "Identifiants incorrects");
                }
            }
        });

        ButCreercompte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                //setVisible(false);
                new FenetreCreerCompteGrid();
            }
        });


        Top.add(Titre);Login.add(Mail); Login.add(ValMail);Login.add(MDP);Login.add(valMDP);
        Buttuns.add(ButSubmit);Buttuns.add(ButSubmitEmploye);CreerCompte.add(creercompte);CreerCompte.add(ButCreercompte);

        add(Top);add(Login);add(Buttuns);add(CreerCompte);

        setSize(new Dimension(500,500));
        setVisible(true);



    }
}
