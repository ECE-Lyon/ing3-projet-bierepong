import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
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
