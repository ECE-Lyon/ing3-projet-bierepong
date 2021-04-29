import javax.swing.*;
import java.awt.*;

public class MenuEmployee extends FonctionsSwing{
    public MenuEmployee(){
        setTitle("Menu employés");
        GridLayout grid = new GridLayout(5, 1);
        grid.setVgap(3);
        setLayout(grid);
        JButton update=new JButton("Mettre à jour les films disponibles");
        JButton discounts=new JButton("Rajouter des offres de réductions");//S'en occuper plus tard
        JButton records=new JButton("Mettre à jour les données clients");
        JButton famous=new JButton("Voir les statistiques");
        JButton commandes=new JButton("Modifier les commandes");
        add(update);add(discounts);add(records);add(famous);add(commandes);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuEmployee();
    }
}
