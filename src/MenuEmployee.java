import javax.swing.*;
import java.awt.*;

public class MenuEmployee extends FonctionsSwing{
    public MenuEmployee(){
        setTitle("Menu employés");
        Container contentPane=this.getContentPane();
        contentPane.setLayout(null);
        JButton update=Button("Mettre à jour les films disponibles",120,30,250,30);
        JButton discounts=Button("Rajouter des offres de réductions",120,70,250,30);
        JButton records=Button("Mettre à jour les données clients",120,110,250,30);
        JButton famous=Button("Revoir les films populaires",120,150,250,30);
        contentPane.add(update);contentPane.add(discounts);contentPane.add(records);contentPane.add(famous);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuEmployee();
    }
}
