package com.company.AffichageEmployee.MenuModifsFilm;

import com.company.AffichageEmployee.MenuEmployee;
import com.company.ElementDeBase.Film;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Film.deleteFilm;
import static com.company.ElementDeBase.Film.libMaker;

public class MenuModifFilm extends JFrame {
    public MenuModifFilm(){
        ArrayList<Film> Lib=libMaker();
        setTitle("Menu Film");
        int len = Lib.size();
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(Film film : Lib){
            JLabel label = new JLabel("  " + film.title);
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("Modifier");
            modifier.addActionListener(e -> {
                dispose();
                new ModifFilm(film);
            });
            panelBis.add(modifier);

            JButton supprimer=new JButton("Supprimer");
            supprimer.addActionListener(e -> {
                dispose();
                deleteFilm(film);
                new MenuModifFilm();
            });
            panelBis.add(supprimer);

            add(label);
            add(panelBis);
        }
        JButton retour=new JButton("Retour");
        retour.addActionListener(e -> {
            dispose();
            new MenuEmployee();
        });
        add(retour);

        JButton add=new JButton("Ajouter un Film");
        add.addActionListener(e -> {
            dispose();
            new AddFilm();
        });
        add(add);

        setSize(500,40*(len+1));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuModifFilm();
    }
}
