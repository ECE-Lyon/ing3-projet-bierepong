package com.company.ElementDeBase;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Film {
    public String title;
    public String releaseDate;
    public int runningTime;
    public String genre;
    public String image;
    public int nbDeVente;

    public Film(){
        nbDeVente = 0;
    }

    public Film(String title,String releaseDate,int runningTime,String genre,String image,int nbDeVente){
        this.title=title;
        this.releaseDate=releaseDate;
        this.runningTime=runningTime;
        this.genre=genre;
        this.image=image;
        this.nbDeVente=nbDeVente;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getReleaseDate(){
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate = releaseDate;
    }

    public int getRunningTime(){
        return runningTime;
    }
    public void setRunningTime(int runningTime){
        this.runningTime = runningTime;
    }

    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }

    public int getNbDeVente(){
        return nbDeVente;
    }
    public void setNbDeVente(int nbDeVente){
        this.nbDeVente = nbDeVente;
    }

    public static JTextArea TextAreaBis(String text){
        JTextArea txt=new JTextArea(text);
        txt.setEditable(false);
        return txt;
    }

    public static JLabel LabelIconeFilmBis(Film film) throws IOException {
        BufferedImage myPicture = ImageIO.read(new File(film.image));
        Image dimg = myPicture.getScaledInstance(200,150, Image.SCALE_SMOOTH);
        JLabel label=new JLabel(new ImageIcon(dimg));
        return label;
    }

    public static void sauvegarderFilm(com.company.ElementDeBase.Film film) {

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:./default");

            try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO FILM (TITLE, GENRE,RELEASE_DATE,RUNNING_TIME,ND_DE_SOLD,AFFICHE) VALUES (?, ?, ?, ?, ?, ?)")) {
                preparedStatement.setString(1, film.getTitle());
                preparedStatement.setString(2, film.getGenre());
                preparedStatement.setString(3, film.getReleaseDate());
                preparedStatement.setInt(4, film.getRunningTime());
                preparedStatement.setInt(5, film.getNbDeVente());
                preparedStatement.setString(6, film.getImage());
                preparedStatement.execute();
            }

            con.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<Film> libMaker() {
        ArrayList<Film> lib = new ArrayList<Film>();;
        try (
                Connection con = DriverManager.getConnection("jdbc:h2:./default");
                PreparedStatement statement = con.prepareStatement("select * from FILM")) {
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    String title = rs.getString("TITLE");
                    String genre = rs.getString("GENRE");
                    String releaseDate = Integer.toString(rs.getInt("RELEASE_DATE"));
                    int runningTime = rs.getInt("RUNNING_TIME");
                    int nd_de_sold = rs.getInt("ND_DE_SOLD");
                    String affiche = rs.getString("AFFICHE");
                    Film film = new Film(title,releaseDate,runningTime,genre,affiche,nd_de_sold);
                    lib.add(film);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lib;
    }

    public static void deleteFilm(Film film){
        try (Connection con = DriverManager.getConnection("jdbc:h2:./default"))
        {
            try (PreparedStatement preparedStatement = con.prepareStatement("delete from FILM where TITLE='"+film.getTitle()+"'")) {
                preparedStatement.execute();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public String toString(){
        return title;
    }

    public static void main(String[] args) throws SQLException {
        ArrayList<Film> lib = libMaker();
        System.out.println(lib.size());
        for (Film film : lib) {
            System.out.println(film.title);
        }
    }
}
