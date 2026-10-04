/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author visha
 */
public class Workout {
    private int excercise_id;
    private String excercise_name;
    private String category;
    private String reps;

    public int getExcercise_id() {
        return excercise_id;
    }

    public void setExcercise_id(int excercise_id) {
        this.excercise_id = excercise_id;
    }

    public String getExcercise_name() {
        return excercise_name;
    }

    public void setExcercise_name(String excercise_name) {
        this.excercise_name = excercise_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }
    
}
