/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.swing.JOptionPane;
import model.Admin;
import java.sql.*;


/**
 *
 * @author visha
 */
public class admindao {
    public static Admin LOGIN(String email, String password){
        Admin admin = null;
        try{
            ResultSet rs = DbOperations.getData("select * from admin where email = '" + email + "' and password = '" + password+ "'");
            while(rs.next()){
                admin = new Admin();
                admin.setEmail(rs.getString("email"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return admin;
    }
}
