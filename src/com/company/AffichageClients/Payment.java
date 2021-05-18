package com.company.AffichageClients;

import com.company.Connexion.FenetreLoginGrid;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Payment extends JFrame {
    public Payment() {

        setTitle("com.company.AffichageClients.Payment");

        JLabel Titre,Pay;
        JButton ButRetour;


        Titre=new JLabel("Robert Pathé");
        Pay=new JLabel("Payment en cours");
        ButRetour= new JButton("Nouvelle commande");


        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        JPanel Top = new JPanel();
        JPanel Image = new JPanel();
        JPanel Bot = new JPanel();
        JPanel Bot2 = new JPanel();

        try {
            File file = new File("Images/pay.gif");
            BufferedImage image = ImageIO.read(file);
            setIconImage(image);

            JLabel lab = new JLabel(new ImageIcon(image));
            Image.add(lab);


        }catch (IOException e){
            e.printStackTrace();
        }

        ButRetour.addActionListener(e -> {
            dispose();
            new FenetreLoginGrid();
        });


        Top.add(Titre);
        Bot.add(Pay);
        Bot2.add(ButRetour);

        add(Top);
        add(Image);
        add(Bot);
        add(Bot2);


        setSize(new Dimension(500,500));
        setVisible(true);

    }
    public static void main(String[] args) {
        new Payment();
    }
}
