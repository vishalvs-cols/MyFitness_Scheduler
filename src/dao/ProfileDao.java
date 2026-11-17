/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author visha
 */
public class ProfileDao {

    public static String[] getProfile(String email) {
//        System.out.println("PROFILE email = [" + email + "]");
        String query = "Select name, email, age, gender, height, weight " + "From users WHERE Lower(email) = Lower(?)";
        try (Connection con = ConnectionProviderClass.getcon();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new String[]{
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("age"),
                    rs.getString("gender"),
                    rs.getString("height"),
                    rs.getString("weight")
                };
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateProfile(String email, String name, int age, String gender, int height, int weight){
        String query = "Update users Set name= ?, age = ?, gender =?, height=?, weight = ? " + "Where Lower(email) = Lower(?)";
        try (Connection con = ConnectionProviderClass.getcon(); 
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, gender);
                ps.setInt(4, height);
                ps.setInt(5, weight);
                ps.setString(6, email);
                return ps.executeUpdate() > 0;
            }
            catch(SQLException e ){
                e.printStackTrace();
                return false;
            }
        }
    // name + email match krta hai ya nii
    public static boolean userExists(String name,String email){
        String query = "SELECT 1 from users Where Lower(email) = Lower(?) and Lower(name) = Lower(?)";
        try(Connection con = ConnectionProviderClass.getcon();
             PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,email);
            ps.setString(2,name);
            return ps.executeQuery().next();
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }    
    }
    public static boolean updatePassword(String email,String password){
        String query = "Update users Set password = ? Where Lower(email) = Lower(?)";
        try(Connection con = ConnectionProviderClass.getcon();
              PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, password);
            ps.setString(2, email);
            return ps.executeUpdate() >0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static String[] getAdminProfile(String email){
        String query = "SELECT name, email from admin WHERE LOWER(email) = LOWER(?)";
        try(Connection con = ConnectionProviderClass.getcon();
                PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new String[]{rs.getString("name"), rs.getString("email")};
            }
        }catch(SQLException e){
                e.printStackTrace();
        }
        return null;
    }
    public static boolean updateAdminName(String email, String name){
        String query = "UPDATE admin SET name = ? WHERE LOWER(email) = LOWER(?)";
        try(Connection con = ConnectionProviderClass.getcon();
               PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, name);
            ps.setString(2, email);
            return ps.executeUpdate() > 0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
         
    }
}
