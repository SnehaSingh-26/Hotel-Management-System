/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management_system;




import java.awt.*;
import java.awt.event.*; //Color class and ActionListener is in awt.event package
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.*;

public class AddEmployee extends JFrame implements ActionListener
{ //Third Frame

        //JPanel contentPane;
	JTextField textField,textField_1,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1;
        JRadioButton Male,Female;
        //JButton b1,b2;

        public AddEmployee()
        {
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE); //background of frame
            setTitle("ADD EMPLOYEE DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("NAME");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17)); //font type is Font.Plain
            Passportno.setBounds(60, 30, 150, 27);
            add(Passportno);
            
            textField = new JTextField();
            textField.setBounds(200, 30, 150, 27);
            add(textField);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            Next.addActionListener(this);
            add(Next);
			
            JLabel Pnrno = new JLabel("AGE");
            Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Pnrno.setBounds(60, 80, 150, 27);
            add(Pnrno);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 80, 150, 27);
            add(textField_1);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 120, 150, 27);
            add(Gender);
		
            Male = new JRadioButton("Male");
            Male.setBackground(Color.WHITE);
            Male.setBounds(200, 120, 70, 27);
            Male.setFont(new Font("Tahoma", Font.PLAIN, 14));
            add(Male);
	
            Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 120, 70, 27);
            Female.setFont(new Font("Tahoma", Font.PLAIN, 14));
            add(Female);
            
            
            JLabel Address = new JLabel("JOB");
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 170, 150, 27);
            add(Address);
			
            String course[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
            c1 = new JComboBox(course); //for drop-down
            c1.setBackground(Color.WHITE);
            c1.setBounds(200,170,150,30);
            add(c1);
            		
            JLabel Nationality = new JLabel("SALARY");
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 220, 150, 27);
            add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel Name = new JLabel("PHONE");
            Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Name.setBounds(60, 270, 150, 27);
            add(Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Phno = new JLabel("AADHAR");
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 320, 150, 27);
            add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 320, 150, 27);
            add(textField_5);
	
            
            JLabel email = new JLabel("EMAIL");
            email.setFont(new Font("Tahoma", Font.PLAIN, 17));
            email.setBounds(60, 370, 150, 27);
            add(email);
			
            textField_6 = new JTextField();
            textField_6.setBounds(200, 370, 150, 27);
            add(textField_6);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD EMPLOYEE DETAILS");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(450, 24, 442, 35);
            add(AddPassengers);
			
     
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Pictures/icons/tenth.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(410,80,480,410);
            add(image);
            
            
            setSize(900,600);
            setVisible(true);
            setLocation(530,200);
            
        /*b1=new JButton("Add");
        b1.setBounds(50, 410, 120, 30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        contentPane.add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(200, 410, 120, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        contentPane.add(b1);*/

    }
         
        
        public void actionPerformed(ActionEvent ae)
        {
                
                    String name = textField.getText();
                    String age = textField_1.getText();
                    String salary = textField_3.getText();
                    String phone = textField_4.getText();
                    String aadhar = textField_5.getText();
                    String email = textField_6.getText();
                   
                    String gender = null;
                    
                    if(Male.isSelected())
                    {
                        gender = "male";
                    
                    }
                    else if(Female.isSelected())
                    {
                        gender = "female";
                    }

                            
                    String s6 = (String)c1.getSelectedItem(); //getSelecetdItem returns an object so it has to be typcasted to String
                    
                    try 
                    {
                        conn c = new conn();
                        String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+s6+"', '"+salary+"', '"+phone+"','"+aadhar+"', '"+email+"')";
                        
                        c.s.executeUpdate(str); //it will not return any object so need to create ResultSet object
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                        new Reception();
                    
                    } 
                    catch (Exception e) 
                    {
                        e.printStackTrace();
        	    } 
                    /*catch (SQLException ex) 
                    {
                        Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
		
                
			
            }
		
		
    public static void main(String[] args)
    {
        new AddEmployee();
    }   
}
