package com.company.ElementDeBase;

import java.sql.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Reduction.listReducMaker;

public class Membre {
    public String mail;
    public String password;
    public String nom;
    public String prenom;
    public Reduction reduction;

    public Membre(String mail,String password,String nom,String prenom,Reduction reduction){
        this.mail=mail;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
        this.reduction=reduction;
    }

    public String getMail() {return mail;}
    public void setMail(String mail) {this.mail = mail;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Reduction getReduction() {return reduction;}
    public void setReduction(Reduction reduction) {this.reduction = reduction;    }

    public static void sauvegarderMembre(Membre membre) {

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:./default");

            try (PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO MEMBERS (MAIL, PASSWORD,NOM,PRENOM,REDUCTION) VALUES (?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, membre.getMail());
                preparedStatement.setString(2, membre.getPassword());
                preparedStatement.setString(3, membre.getNom());
                preparedStatement.setString(4, membre.getPrenom());
                preparedStatement.setString(5, membre.getReduction().getNom());
                preparedStatement.execute();
            }
            con.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<Membre> listMembreMaker() {
        ArrayList<Membre> lib = new ArrayList<>();
        ArrayList<Reduction> reducLib = listReducMaker();
        int i =0;
        try (
                Connection con = DriverManager.getConnection("jdbc:h2:./default");
                PreparedStatement statement = con.prepareStatement("select * from MEMBERS")) {
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    String mail = rs.getString("MAIL");
                    String password = rs.getString("PASSWORD");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String reductionString = rs.getString("REDUCTION");
                    while(!reducLib.get(i).getNom().equals(reductionString) && i < reducLib.size()-1){ i++; }
                    Membre membre = new Membre(mail,password,nom,prenom,reducLib.get(i));
                    lib.add(membre);
                    i=0;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lib;
    }

    public static void deleteMembre(Membre membre){
        try (Connection con = DriverManager.getConnection("jdbc:h2:./default"))
        {
            try (PreparedStatement preparedStatement = con.prepareStatement(
                    "delete from MEMBERS where MAIL='"+membre.getMail()+"'")) {
                preparedStatement.execute();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }
    //permet d'afficher seulement le mail d'un membre dans les combobos
    @Override
    public String toString() {
        return mail;
    }
}