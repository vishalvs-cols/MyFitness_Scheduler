/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.ResultSet;
/**
 *
 * @author visha
 */
public class DbOperations {
    public static void setDataOrDelete(String Query, String msg){
        try{
            Connection con = ConnectionProviderClass.getcon();
            Statement st = con.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals(" ")){
                JOptionPane.showMessageDialog(null, msg);
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ResultSet getData(String query){
        
        try{
            Connection con = ConnectionProviderClass.getcon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
