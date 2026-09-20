/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author visha
 */
public class ConnectionProviderClass {
    public static Connection getcon(){
        try{
            Class.forName("org.postgresql.Driver");
//            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myfitness_scheduler","postgres","7355Vishal");
//            return con;
            String url = "jdbc:postgresql://localhost:5432/myfitness_scheduler"; 
            String username = "postgres";
            String password = "7355Vishal"; 
//            
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Connection Error:" + e.getMessage());
            return null;
        }
    }
}
