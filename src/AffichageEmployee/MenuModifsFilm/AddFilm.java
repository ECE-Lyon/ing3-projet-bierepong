package AffichageEmployee.MenuModifsFilm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFilm extends JFrame{
    protected AddFilm() {
        setTitle("Ajouter un Film");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel titreLab = new JLabel("  Titre :");
        JTextField titreField = new JTextField("");
        contentPane.add(titreLab);contentPane.add(titreField);

        JLabel genreLab = new JLabel("  Genre :");
        JTextField genreField = new JTextField("");
        contentPane.add(genreLab);contentPane.add(genreField);

        JLabel dateLab = new JLabel("  Date de sortie :");
        JTextField dateField = new JTextField("");
        contentPane.add(dateLab);contentPane.add(dateField);

        JLabel dureeLab = new JLabel("  Durée :");
        JTextField dureeField = new JTextField("");
        contentPane.add(dureeLab);contentPane.add(dureeField);

        JLabel afficheLab = new JLabel("  Affiche :");
        JTextField afficheField = new JTextField("");
        contentPane.add(afficheLab);contentPane.add(afficheField);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifFilm();
            }
        });

        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddFilm();
    }
}
