/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package airliance.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



/**
 * 
 *
 * @author aritr
 */
public  class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfphone, tfadhaar, tfnationality, tfaddress;
    JRadioButton rbfemale,rbmale;
    
    
    public AddCustomer()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading= new JLabel("ADD CUSTOMR DETAIL");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font ("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        //NAME
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
         tfname=new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);
        
        //NATIONALITY
         JLabel lblnationality= new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality=new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);
        
        //ADHAAR
         JLabel lbladhaar= new JLabel("Adhaar N0");
        lbladhaar.setBounds(60, 180, 150, 25);
        lbladhaar.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbladhaar);
        
        tfadhaar=new JTextField();
        tfadhaar.setBounds(220,180,150,25);
        add(tfadhaar);
        
        //ADDRESS
        JLabel lbladdress= new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        //SEXUALITY
          JLabel lblgender= new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        ButtonGroup gendergroup=new ButtonGroup();
        
         rbmale=new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
         rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        
        //PHONR NO
        JLabel lblphone= new JLabel("Phone No");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font ("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
         
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon Image=new ImageIcon("C:/Users/aritr/OneDrive/Desktop/airliance recommendation/icons-20240928T115136Z-001/icons/emp.png");
        JLabel lblimage=new JLabel(Image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        
        
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String name=tfname.getText();
        String nationality=tfnationality.getText();
        String phone=tfphone.getText();
        String address=tfaddress.getText();
        String adhaar=tfadhaar.getText();
        String gender= null;
        if(rbmale.isSelected())
        {
            gender= "Male";
        }
        else
        {
            gender="Female";
        }
        try
        {
            Connectivity conn=new Connectivity();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+adhaar+"', '"+gender+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer details added successfully");
            
            setVisible(false);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main (String args[])
    {
        new AddCustomer();
        
    }
    
}
