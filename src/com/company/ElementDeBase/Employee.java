package com.company.ElementDeBase;

import java.sql.*;
import java.util.ArrayList;

public class Employee {
    private String mail;
    private String password;

    public String getMail() {return mail;}
    public void setMail(String mail) { this.mail = mail; }
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public static void sauvegarderEmployee(Employee employee) {
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:./default");

            try (PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO EMPLOYEE (Mail, Password) VALUES (?, ?)")) {
                preparedStatement.setString(1, employee.getMail());
                preparedStatement.setString(2, employee.getPassword());
                preparedStatement.execute();
            }
            con.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<Employee> listEmployeeMaker() {
        ArrayList<Employee> lib = new ArrayList<>();
        try (
                Connection con = DriverManager.getConnection("jdbc:h2:./default");
                PreparedStatement statement = con.prepareStatement("select * from EMPLOYEE")) {
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    String mail1 = rs.getString("MAIL");
                    String password1 = rs.getString("PASSWORD");
                    Employee employee = new Employee();
                    employee.setMail(mail1);
                    employee.setPassword(password1);
                    lib.add(employee);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lib;
    }

    public static void deleteEmployee(Employee employee){
        try (Connection con = DriverManager.getConnection("jdbc:h2:./default"))
        {
            try (PreparedStatement preparedStatement = con.prepareStatement(
                    "delete from EMPLOYEE where MAIL='"+employee.getMail()+"'")) {
                preparedStatement.execute();
            }
            con.close();
        } catch (SQLException e) {
        }

    }
}
