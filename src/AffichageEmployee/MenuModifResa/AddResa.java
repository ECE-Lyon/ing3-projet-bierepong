package AffichageEmployee.MenuModifResa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddResa extends JFrame {
    protected AddResa() {
        int numDeResa = 69;

        setTitle("Ajouter une Réservation");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel numLab = new JLabel(Integer.toString(numDeResa));
        contentPane.add(empty);contentPane.add(numLab);

        JLabel idLab = new JLabel("  ID Acheteur");
        JTextField idField = new JTextField("");
        contentPane.add(idLab);contentPane.add(idField);

        JLabel filmLab = new JLabel("  Film :");
        JTextField filmField = new JTextField("");
        contentPane.add(filmLab);contentPane.add(filmField);

        JLabel nbLab = new JLabel("  Nombre de tickets :");
        JTextField nbField = new JTextField("");
        contentPane.add(nbLab);contentPane.add(nbField);

        JLabel reducLab = new JLabel("  Réduction :");
        JTextField reducField = new JTextField("");
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
        new AddResa();
    }
}
