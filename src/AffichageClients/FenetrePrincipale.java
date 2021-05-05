package AffichageClients;

import java.awt.*;
import javax.swing.*;


public class FenetrePrincipale extends JFrame{
    public FenetrePrincipale (){
        setTitle("Validation");
        Container contentPane=this.getContentPane();
        contentPane.setLayout(null);
        JLabel choose=Label("Choose the movie you want to watch",110,0,300,30);
        contentPane.add(choose);
        JRadioButton film1=RadioButton("1st film",180,30,100);
        JRadioButton film2=RadioButton("2nd film",180,60,100);
        JRadioButton film3=RadioButton("3rd film",180,90,100);
        contentPane.add(film1);contentPane.add(film2);contentPane.add(film3);
        JLabel nbTickets=Label("Number of tickets : ",140,120,150,30);
        contentPane.add(nbTickets);
        JTextField numberTickets=ChampText("",260,120,70,30);
        contentPane.add(numberTickets);
        JLabel discount=Label("Do you have a discount?",110,150,150,30);
        contentPane.add(discount);
        JRadioButton yes=RadioButton("yes",270,150,50);
        JRadioButton no=RadioButton("no",320,150,50);
        contentPane.add(yes);contentPane.add(no);
        JButton myButton=Button("Buy tickets",180,180,100,30);
        contentPane.add(myButton);
        setSize(500,300);
        setVisible(true);
    }

    public JRadioButton RadioButton(String text,int x,int y,int width){
        JRadioButton radioButton=new JRadioButton(text);
        radioButton.setBounds(x,y,width,30);
        return radioButton;
    }
    public JLabel Label(String text,int x,int y,int widght,int lenght){
        JLabel label=new JLabel(text);
        label.setBounds(x,y,widght,lenght);
        return label;
    }
    public JTextField ChampText(String text,int x,int y,int width,int height){
        JTextField textField=new JTextField(text);
        textField.setBounds(x,y,width,height);
        return textField;
    }
    public JButton Button(String text,int x,int y,int width,int height){
        JButton button=new JButton(text);
        button.setBounds(x, y, width, height);
        return button;
    }

    public static void main(String[] args) {
        new FenetrePrincipale();
    }

}