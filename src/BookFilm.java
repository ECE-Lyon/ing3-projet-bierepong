import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BookFilm extends FonctionsSwing{
    public BookFilm () throws IOException {
        Film film_1 = new Film();
        film_1.setGenre("Commédie");
        film_1.setReleaseDate("15 Janvier 2004");
        film_1.setTitle("Shrek");
        film_1.setRunningTime(106);
        film_1.setImage("Images/ShrekPNG.png");

        Film film_2 = new Film();
        film_2.setGenre("Horreur");
        film_2.setReleaseDate("30 Mars 1998");
        film_2.setTitle("Picsou et l'attaque des nains");
        film_2.setRunningTime(95);
        film_2.setImage("Images/Shrek.jpg");

        Film Lib[] = {film_1,film_2};

        int nbFilm = Lib.length;
        int tailleFenetre = 320 + 235 * ( nbFilm / 5 + 1);

        setTitle("Validation");
        Container contentPane=this.getContentPane();
        contentPane.setLayout(null);

        for (int i=0; i<nbFilm; i++) {
            Film.filmAffiche(Lib[i], this, i);
        }

        JLabel choose=Label("Choose the movie you want to watch",110,tailleFenetre - 270,300,30);
        contentPane.add(choose);

        for (int i=0; i<nbFilm; i++) {
            JRadioButton film=RadioButton(Lib[i].title,180,tailleFenetre - 210 - (nbFilm - i - 1) * 30,100);
            contentPane.add(film);
        }

        JLabel nbTickets=Label("Number of tickets : ",140,tailleFenetre - 180,150,30);
        contentPane.add(nbTickets);
        JTextField numberTickets=ChampText("",260,tailleFenetre - 180,70,30);
        contentPane.add(numberTickets);
        JLabel discount=Label("Do you have a discount?",110,tailleFenetre - 150,150,30);
        contentPane.add(discount);
        JRadioButton yes=RadioButton("yes",270,tailleFenetre - 150,50);
        JRadioButton no=RadioButton("no",320,tailleFenetre - 150,50);
        contentPane.add(yes);contentPane.add(no);
        JButton myButton=Button("Buy tickets",180,tailleFenetre - 120,100,30);
        contentPane.add(myButton);
        setSize(1050,tailleFenetre);
        setVisible(true);
    }

    public void containAddTxt (JTextArea txt){
        Container contentPane=this.getContentPane();
        contentPane.add(txt);
    }

    public void containAddLabel (JLabel label){
        Container contentPane=this.getContentPane();
        contentPane.add(label);
    }

    public static void main(String[]args) throws IOException {
        new BookFilm();

    }
}