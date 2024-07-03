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
//import java.awt.EventQueue;
import java.util.Date;

//import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class NewCustomer extends JFrame
{
	//Connection conn = null;
	//PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t6;
        JComboBox comboBox;
        JRadioButton r1,r2;
        Choice c1;
        JLabel CheckInTime; 
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
            new Customer();
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); }*/
	

	public NewCustomer() 
        {
		
                setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Pictures/icons/fifth.png"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
		
		JLabel lblName = new JLabel("NEW CUSTOMER FORM");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 11, 260, 53);
		contentPane.add(lblName);
                
                JLabel lblId = new JLabel("ID :");
		lblId.setBounds(35, 76, 200, 14);
		contentPane.add(lblId);
                
                comboBox = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
		comboBox.setBounds(271, 73, 150, 20);
		contentPane.add(comboBox);
                
                JLabel l2 = new JLabel("Number :");
		l2.setBounds(35, 111, 200, 14);
		contentPane.add(l2);
                
                t1 = new JTextField();
		t1.setBounds(271, 111, 150, 20);
		contentPane.add(t1);
		//t1.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name :");
		lblName_1.setBounds(35, 151, 200, 14);
		contentPane.add(lblName_1);
		
		t2 = new JTextField();
		t2.setBounds(271, 151, 150, 20);
		contentPane.add(t2);
		//t2.setColumns(10);

                
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 191, 200, 14);
		contentPane.add(lblGender);
                
                r1 = new JRadioButton("Male");
                r1.setFont(new Font("Raleway", Font.BOLD, 14));
                r1.setBackground(Color.WHITE);
                r1.setBounds(271, 191, 80, 12);
                add(r1);
                
                r2 = new JRadioButton("Female");
                r2.setFont(new Font("Raleway", Font.BOLD, 14));
                r2.setBackground(Color.WHITE);
                r2.setBounds(350, 191, 100, 12);
		add(r2);
                
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(35, 231, 200, 14);
		contentPane.add(lblCountry);
		
		JLabel lblReserveRoomNumber = new JLabel("Allocated Room Number :");
		lblReserveRoomNumber.setBounds(35, 274, 200, 14);
		contentPane.add(lblReserveRoomNumber);
                
                c1 = new Choice();
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery("select * from room");
                    while(rs.next()) //looping through the data through next()
                    {
                        c1.add(rs.getString("roomnumber"));   //Add values dynamically through add() 
                    }
                }catch(Exception e){ }
                c1.setBounds(271, 274, 150, 20);
		contentPane.add(c1);
		
                
                JLabel lbltime = new JLabel("Checked-In :");
		lbltime.setBounds(35, 316, 200, 14);
                lbltime.setFont(new Font("Raleway", Font.BOLD, 14));
		contentPane.add(lbltime);  //or add(lbltime)

                Date date=new Date();
		CheckInTime = new JLabel(""+date); //date has to be converted to string to pass in Jlabel
		CheckInTime.setFont(new Font("Raleway", Font.BOLD, 14));
                CheckInTime.setBounds(230, 316, 150, 25);
                
		contentPane.add(CheckInTime);
		
		JLabel lblDeposit = new JLabel("Deposit :");
		lblDeposit.setBounds(35, 359, 200, 14);
		contentPane.add(lblDeposit);
		
		
		
		
		
		t3 = new JTextField();
		t3.setBounds(271, 231, 150, 20);
		contentPane.add(t3);
		//t3.setColumns(10);
		
		
		/*t5 = new JTextField();
		t5.setBounds(271, 316, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);*/
		
		t6 = new JTextField();
		t6.setBounds(271, 359, 150, 20);
		contentPane.add(t6);
		//t6.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
                        {
                            conn c = new conn();
                            String radio = null;
                            
                            if(r1.isSelected())
                            { 
                                radio = "Male";
                            }
                            else if(r2.isSelected())
                            { 
                                radio = "Female";
                            }
                            
                            //String s6 = c1.getSelectedItem();
                          
                            try
                            {
	    			
                                String id= (String)comboBox.getSelectedItem(); 
	    			String number =  t1.getText();
	    			String name =  t2.getText();
                                String gender =  radio;
	    			String country =  t3.getText();
	    			//String s7 =  t5.getText();
                                String room=c1.getSelectedItem();
                                String time=CheckInTime.getText();
                                String deposit =  t6.getText();
                                
                                String q1 = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                                String q2 = "update room set availability = 'Occupied' where roomnumber='"+room+"'";
                                c.s.executeUpdate(q1);
                                c.s.executeUpdate(q2);
	    			
	    			
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
                            }
                            catch(Exception e1)
                            {
	    			System.out.println(e1.getMessage());
                            }
                            /*catch(NumberFormatException s)
                            {
		    		JOptionPane.showMessageDialog(null, "Please enter a valid Number");
                            }*/
                        }
                });
		btnNewButton.setBounds(100, 430, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Reception().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 430, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
        public static void main(String[] args) 
        {
            new NewCustomer();
        }
}