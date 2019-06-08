/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Nathan
 */
public class NiveauDAO extends DAO<Niveau> {

    public NiveauDAO(Connection conn) {
        super(conn);
    }
    @Override
    public boolean create(Niveau o) {
        try {
            String query = "INSERT INTO niveau (ID, Nom)"
                         + " VALUES (?, ?)";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.setInt(1, o.getID());
            preparedStmt.setString(2, o.getNom());
            preparedStmt.execute();
        } catch (SQLException ex) { System.out.println("Ajout niveau echoue."); }
        return true;
    }

    @Override
    public boolean delete(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Niveau o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Niveau find(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNbRows() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<Integer, Niveau> getTable() {
        HashMap<Integer, Niveau> niveaux = new HashMap<>();
        try {
            ResultSet rs = this.co.createStatement().executeQuery("SELECT * FROM niveau");
            while(rs.next()) {
                int ID = rs.getInt("ID");
                niveaux.put(ID, new Niveau(ID,rs.getString("Nom")));
            }
        } catch (SQLException ex) {}

        return niveaux;      
    }

    @Override
    public void deteleTable() {
        try {
            String query = "DELETE FROM niveau";
            PreparedStatement preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("Table niveau supprimee");
            
            query = "ALTER TABLE niveau AUTO_INCREMENT = 1";
            preparedStmt = this.co.prepareStatement(query);
            preparedStmt.execute();
            System.out.println("AutoIncrement a 1");
            
        } catch (SQLException ex) { System.out.println("Suppression de table niveau echouee."); }
    }
    
    @Override
    public int getMaxID() {
        int maxID = 0;
        try {      
            ResultSet result = this.co.createStatement().executeQuery("SELECT * FROM niveau");
            result.last();
            maxID = result.getInt("ID"); // Donne le dernier ID
            //rs.beforeFirst();
            
        } catch (SQLException ex) {}
        return maxID;
    }
}
