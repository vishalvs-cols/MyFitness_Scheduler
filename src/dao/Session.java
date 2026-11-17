/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author visha
 */
public class Session {
    public static String email = null;
    public static boolean isAdmin = false;
    
    public static boolean isLoggedIn(){
        return email != null;
    }
    
    public static void logout(){
        email = null; 
        isAdmin = false;
    }
}
