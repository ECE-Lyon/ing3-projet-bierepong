package AffichageEmployee.MenuModifResa;

import ElementDeBase.Reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifResa extends JFrame{
    private Reservation resa;
    protected ModifResa(Reservation resa) {
        setTitle("Modification Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel numLab = new JLabel(Integer.toString(resa.numDeResa));
        contentPane.add(empty);contentPane.add(numLab);

        JLabel emptyBis = new JLabel("");
        JLabel idLab = new JLabel(resa.idAcheteur);
        contentPane.add(emptyBis);contentPane.add(idLab);

        JLabel filmLab = new JLabel("  Film :");
        JTextField filmField = new JTextField(resa.titreFilm);
        contentPane.add(filmLab);contentPane.add(filmField);

        JLabel nbLab = new JLabel("  Nombre de tickets :");
        JTextField nbField = new JTextField(Integer.toString(resa.nbTickets));
        contentPane.add(nbLab);contentPane.add(nbField);

        JLabel reducLab = new JLabel("  Réduction :");
        JTextField reducField = new JTextField(resa.reduc);
        contentPane.add(reducLab);contentPane.add(reducField);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifResa();
            }
        });

        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        Reservation reservation=new Reservation(2,1,"michel","schreck",
                "Etudiante");
        new ModifResa(reservation);
    }
}
