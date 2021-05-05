package AffichageEmployee;

import ElementDeBase.Film;
import ElementDeBase.Membre;
import ElementDeBase.Reduction;
import ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;

public class MenuModif extends JFrame{
    public static void main(String[] args) {
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

        Film film_3 = new Film();
        film_3.setGenre("Commédie");
        film_3.setReleaseDate("17 Juillet 2123");
        film_3.setTitle("Monstre&Co");
        film_3.setRunningTime(132);
        film_3.setImage("Images/MontreAndCoCursed.png");

        Film film_5 = new Film();
        film_5.setGenre("Commédie");
        film_5.setReleaseDate("15 Janvier 2004");
        film_5.setTitle("Shrek");
        film_5.setRunningTime(106);
        film_5.setImage("Images/ShrekPNG.png");

        Film film_6 = new Film();
        film_6.setGenre("Bucolique");
        film_6.setReleaseDate("69 Juin 1969");
        film_6.setTitle("Rocco au payx des noix de coco");
        film_6.setRunningTime(95);
        film_6.setImage("Images/Shrek.jpg");


        Film Lib[] = {film_1, film_2, film_3, film_5,film_6};

        //MenuModif menu = new MenuModif();
        //menu.ModifFilm(Lib);
    }
}
