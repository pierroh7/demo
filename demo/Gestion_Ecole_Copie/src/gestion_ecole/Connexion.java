/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_ecole;

import java.sql.*;

/**
 *
 * @author pierr
 */
public class Connexion {
    Connection connect;
    
    public Connexion(){
        try{
            Class.forName("com.mysql.jbdc.Driver"); //Pour tester la base Driver de la classe de la bibliothèque JDBC 
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        try{
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecole", "root", ""); //Connexion à la base
        }catch(SQLException es){
            System.out.println(es);
        }
    }
        
    public Connection getConnection(){
            return connect;
        }
    }
    

