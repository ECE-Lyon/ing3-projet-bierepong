package AffichageEmployee.MenuModifsMembre;

import AffichageEmployee.MenuEmployee;
import ElementDeBase.Membre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuModifMembre extends JFrame{
    public MenuModifMembre(){
        Membre[] Lib=getMembre();
        setTitle("Menu Membre");
        int len = Lib.length;
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(int i=0;i<len;i++){
            Membre membre=Lib[i];
            JLabel id = new JLabel("  " + membre.id);
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("Modifier");
            modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ModifMembre(membre);
                }
            });
            panelBis.add(modifier);

            panelBis.add(new JButton("Supprimer"));

            add(id);
            add(panelBis);
        }
        JButton retour=new JButton("Retour");
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuEmployee();
            }
        });
        add(retour);

        JButton add=new JButton("Ajouter un Membre");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddMembre();
            }
        });
        add(add);
        setSize(500,60*(len+1));
        setVisible(true);
    }
    public Membre[] getMembre(){
        Membre[] membres=new Membre[2];
        membres[0]=new Membre();
        membres[1] = new Membre();
        return membres;
    }

    public static void main(String[] args) {
        new MenuModifMembre();
    }
}
