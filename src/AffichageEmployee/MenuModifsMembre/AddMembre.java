package AffichageEmployee.MenuModifsMembre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMembre extends JFrame{
    protected AddMembre() {
        setTitle("Ajouter un Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel idLab = new JLabel("  ID");
        JTextField idField = new JTextField("");
        contentPane.add(idLab);contentPane.add(idField);

        JLabel prenomLab = new JLabel("  Prénom :");
        JTextField prenomField = new JTextField("");
        contentPane.add(prenomLab);contentPane.add(prenomField);

        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField("");
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel ageLab = new JLabel("  Age :");
        JTextField ageField = new JTextField("");
        contentPane.add(ageLab);contentPane.add(ageField);

        JLabel etudiantLab = new JLabel("  Etudiant :");
        JPanel student = new JPanel();
        student.setLayout(new GridLayout(1,2));
        JRadioButton oui = new JRadioButton("Oui");
        JRadioButton non = new JRadioButton("Non",true);
        student.add(oui);
        student.add(non);
        contentPane.add(etudiantLab);contentPane.add(student);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifMembre();
            }
        });

        JButton valider = new JButton("Valider");
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddMembre();
    }
}
