/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airliance.management.system;

/**
 *
 * @author aritr
 */
import java.sql.*;
public class Connectivity {
    
    Connection c;
    Statement s;
    
    public Connectivity()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "Aritra@2002");
            s= c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
    
}
