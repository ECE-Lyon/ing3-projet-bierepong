package AffichageClients;

import ElementDeBase.Film;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FilmWindow extends JFrame{
    public FilmWindow () throws IOException {
        Film film_1 = new Film();
        film_1.setGenre("Commédie");
        film_1.setReleaseDate("15 Janvier 2004");
        film_1.setTitle("Shrek");
        film_1.setRunningTime(106);
        film_1.setImage("Images/ShrekPNG.png");

        Film film_2 = new Film();
        film_2.setGenre("Horreur");
        film_2.setReleaseDate("30 Mars 1998");
        film_2.setTitle("Picsou et l'attaque des nains");
        film_2.setRunningTime(95);
        film_2.setImage("Images/Shrek.jpg");

        Film film_3 = new Film();
        film_3.setGenre("Commédie");
        film_3.setReleaseDate("17 Juillet 2123");
        film_3.setTitle("Monstre&Co");
        film_3.setRunningTime(132);
        film_3.setImage("Images/MontreAndCoCursed.png");

        Film film_5 = new Film();
        film_5.setGenre("Commédie");
        film_5.setReleaseDate("15 Janvier 2004");
        film_5.setTitle("Shrek");
        film_5.setRunningTime(106);
        film_5.setImage("Images/ShrekPNG.png");

        Film film_6 = new Film();
        film_6.setGenre("Bucolique");
        film_6.setReleaseDate("69 Juin 1969");
        film_6.setTitle("Rocco au payx des noix de coco");
        film_6.setRunningTime(95);
        film_6.setImage("Images/Shrek.jpg");

        String[] listeReduc = {"Aucune", "Etudiant", "Senior", "Prolétaire","Ex-Taulard"};

        Film Lib[] = {film_1, film_2, film_3,film_5, film_5,film_6};

        int nbFilm = Lib.length;

        int tailleFenetre = ((nbFilm - 1) / 5 + 1) * 2 + 2 + nbFilm / 3;

        setTitle("Validation");
        GridLayout grid = new GridLayout(tailleFenetre, 5);

        grid.setHgap(10);
        setLayout(grid);

        //Cette boucle sert à afficher les films les uns après les autres
        for (int j = 0; j <(nbFilm - 1) / 5 + 1; j++){
            if (nbFilm-(j*5)<5){ // if (il reste moins de 5 films à afficher sur une ligne)
                for (int i = 0; i < nbFilm%5; i++) {
                    JLabel label = Film.LabelIconeFilmBis(Lib[i+j*5]);
                    add(label);
                }
                for (int i = 0; i < 5 - nbFilm % 5; i++) { //Complete le reste de la ligne de case vide
                    JLabel blank = new JLabel("");
                    add(blank);
                }
                for (int i = 0; i < nbFilm%5; i++) {
                    JTextArea txt = Film.TextAreaBis(Lib[i+j*5].title + "\n" + Lib[i+j*5].genre + "\n" + Lib[i+j*5].releaseDate + "\n" + Integer.toString(Lib[i+j*5].runningTime) + " min");
                    add(txt);
                }
                for (int i = 0; i < 5 - nbFilm % 5; i++) { //Complete le reste de la ligne de case vide
                    JLabel blank = new JLabel("");
                    add(blank);
                }
            }
            else {
                for (int i = 0; i < 5; i++) {
                    JLabel label = Film.LabelIconeFilmBis(Lib[i]);
                    add(label);
                }
                for (int i = 0; i < 5; i++) {
                    JTextArea txt = Film.TextAreaBis(Lib[i].title + "\n" + Lib[i].genre + "\n" + Lib[i].releaseDate + "\n" + Integer.toString(Lib[i].runningTime) + " min");
                    add(txt);
                }
            }

        }

        for (int i=0; i<2; i++) {
            JLabel blank = new JLabel("");
            add(blank);
        }
        JPanel panel = firstSoloPanel (Lib[0]);
        if(nbFilm!=1){
            panel = firstDuoPanel (Lib[0],Lib[1]);
        }
        add(panel);
        for (int j=0; j<4; j++) {
            JLabel blank = new JLabel("");
            add(blank);
        }

        for (int i=0;i<nbFilm/3;i++){
            if(i+1==nbFilm/3 && nbFilm%3==0){
                panel=soloPanel (Lib[2+3*i]);
            }
            else if(i+1==nbFilm/3 && nbFilm%3==1){
                panel=duoPanel (Lib[2+3*i],Lib[3+3*i]);
            }
            else {
                panel=trioPanel(Lib[2+3*i],Lib[3+3*i],Lib[4+3*i]);
            }
            add(panel);
            for (int j=0; j<4; j++) {
                JLabel blank = new JLabel("");
                add(blank);
            }
        }
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JPanel panelBis = new JPanel();
        panelBis.setLayout(new GridLayout(1,2));
        JLabel label = new JLabel("Nombre de ticket");
        JTextField champ = new JTextField("");
        panelBis.add(label);
        panelBis.add(champ);

        JPanel panelTer = new JPanel();
        panelTer.setLayout(new GridLayout(1,2));
        label = new JLabel("Réduction");
        JComboBox choix = new JComboBox(listeReduc);
        panelTer.add(label);
        panelTer.add(choix);


        JButton button=new JButton("Acheter");
        panel.add(panelBis);
        panel.add(panelTer);
        panel.add(button);
        add(panel);


        setSize(new Dimension(1040,tailleFenetre*150));
        setVisible(true);
    }

    public void containAddTxt (JTextArea txt){
        Container contentPane=this.getContentPane();
        contentPane.add(txt);
    }

    public void containAddLabel (JLabel label){
        Container contentPane=this.getContentPane();
        contentPane.add(label);
    }

    public JPanel firstSoloPanel (Film film){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        JLabel label = new JLabel("Choisit un film chakal");
        JRadioButton bFilm1=new JRadioButton(film.title);
        panel.add(label);
        panel.add(bFilm1);
        return panel;
    }

    public JPanel firstDuoPanel (Film film1, Film film2){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        JLabel label = new JLabel("Choisit un film chakal");
        JRadioButton bFilm1=new JRadioButton(film1.title);
        JRadioButton bFilm2=new JRadioButton(film2.title);
        panel.add(label);
        panel.add(bFilm1);
        panel.add(bFilm2);
        return panel;
    }

    public JPanel soloPanel (Film film){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        JRadioButton bFilm1=new JRadioButton(film.title);
        panel.add(bFilm1);
        return panel;
    }

    public JPanel duoPanel (Film film1,Film film2){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        JRadioButton bFilm1=new JRadioButton(film1.title);
        JRadioButton bFilm2=new JRadioButton(film2.title);
        panel.add(bFilm1);
        panel.add(bFilm2);
        return panel;
    }

    public JPanel trioPanel (Film film1,Film film2,Film film3){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        JRadioButton bFilm1=new JRadioButton(film1.title);
        JRadioButton bFilm2=new JRadioButton(film2.title);
        JRadioButton bFilm3=new JRadioButton(film3.title);
        panel.add(bFilm1);
        panel.add(bFilm2);
        panel.add(bFilm3);
        return panel;
    }

    public static void main(String[]args) throws IOException {
        new FilmWindow();
    }
}