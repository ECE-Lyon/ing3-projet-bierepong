package com.company;

import AffichageClients.FenetrePrincipale;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreLogin extends JFrame{
    public FenetreLogin(){

        Container f=this.getContentPane ();
        f.setLayout (new FlowLayout());
        setSize(400,400);
        f.setBackground(Color.lightGray);
        setVisible(true);

        JLabel Titre,Mail,MDP,creercompte;
        JTextField ValMail,valMDP;
        JButton ButSubmit, ButCreercompte;

        Titre=new JLabel("Robert Pathé");
        Mail=new JLabel("Mail:");
        MDP=new JLabel("MdP:");
        creercompte=new JLabel("Pas de compte?");

        ValMail=new JTextField("");
        valMDP=new JPasswordField("");

        ButSubmit=new JButton("Submit");
        ButCreercompte=new JButton("Créer un compte");


        Titre.setBounds(150,0,200,100);

        Mail.setBounds(50,100, 100,30);
        ValMail.setBounds(100,100, 200,30);
        MDP.setBounds(50,150, 100,30);
        valMDP.setBounds(100,150, 200,30);

        ButSubmit.setBounds(150,200,100,20);

        creercompte.setBounds(100,210,100,100);
        ButCreercompte.setBounds(200,250,140,20);

        ButSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(ValMail.getText().equals("admin") && valMDP.getText().equals("password")){
                    dispose();
                    //setVisible(false);
                    new FenetrePrincipale();
                }
                else{
                    JOptionPane.showMessageDialog(f, "Identifiants incorrects");
                }
            }
        });

        ButCreercompte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                //setVisible(false);
                new FenetreCreerCompte();
            }
        });

        f.add(Mail);f.add(ValMail);f.add(MDP);f.add(valMDP);f.add(Titre);f.add(ButSubmit);f.add(creercompte);f.add(ButCreercompte);

        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new FenetreLogin();
    }
}