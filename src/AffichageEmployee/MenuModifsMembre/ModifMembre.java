package AffichageEmployee.MenuModifsMembre;

import AffichageEmployee.MenuEmployee;
import ElementDeBase.Membre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifMembre extends JFrame{
    private Membre membre;
    protected ModifMembre(Membre membre) {
        setTitle("Modification Membre");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(6, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);

        JLabel empty = new JLabel("");
        JLabel idLab = new JLabel(membre.id);
        contentPane.add(empty);contentPane.add(idLab);

        JLabel prenomLab = new JLabel("  Prénom :");
        JTextField prenomField = new JTextField(membre.prenom);
        contentPane.add(prenomLab);contentPane.add(prenomField);

        JLabel nomLab = new JLabel("  Nom :");
        JTextField nomField = new JTextField(membre.nom);
        contentPane.add(nomLab);contentPane.add(nomField);

        JLabel ageLab = new JLabel("  Age :");
        JTextField ageField = new JTextField(Integer.toString(membre.age));
        contentPane.add(ageLab);contentPane.add(ageField);

        JLabel etudiantLab = new JLabel("  Etudiant :");
        JPanel student = new JPanel();
        student.setLayout(new GridLayout(1,2));
        JRadioButton oui = new JRadioButton("Oui");
        JRadioButton non = new JRadioButton("Non");
        if (membre.etudiant) {
            oui.setSelected(true);
        }
        else {
            non.setSelected(true);
        }
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
        Membre membre=new Membre();
        new ModifMembre(membre);
    }
}
