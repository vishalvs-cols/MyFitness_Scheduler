 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
/**
 *
 * @author visha
 */
public class userdao {
    public static void REGISTER(User users){
        String query = "INSERT INTO users(name, email, password, age, gender) values('"+users.getName()+"','"+users.getEmail()+"','"+users.getPassword()+"','"+users.getAge()+"','"+users.getGender()+"')";
        DbOperations.setDataOrDelete(query, "REGISTER SUCCESSFULLY");
        
    }
    public static User LOGIN(String email, String password){
        User users = null;
        try{
            ResultSet rs = DbOperations.getData("select * from users where email = '"+email+"' and password = '"+password+"'");
            
            while(rs.next()){
                users= new User();
                users.setEmail(rs.getString("email"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return users;
    }
}
