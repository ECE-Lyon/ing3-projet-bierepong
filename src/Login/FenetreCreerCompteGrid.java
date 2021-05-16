package Login;

import ElementDeBase.Membre;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FenetreCreerCompteGrid extends JFrame {

    public FenetreCreerCompteGrid() {

        setTitle("Création de compte");

        JLabel Titre,Mail,MDP,ValidMDP,Nom,Prenom,Age,Etudiant,Senior;
        JTextField ValMail,valMDP,valValidMDP,valNom,valPrenom,valAge;
        JCheckBox valEtudiant, valSenior;
        JButton ButSubmit, ButRetour;

        Titre=new JLabel("Robert Pathé, création de compte");
        Nom=new JLabel("Nom:");
        Prenom=new JLabel("Prenom:");
        Age=new JLabel("Age:");
        Etudiant=new JLabel("Etudiant?:");
        Senior=new JLabel("Senior?:");
        Mail=new JLabel("Mail:");
        MDP=new JLabel("MDP:");
        ValidMDP=new JLabel("Vérifier le mdp:");


        valNom=new JTextField("");
        valPrenom=new JTextField("");
        valAge=new JTextField("");
        ValMail=new JTextField("");
        valMDP=new JPasswordField("");
        valValidMDP=new JPasswordField("");

        valEtudiant= new JCheckBox("");
        valSenior= new JCheckBox("");

        ButSubmit=new JButton("Valider");
        ButRetour=new JButton("Retour");

        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        JPanel Top = new JPanel();
        //Top.setLayout(new GridLayout(1,1));

        JPanel Login = new JPanel();
        Login.setLayout(new GridLayout(8,2));

        JPanel Buttuns = new JPanel();
        //Login.setLayout(new GridLayout(3,2));

        JPanel CreerCompte = new JPanel();
        //CreerCompte.setLayout(new GridLayout(1,2));

        ButSubmit.addActionListener(e -> {
            Membre membre = new Membre();
            String nom = valNom.getText();
            String prenom = valPrenom.getText();
            int age = Integer.parseInt(valAge.getText());
            String Mail1 =ValMail.getText();
            String Password = valMDP.getText();
            String verifPassord = valValidMDP.getText();
            String etudiant;
            String senior;

            if(valEtudiant.isSelected()){etudiant="oui"; } else{etudiant = "non";}
            if(valSenior.isSelected()){senior="oui"; } else{senior = "non";}

            /*boolean etudiant;
            boolean senior;

            etudiant= valEtudiant.isSelected();
            senior= valSenior.isSelected();*/

            membre.setMail(Mail1);
            membre.setNom(nom);
            membre.setPrenom(prenom);
            membre.setAge(age);
            membre.setPassword(Password);
            membre.setEtudiant(etudiant);
            membre.setSenior(senior);

            //if(!Mail1.contains("@")){JOptionPane.showMessageDialog(Buttuns, "Adresse Mail invalide!");}

            if(Password.equals(verifPassord)){
                Sauvegarder(membre);
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

        Login.add(Nom);Login.add(valNom);Login.add(Prenom);Login.add(valPrenom);Login.add(Age);Login.add(valAge);
        Login.add(Mail); Login.add(ValMail);Login.add(MDP);Login.add(valMDP);Login.add(ValidMDP);Login.add(valValidMDP);
        Login.add(Etudiant);Login.add(valEtudiant);Login.add(Senior);Login.add(valSenior);

        Buttuns.add(ButRetour);Buttuns.add(ButSubmit);

        add(Top);add(Login);add(Buttuns);add(CreerCompte);

        setSize(new Dimension(500,500));
        setVisible(true);



    }

    void Sauvegarder(Membre membre) {

        try{
            Connection con = DriverManager.getConnection("jdbc:h2:./default");

            //statement.execute("insert into members(NOM) values (Mail)");

            //ResultSet resultSet = statement.executeQuery("select MAIL from members");

            //statement.executeUpdate("INSERT INTO MEMBERS " + "VALUES ('Mail', 1234, 'benar', 'antoine',12, 'oui')");

            try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO MEMBERS (Mail, Password, nom,prenom,age,etudiant,senior) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, membre.getMail());
                preparedStatement.setString(2, membre.getPassword());
                preparedStatement.setString(3, membre.getNom());
                preparedStatement.setString(4, membre.getPrenom());
                preparedStatement.setInt(5, membre.getAge());
                preparedStatement.setString(6, membre.getEtudiant());
                preparedStatement.setString(7, membre.getSenior());
                preparedStatement.execute();
            }


           /* while(resultSet.next()){
                if((resultSet.getString("mail")).equals(Mail)){
                    System.out.println("Un compte utilisant cette adresse mail existe deja");
                    break;
                }
                //statement.executeUpdate("INSERT INTO MEMBERS " + "VALUES ('Mail', 1234, 'benar', 'antoine',12, 'oui')"); //attention jsp comment mettre les bonnes valeurs
                System.out.println("Le compte a bien été sauvegardé!");
                //System.out.println("info1:"+resultSet.getString("id"));
            }*/
            //if(id n'existe pas déjà){id = Math.random()*10000}

            con.close();
        }catch(
                SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
