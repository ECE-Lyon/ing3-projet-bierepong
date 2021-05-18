package com.company.ElementDeBase;

import java.sql.*;
import java.util.ArrayList;

public class Reduction {
    public String nom;
    public int montant;

    public Reduction(String nom,int montant){
        this.nom=nom;
        this.montant=montant;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getMontant() { return montant; }

    public static void sauvegarderReduc(Reduction reduction) {

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:./default");

            try (PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO REDUCTION (NOM, MONTANT) VALUES (?, ?)")) {
                preparedStatement.setString(1, reduction.getNom());
                preparedStatement.setInt(2, reduction.getMontant());
                preparedStatement.execute();
            }
            con.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<Reduction> listReducMaker() {
        ArrayList<Reduction> lib = new ArrayList<>();;
        try (
                Connection con = DriverManager.getConnection("jdbc:h2:./default");
                PreparedStatement statement = con.prepareStatement("select * from REDUCTION")) {
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    String nom = rs.getString("NOM");
                    int montant = rs.getInt("MONTANT");
                    Reduction reduction = new Reduction(nom,montant);
                    lib.add(reduction);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lib;
    }

    public static void deleteReduc(Reduction reduction){
        try (Connection con = DriverManager.getConnection("jdbc:h2:./default"))
        {
            try (PreparedStatement preparedStatement = con.prepareStatement(
                    "delete from REDUCTION where NOM='"+reduction.getNom()+"'")) {
                preparedStatement.execute();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public String toString(){
        return nom;
    }
}
