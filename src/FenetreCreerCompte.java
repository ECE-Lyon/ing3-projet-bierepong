package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FenetreCreerCompte extends JFrame{
    public FenetreCreerCompte(){
        Container f=this.getContentPane ();
        f.setLayout (new FlowLayout());
        setSize(800,600);
        f.setBackground(Color.lightGray);
        setVisible(true);

        JLabel Titre,Mail,MDP,creercompte,ValidMDP;
        JTextField ValMail,valMDP,valValidMDP;
        JButton ButSubmit, ButRetour;

        Titre=new JLabel("Robert Pathé, création de compte");
        Mail=new JLabel("Mail:");
        MDP=new JLabel("MDP:");
        creercompte=new JLabel("Pas de compte?");
        ValidMDP=new JLabel("Vérifier le mdp:");

        ValMail=new JTextField("");
        valMDP=new JPasswordField("");
        valValidMDP=new JPasswordField("");

        ButSubmit=new JButton("Valider");
        ButRetour=new JButton("Retour");


        Titre.setBounds(110,0,200,100);

        Mail.setBounds(50,100, 100,30);
        ValMail.setBounds(100,100, 200,30);
        MDP.setBounds(50,150, 100,30);
        valMDP.setBounds(100,150, 200,30);

        ValidMDP.setBounds(0,200, 200,30);
        valValidMDP.setBounds(100,200, 200,30);

        ButRetour.setBounds(100,250,100,20);
        ButSubmit.setBounds(200,250,100,20);


        ButSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int c=0;
                //for (int i=0;i<=ValMail.lenth;i++){
                    //if(ValMail[i]=='@'){

                    //}
                    
                //}

                //sauvegarder dans base de donnée
                /*
                try{
                    Connection con = DriverManager.getConnection("jdbc:h2:./default");
                    con.close();
                }catch(SQLException throwables){
                    throwables.printStackTrace();
                }
        */

            }
        });

        ButRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                //f.setVisible(false);
                new FenetreLogin();
            }
        });

        f.add(Mail);f.add(ValMail);f.add(MDP);f.add(valMDP);f.add(Titre);f.add(ButSubmit);f.add(creercompte);f.add(ValidMDP);f.add(valValidMDP);f.add(ButRetour);

        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);

    }
}






