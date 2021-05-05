package AffichageEmployee.MenuModifsFilm;

import AffichageEmployee.MenuEmployee;
import AffichageEmployee.MenuModifsFilm.ModifFilm;
import ElementDeBase.Film;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuModifFilm extends JFrame {
    public MenuModifFilm(){
        Film[] Lib=GetLib();
        setTitle("Menu Film");
        int len = Lib.length;
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(int i=0;i<len;i++){
            Film film=Lib[i];
            JLabel label = new JLabel("  " + film.title);
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("Modifier");
            modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ModifFilm(film);
                }
            });
            panelBis.add(modifier);
            panelBis.add(new JButton("Supprimer"));

            add(label);
            add(panelBis);
        }
        JButton retour=new JButton("Retour");
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuEmployee();
            }
        });
        add(retour);

        JButton add=new JButton("Ajouter un Film");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddFilm();
            }
        });
        add(add);
        setSize(500,40*(len+1));
        setVisible(true);


    }
    public Film[] GetLib(){
        Film film_1 = new Film("Shrek","15 Janvier 2004",106,
                "Commédie","Images/ShrekPNG.png",1);

        Film film_2 = new Film("Picsou et l'attaque des nains","30 Mars 1998",95,
                "Horreur","Images/Shrek.jpg",1);

        Film film_3 = new Film("Monstre&Co","17 Juillet 2123",132,
                "Commédie","Images/MontreAndCoCursed.png",1);

        Film film_5 = new Film("Shrek","15 Janvier 2004",106,
                "Commédie","Images/ShrekPNG.png",1);

        Film film_6 = new Film("Rocco au payx des noix de coco","69 Juin 1969",95,
                "Bucolique","Images/Shrek.jpg",1);

        Film Lib[] = {film_1, film_2, film_3, film_5,film_6};
        return Lib;
    }

    public static void main(String[] args) {
        new MenuModifFilm();
    }
}
