package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FenetreCreerCompteGrid extends JFrame {

    public FenetreCreerCompteGrid() {

        setTitle("Identification");

        JLabel Titre,Mail,MDP,ValidMDP;
        JTextField ValMail,valMDP,valValidMDP;
        JButton ButSubmit, ButRetour;

        Titre=new JLabel("Robert Pathé, création de compte");
        Mail=new JLabel("Mail:");
        MDP=new JLabel("MDP:");
        ValidMDP=new JLabel("Vérifier le mdp:");

        ValMail=new JTextField("");
        valMDP=new JPasswordField("");
        valValidMDP=new JPasswordField("");

        ButSubmit=new JButton("Valider");
        ButRetour=new JButton("Retour");

        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        JPanel Top = new JPanel();
        //Top.setLayout(new GridLayout(1,1));

        JPanel Login = new JPanel();
        Login.setLayout(new GridLayout(3,2));

        JPanel Buttuns = new JPanel();
        //Login.setLayout(new GridLayout(3,2));

        JPanel CreerCompte = new JPanel();
        //CreerCompte.setLayout(new GridLayout(1,2));

        ButSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Type=null;
                String Mail=ValMail.getText();
                String Password = valMDP.getText();
                String verifPassord = valValidMDP.getText();

                if(Password.equals(verifPassord)){
                    //Sauvegarder(Type,Mail,Password);
                }
                else{
                    JOptionPane.showMessageDialog(Buttuns, "Vos mots de passe doivent être identiques!");
                }
                System.out.println(Mail+Password);
                //int c=0;
                //for (int i=0;i<=ValMail.lenth;i++){
                //if(ValMail[i]=='@'){//}//}
                //sauvegarder dans base de donnée
                //Sauvegarder(Type,Mail,Password);

            }
        });

        ButRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FenetreLoginGrid();
            }
        });


        Top.add(Titre);Login.add(Mail); Login.add(ValMail);Login.add(MDP);Login.add(valMDP);Login.add(ValidMDP);Login.add(valValidMDP);
        Buttuns.add(ButRetour);Buttuns.add(ButSubmit);

        add(Top);add(Login);add(Buttuns);add(CreerCompte);

        setSize(new Dimension(500,500));
        setVisible(true);



    }

    void Sauvegarder(String Type,String Mail, String Password) { //type: senior, enfant...
        String id="root";
        String password="root";
        try{
            Connection con = DriverManager.getConnection("jdbc:h2:./default",id,password);
            Statement statement = con.createStatement();

            statement.execute("insert into products(name) values ('name1'),('name 2')");

            ResultSet resultSet = statement.executeQuery("select * from products");

            while(resultSet.next()){
                System.out.println("info1:"+resultSet.getString("id"));
                System.out.println("nom:"+resultSet.getString("name"));
            }


            con.close();
        }catch(
        SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
