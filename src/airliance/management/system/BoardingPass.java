/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package airliance.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;





/**
 * 
 *
 * @author aritr
 */
public  class BoardingPass extends JFrame implements ActionListener{
    
    JTextField  tfpnr; 
    JLabel tfname,tfnationality, lblsrc, lbldest,labelfname,labelfcode,labeldate;
    JButton  fetchButton;
    
    
    
    
    
    
    
    public BoardingPass()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font ("Tahoma", Font.PLAIN, 32));
        //heading.setForeground(Color.BLUE);
        add(heading);
        
        
        //BOARDING PASS
        JLabel subheading= new JLabel("BOARDING PASS");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font ("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
         //PNR DETAILS
         JLabel lbladhaar= new JLabel("PNR DETAILS");
        lbladhaar.setBounds(60, 100, 150, 25);
        lbladhaar.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbladhaar);
        
        tfpnr=new JTextField();
        tfpnr.setBounds(220,100,150,25);
        add(tfpnr);
        
        fetchButton= new JButton("ENTER");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        
        
        //NAME
        JLabel lblname= new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
         tfname=new JLabel();
        tfname.setBounds(220,140,150,25);
        add(tfname);
        
        //NATIONALITY
         JLabel lblnationality= new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality=new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
      
        //SRC
        JLabel lbladdress= new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblsrc=new JLabel();
        lblsrc.setBounds(220,220,150,25);
        add(lblsrc);
        
        //DEST
          JLabel lblgender= new JLabel("DEST");
        lblgender.setBounds(60, 340, 150, 25);
        lblgender.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
         lbldest= new JLabel();
        lbldest.setBounds(220, 340, 150, 25);
        //labelgender.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbldest);
       
        
        //Flight Name
         JLabel lblfname= new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname=new JLabel();
        labelfname.setBounds(220,260,150,25);
        add(labelfname);
        
        //flight code
         JLabel lblfcode= new JLabel("Flight Code");
        lblfcode.setBounds(60, 300, 150, 25);
        lblfcode.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode=new JLabel();
        labelfcode.setBounds(220,300,150,25);
        add(labelfcode);
        
        //Date of travel
         JLabel lbldate= new JLabel("DATE");
        lbldate.setBounds(60, 380, 150, 25);
        lbldate.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 380, 150, 25);
        add(labeldate);
        
        
        //Image Icon
        
        ImageIcon i1=new ImageIcon("C:/Users/aritr/OneDrive/Desktop/airliance recommendation/icons-20240928T115136Z-001/icons/airindia.png");
        Image i2=i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        
        
        
        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        //Fetch Adhaar
        if(ae.getSource()==fetchButton)
        {
        String pnr=tfpnr.getText();
        
       
        try
        {
            Connectivity conn=new Connectivity();
            
            String query = "select * from reservation where PNR ='"+pnr+"'";
             ResultSet rs = conn.s.executeQuery(query);
             
              if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    tfnationality.setText(rs.getString("nationality"));
                    lblsrc.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
                }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        }
    }
        
        //Fetch Flight Availability
       
    
    public static void main (String args[])
    {
        new BoardingPass();
        
    }
    
}

