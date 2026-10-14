/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Exercise;
import java.sql.*;

/**
 *
 * @author visha
 */
public class Exercisedao {
    public static void SAVE(Exercise addexercise){
        String query = "INSERT INTO addexercise(name, category, setsreps) values ('"+addexercise.getName()+"','"+addexercise.getCategory()+"','"+addexercise.getSetsReps()+"')";
        DbOperations.setDataOrDelete(query, "Exercise Added Successfully");
    }
    
    public static ArrayList<Exercise> getAllRecords(){
        ArrayList<Exercise> arraylist = new ArrayList<>();
        try{
           ResultSet rs =  DbOperations.getData("select *from addexercise");
           while(rs.next()){
               Exercise addexercise = new Exercise();
               addexercise.setId(rs.getInt("id"));
               addexercise.setName(rs.getString("name"));
               addexercise.setCategory(rs.getString("category"));
               addexercise.setSetsReps(rs.getString("setsreps"));
               arraylist.add(addexercise);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arraylist;
    }
    
    public static void UPDATE(Exercise addexercise){
        String query = "Update addexercise set name = '"+addexercise.getName()+"',category = '"+addexercise.getCategory()+"',setsreps = '"+addexercise.getSetsReps()+"' where id = '"+addexercise.getId()+"'";
        DbOperations.setDataOrDelete(query, "Exercise Update Successfully");
    }
    
    public static void DELETE(String id){
        String query = "Delete from addexercise where id = '"+id+"'";
        DbOperations.setDataOrDelete(query, "Exercise Deleted Successfully");
    }
        
}
