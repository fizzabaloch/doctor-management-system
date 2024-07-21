/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Insert {

    public static void main(String[] args) {
        // Ensure Swing components are created on the Event Dispatch Thread
        
            JFrame jf = new JFrame("Frame");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLayout(null); // Using null layout

            JTextField uname = new JTextField(100);
            JTextField pass = new JTextField(100);

            uname.setBounds(30, 50, 200, 30); // Correcting the size
            pass.setBounds(30, 150, 200, 30); // Correcting the size

            jf.add(uname);
            jf.add(pass);

            jf.setSize(400, 400);
            jf.setVisible(true);

            JButton jb = new JButton("press");
            jf.add(jb);
            
            
            jb.setBounds(30, 250, 100, 30);
            jb.addActionListener(e->{
                try {
                // Loading the MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "")) {
                    
                    String sqli = "INSERT into szabist (uname,pass) values (?,?)";
                    PreparedStatement pst1 = con.prepareStatement(sqli);
                    pst1.setString(1,uname.getText());
                    pst1.setString(2,pass.getText());
                    
                   int n =  pst1.executeUpdate();
                   if(n>0){
                       JOptionPane.showMessageDialog(jf,"insertion successful");
                   }
                   else{
                       JOptionPane.showMessageDialog(jf,"insertion unsuccessful");
                      
                   }
                    
                    
                    
                    
                    
                    
                    String sql = "SELECT * FROM szabist WHERE uname=? AND pass=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, uname.getText());
                    pst.setString(2, pass.getText());
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(jf, "Username and Password Matched!");
                    } else {
                        JOptionPane.showMessageDialog(jf, "Username and Password incorrect!");
                        uname.setText("");
                        pass.setText("");
                    }
                    
                    String sql2 = "UPDATE szabist SET uname=?,pass=? WHERE 1";
                    PreparedStatement pst2 = con.prepareStatement(sql2);
                    pst2.setString(1,"ruchi");
                    pst2.setString(2, "ruchi");
                    int n2 = pst2.executeUpdate();
                    
                    if(n2>0){
                        JOptionPane.showMessageDialog(jf, "successfully updated");
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(jf, "update had some problem ");
                       
                    }
                    
                    
                    String del = "DELETE from szabist where uname='ruchi'";
                    
                    PreparedStatement pst3 = con.prepareStatement(del);
                    pst3.execute();
                     JOptionPane.showMessageDialog(jf, "deleted data ");
                }
            } 
                catch (HeadlessException | ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(jf, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
                
            
        
            });
                
    }
}
