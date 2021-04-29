import javax.swing.*;

public class FonctionsSwing extends JFrame{
    public JRadioButton RadioButton(String text, int x, int y, int width){
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
        textField.setEditable(false);
        textField.setBounds(x,y,width,height);
        return textField;
    }
    public JButton Button(String text,int x,int y,int width,int height){
        JButton button=new JButton(text);
        button.setBounds(x, y, width, height);
        return button;
    }
}
