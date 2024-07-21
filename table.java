/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;


import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fiza
 */
public class table {
    public static void main(String[] args) {
        
        JFrame f = new JFrame("frame");
        f.setSize(400,400);
      // JScrollPane sp = new JScrollPane();
        
        JTable t = new JTable(4,2);
        t.setBackground(Color.red);
        t.setBounds(10,10,20,20);
      // f.add(sp);
        f.add(t);
        
        
      //  f.pack();
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "")) {
                String sql = " SELECT * FROM szabist";
                Statement pst = con.createStatement();
                
                ResultSet rs = pst.executeQuery(sql);
                while(rs.next()){
                    //String Name = rs.getString("FULL_NAME");
                    String Username = rs.getString("uname");
                    String Password = rs.getString("pass");
                  //  String Email = rs.getString("EMAIL");
                  //  String Contact_num = rs.getString("CONTACT_NUM");
                    
                   
                    String tbData[] = {Username,Password};
                    DefaultTableModel tb2Model =(DefaultTableModel)t.getModel();
                    tb2Model.addRow(tbData);
}
            }
        }catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(f, e);
        }
        
        f.setVisible(true);
        
    }
}
