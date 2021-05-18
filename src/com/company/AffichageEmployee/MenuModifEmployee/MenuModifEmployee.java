package com.company.AffichageEmployee.MenuModifEmployee;

import com.company.AffichageEmployee.MenuEmployee;
import com.company.AffichageEmployee.MenuModifsReduc.AddReduc;
import com.company.AffichageEmployee.MenuModifsReduc.MenuModifReduc;
import com.company.AffichageEmployee.MenuModifsReduc.ModifReduc;
import com.company.ElementDeBase.Employee;
import com.company.ElementDeBase.Reduction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.company.ElementDeBase.Employee.deleteEmployee;
import static com.company.ElementDeBase.Employee.listEmployeeMaker;
import static com.company.ElementDeBase.Reduction.deleteReduc;
import static com.company.ElementDeBase.Reduction.listReducMaker;

public class MenuModifEmployee extends JFrame{
    public MenuModifEmployee(){
        ArrayList<Employee> employees = listEmployeeMaker();
        setTitle("Menu Employés");
        int len = employees.size();
        GridLayout grid = new GridLayout(len+1, 2);
        grid.setVgap(3);
        setLayout(grid);

        for(int i=0;i<len;i++){
            Employee employee=employees.get(i);
            JLabel label = new JLabel("  " + employee.getMail());
            JPanel panelBis = new JPanel();
            GridLayout gridBis = new GridLayout(1, 2);
            gridBis.setHgap(3);
            panelBis.setLayout(gridBis);

            JLabel blank=new JLabel("");
            panelBis.add(blank);

            JButton supprimer=new JButton("Supprimer");
            supprimer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    deleteEmployee(employee);
                    new MenuModifEmployee();
                }
            });
            panelBis.add(supprimer);

            add(label);
            add(panelBis);
        }
        JButton retour=new JButton("Retour");
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuEmployee();
            }
        });
        add(retour);

        JButton add=new JButton("Ajouter un Collègue");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddEmployee();
            }
        });
        add(add);
        setSize(500,40*(len+1));
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuModifEmployee();
    }
}
