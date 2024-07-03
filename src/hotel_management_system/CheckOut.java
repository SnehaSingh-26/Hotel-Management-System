/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel_management_system;

//import java.awt.BorderLayout;
import java.awt.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;
//import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {
    //Connection conn = null;
    //PreparedStatement pst = null;

    //private JPanel contentPane;
    private JLabel t1;
    Choice c1;
    JLabel lblcheckintime,lblRoomNumber;
    
    public CheckOut() throws SQLException {
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null); //yhis has to be done otherwise setBounds will not work
        
       setBounds(300,200,800,400);
       setVisible(true);
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Pictures/icons/sixth.jpg"));
//        Image i3 = i1.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
//        ImageIcon i2 = new ImageIcon(i3);
//        JLabel l1 = new JLabel(i2);
//        l1.setBounds(300, 0, 500, 225);
//        add(l1);

        JLabel text = new JLabel("CheckOut");
        text.setBounds(100,20,100,30);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);  //adding to the frame

        JLabel lblName = new JLabel("Cust_id :");
        lblName.setBounds(30, 80, 100, 30);
        add(lblName);

        
       
//        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Pictures/icons/tick.png"));
//        Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
//        ImageIcon i6 = new ImageIcon(i5);
//        JButton tick= new JButton(i6);
//        tick.setBounds(290, 82, 20, 20);
//        add(tick);
//
//        tick.addActionListener(new ActionListener() {
//
//            public void actionPerformed(ActionEvent ae) {
//                System.out.println("Hi");
//                try {
//
//                    conn c = new conn();
//                    String number = c1.getSelectedItem();
//                    ResultSet rs = c.s.executeQuery("select * from customer where number = " + number);
//
//                    if (rs.next()) {
//                        System.out.println("clicked");
//                        t1.setText(rs.getString("room"));
//                    }
//                } catch (Exception e) {
//                }
//            }
//        });

        JLabel lblRoom = new JLabel("RoomNumber:");   
        lblRoom.setBounds(30, 130, 100, 30);
        add(lblRoom);

        lblRoomNumber  = new JLabel();   //t1 is Jlabel not text field because room_no is already allotted.
        lblRoomNumber.setBounds(150, 130, 100, 30);
        add(lblRoomNumber);
        
        JLabel lblcheckin=new JLabel("Checkin time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
        lblcheckintime=new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);
        
        JLabel lblcheckout=new JLabel("Checkout time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date=new Date();
        JLabel lblcheckouttime=new JLabel(""+date); //jlabel takes a string therefore date converetd to string here
        lblcheckouttime.setBounds(150,230,100,30);
        add(lblcheckouttime);
        
        c1 = new Choice(); //Choice is a drop-down
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");  //import sql
            while (rs.next())
            {
                c1.add(rs.getString("number"));
                lblRoomNumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
        c1.setBounds(150, 80, 150, 25);
        add(c1);
        
        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.setBounds(30, 280, 120, 30);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        add(btnCheckOut);

        btnCheckOut.addActionListener(new ActionListener() {
            //override actionPerformed
            public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String s1 = lblRoomNumber.getText();
                String deleteSQL = "Delete from customer where number = " + id;
                String q2 = "update room set availability = 'Available' where room_number = " + s1;

                

                try {
                    conn c = new conn();
                    //dml commands
                    c.s.executeUpdate(deleteSQL);
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Check Out Successful");
                    new Reception().setVisible(true);
                    setVisible(false);
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }
        });
        
        JButton btnExit = new JButton("Back");
        btnExit.setBounds(170, 280, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        

        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args)throws SQLException
    {
        new CheckOut();

    }

    

}
