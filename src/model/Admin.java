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
public class Admin {
    private int admin_id;
    private String email;
    private String password;
    
    public int getAdmin_id(){
        return admin_id;
    }
    public void setAdmin_id(int admin_id){
        this.admin_id = admin_id;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String Email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String Password){
        this.password = password;
    }
}

