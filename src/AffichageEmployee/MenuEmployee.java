package AffichageEmployee;

import AffichageEmployee.MenuModifsFilm.MenuModifFilm;
import AffichageEmployee.MenuModifsMembre.MenuModifMembre;
import AffichageEmployee.MenuModifsReduc.MenuModifReduc;
import AffichageEmployee.MenuModifResa.MenuModifResa;

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
        panel.add(blank);
        panel.add(blankbis);
        panel.add(logOut);

        JButton update=new JButton("Mettre à jour les films disponibles");
        JButton discounts=new JButton("Rajouter des offres de réductions");//S'en occuper plus tard
        JButton records=new JButton("Mettre à jour les données clients");
        JButton stat=new JButton("Voir les statistiques");
        JButton resa=new JButton("Modifier les reservations");

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
        contentPane.add(panel);contentPane.add(update);contentPane.add(discounts);contentPane.add(records);contentPane.add(stat);contentPane.add(resa);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuEmployee();
    }
}
