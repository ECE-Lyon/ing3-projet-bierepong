import java.awt.*;
import javax.swing.*;

public class FilmWindow extends JFrame{
    public FilmWindow (){
        setTitle("Film");
        Container contentPane=this.getContentPane();
        contentPane.setLayout(null);
    }

    public void containAddTxt (JTextArea txt){
        Container contentPane=this.getContentPane();
        contentPane.setLayout(null);
        contentPane.add(txt);
    }

    public void containAddLabel (JLabel label){
        Container contentPane=this.getContentPane();
        contentPane.setLayout(null);
        contentPane.add(label);
    }

    public void Final(){
        setSize(1200,700);
        setVisible(true);
    }

    public static void main(String[]args){
        FilmWindow filmWindow = new FilmWindow();
        filmWindow.Final();
    }

}

