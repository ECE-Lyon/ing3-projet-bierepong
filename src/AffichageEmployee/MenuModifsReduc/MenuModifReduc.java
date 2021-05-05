package AffichageEmployee.MenuModifsReduc;

import AffichageEmployee.MenuEmployee;
import AffichageEmployee.MenuModifsReduc.ModifReduc;
import ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuModifReduc extends JFrame{
    public MenuModifReduc(){
        Reduction[] Lib=getDiscount();
        setTitle("Menu Réduction");
        int len = Lib.length;
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(int i=0;i<len;i++){
            Reduction reduc=Lib[i];
            JLabel label = new JLabel("  " + reduc.nom);
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JButton modifier=new JButton("modifier");
            modifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ModifReduc(reduc);
                }
            });
            panelBis.add(modifier);

            panelBis.add(new JButton("Supprimer"));

            add(label);
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

        JButton add=new JButton("Ajouter une Réduction");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddReduc();
            }
        });
        add(add);
        setSize(500,40*(len+1));
        setVisible(true);
    }
    public Reduction[] getDiscount(){
        Reduction reduction1=new Reduction("student",3);
        Reduction reduction2=new Reduction("senior",2);
        Reduction[] Lib={reduction1,reduction2};
        return Lib;
    }

    public static void main(String[] args) {
        new MenuModifReduc();
    }
}
