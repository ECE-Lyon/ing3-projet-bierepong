package AffichageEmployee.MenuModifsReduc;

import ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifReduc extends JFrame{
    private Reduction reduc;
    protected ModifReduc(Reduction reduc) {
        setTitle("Modification Réduction");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(3, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);


        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField(reduc.nom);
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel montantLab = new JLabel("  Montant :");
        JTextField montantField = new JTextField(Integer.toString(reduc.montant));
        contentPane.add(montantLab);contentPane.add(montantField);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifReduc();
            }
        });

        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        Reduction reduction=new Reduction("senior",3);
        new ModifReduc(reduction);
    }
}
