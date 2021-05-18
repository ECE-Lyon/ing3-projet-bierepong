package com.company.AffichageClients;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Payment extends JFrame {
    public Payment() {
        setTitle("com.company.AffichageClients.Payment");

        JLabel Titre,Pay;

        Titre=new JLabel("Robert Pathé");
        Pay=new JLabel("\n com.company.AffichageClients.Payment en cours");

        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        JPanel Top = new JPanel();
        JPanel Image = new JPanel();
        JPanel Bot = new JPanel();

        try {
            File file = new File("Images/pay.gif");
            BufferedImage image = ImageIO.read(file);
            setIconImage(image);

            JLabel lab = new JLabel(new ImageIcon(image));
            Image.add(lab);


        }catch (IOException e){
            e.printStackTrace();
        }
        Top.add(Titre);
        Bot.add(Pay);
        add(Top);
        add(Image);
        add(Bot);


        setSize(new Dimension(500,500));
        setVisible(true);

    }

    public static void main(String[] args) {
        new Payment();
    }
}
