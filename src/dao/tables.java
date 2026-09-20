/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author visha
 */
public class tables {
    public static void main(String[] args){
        try{
            Connection con = ConnectionProviderClass.getcon();
            Statement st = con.createStatement();
            
            String userTable  = "CREATE TABLE IF NOT EXISTS users(" + "id SERIAL PRIMARY KEY," + "name VARCHAR(200)," + "email VARCHAR(250)," + "password VARCHAR(100)," + "age int," + "gender VARCHAR(100))"; 
            st.executeUpdate(userTable);
            javax.swing.JOptionPane.showMessageDialog(null, "Table Created Successfully");
//            String query = "INSERT INTO users(name, email, password,confirm password, age, gender) VALUES ('"+user.getFull_Name()+"', '"+user.getEmail()+"', '"+user.getPassword()+"', '"+user.getConfirm_Password()+"', '"+user.getAge()+"','"+user.getGender()+"','false') ";
//            DbOperations.setDataOrDelete(query, "Register Successfully !");
        }
        catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,e);
        }
    }
}
