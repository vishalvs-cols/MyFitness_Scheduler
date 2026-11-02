/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author visha
 */
public class ScheduleDao {
    public static boolean Save(String email, ArrayList<Integer> exerciseIds){
        String query = "Insert Into workout(user_id, exercise_id, workout_date)" + "Select user_id, ?, CURRENT_DATE FROM users WHERE LOWER(email)= Lower(?)";
        try(Connection con = ConnectionProviderClass.getcon();
              PreparedStatement ps = con.prepareStatement(query)){
            con.setAutoCommit(false);
            for(int id : exerciseIds){
                ps.setInt(1, id);
                ps.setString(2, email);
                ps.addBatch();
            }
            int inserted = 0;
            for(int r : ps.executeBatch()){
                if(r> 0 || r == Statement.SUCCESS_NO_INFO){
                    inserted++;
                }
            }
            con.commit();
            return inserted == exerciseIds.size();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<String> getDates(String email){
        ArrayList<String> dates = new ArrayList<>();
        String query = "Select Distinct  w.workout_date from workout w "
                    + "JOIN users u ON u.user_id = w.user_id "
                    + "Where LOWER (u.email) = Lower(?) "
                    + "ORDER BY w.workout_date DESC ";
        try(Connection con = ConnectionProviderClass.getcon();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                dates.add(rs.getDate(1).toString());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return dates;
    }
    
    public static ArrayList<Object[]> getWorkouts(String email, String date){
        ArrayList<Object[]> rows = new ArrayList<>();
        String query = "Select w.workout_date, e.name, e.category, e.setsreps "
                    + "From workout w "
                    + "JOIN users u ON u.user_id = w.user_id "
                    + "JOIN addexercise e ON e.id = w.exercise_id "
                    + "WHERE LOWER(u.email) = LOWER(?) "
                    + (date != null ? "AND w.workout_date = ? " : "")
                    + "ORDER BY w.workout_date DESC, w.workout_id";
        try(Connection con = ConnectionProviderClass.getcon();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, email);
            if(date != null){
                ps.setDate(2, java.sql.Date.valueOf(date));
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                rows.add(new Object[]{
                    rs.getDate("workout_date"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getString("setsreps")
                });
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rows;
    }
}
