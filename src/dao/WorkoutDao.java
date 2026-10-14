/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Workout;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author visha 
 */
public class WorkoutDao {
    public static void save(Workout exercisecategory){
        String query = "Insert Into exercisecategory(name) values('" + exercisecategory.getname() + "')";
        DbOperations.setDataOrDelete(query, "Exercise Added Successfully.");
    }
    
    public static ArrayList<Workout> getAllRecords(){
        ArrayList<Workout> arrayList = new ArrayList<>();
        try{
            ResultSet rs =  DbOperations.getData("Select * from exercisecategory");
            
           while(rs.next()){
               Workout exercisecategory = new Workout();
               exercisecategory.setid(rs.getInt("id"));
               exercisecategory.setname(rs.getString("name"));
               arrayList.add(exercisecategory);
           }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    
    public static void Delete(String id){
        String query = "delete from exercisecategory where id='" +id+ "'";
        DbOperations.setDataOrDelete(query, "Excercise Deleted Successfully");
    }

    public static void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
