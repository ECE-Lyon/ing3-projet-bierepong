package com.company.AffichageEmployee.MenuModifEmployee;

import com.company.AffichageEmployee.MenuModifsReduc.AddReduc;
import com.company.AffichageEmployee.MenuModifsReduc.MenuModifReduc;
import com.company.ElementDeBase.Employee;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.ElementDeBase.Employee.sauvegarderEmployee;

public class AddEmployee extends JFrame {
    protected AddEmployee() {
        setTitle("Ajouter un Employé");

        Container contentPane=this.getContentPane();
        GridLayout grid = new GridLayout(3, 2);
        grid.setVgap(3);
        contentPane.setLayout(grid);


        JLabel mailLab = new JLabel("  Mail :");
        JTextField mailField = new JTextField("");
        contentPane.add(mailLab);contentPane.add(mailField);

        JLabel passLab = new JLabel("  MDP :");
        JTextField passField = new JTextField("");
        contentPane.add(passLab);contentPane.add(passField);

        JButton annule = new JButton("Annuler");
        annule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuModifEmployee();
            }
        });

        JButton valider = new JButton("Valider");
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mail=mailField.getText();
                String pass=passField.getText();
                Employee employee=new Employee();
                employee.setPassword(pass);
                employee.setMail(mail);
                sauvegarderEmployee(employee);
                dispose();
                new MenuModifEmployee();
            }
        });
        contentPane.add(annule);contentPane.add(valider);

        setSize(500,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
