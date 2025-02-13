
package airliance.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
//    JButton submit, reset, close;
//    JTextField tfusername;
//    JPasswordField tfpassword;

    public Home() {
        //getContentPane().setBackground(Color.white);
        setLayout(null);

        //ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airliance.management.system.icons-20240928T115136Z-001/icons/front.jpg"));
       ImageIcon i1 = new ImageIcon("C:/Users/aritr/OneDrive/Desktop/airliance recommendation/icons-20240928T115136Z-001/icons/front.jpg");


        JLabel image=new JLabel(i1);
       image.setBounds(0, 0, 1600, 800);
        add(image);
        
        JLabel heading=new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500,40,1000,490);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("TAHOMA", Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar= new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details= new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails= new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails= new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight= new JMenuItem("Book flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails= new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
         JMenuItem ticketCancellation= new JMenuItem("Cancel Ticket");
          ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu ticket= new JMenu("Ticket");
        menubar.add(ticket);
        
           JMenuItem boardingPass= new JMenuItem("Boarding Pass");
           boardingPass.addActionListener(this);
           ticket.add(boardingPass);
        
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String text=ae.getActionCommand();
//        if(text.equals("Add Customer Details"))
//        {
//            new customerDetails();
//        }
//        else if(text.equals("Flight Details"));
//        {
//            new flightDetails();
//        }
            if (text.equals("Add Customer Details")) 
            {
            new AddCustomer(); // Assuming this is a class to be defined
        } 
            else if (text.equals("Flight Details")) {
            new FlightInfo();
        }
            else if(text.equals("Book flight"))
            {
                new BookFlight();
            }
            else if(text.equals("Journey Details"))
            {
                new JourneyDetails();
            }
            else if(text.equals("Cancel Ticket"))
            {
                new Cancel();
            }
            else if(text.equals("Boarding Pass"))
            {
                new BoardingPass();
            }
        
    }

    public static void main(String[] args) {
        new Home();
    }
}
