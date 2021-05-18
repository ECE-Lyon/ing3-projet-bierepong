package com.company.ElementDeBase;

import java.sql.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Film.*;
import static com.company.ElementDeBase.Membre.listMembreMaker;
import static com.company.ElementDeBase.Reduction.listReducMaker;

public class Reservation {
    public int nbTickets;
    public int numDeResa;
    public Membre membre;
    public Film film;
    public Reduction reduction;

    public Reservation(int nbTickets,int numDeResa,Membre membre,Film film){
        this.nbTickets=nbTickets;
        this.numDeResa=numDeResa;
        this.membre=membre;
        this.film=film;
        this.reduction=this.membre.getReduction();
    }

    public int getNbTickets() { return nbTickets; }
    public void setNbTickets(int nbTickets) { this.nbTickets = nbTickets; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public Membre getIdAcheteur() { return membre; }
    public void setIdAcheteur(Membre membre) { this.membre = membre; }

    public int getNumDeResa() { return numDeResa; }
    public void setNumDeResa(int numDeResa) { this.numDeResa = numDeResa; }

    public Reduction getReduction() {return reduction;}
    public void setReduction(Reduction reduction) { this.reduction = reduction;}

    public static void sauvegarderResa(Reservation reservation) {

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:./default");

            try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO RESERVATION (NB_TICKET, NUM_DE_RES, MAIL_ACHETEUR,TITLE_FILM,REDUCTION) VALUES (?, ?, ?, ?, ?)")) {
                preparedStatement.setInt(1, reservation.getNbTickets());
                preparedStatement.setInt(2, reservation.getNumDeResa());
                preparedStatement.setString(3, reservation.getIdAcheteur().getMail());
                preparedStatement.setString(4, reservation.getFilm().getTitle());
                preparedStatement.setString(5, reservation.getReduction().getNom());
                preparedStatement.execute();
            }

            con.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        //Met à jour le nombre de places vendues sur le film
        Film film1 = reservation.getFilm();
        film1.setNbDeVente(reservation.getFilm().getNbDeVente()+reservation.getNbTickets());
        deleteFilm(reservation.getFilm());
        sauvegarderFilm(film1);
    }

    public static ArrayList<Reservation> listResaMaker() {
        ArrayList<Reservation> lib = new ArrayList<Reservation>();
        ArrayList<Membre> membreLib = listMembreMaker();
        ArrayList<Reduction> reducLib = listReducMaker();
        ArrayList<Film> filmLib = libMaker();
        int i = 0,j=0,k=0;
        try (
                Connection con = DriverManager.getConnection("jdbc:h2:./default");
                PreparedStatement statement = con.prepareStatement("select * from RESERVATION")) {
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    int nb_ticket= rs.getInt("NB_TICKET");
                    int nb_de_res = rs.getInt("NUM_DE_RES");
                    String id_acheteur = rs.getString("MAIL_ACHETEUR");
                    String title = rs.getString("TITLE_FILM");
                    String reduction = rs.getString("REDUCTION");
                    while (!membreLib.get(k).getMail().equals(id_acheteur) && k<membreLib.size()-1){k++;}
                    while (!filmLib.get(j).getTitle().equals(title) && j<filmLib.size()-1){j++;}
                    while (!reducLib.get(i).getNom().equals(reduction) && i<reducLib.size()-1){i++;}
                    Reservation reservation= new Reservation(nb_ticket,nb_de_res,membreLib.get(k),filmLib.get(j));
                    reservation.setReduction(reducLib.get(i));
                    i=0;j=0;k=0;
                    lib.add(reservation);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lib;
    }

    public static void deleteResa(Reservation reservation){
        try (Connection con = DriverManager.getConnection("jdbc:h2:./default"))
        {
            try (PreparedStatement preparedStatement = con.prepareStatement("delete from RESERVATION where NUM_DE_RES="+Integer.toString(reservation.getNumDeResa()))) {
                preparedStatement.execute();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        //Met à jour le nombre de places vendues sur le film
        Film film1 = reservation.getFilm();
        film1.setNbDeVente(reservation.getFilm().getNbDeVente()-reservation.getNbTickets());
        deleteFilm(reservation.getFilm());
        sauvegarderFilm(film1);
    }
}

