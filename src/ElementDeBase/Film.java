package ElementDeBase;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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


    public static void main(String[] args) {
        System.out.println(6/5);
    }
}
