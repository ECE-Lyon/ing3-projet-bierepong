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

    public static JTextArea TextArea(String text, int x, int y, int widght, int lenght){
        JTextArea txt=new JTextArea(text);
        txt.setEditable(false);
        txt.setBounds(x,y,widght,lenght);
        return txt;
    }

    public static JLabel LabelIcone(ImageIcon Icone, int x, int y, int widght, int lenght){
        JLabel label=new JLabel(Icone);
        label.setBounds(x,y,widght,lenght);
        return label;
    }

    public static void filmAffiche(Film film1, FilmWindow filmWindow, int nbDejaAffiche) throws IOException {
        int largeur = 200;
        int hauteurImage = 150;
        int marge = 10;

        JTextArea txt = TextArea(film1.title + "\n" + film1.genre + "\n" + film1.releaseDate + "\n" + Integer.toString(film1.runningTime) + " min",marge + (largeur + marge) * nbDejaAffiche,hauteurImage + marge * 2 + 10, largeur,65);
        filmWindow.containAddTxt(txt);

        BufferedImage myPicture = ImageIO.read(new File(film1.image));
        Image dimg = myPicture.getScaledInstance(largeur,hauteurImage, Image.SCALE_SMOOTH);
        JLabel picLabel = LabelIcone(new ImageIcon(dimg),marge + (largeur + marge) * nbDejaAffiche,marge + 10,largeur,hauteurImage);

        filmWindow.containAddLabel(picLabel);
    }


    public static void main (String[] args) throws IOException {
        Film film1 = new Film();
        film1.setGenre("Commédie");
        film1.setReleaseDate("15 Janvier 2004");
        film1.setTitle("Shrek");
        film1.setRunningTime(106);
        film1.setImage("Images/ShrekPNG.png");

        Film film2 = new Film();
        film2.setGenre("Horreur");
        film2.setReleaseDate("30 Mars 1998");
        film2.setTitle("Picsou et l'attaque des nains");
        film2.setRunningTime(95);
        film2.setImage("Images/Shrek.jpg");

        FilmWindow filmWindow = new FilmWindow();
        filmAffiche(film1,filmWindow,0);
        filmAffiche(film2,filmWindow,1);
        filmWindow.Final();
    }

}
