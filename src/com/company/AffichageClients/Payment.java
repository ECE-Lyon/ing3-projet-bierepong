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
        JPEGImageReadParam pay;


        Titre=new JLabel("Robert Pathé");
        Pay=new JLabel("\n com.company.AffichageClients.Payment en cours");

        GridLayout grid = new GridLayout(4, 3);
        grid.setHgap(10);
        setLayout(grid);

        JPanel Top = new JPanel();
        JPanel Image = new JPanel();
        JPanel Bot = new JPanel();
        //Icon imgIcon = new ImageIcon(this.getClass().getResource("ajax-loader.gif"));

        //URL url = this.getClass().getResource("/.pay.gif");
        //Icon myImgIcon = new ImageIcon(url);

        try {
            File file = new File("Images/pay.gif");
            BufferedImage image = ImageIO.read(file);
            setIconImage(image);

            JLabel lab = new JLabel(new ImageIcon(image));
            Image.add(lab);


        }catch (IOException e){
            e.printStackTrace();
        }
        //JLabel imageLbl = new JLabel(image);
        //Top.add(imageLbl, BorderLayout.CENTER);


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
