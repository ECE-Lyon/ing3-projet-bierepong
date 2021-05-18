package com.company.AffichageEmployee;

import com.company.AffichageEmployee.MenuModifEmployee.MenuModifEmployee;
import com.company.AffichageEmployee.MenuModifsFilm.MenuModifFilm;
import com.company.AffichageEmployee.MenuModifsMembre.MenuModifMembre;
import com.company.AffichageEmployee.MenuModifsReduc.MenuModifReduc;
import com.company.AffichageEmployee.MenuModifResa.MenuModifResa;
import com.company.Connexion.FenetreLoginGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEmployee extends JFrame{
    public MenuEmployee(){
        setTitle("Menu employés");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 1);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        JLabel blank = new JLabel("");
        JLabel blankbis = new JLabel("");
        JButton logOut = new JButton("Log out");

        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FenetreLoginGrid();
            }
        });

        panel.add(blank);
        panel.add(blankbis);
        panel.add(logOut);

        JButton update=new JButton("Mettre à jour les films disponibles");
        JButton discounts=new JButton("Mettre à jour les offres de réductions");
        JButton records=new JButton("Mettre à jour les données clients");
        JButton resa=new JButton("Modifier les réservations");
        JButton employee=new JButton("Modifier les employés");

        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifFilm();
            }
        });
        discounts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifReduc();
            }
        });
        records.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifMembre();
            }
        });
        resa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifResa();
            }
        });
        employee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifEmployee();
            }
        });

        contentPane.add(panel);contentPane.add(update);contentPane.add(discounts);contentPane.add(records);contentPane.add(resa);contentPane.add(employee);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuEmployee();
    }
}
