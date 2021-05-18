package com.company.AffichageEmployee;

import com.company.AffichageEmployee.MenuModifEmployee.MenuModifEmployee;
import com.company.AffichageEmployee.MenuModifResa.MenuModifResa;
import com.company.AffichageEmployee.MenuModifsFilm.MenuModifFilm;
import com.company.AffichageEmployee.MenuModifsMembre.MenuModifMembre;
import com.company.AffichageEmployee.MenuModifsReduc.MenuModifReduc;
import com.company.Connexion.FenetreLoginGrid;

import javax.swing.*;
import java.awt.*;

public class MenuEmployee extends JFrame{
    public MenuEmployee(){
        setTitle("Menu employés");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(7, 1);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        JLabel blank = new JLabel("");
        JLabel blankbis = new JLabel("");
        JButton logOut = new JButton("Log out");

        logOut.addActionListener(e -> {
            dispose();
            new FenetreLoginGrid();
        });

        panel.add(blank);
        panel.add(blankbis);
        panel.add(logOut);

        JButton update=new JButton("Mettre à jour les films disponibles");
        JButton discounts=new JButton("Mettre à jour les offres de réductions");
        JButton records=new JButton("Mettre à jour les données clients");
        JButton resa=new JButton("Modifier les réservations");
        JButton employee=new JButton("Modifier les employés");
        JButton stat=new JButton("Statistiques");

        update.addActionListener(e -> {
            dispose();
            new MenuModifFilm();
        });
        discounts.addActionListener(e -> {
            dispose();
            new MenuModifReduc();
        });
        records.addActionListener(e -> {
            dispose();
            new MenuModifMembre();
        });
        resa.addActionListener(e -> {
            dispose();
            new MenuModifResa();
        });
        employee.addActionListener(e -> {
            dispose();
            new MenuModifEmployee();
        });
        stat.addActionListener(e -> {
            dispose();
            new MenuStat();
        });

        contentPane.add(panel);contentPane.add(update);contentPane.add(discounts);
        contentPane.add(records);contentPane.add(resa);contentPane.add(employee);contentPane.add(stat);
        setSize(500,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuEmployee();
    }
}
