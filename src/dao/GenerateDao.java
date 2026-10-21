/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.GenerateWorkouts;

/**
 *
 * @author visha
 */
public class GenerateDao {
    public static String getWorkout_id(){
        int workout_id = 1;
        try{
            ResultSet rs = DbOperations.getData("Select max(workout_id) from workout ");
            if(rs.next()){
                workout_id = rs.getInt(1);
                workout_id = workout_id + 1;
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(workout_id);
    }
    
    public static void SAVE(GenerateWorkouts workout){
        String query = "INSERT INTO workout values ('" +workout.getWorkout_id()+ "', '"+workout.getName()+"', '"+workout.getEmail()+"', '"+workout.getWorkout_date()+"','"+workout.getCreatedBy()+"')";
        DbOperations.setDataOrDelete(query, "Workouts Added Successfully");
    }
}
