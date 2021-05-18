package com.company.AffichageEmployee;

import com.company.AffichageEmployee.MenuEmployee;
import com.company.ElementDeBase.Film;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static com.company.ElementDeBase.Film.deleteFilm;
import static com.company.ElementDeBase.Film.libMaker;

public class MenuStat extends JFrame {
    public MenuStat(){
        ArrayList<Film> Lib=libMaker();
        setTitle("Menu Film");
        int len = Lib.size();
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(Film film : Lib){
            JLabel label = new JLabel("  " + film.title);
            JLabel labelbis = new JLabel("  " + film.nbDeVente);
            add(label);
            add(labelbis);
        }
        JButton retour=new JButton("Retour");
        retour.addActionListener(e -> {
            dispose();
            new MenuEmployee();
        });
        add(retour);

        setSize(500,40*(len+1));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuStat();
    }
}
