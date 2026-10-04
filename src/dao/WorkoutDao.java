/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Workout;

/**
 *
 * @author visha 
 */
public class WorkoutDao {
    public static void save(Workout excercise){
        String query = "Insert Into excercise(excerise_name, category, reps) values('" +excercise.getExcercise_name() + "', '" +excercise.getCategory() +"', '" + excercise.getReps() + "')";
        DbOperations.setDataOrDelete(query, "Exercise Added Successfully.");
    }
    
    
    
}
