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
public  class BookFlight extends JFrame implements ActionListener{
    
    JTextField  tfadhaar; 
    JLabel tfname,tfnationality, tfaddress, labelgender,labelfname,labelfcode;
    JButton bookflight, flight, fetchButton;
    Choice source, destination;
    JDateChooser dcdate;
    
    
    
    
    
    public BookFlight()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font ("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
         //ADHAAR
         JLabel lbladhaar= new JLabel("Adhaar N0");
        lbladhaar.setBounds(60, 80, 150, 25);
        lbladhaar.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbladhaar);
        
        tfadhaar=new JTextField();
        tfadhaar.setBounds(220,80,150,25);
        add(tfadhaar);
        
        fetchButton= new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        
        
        //NAME
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
         tfname=new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        //NATIONALITY
         JLabel lblnationality= new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality=new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
       
        
        
        
        //ADDRESS
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress=new JLabel();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        //SEXUALITY
          JLabel lblgender= new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
         labelgender= new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25);
        //labelgender.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(labelgender);
        
//        ButtonGroup gendergroup=new ButtonGroup();
//        
//         rbmale=new JRadioButton("Male");
//        rbmale.setBounds(220, 280, 70, 25);
//        rbmale.setBackground(Color.WHITE);
//        add(rbmale);
//        
//         rbfemale=new JRadioButton("Female");
//        rbfemale.setBounds(300, 280, 70, 25);
//        rbfemale.setBackground(Color.WHITE);
//        add(rbfemale);
//        
//        gendergroup.add(rbmale);
//        gendergroup.add(rbfemale);

        //Flight Source
        JLabel lblsource= new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source= new Choice();
        source.setBounds(220, 330,150, 25);
        source.add("Source");
        add(source);
        
        //Flight Destination
         JLabel lbldest= new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination= new Choice();
        destination.setBounds(220, 380,150, 25);
        destination.add("Destination");
        add(destination);
        
        try{
            Connectivity c= new Connectivity();
            String query="select * from flight";
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next())
            {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
//        
        
       
         //Fetch flight
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        //Flight Name
         JLabel lblfname= new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname=new JLabel();
        labelfname.setBounds(220,430,150,25);
        add(labelfname);
        
        //flight code
         JLabel lblfcode= new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode=new JLabel();
        labelfcode.setBounds(220,480,150,25);
        add(labelfcode);
        
        //Date of travel
         JLabel lbldate= new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 530, 150, 25);
        add(dcdate);
        
        
        //Image Icon
        
        ImageIcon i1=new ImageIcon("C:/Users/aritr/OneDrive/Desktop/airliance recommendation/icons-20240928T115136Z-001/icons/details.jpg");
        Image i2=i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image= new ImageIcon(i2);
        
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        //Book Flight
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        
        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        //Fetch Adhaar
        if(ae.getSource()==fetchButton)
        {
        String adhaar=tfadhaar.getText();
        
       
        try
        {
            Connectivity conn=new Connectivity();
            
            String query = "select * from passenger where aadhar ='"+adhaar+"'";
             ResultSet rs = conn.s.executeQuery(query);
             
             if(rs.next())
             {
                 tfname.setText(rs.getString("name"));
                 tfnationality.setText(rs.getString("nationality"));
                 tfaddress.setText(rs.getString("address"));
                 labelgender.setText(rs.getString("gender"));
             }
             else
             {
             
            JOptionPane.showMessageDialog(null, "Please enter correct Adhaar Num");
             }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        
        //Fetch Flight Availability
        else if(ae.getSource()==flight)
        {
        String src =source.getSelectedItem();
         String dest =destination.getSelectedItem();
        
       
        try
        {
            Connectivity conn=new Connectivity();
            
            String query = "select * from flight where source ='"+src+"'and destination='"+dest+"'";
             ResultSet rs = conn.s.executeQuery(query);
             
             if(rs.next())
             {
                 labelfname.setText(rs.getString("f_name"));
                 labelfcode.setText(rs.getString("f_code"));
                 
             }
             else
             {
             
            JOptionPane.showMessageDialog(null, "No flights found");
             }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
        
        
        else 
        {
       Random random = new Random();
            
            String adhaar = tfadhaar.getText();
            String name = tfname.getText(); 
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); 
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
        
       
        try
        {
            Connectivity conn=new Connectivity();
            
            String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+adhaar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";
              conn.s.executeUpdate(query);
             
            
            JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
             
            setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        }
    }
    public static void main (String args[])
    {
        new BookFlight();
        
    }
    
}

