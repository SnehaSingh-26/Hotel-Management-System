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

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//which defines a class HotelManagementSystem that extends JFrame and implements ActionListener. 
//The class creates a simple GUI (Graphical User Interface) for a hotel management system, featuring a background image,
//a label, and a button that triggers an action.

//HotelManagementSystem extends JFrame, meaning it inherits the properties of a window with a title bar, close button, etc.
//It implements ActionListener, meaning it can respond to action events (like button clicks).
public class HotelManagementSystem extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public HotelManagementSystem() {
		/*setSize(1300, 730): Sets the frame size.
                setLayout(null): Uses no layout manager, allowing manual placement of components.
                setLocation(300, 300): Sets the frame's location on the screen.*/
                setSize(1300,730);          // setContentPane(300,300,1366,390);   frame size
                setLayout(null);
                setLocation(300,100);

                //JLabel l1: A label for displaying text or an image.
		l1 = new JLabel("");
                b1 = new JButton("Next");
                
                /*b1.setBackground(Color.WHITE): Sets the button's background color.
                b1.setForeground(Color.BLACK): Sets the button's text color.*/
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
				
                
             /*ImageIcon i1: Loads an image from the resources.
               Image i3: Scales the image to the specified size.
               ImageIcon i2: Creates a new ImageIcon with the scaled image.
                l1 = new JLabel(i2): Sets the label to display the image.*/   
              ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("Pictures/icons/first.jpg"));
//ImageIcon is a concrete implementation of the Icon interface that is used for displaying images in components like JLabel, JButton, etc.
               Image i3 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);
               //Image is an abstract class that provides various methods for manipulating images, such as scaling and drawing.
               ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
               // JLabel l1;
                JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(30,10,1500,100);
                lid.setFont(new Font("serif",Font.PLAIN,70));
                lid.setForeground(Color.blue);
                l1.add(lid);
                
                b1.setBounds(570,525,150,50);
		l1.setBounds(0, 0, 1366, 590);
                
                l1.add(b1);
		add(l1);
 //b1.addActionListener(this): Registers the current instance (this) as the listener for button click events.
                b1.addActionListener(this);
                setVisible(true);
               //Creates an infinite loop that makes the title label blink by toggling its visibility every 500 milliseconds. 
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	}
        //This method is called when the button is clicked.
        @Override
        public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                HotelManagementSystem window = new HotelManagementSystem();
                window.setVisible(true);			
	}
}
